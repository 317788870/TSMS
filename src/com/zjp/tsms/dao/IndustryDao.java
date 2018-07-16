package com.zjp.tsms.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.zjp.tsms.entity.Industry;
import com.zjp.tsms.util.DBUtil;

/**
 * @author zjp
 * @date 2017年11月7日 下午12:04:32
 */
public class IndustryDao {

	private String sql = "";
	private Object[] params = null;
	private List<Map<String, String>> list= null;
	private boolean flag = false;
	
	private DBUtil db = DBUtil.getInstance();
	private static IndustryDao instance = null;
	private IndustryDao() {}
	
	public static IndustryDao getInstance() {
		if (instance == null) {
			instance = new IndustryDao();
		}
		return instance;
	}
	
	
	public List<Industry> getIndustry(){
		List<Industry> listIndust = new ArrayList<>();
		sql = "select id,industryName from tb_industry";
		list = db.query(sql);
		if (list!= null && list.size() > 0) {
			for (Map<String, String> map : list) {
				Industry industry = new Industry();
				try {
					BeanUtils.populate(industry, map);
					listIndust.add(industry);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return listIndust;
		}
		return null;
	}
}

