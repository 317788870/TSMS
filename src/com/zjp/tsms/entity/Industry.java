package com.zjp.tsms.entity;

import java.io.Serializable;

/**
 * 行业代码
 * @author zjp
 * @date 2017年10月31日 下午4:01:03
 */
public class Industry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 行业编码 */
	private int id;
	
	/** 行业名称 */
	private String industryName;
	
	/** 录入日期 */
	private String date;
	
	/** 录入人员User Id */
	private int recordUserId;

	public Industry() {
		super();
	}

	public Industry(int id, String industryName, String date, int recordUserId) {
		super();
		this.id = id;
		this.industryName = industryName;
		this.date = date;
		this.recordUserId = recordUserId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRecordUserId() {
		return recordUserId;
	}

	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}
	
	
}

