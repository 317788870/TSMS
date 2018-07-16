package com.zjp.tsms.entity;

import java.io.Serializable;

/**
 * 税务人员信息表
 * @author zjp
 * @date 2017年10月31日 下午4:19:08
 */
public class Taxer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	/** 税务人员工号 */
	private String taxerCode;
	
	/** 税务人员姓名 */
	private String taxerName;
	
	/** 电话 */
	private String mobile;
	
	/** 地址 */
	private String address;
	
	/** 性别 */
	private String sex;
	
	/** 出生日期 */
	private String birthday;
	
	/** 邮箱 */
	private String email;
	
	/** TaxOrgan的id */
	private int organId;
	
	/** 有效标志：1有效，0无效，默认0 */
	private int state = 0;
	
	/** 上级领导Taxer的id */
	private int mgr;
	
	/** 系统管理员标志：1为管理员 ，0不是 */
	private int admin = 0;
	
	/** 录入日期 */
	private String recordDate;
	
	/** 录入人员：User的id */
	private int recordUserId;

	public Taxer() {
		super();
	}

	public Taxer(int id, String taxerCode, String taxerName, String mobile, String address, String sex, String birthday,
			String email, int organId, int state, int mgr, int admin, String recordDate, int recordUserId) {
		super();
		this.id = id;
		this.taxerCode = taxerCode;
		this.taxerName = taxerName;
		this.mobile = mobile;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.organId = organId;
		this.state = state;
		this.mgr = mgr;
		this.admin = admin;
		this.recordDate = recordDate;
		this.recordUserId = recordUserId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaxerCode() {
		return taxerCode;
	}

	public void setTaxerCode(String taxerCode) {
		this.taxerCode = taxerCode;
	}

	public String getTaxerName() {
		return taxerName;
	}

	public void setTaxerName(String taxerName) {
		this.taxerName = taxerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOrganId() {
		return organId;
	}

	public void setOrganId(int organId) {
		this.organId = organId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public int getRecordUserId() {
		return recordUserId;
	}

	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}
	
	
}

