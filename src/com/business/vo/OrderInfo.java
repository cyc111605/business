package com.business.vo;

public class OrderInfo {
	private String orderId;
	private String buyName;
	private int buyNumber;
	private String buyProductsName;
	private int outInfo;
	private int overInfo;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBuyName() {
		return buyName;
	}
	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}
	public int getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}
	public String getBuyProductsName() {
		return buyProductsName;
	}
	public void setBuyProductsName(String buyProductsName) {
		this.buyProductsName = buyProductsName;
	}
	public int getOutInfo() {
		return outInfo;
	}
	public void setOutInfo(int outInfo) {
		this.outInfo = outInfo;
	}
	public int getOverInfo() {
		return overInfo;
	}
	public void setOverInfo(int overInfo) {
		this.overInfo = overInfo;
	}
	
}
