package com.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.IProductsInfo;
import com.business.vo.ProductsInfo;

public class ProductsInfoDAOImpl implements IProductsInfo{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public ProductsInfoDAOImpl(Connection conn){
		this.conn=conn;
	}
	@Override
	public boolean doInsert(ProductsInfo productsinfo) throws Exception {
		boolean flag=false;
		String sql="insert into products_info values(?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, productsinfo.getProductId());
		this.pstmt.setString(2, productsinfo.getProductName());
		this.pstmt.setString(3, productsinfo.getProductAbstract());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(ProductsInfo productsinfo) throws Exception {
		boolean flag=false;
		String sql="delete from products_info where product_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, productsinfo.getProductId());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doUpdate(ProductsInfo productsinfo) throws Exception {
		boolean flag=false;
		String sql="update products_info set product_id=?,product_name=?,product_abstract=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, productsinfo.getProductId());
		this.pstmt.setString(2, productsinfo.getProductName());
		this.pstmt.setString(3, productsinfo.getProductAbstract());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public int findCount() throws Exception {
		int count=0;
		String sql="select count(*) from products_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) count=rs.getInt(1);
		this.pstmt.close();
		return count;
	}

	@Override
	public List<ProductsInfo> findAll() throws Exception {
		List<ProductsInfo> all=new ArrayList<ProductsInfo>();
		String sql="select * from products_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		ProductsInfo productsinfo=null;
		while(rs.next()){
			productsinfo=new ProductsInfo();
			productsinfo.setProductId(rs.getString(1));
			productsinfo.setProductName(rs.getString(2));
			productsinfo.setProductAbstract(rs.getString(3));
			all.add(productsinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public boolean findById(String id) throws Exception {
		boolean flag=false;
		String sql="select * from products_info where product_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public ProductsInfo findByIdI(String id) throws Exception {
		ProductsInfo productsinfo=null;
		String sql="select * from products_info where product_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			productsinfo=new ProductsInfo();
			productsinfo.setProductId(rs.getString(1));
			productsinfo.setProductName(rs.getString(2));
			productsinfo.setProductAbstract(rs.getString(3));
		}
		this.pstmt.close();
		return productsinfo;
	}

	@Override
	public List<ProductsInfo> findBlurName(String key) throws Exception {
		List<ProductsInfo> all=new ArrayList<ProductsInfo>();
		String sql="select * from products_info where product_name like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		ProductsInfo productsinfo=null;
		while(rs.next()){
			productsinfo=new ProductsInfo();
			productsinfo.setProductId(rs.getString(1));
			productsinfo.setProductName(rs.getString(2));
			productsinfo.setProductAbstract(rs.getString(3));
			all.add(productsinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<ProductsInfo> findBlurText(String key) throws Exception {
		List<ProductsInfo> all=new ArrayList<ProductsInfo>();
		String sql="select * from products_info where product_abstract like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		ProductsInfo productsinfo=null;
		while(rs.next()){
			productsinfo=new ProductsInfo();
			productsinfo.setProductId(rs.getString(1));
			productsinfo.setProductName(rs.getString(2));
			productsinfo.setProductAbstract(rs.getString(3));
			all.add(productsinfo);
		}
		this.pstmt.close();
		return all;
	}

}
