package com.zjp.tsms.entity;

import java.io.Serializable;

/**
 * 
 * @author zjp
 * @date 2017年10月31日 下午3:54:21
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	/** 用户名 */
	private String userName;
	
	/** 密码 */
	private String password;
	
	/** 税务工作人员的id */
	private int taxerId;
	
	/** 盐值 */
	private String salt;
	
	/** 邮箱 */
	private String email;

	public User() {
		super();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(int id, String userName, String password, int taxerId, String salt, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.taxerId = taxerId;
		this.salt = salt;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTaxerId() {
		return taxerId;
	}

	public void setTaxerId(int taxerId) {
		this.taxerId = taxerId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

