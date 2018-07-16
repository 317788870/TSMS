package com.zjp.tsms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.And;
import com.zjp.tsms.entity.TaxPayer;
import com.zjp.tsms.util.DBUtil;
import com.zjp.tsms.util.StringUtil;

/**
 * @author zjp
 * @date 2017年11月1日 下午5:08:34
 */
public class TaxPayerDao {

	private DBUtil db = DBUtil.getInstance();
	private static TaxPayerDao instance = null;
	private String sql = "";
	private List<Map<String, String>> list= null;
	private Object[] params = null;
	private boolean flag = false;
	
	private TaxPayerDao() {}
	
	public static TaxPayerDao getInstance() {
		if (instance == null) {
			instance = new TaxPayerDao();
		}
		return instance;
	}
	
	/**
	 * 根据不同的条件查询纳税公司信息
	 * @param pageNo
	 * @param pageSize
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public List<Map<String, String>>  getAllTaxPayerByPage(int pageNo, int pageSize, String payerCode, String payerName){
		sql = "select p.id,p.payerCode,p.payerName,p.bizAddress,p.bizAddressPhone,o.organName,i.industryName,"
				+ "p.bizScope,p.invoiceType,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,t.taxerName,"
				+ "p.recordDate from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer t on "
				+ "p.taxOrganId=o.id and p.industryId=i.id and o.leaderId=t.id  where p.removeState=0 ";
		params = new Object[] {(pageNo - 1) * pageSize,pageSize};
		
		boolean checkCode = payerCode!=null&&payerCode.toString().length()>0;
		boolean checkName = payerName!=null&&payerName.toString().length()>0;
		
		if (checkCode) {
			sql += "and p.payerCode=" + payerCode;
		}
		if (checkName) {
			sql += " and p.payerName like '%" + payerName + "%' ";
		}
		
		sql += " order by p.recordDate desc limit ?,?";
		list = db.query(sql, params);
		if (list != null) {
			return list;
		}
		return null;
	}
	/**
	 * 获取去总行数
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public int getAllPayersTotalRows(String payerCode, String payerName){
		sql = "select count(*) as coun from tb_tax_payer where removeState=0";
		list = db.query(sql);
		return Integer.parseInt(list.get(0).get("coun"));
	}
	public List<Map<String, String>> getTaxPayerById(int id){
		sql = "select p.id,p.payerCode,p.payerName,p.bizAddress,p.bizAddressPhone,o.organName,i.industryName,"
				+ "p.bizScope,p.invoiceType,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,t.taxerName,"
				+ "p.recordDate from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer t on "
				+ "p.taxOrganId=o.id and p.industryId=i.id and o.leaderId=t.id where p.removeState=0 and p.id=?";
		params = new Object[] {id};
		list = db.query(sql, params);
		if (list!=null && list.size()==1) {
			return list;
		}
		return null;
	}
	
	/**
	 * 根据id删除纳税信息
	 * @param id
	 * @return
	 */
	public boolean deletePayerById(int id) {
		sql = "update tb_tax_payer set removeState=1 where id=?";
		params = new Object[]{id};
		flag = db.update(sql, params);
		if (flag) {
			return flag;
		}
		return false;
	}
	/**
	 * 修改纳税人信息
	 * @param p
	 * @return
	 */
	public boolean updatePayer(TaxPayer p) {
		sql = "update  tb_tax_payer set payerName=?,bizAddress=?,bizAddressPhone=?,taxOrganId=?,industryId=?,bizScope=?,invoiceType=?,legalPerson=?,legalIdCard=?,finaceName=?,finaceIdCard=?,userId=? where id=?";
		params = new Object[] { p.getPayerName(), p.getBizAddress(), p.getBizAddressPhone(), p.getTaxOrganId(),p.getIndustryId(), p.getBizScope(), p.getInvoiceType(), p.getLegalPerson(), p.getLegalIdCard(),p.getFinaceName(), p.getFinaceIdCard(), p.getUserId(), p.getId() };
		flag = db.update(sql, params);
		if (flag) {
			return flag;
		}
		return false;
	}
	
	
	/**
	 * 根据payCode查询
	 * @param payerCode
	 * @return
	 */
	public List<Map<String, String>> getTaxPayerByPayerCode(String payerCode){
		sql = "select p.id,p.payerCode,p.payerName,p.bizAddress,p.bizAddressPhone,o.organName,i.industryName,"
				+ "p.bizScope,p.invoiceType,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,t.taxerName,"
				+ "p.recordDate from tb_tax_payer p join tb_tax_organ o join tb_industry i join tb_taxer t on "
				+ "p.taxOrganId=o.id and p.industryId=i.id and o.leaderId=t.id  where p.removeState=0 and p.payerCode=?";
		params = new Object[] {payerCode};
		list = db.query(sql, params);
		if (list!=null && list.size()==1) {
			return list;
		}
		return null;
	}
	
	/**
	 * 根据payerCode检查是否存在该纳税编号
	 * @param payerCode
	 * @return
	 */
	public boolean checkPayerCode(String payerCode) {
		sql = "select * from tb_tax_payer where payerCode=?";
		params = new Object[] {payerCode};
		list = db.query(sql, params);
		if (list != null && list.size() > 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 添加纳税人
	 * @param p
	 * @return
	 */
	public boolean addTaxPayer(TaxPayer p) {
		sql = "insert into tb_tax_payer(payerCode,payerName,bizAddress,bizAddressPhone,taxOrganId,industryId,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,userId) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		params = new Object[] {p.getPayerCode(),p.getPayerName(),p.getBizAddress(),p.getBizAddressPhone(),p.getTaxOrganId(),p.getIndustryId(),p.getBizScope(),p.getInvoiceType(),p.getLegalPerson(),p.getLegalIdCard(),p.getFinaceName(),p.getFinaceIdCard(),p.getUserId()};
		return db.update(sql, params);
	}
	
	
	
	/**
	 * 未被调查企业统计
	 * @param pageNo
	 * @param pageSize
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public List<Map<String, String>> getNoResearchByPage(int pageNo,int pageSize,String payerCode, String payerName) {
		list = new ArrayList<>();
		sql = "select p.payerCode,p.payerName,o.organName,i.industryName,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,p.recordDate "
				+ "from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id and p.removeState=0 and p.id not "
				+ "in(select s.payerId from tb_tax_source s,tb_tax_payer p where p.id=s.payerId)";
		if (payerCode != null && !"".equals(payerCode)) {
			sql = sql + " and payerCode="+payerCode;
		}
		if (payerName != null && !"".equals(payerName)) {
			sql = sql + " and payerName like '%"+payerName+"%'";
		}
		sql = sql + " limit ?,?";
		
		params = new Object[] {(pageNo-1)*pageSize, pageSize};
		list = db.query(sql, params);
		if (list != null && list.size() > 0) {
			return list;
		}
		return list;
		
	}
	/**
	 * 未被调查企业统计
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public int getNoResearchCount(String payerCode, String payerName) {
		
		sql = "select count(*) coun from tb_tax_payer p join tb_tax_organ o join tb_industry i on p.taxOrganId=o.id and p.industryId=i.id and p.removeState=0 and p.id not "
				+ "in(select s.payerId from tb_tax_source s,tb_tax_payer p where p.id=s.payerId)";
		if (payerCode != null && !"".equals(payerCode)) {
			sql = sql + " and payerCode="+payerCode;
		}
		if (payerName != null && !"".equals(payerName)) {
			sql = sql + " and payerName like '%"+payerName+"%'";
		}
		list = db.query(sql,new Object[] {});
		
		return StringUtil.stringToInteger(list.get(0).get("coun"));
		
	}
	
	
	
}

