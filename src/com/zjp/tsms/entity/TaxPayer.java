package com.zjp.tsms.entity;

import java.io.Serializable;

/**
 * @author zjp
 * @date 2017年11月1日 上午10:54:37
 */
public class TaxPayer implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	/** 纳税人识别号 */
	private String payerCode;
	
	/** 纳税公司名称 */
	private String payerName;
	
	/** 生产经营地址 */
	private String bizAddress;
	
	/** 生产经营电话 */
	private String bizAddressPhone;
	
	/** 所属税务机关id：TaxOrgan的id */
	private int taxOrganId;
	
	/** 行业 */
	private int industryId;
	
	/** 经营范围 */
	private String bizScope;
	
	/** 票种核定 */
	private String invoiceType;
	
	/** 法人姓名 */
	private String legalPerson;
	
	/** 法人身份证 */
	private String legalIdCard;
	
	/** 法人手机号 */
	private String leagalMobile;
	
	/** 法人身份证图片 */
	private String legalIdCardImageUrl;
	
	/** 财务姓名 */
	private String finaceName;
	
	/** 财务身份证 */
	private String finaceIdCard;
	
	/** 财务手机号 */
	private String finaceMobile;
	
	/** 财务身份证图片 */
	private String finaceIdCardImageUrl;
	
	/** 办税专员 */
	private String taxerName;
	
	/** 办税专员身份证 */
	private String taxerIdCard;
	
	/** 办税专员手机号 */
	private String taxerMobile;
	
	/** 办税专员身份证图片 */
	private String taxerIdCardImageUrl;
	
	/** 录入日期 */
	private String recordDate;
	
	/** user的id */
	private int userId;
	
	/** 移除状态： 0：正常 1：移除 */
	private int removeState;

	public TaxPayer() {
		super();
	}

	public TaxPayer(int id, String payerCode, String payerName, String bizAddress, String bizAddressPhone,
			int taxOrganId, int industryId, String bizScope, String invoiceType, String legalPerson, String legalIdCard,
			String leagalMobile, String legalIdCardImageUrl, String finaceName, String finaceIdCard,
			String finaceMobile, String finaceIdCardImageUrl, String taxerName, String taxerIdCard, String taxerMobile,
			String taxerIdCardImageUrl, String recordDate, int userId, int removeState) {
		super();
		this.id = id;
		this.payerCode = payerCode;
		this.payerName = payerName;
		this.bizAddress = bizAddress;
		this.bizAddressPhone = bizAddressPhone;
		this.taxOrganId = taxOrganId;
		this.industryId = industryId;
		this.bizScope = bizScope;
		this.invoiceType = invoiceType;
		this.legalPerson = legalPerson;
		this.legalIdCard = legalIdCard;
		this.leagalMobile = leagalMobile;
		this.legalIdCardImageUrl = legalIdCardImageUrl;
		this.finaceName = finaceName;
		this.finaceIdCard = finaceIdCard;
		this.finaceMobile = finaceMobile;
		this.finaceIdCardImageUrl = finaceIdCardImageUrl;
		this.taxerName = taxerName;
		this.taxerIdCard = taxerIdCard;
		this.taxerMobile = taxerMobile;
		this.taxerIdCardImageUrl = taxerIdCardImageUrl;
		this.recordDate = recordDate;
		this.userId = userId;
		this.removeState = removeState;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getBizAddress() {
		return bizAddress;
	}

	public void setBizAddress(String bizAddress) {
		this.bizAddress = bizAddress;
	}

	public String getBizAddressPhone() {
		return bizAddressPhone;
	}

	public void setBizAddressPhone(String bizAddressPhone) {
		this.bizAddressPhone = bizAddressPhone;
	}

	public int getTaxOrganId() {
		return taxOrganId;
	}

	public void setTaxOrganId(int taxOrganId) {
		this.taxOrganId = taxOrganId;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getBizScope() {
		return bizScope;
	}

	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalIdCard() {
		return legalIdCard;
	}

	public void setLegalIdCard(String legalIdCard) {
		this.legalIdCard = legalIdCard;
	}

	public String getLeagalMobile() {
		return leagalMobile;
	}

	public void setLeagalMobile(String leagalMobile) {
		this.leagalMobile = leagalMobile;
	}

	public String getLegalIdCardImageUrl() {
		return legalIdCardImageUrl;
	}

	public void setLegalIdCardImageUrl(String legalIdCardImageUrl) {
		this.legalIdCardImageUrl = legalIdCardImageUrl;
	}

	public String getFinaceName() {
		return finaceName;
	}

	public void setFinaceName(String finaceName) {
		this.finaceName = finaceName;
	}

	public String getFinaceIdCard() {
		return finaceIdCard;
	}

	public void setFinaceIdCard(String finaceIdCard) {
		this.finaceIdCard = finaceIdCard;
	}

	public String getFinaceMobile() {
		return finaceMobile;
	}

	public void setFinaceMobile(String finaceMobile) {
		this.finaceMobile = finaceMobile;
	}

	public String getFinaceIdCardImageUrl() {
		return finaceIdCardImageUrl;
	}

	public void setFinaceIdCardImageUrl(String finaceIdCardImageUrl) {
		this.finaceIdCardImageUrl = finaceIdCardImageUrl;
	}

	public String getTaxerName() {
		return taxerName;
	}

	public void setTaxerName(String taxerName) {
		this.taxerName = taxerName;
	}

	public String getTaxerIdCard() {
		return taxerIdCard;
	}

	public void setTaxerIdCard(String taxerIdCard) {
		this.taxerIdCard = taxerIdCard;
	}

	public String getTaxerMobile() {
		return taxerMobile;
	}

	public void setTaxerMobile(String taxerMobile) {
		this.taxerMobile = taxerMobile;
	}

	public String getTaxerIdCardImageUrl() {
		return taxerIdCardImageUrl;
	}

	public void setTaxerIdCardImageUrl(String taxerIdCardImageUrl) {
		this.taxerIdCardImageUrl = taxerIdCardImageUrl;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRemoveState() {
		return removeState;
	}

	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}
	
}

