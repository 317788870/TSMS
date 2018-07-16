package com.zjp.tsms.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.zjp.tsms.entity.Taxer;
import com.zjp.tsms.util.DBUtil;
import com.zjp.tsms.util.StringUtil;

/**
 * @author zjp
 * @date 2017年11月3日 上午11:14:58
 */
public class TaxerDao {

	private String sql = "";
	private Object[] params = null;
	private List<Map<String, String>> list= null;
	
	private DBUtil db = DBUtil.getInstance();
	private static TaxerDao instance = null;
	private TaxerDao() {}
	
	public static TaxerDao getInstance() {
		if (instance == null) {
			instance = new TaxerDao();
		}
		return instance;
	}
	
	/**
	 * 根据id查询办税专员
	 * @param id
	 * @return
	 */
	public List<Map<String, String>> getTaxerById(int id) {
		sql= "select t.id,t.taxerCode,t.taxerName,t.mobile,t.address,t.sex,t.birthday,t.email,o.organName from tb_taxer t inner join tb_tax_organ o on t.organId=o.id where t.id=?";
		params = new Object[] {id};
		List<Map<String, String>> list = db.query(sql, params);
		
		if (list != null && list.size() == 1) {
			return list;
		}
		return null;
	}
	/**
	 * 获取办税专员的名字和id
	 * @return
	 */
	public List<Taxer> getTaxer(){
		List<Taxer> listTaxer = new ArrayList<>();
		sql = "select id,taxerName from tb_taxer";
		list = db.query(sql);
		if (list!= null && list.size() > 0) {
			for (Map<String, String> map : list) {
				Taxer taxer = new Taxer();
				try {
					BeanUtils.populate(taxer, map);
					listTaxer.add(taxer);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return listTaxer;
		}
		return null;
	}
	
	/**
	 * 根据id查询办税专员名称
	 * @param id
	 * @return
	 */
	public String getTaxerName(String id) {
		sql = "select taxerName from tb_taxer where id=?";
		params = new Object[] {id};
		list = db.query(sql, params);
		if (list!= null && list.size() == 1) {
			return list.get(0).get("taxerName");
		}
		return null;
	}
	
	
	/**
	 * 分页查询办税专员列表或根据名字进行模糊查询
	 * @param pageNo
	 * @param pageSize
	 * @param taxerName
	 * @return
	 */
	public List<Map<String, String>> getTaxerByPage(int pageNo, int pageSize, String taxerName){
		sql = "select t.id,t.taxerCode,t.taxerName,o.organName,t.mobile,t.address,t.email from tb_taxer t join tb_tax_organ o on t.organId=o.id where t.state=0 ";
		if (taxerName != null && !"".equals(taxerName)) {
			sql = sql +"and t.taxerName like '%"+taxerName+"%' ";
		}
		sql = sql + "limit ?,?";
		list = db.query(sql,new Object[] {(pageNo-1)*pageSize,pageSize});
		
		if (list!= null && list.size() > 0) {
			return list;
		}
		return null;
	}
	/**
	 * 分页查询总条数
	 * @param taxerName
	 * @return
	 */
	public int getTaxerCount(String taxerName){
		
		sql = "select count(*) coun from tb_taxer where state=0 ";
		if (taxerName != null && !"".equals(taxerName)) {
			sql = sql +"and taxerName like '%"+taxerName+"%' ";
		}
		list = db.query(sql);
		
		return StringUtil.stringToInteger(list.get(0).get("coun"));
	}
	
	/**
	 * 添加办税专员
	 * @param t
	 * @return
	 */
	public boolean addTaxer(Taxer t) {
		sql = "insert into tb_taxer(taxerCode,taxerName,mobile,address,sex,birthday,email,organId) value(?,?,?,?,?,?,?,?)";
		params = new Object[] {t.getTaxerCode(),t.getTaxerName(),t.getMobile(),t.getAddress(),t.getSex(),t.getBirthday(),t.getEmail(),t.getOrganId()};
		return db.update(sql, params);
	}
	
	/**
	 *根据id删除
	 * @param id
	 * @return
	 */
	public boolean deleteTaxerById(int id) {
		sql = "update tb_taxer set state=1 where id=?";
		params = new Object[]{id};
		return db.update(sql, params);
	}

	/**
	 * 修改办税专员
	 * @param taxer
	 */
	public boolean updateTaxer(Taxer t) {
		sql = "update tb_taxer set taxerCode=?,taxerName=?,mobile=?,address=?,sex=?,birthday=?,email=?,organId=? where id=?";
		params = new Object[] {t.getTaxerCode(),t.getTaxerName(),t.getMobile(),t.getAddress(),t.getSex(),t.getBirthday(),t.getEmail(),t.getOrganId(),t.getId()};
		return db.update(sql, params);
		
	}
}

