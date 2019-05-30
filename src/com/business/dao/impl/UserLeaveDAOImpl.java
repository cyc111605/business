package com.business.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.business.dao.IUserLeave;
import com.business.vo.UserLeave;
public class UserLeaveDAOImpl implements IUserLeave{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public UserLeaveDAOImpl(Connection conn){
		this.conn=conn;
	}
	@Override
	public boolean doInsert(UserLeave userleave) throws Exception {
		boolean flag=false;
		String sql="insert into user_leave values(?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, userleave.getLeaveId());
		this.pstmt.setString(2, userleave.getLeaveName());
		this.pstmt.setString(3, userleave.getLeaveInfo());
		this.pstmt.setDate(4,new java.sql.Date(new Date().getTime()));
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(UserLeave userleave) throws Exception {
		boolean flag=false;
		String sql="delete from user_leave where leave_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, userleave.getLeaveId());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doUpdate(UserLeave userleave) throws Exception {
		boolean flag=false;
		String sql="update user_leave set leave_name=?,leave_info=?,leave_time=? where leave_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, userleave.getLeaveId());
		this.pstmt.setString(2, userleave.getLeaveName());
		this.pstmt.setString(3, userleave.getLeaveInfo());
		this.pstmt.setDate(4,new java.sql.Date(new Date().getTime()));
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}
	@Override
	public int findCount() throws Exception {
		int count=0;
		String sql="select (*) from user_leave";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) count=rs.getInt(1);
		this.pstmt.close();
		return count;
	}

	@Override
	public List<UserLeave> findAll() throws Exception {
		List<UserLeave> all=new ArrayList<UserLeave>();
		String sql="select * from user_leave";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		UserLeave userleave=null;
		while(rs.next()){
			userleave =new UserLeave();
			userleave.setLeaveId(rs.getString(1));
			userleave.setLeaveName(rs.getString(2));
			userleave.setLeaveInfo(rs.getString(3));
			userleave.setLeaveTime(rs.getDate(4));
			all.add(userleave);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public boolean findById(String id) throws Exception {
		boolean flag=false;
		String sql="select * from user_leave where leave_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public UserLeave findByIdI(String id) throws Exception {
		UserLeave userleave=null;
		String sql="select * from user_leave where leave_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			userleave=new UserLeave();
			userleave.setLeaveId(rs.getString(1));
			userleave.setLeaveName(rs.getString(2));
			userleave.setLeaveInfo(rs.getString(3));
			userleave.setLeaveTime(rs.getDate(4));
		}
		this.pstmt.close();
		return userleave;
	}

	@Override
	public List<UserLeave> findBlurText(String key) throws Exception {
		List<UserLeave> all=new ArrayList<UserLeave>();
		String sql="select * from leave_info like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		UserLeave userleave=null;
		while(rs.next()){
			userleave=new UserLeave();
			userleave.setLeaveId(rs.getString(1));
			userleave.setLeaveName(rs.getString(2));
			userleave.setLeaveInfo(rs.getString(3));
			userleave.setLeaveTime(rs.getDate(4));
			all.add(userleave);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<UserLeave> findByName(String user) throws Exception {
		List<UserLeave> all=new ArrayList<UserLeave>();
		String sql="select * from user_leave where leave_name like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+user+"%");
		ResultSet rs=this.pstmt.executeQuery();
		UserLeave userleave=null;
		while(rs.next()){
			userleave=new UserLeave();
			userleave.setLeaveId(rs.getString(1));
			userleave.setLeaveName(rs.getString(2));
			userleave.setLeaveInfo(rs.getString(3));
			userleave.setLeaveTime(rs.getDate(4));
			all.add(userleave);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<UserLeave> findBlur(String key) throws Exception {
		List<UserLeave> all=new ArrayList<UserLeave>();
		String sql="select * from user_leave where leave_name like ? or leave_info like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+key+"%");
		this.pstmt.setString(2, "%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		UserLeave userleave=null;
		while(rs.next()){
			userleave=new UserLeave();
			userleave.setLeaveId(rs.getString(1));
			userleave.setLeaveName(rs.getString(2));
			userleave.setLeaveInfo(rs.getString(3));
			userleave.setLeaveTime(rs.getDate(4));
			all.add(userleave);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<UserLeave> findFlag(int flag) throws Exception {
		List<UserLeave> all=new ArrayList<UserLeave>();
		String sql="select * from user_leave where news_products=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, flag);
		ResultSet rs=this.pstmt.executeQuery();
		UserLeave userleave=null;
		while(rs.next()){
			userleave=new UserLeave();
			userleave.setLeaveId(rs.getString(1));
			userleave.setLeaveName(rs.getString(2));
			userleave.setLeaveInfo(rs.getString(3));
			userleave.setLeaveTime(rs.getDate(4));
			all.add(userleave);
		}
		this.pstmt.close();
		return all;
	}
    
}
