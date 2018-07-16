package com.zjp.tsms.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.zjp.tsms.entity.TaxOrgan;
import com.zjp.tsms.util.DBUtil;

/**
 * @author zjp
 * @date 2017年11月2日 下午2:50:19
 */
public class TaxOrganDao {

	private String sql = "";
	private Object[] params = null;
	private List<Map<String, String>> list= null;
	private boolean flag = false;
	
	private DBUtil db = DBUtil.getInstance();
	private static TaxOrganDao instance = null;
	
	private TaxOrganDao() {}
	
	public static TaxOrganDao getInstance() {
		if (instance == null) {
			instance = new TaxOrganDao();
		}
		return instance;
	}
	
	public TaxOrgan geTaxOrganById(int id) {
	
		return null;
	}
	
	public List<TaxOrgan> getTaxOrgan(){
		List<TaxOrgan> listTaxOrgan = new ArrayList<>();
		sql = "select id,organName from tb_tax_organ";
		list = db.query(sql);
		if (list!= null && list.size() > 0) {
			for (Map<String, String> map : list) {
				TaxOrgan taxOrgan = new TaxOrgan();
				try {
					BeanUtils.populate(taxOrgan, map);
					listTaxOrgan.add(taxOrgan);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return listTaxOrgan;
		}
		return null;
	}
}

