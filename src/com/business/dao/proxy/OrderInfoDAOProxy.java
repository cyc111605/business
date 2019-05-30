package com.business.dao.proxy;

import java.util.List;

import com.business.dao.IOrderInfo;
import com.business.dao.impl.OrderInfoDAOImpl;
import com.business.dbc.DatabaseConnection;
import com.business.vo.OrderInfo;

public class OrderInfoDAOProxy implements IOrderInfo{
	private DatabaseConnection dbc=null;
	private IOrderInfo dao=null;
	public OrderInfoDAOProxy()throws Exception{
		this.dbc=new DatabaseConnection();
		this.dao=new OrderInfoDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doInsert(OrderInfo orderinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(orderinfo.getOrderId())==false){
				flag=this.dao.doInsert(orderinfo);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(OrderInfo orderinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(orderinfo.getOrderId())){
				flag=this.dao.doDelete(orderinfo);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(OrderInfo orderinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(orderinfo.getOrderId())){
				flag=this.dao.doUpdate(orderinfo);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public int findCount() throws Exception {
		int count=0;
		try{
			count=this.dao.findCount();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return count;
	}

	@Override
	public List<OrderInfo> findAll() throws Exception {
		List<OrderInfo> all=null;
		try{
			all=this.dao.findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public boolean findById(String id) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.findById(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public OrderInfo findByIdI(String id) throws Exception {
		OrderInfo orderinfo=null;
		try{
			orderinfo=this.dao.findByIdI(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return orderinfo;
	}

	@Override
	public List<OrderInfo> findBlur(String key) throws Exception {
		List<OrderInfo> all=null;
		try{
			all=this.dao.findBlur(key);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<OrderInfo> findOut(int out) throws Exception {
		List<OrderInfo> all=null;
		try{
			all=this.dao.findOut(out);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<OrderInfo> findOver(int over) throws Exception {
		List<OrderInfo> all=null;
		try{
			all=this.dao.findOver(over);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<OrderInfo> findUser(String user) throws Exception {
		List<OrderInfo> all=null;
		try{
			all=this.dao.findUser(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<OrderInfo> findProduct(String product) throws Exception {
		List<OrderInfo> all=null;
		try{
			all=this.dao.findProduct(product);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

}
