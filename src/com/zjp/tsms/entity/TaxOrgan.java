package com.zjp.tsms.entity;

import java.io.Serializable;

/**
 * 税务机关表
 * @author zjp
 * @date 2017年11月1日 上午9:38:03
 */
public class TaxOrgan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 税务机关代码 */
	private int id;
	
	/** 税务机关名称 */
	private String organName;
	
	/** 上级税务机关代码 */
	private int parentId;
	
	/** 税务机关地址 */
	private String address;
	
	/** 税务机关电话 */
	private String phone;
	
	/** 传真 */
	private String faxPhone;
	
	/** 电子信息 */
	private String email;
	
	/** 负责人Taxer的id */
	private int leaderId;
	
	/** 国地税类型代码：国税1000210 地税1000215 */
	private String taxTypeCode;
	
	/** 有效标志 */
	private int state;
	
	/** 录入日期 */
	private String recordDate;
	
	/** 录入人员 User的id */
	private int recordUserId;

	public TaxOrgan() {
		super();
	}

	public TaxOrgan(int id, String organName, int parentId, String address, String phone, String faxPhone, String email,
			int leaderId, String taxTypeCode, int state, String recordDate, int recordUserId) {
		super();
		this.id = id;
		this.organName = organName;
		this.parentId = parentId;
		this.address = address;
		this.phone = phone;
		this.faxPhone = faxPhone;
		this.email = email;
		this.leaderId = leaderId;
		this.taxTypeCode = taxTypeCode;
		this.state = state;
		this.recordDate = recordDate;
		this.recordUserId = recordUserId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFaxPhone() {
		return faxPhone;
	}

	public void setFaxPhone(String faxPhone) {
		this.faxPhone = faxPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public String getTaxTypeCode() {
		return taxTypeCode;
	}

	public void setTaxTypeCode(String taxTypeCode) {
		this.taxTypeCode = taxTypeCode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

