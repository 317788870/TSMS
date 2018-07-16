package com.zjp.tsms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zjp.tsms.entity.TaxSource;
import com.zjp.tsms.util.DBUtil;
import com.zjp.tsms.util.StringUtil;

/**
 * 税源
 * @author zjp
 * @date 2017年11月6日 下午4:48:46
 */
public class TaxSourceDao {


	private DBUtil db = DBUtil.getInstance();
	private static TaxSourceDao instance = null;
	private String sql = "";
	private List<Map<String, String>> list= null;
	private Object[] params = null;
	private boolean flag = false;
	
	private TaxSourceDao() {}
	
	public static TaxSourceDao getInstance() {
		if (instance == null) {
			instance = new TaxSourceDao();
		}
		return instance;
	}
	
	/**
	 * 通过纳税人id获取是否用户税源任务
	 * @param id
	 * @return
	 */
	public boolean getTaxSourceByPayerId(int id) {
		sql = "select * from tb_tax_source where payerId=?";
		params = new Object[] {id};
		list = db.query(sql, params);
		if (list != null && list .size() > 0) {
			return true;
		}
		return flag;
	}
	/**
	 * 添加税源任务
	 * @param s
	 * @return
	 */
	public boolean addTaxSource(TaxSource s) {
		sql = "insert into tb_tax_source(taskName,payerId,subOrganId,approverId,executeId,executeTime,taskState) values(?,?,?,?,?,?,?)";
		params = new Object[] {s.getTaskName(),s.getPayerId(),s.getSubOrganId(),s.getApproveId(),s.getExecuteId(),s.getExecuteTime(),s.getTaskState()};
		return db.update(sql, params);
	}
	/**
	 * 修改税源任务
	 * @param s
	 * @return
	 */
	public boolean updateTaxSource(TaxSource s) {
		sql = "update tb_tax_source set subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=? where id=?";
		params = new Object[] {s.getSubOrganId(),s.getApproveId(),s.getExecuteId(),s.getExecuteTime(),s.getTaskState(),s.getId()};
		
		return db.update(sql, params);
	}
	
	
	
	/**
	 * 根据条件查询数据
	 * @param pageNo
	 * @param pageSize
	 * @param payerCode
	 * @param payerName
	 * @param taxOrganId
	 * @param industryId
	 * @param executeTime
	 * @param recordTaskDate
	 * @return
	 */
	public List<Map<String, String>> getAllSearchTaskByPage(int pageNo, int pageSize,String payerCode,String payerName,String taxOrganId,String industryId,String executeTime,String recordTaskDate){
		list = new ArrayList<>();
		StringBuffer sb= new StringBuffer();
		sb.append("select s.id,s.taskName,p.id payerId,p.payerCode,p.payerName,i.industryName,p.bizScope,s.executeTime,s.recordTaskDate,DATEDIFF(s.recordTaskDate,s.executeTime) time,o.organName from tb_tax_source s join tb_tax_payer p join tb_industry i join tb_tax_organ o on s.payerId=p.id and p.industryId=i.id and s.subOrganId=o.id where p.removeState=0");
		
		if (StringUtil.isNotNull(payerCode)) {
			sb.append(" and payerCode="+payerCode);
		}
		if (StringUtil.isNotNull(payerName)) {
			sb.append(" and payerName like '%" + payerName + "%'");
		}
		if (StringUtil.isNotNull(taxOrganId)) {
			sb.append(" and taxOrganId="+taxOrganId);
		}
		if (StringUtil.isNotNull(industryId)) {
			sb.append(" and industryId="+industryId);
		}
		if (StringUtil.isNotNull(executeTime)) {
			sb.append(" and executeTime>='"+executeTime+"'");
		}
		if (StringUtil.isNotNull(recordTaskDate)) {
			sb.append(" and recordTaskDate<='"+recordTaskDate+"'");
		}
		sb.append(" order by s.id limit ?, ?");
		params = new Object[] {(pageNo-1)*pageSize, pageSize};
		list = db.query(sb.toString(), params);
		
		if (list != null && list.size() > 0) {
			return list;
		}
		return list;
	}
	/**
	 * 根据条件查询共多少条数据
	 * @param payerCode
	 * @param payerName
	 * @param taxOrganId
	 * @param industryId
	 * @param executeTime
	 * @param recordTaskDate
	 * @return
	 */
	public int getAllSearchTaskCount(String payerCode,String payerName,String taxOrganId,String industryId,String executeTime,String recordTaskDate) {
		StringBuffer sb= new StringBuffer();
		sb.append("select count(*) coun from tb_tax_source s join tb_tax_payer p join tb_industry i join tb_tax_organ o on s.payerId=p.id and p.industryId=i.id and s.subOrganId=o.id where p.removeState=0");
		
		if (StringUtil.isNotNull(payerCode)) {
			sb.append(" and payerCode="+payerCode);
		}
		if (StringUtil.isNotNull(payerName)) {
			sb.append(" and payerName like '%" + payerName + "%'");
		}
		if (StringUtil.isNotNull(taxOrganId)) {
			sb.append(" and taxOrganId="+taxOrganId);
		}
		if (StringUtil.isNotNull(industryId)) {
			sb.append(" and industryId="+industryId);
		}
		if (StringUtil.isNotNull(executeTime)) {
			sb.append(" and executeTime>='"+executeTime+"'");
		}
		if (StringUtil.isNotNull(recordTaskDate)) {
			sb.append(" and recordTaskDate<='"+recordTaskDate+"'");
		}

		params = new Object[] {};
		list = db.query(sb.toString(),params);
		return Integer.parseInt(list.get(0).get("coun"));
	}
	
	/**
	 * 根据id查询税源任务详情
	 * @param id
	 * @return
	 */
	public List<Map<String, String>> getTaskInfoById(int id){
		list = new ArrayList<>();
		sql = "select s.id,s.payerId,p.payerCode,p.payerName,p.bizAddress,i.industryName,p.bizScope,p.invoiceType,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,s.executeTime,p.recordDate,s.taskName,s.recordTaskDate,s.taskState,o.organName,t1.taxerName approverName,t2.taxerName executeName from tb_tax_source s join tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_taxer t1 join tb_taxer t2 on s.payerId=p.id and p.industryId=i.id and s.subOrganId=o.id and t1.id=s.approverId and t2.id=s.executeId and s.id=?";
		params = new Object[] {id};
		
		list = db.query(sql, params);
		if (list!=null && list.size()==1) {
			return list;
		}
		return list;
	}
	
	/**
	 * 删除税源任务
	 * @param id
	 * @return
	 */
	public boolean deleteTaskById(int id) {
		sql = "update tb_tax_source set removeState=1 where id=?";
		params = new Object[]{id};
		flag = db.update(sql, params);
		if (flag) {
			return flag;
		}
		return false;
	}

	
	
}

