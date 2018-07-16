package com.zjp.tsms.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.zjp.tsms.entity.User;
import com.zjp.tsms.util.DBUtil;

/**
 * @author zjp
 * @date 2017年11月1日 上午11:47:36
 */
public class UserDao {

	private DBUtil db = DBUtil.getInstance();
	private static UserDao instance = null;
	
	private UserDao() {}
	
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	
	/**
	 * 登录操作
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName) {
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> list = db.query("select * from tb_user where userName=?", new Object[] {userName});
		
		if (list != null && list.size() == 1) {
			map = list.get(0);
		}
		User user = new User();
		
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	/**
	 * 修改密码
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean modifyPasswordByUserName(String userName,String password) {
		boolean flag = db.update("update tb_user set password=? where userName=?", new Object[] {password,userName});
		if (flag) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据办税专员id查询办税专员用户详情
	 * @param id
	 * @return
	 */
	public List<Map<String, String>> getUserInfoByTaxerId(int id){
		List<Map<String, String>> list = db.query("select * from tb_user u join tb_taxer t on u.taxerId=t.id where t.id=?", id);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
}

