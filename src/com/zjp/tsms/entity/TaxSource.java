package com.zjp.tsms.entity;

import java.io.Serializable;

/**
 * 税源基础信息任务表
 * @author zjp
 * @date 2017年11月1日 上午10:32:11
 */
public class TaxSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 任务编号 */
	private int id;
	
	/** 纳税人id：Payer的id */
	private int payerId;
	
	/** 任务名称 */
	private String taskName;
	
	/** 下达部门id：TaxOrgan的id */
	private int subOrganId;
	
	/** 批准人id：Taxer的id */
	private int approveId;
	
	/** 执行人id：Taxer的id */
	private int executeId;
	
	/** 执行时间 */
	private String executeTime;
	
	/** 任务来源 */
	private String taskFrom;
	
	/** 执行状态 */
	private String taskState;
	
	/** 调查结论或意见 */
	private String idea;
	
	/** 风险等级 */
	private int riskLevel;
	
	/** 录入日期 */
	private String recorTaskdDate;
	
	/** 录入人员id：User的id */
	private int recordUserId;
	
	/** 移除状态 */
	private int removeState;

	public TaxSource() {
		super();
	}

	public TaxSource(int id, int payerId, String taskName, int subOrganId, int approveId, int executeId,
			String executeTime, String taskFrom, String taskState, String idea, int riskLevel, String recorTaskdDate,
			int recordUserId, int removeState) {
		super();
		this.id = id;
		this.payerId = payerId;
		this.taskName = taskName;
		this.subOrganId = subOrganId;
		this.approveId = approveId;
		this.executeId = executeId;
		this.executeTime = executeTime;
		this.taskFrom = taskFrom;
		this.taskState = taskState;
		this.idea = idea;
		this.riskLevel = riskLevel;
		this.recorTaskdDate = recorTaskdDate;
		this.recordUserId = recordUserId;
		this.removeState = removeState;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPayerId() {
		return payerId;
	}

	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getSubOrganId() {
		return subOrganId;
	}

	public void setSubOrganId(int subOrganId) {
		this.subOrganId = subOrganId;
	}

	public int getApproveId() {
		return approveId;
	}

	public void setApproveId(int approveId) {
		this.approveId = approveId;
	}

	public int getExecuteId() {
		return executeId;
	}

	public void setExecuteId(int executeId) {
		this.executeId = executeId;
	}

	public String getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}

	public String getTaskFrom() {
		return taskFrom;
	}

	public void setTaskFrom(String taskFrom) {
		this.taskFrom = taskFrom;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public int getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRecorTaskdDate() {
		return recorTaskdDate;
	}

	public void setRecorTaskdDate(String recorTaskdDate) {
		this.recorTaskdDate = recorTaskdDate;
	}

	public int getRecordUserId() {
		return recordUserId;
	}

	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}

	public int getRemoveState() {
		return removeState;
	}

	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}
	
}

