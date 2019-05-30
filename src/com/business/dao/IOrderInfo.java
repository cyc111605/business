package com.business.dao;

import java.util.List;

import com.business.vo.OrderInfo;

public interface IOrderInfo {
	public boolean doInsert(OrderInfo orderinfo)throws Exception;
	public boolean doDelete(OrderInfo orderinfo)throws Exception;
	public boolean doUpdate(OrderInfo orderinfo)throws Exception;
	public int findCount()throws Exception;
	public List<OrderInfo> findAll()throws Exception;
	public boolean findById(String id)throws Exception;
	public OrderInfo findByIdI(String id)throws Exception;
	public List<OrderInfo> findBlur(String key)throws Exception;
	public List<OrderInfo> findOut(int out)throws Exception;
	public List<OrderInfo> findOver(int over)throws Exception;
	public List<OrderInfo> findUser(String user)throws Exception;
	public List<OrderInfo> findProduct(String product)throws Exception;
}
