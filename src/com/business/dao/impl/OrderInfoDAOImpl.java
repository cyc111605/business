package com.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.IOrderInfo;
import com.business.vo.OrderInfo;

public class OrderInfoDAOImpl implements IOrderInfo{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public OrderInfoDAOImpl(Connection conn){
		this.conn=conn;
	}
	@Override
	public boolean doInsert(OrderInfo orderinfo) throws Exception {
		boolean flag=false;
		String sql="insert into order_info values(?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, orderinfo.getOrderId());
		this.pstmt.setString(2, orderinfo.getBuyName());
		this.pstmt.setInt(3, orderinfo.getBuyNumber());
		this.pstmt.setString(4, orderinfo.getBuyProductsName());
		this.pstmt.setInt(5, orderinfo.getOutInfo());
		this.pstmt.setInt(6, orderinfo.getOverInfo());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(OrderInfo orderinfo) throws Exception {
		boolean flag=false;
		String sql="delete from order_info where order_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, orderinfo.getOrderId());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doUpdate(OrderInfo orderinfo) throws Exception {
		boolean flag=false;
		String sql="update order_info set order_id=?,buy_name=?,buy_number=?,buy_products_name=?,out_info=?,over_info=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, orderinfo.getOrderId());
		this.pstmt.setString(2, orderinfo.getBuyName());
		this.pstmt.setInt(3, orderinfo.getBuyNumber());
		this.pstmt.setString(4, orderinfo.getBuyProductsName());
		this.pstmt.setInt(5, orderinfo.getOutInfo());
		this.pstmt.setInt(6, orderinfo.getOverInfo());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public int findCount() throws Exception {
		int count=0;
		String sql="select count(*) from order_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) count=rs.getInt(1);
		this.pstmt.close();
		return count;
	}

	@Override
	public List<OrderInfo> findAll() throws Exception {
		List<OrderInfo> all=new ArrayList<OrderInfo>();
		String sql="select * from order_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		OrderInfo orderinfo=null;
		while(rs.next()){
			orderinfo=new OrderInfo();
			orderinfo.setOrderId(rs.getString(1));
			orderinfo.setBuyName(rs.getString(2));
			orderinfo.setBuyNumber(rs.getInt(3));
			orderinfo.setBuyProductsName(rs.getString(4));
			orderinfo.setOutInfo(rs.getInt(5));
			orderinfo.setOverInfo(rs.getInt(6));
			all.add(orderinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public boolean findById(String id) throws Exception {
		boolean flag=false;
		String sql="select * from order_info where order_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public OrderInfo findByIdI(String id) throws Exception {
		OrderInfo orderinfo=null;
		String sql="select * from order_info where order_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			orderinfo=new OrderInfo();
			orderinfo.setOrderId(rs.getString(1));
			orderinfo.setBuyName(rs.getString(2));
			orderinfo.setBuyNumber(rs.getInt(3));
			orderinfo.setBuyProductsName(rs.getString(4));
			orderinfo.setOutInfo(rs.getInt(5));
			orderinfo.setOverInfo(rs.getInt(6));
		}
		this.pstmt.close();
		return orderinfo;
	}

	@Override
	public List<OrderInfo> findBlur(String key) throws Exception {
		List<OrderInfo> all=new ArrayList<OrderInfo>();
		String sql="select * from order_info where buy_name like ? or buy_products_name like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,"%"+key+"%");
		this.pstmt.setString(2,"%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		OrderInfo orderinfo=null;
		while(rs.next()){
			orderinfo=new OrderInfo();
			orderinfo.setOrderId(rs.getString(1));
			orderinfo.setBuyName(rs.getString(2));
			orderinfo.setBuyNumber(rs.getInt(3));
			orderinfo.setBuyProductsName(rs.getString(4));
			orderinfo.setOutInfo(rs.getInt(5));
			orderinfo.setOverInfo(rs.getInt(6));
			all.add(orderinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<OrderInfo> findOut(int out) throws Exception {
		List<OrderInfo> all=new ArrayList<OrderInfo>();
		String sql="select * from order_info where out_info=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,out);
		ResultSet rs=this.pstmt.executeQuery();
		OrderInfo orderinfo=null;
		while(rs.next()){
			orderinfo=new OrderInfo();
			orderinfo.setOrderId(rs.getString(1));
			orderinfo.setBuyName(rs.getString(2));
			orderinfo.setBuyNumber(rs.getInt(3));
			orderinfo.setBuyProductsName(rs.getString(4));
			orderinfo.setOutInfo(rs.getInt(5));
			orderinfo.setOverInfo(rs.getInt(6));
			all.add(orderinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<OrderInfo> findOver(int over) throws Exception {
		List<OrderInfo> all=new ArrayList<OrderInfo>();
		String sql="select * from order_info where over_info=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,over);
		ResultSet rs=this.pstmt.executeQuery();
		OrderInfo orderinfo=null;
		while(rs.next()){
			orderinfo=new OrderInfo();
			orderinfo.setOrderId(rs.getString(1));
			orderinfo.setBuyName(rs.getString(2));
			orderinfo.setBuyNumber(rs.getInt(3));
			orderinfo.setBuyProductsName(rs.getString(4));
			orderinfo.setOutInfo(rs.getInt(5));
			orderinfo.setOverInfo(rs.getInt(6));
			all.add(orderinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<OrderInfo> findUser(String user) throws Exception {
		List<OrderInfo> all=new ArrayList<OrderInfo>();
		String sql="select * from order_info where buy_name=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,user);
		ResultSet rs=this.pstmt.executeQuery();
		OrderInfo orderinfo=null;
		while(rs.next()){
			orderinfo=new OrderInfo();
			orderinfo.setOrderId(rs.getString(1));
			orderinfo.setBuyName(rs.getString(2));
			orderinfo.setBuyNumber(rs.getInt(3));
			orderinfo.setBuyProductsName(rs.getString(4));
			orderinfo.setOutInfo(rs.getInt(5));
			orderinfo.setOverInfo(rs.getInt(6));
			all.add(orderinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<OrderInfo> findProduct(String product) throws Exception {
		List<OrderInfo> all=new ArrayList<OrderInfo>();
		String sql="select * from order_info where buy_products_name=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,product);
		ResultSet rs=this.pstmt.executeQuery();
		OrderInfo orderinfo=null;
		while(rs.next()){
			orderinfo=new OrderInfo();
			orderinfo.setOrderId(rs.getString(1));
			orderinfo.setBuyName(rs.getString(2));
			orderinfo.setBuyNumber(rs.getInt(3));
			orderinfo.setBuyProductsName(rs.getString(4));
			orderinfo.setOutInfo(rs.getInt(5));
			orderinfo.setOverInfo(rs.getInt(6));
			all.add(orderinfo);
		}
		this.pstmt.close();
		return all;
	}

}
