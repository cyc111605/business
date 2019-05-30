package com.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.IUserInfo;
import com.business.vo.UserInfo;

public class UserInfoDAOImpl implements IUserInfo{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public UserInfoDAOImpl(Connection conn){
		this.conn=conn;
	}
	@Override
	public boolean doInsert(UserInfo user) throws Exception {
		boolean flag=false;
		String sql="insert into user_info values(?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserId());
		this.pstmt.setString(2, user.getUserName());
		this.pstmt.setString(3, user.getUserPass());
		this.pstmt.setInt(4, user.getAdmin());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}
	@Override
	public boolean doDelete(UserInfo user) throws Exception {
		boolean flag=false;
		String sql="delete from user_info where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserId());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}
	@Override
	public boolean doUpdate(UserInfo user) throws Exception {
		boolean flag=false;
		String sql="update user_info set user_name=?,user_pass=?,admin=? where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserName());
		this.pstmt.setString(2, user.getUserPass());
		this.pstmt.setInt(3, user.getAdmin());
		this.pstmt.setString(4, user.getUserId());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}
	@Override
	public boolean findById(String id) throws Exception {
		boolean flag=false;
		String sql="select * from user_info where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) flag=true;
		this.pstmt.close();
		return flag;
	}
	@Override
	public List<UserInfo> findAll() throws Exception {
		List<UserInfo> all=new ArrayList<UserInfo>();
		String sql="select * from user_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		UserInfo user=null;
		while(rs.next()){
			user=new UserInfo();
			user.setUserId(rs.getString(1));
			user.setUserName(rs.getString(2));
			user.setUserPass(rs.getString(3));
			user.setAdmin(rs.getInt(4));
			all.add(user);
		}
		this.pstmt.close();
		return all;
	}
	@Override
	public UserInfo findByIdI(String id) throws Exception {
		UserInfo user=null;
		String sql="select * from user_info where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			user=new UserInfo();
			user.setUserId(rs.getString(1));
			user.setUserName(rs.getString(2));
			user.setUserPass(rs.getString(3));
			user.setAdmin(rs.getInt(4));
		}
		this.pstmt.close();
		return user;
	}
	@Override
	public int findCount() throws Exception {
		int count=0;
		String sql="select count(*) from user_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) count=rs.getInt(1);
		return count;
	}
	@Override
	public List<UserInfo> findBlur(String key) throws Exception {
		List<UserInfo> all=new ArrayList<UserInfo>();
		String sql="select * from user_info where user_name like ? and admin=1";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		UserInfo user=null;
		while(rs.next()){
			user=new UserInfo();
			user.setUserId(rs.getString(1));
			user.setUserName(rs.getString(2));
			user.setUserPass(rs.getString(3));
			user.setAdmin(rs.getInt(4));
			all.add(user);
		}
		this.pstmt.close();
		return all;
	}
	public List<UserInfo> findBlurAdmin(String key) throws Exception {
		List<UserInfo> all=new ArrayList<UserInfo>();
		String sql="select * from user_info where user_name like ? and admin=0";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		UserInfo user=null;
		while(rs.next()){
			user=new UserInfo();
			user.setUserId(rs.getString(1));
			user.setUserName(rs.getString(2));
			user.setUserPass(rs.getString(3));
			user.setAdmin(rs.getInt(4));
			all.add(user);
		}
		this.pstmt.close();
		return all;
	}
	@Override
	public List<UserInfo> findAdmin(int number) throws Exception {
		List<UserInfo> all=new ArrayList<UserInfo>();
		String sql="select * from user_info where admin=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,number);
		ResultSet rs=this.pstmt.executeQuery();
		UserInfo user=null;
		while(rs.next()){
			user=new UserInfo();
			user.setUserId(rs.getString(1));
			user.setUserName(rs.getString(2));
			user.setUserPass(rs.getString(3));
			user.setAdmin(rs.getInt(4));
			all.add(user);
		}
		this.pstmt.close();
		return all;
	}
}