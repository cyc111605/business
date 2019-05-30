package com.business.vo;

import java.util.Date;

public class UserLeave {
	private String leaveId;
	private String leaveName;
	private String leaveInfo;
	private Date leaveTime;
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveName() {
		return leaveName;
	}
	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}
	public String getLeaveInfo() {
		return leaveInfo;
	}
	public void setLeaveInfo(String leaveInfo) {
		this.leaveInfo = leaveInfo;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	
}
