package com.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.business.dao.INewsInfo;
import com.business.vo.NewsInfo;

public class NewsInfoDAOImpl implements INewsInfo{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public NewsInfoDAOImpl(Connection conn){
		this.conn=conn;
	}
	@Override
	public boolean doInsert(NewsInfo newsinfo) throws Exception {
		boolean flag=false;
		String sql="insert into news_info values(?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, newsinfo.getNewsId());
		this.pstmt.setString(2, newsinfo.getNewsName());
		this.pstmt.setString(3, newsinfo.getNewsAbstract());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDelete(NewsInfo newsinfo) throws Exception {
		boolean flag=false;
		String sql="delete from news_info where news_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, newsinfo.getNewsId());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doUpdate(NewsInfo newsinfo) throws Exception {
		boolean flag=false;
		String sql="update news_info set news_name=?,news_abstract=? where news_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, newsinfo.getNewsName());
		this.pstmt.setString(2, newsinfo.getNewsAbstract());
		this.pstmt.setString(3, newsinfo.getNewsId());
		if(this.pstmt.executeUpdate()>0) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public int findCount() throws Exception {
		int count=0;
		String sql="select count(*) from news_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) count=rs.getInt(1);
		this.pstmt.close();
		return count;
	}

	@Override
	public List<NewsInfo> findAll() throws Exception {
		List<NewsInfo> all=new ArrayList<NewsInfo>();
		String sql="select * from news_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		NewsInfo newsinfo=null;
		while(rs.next()){
			newsinfo=new NewsInfo();
			newsinfo.setNewsId(rs.getString(1));
			newsinfo.setNewsName(rs.getString(2));
			newsinfo.setNewsAbstract(rs.getString(3));
			all.add(newsinfo);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public boolean findById(String id) throws Exception {
		boolean flag=false;
		String sql="select * from news_info where news_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) flag=true;
		this.pstmt.close();
		return flag;
	}

	@Override
	public NewsInfo findByIdI(String id) throws Exception {
		NewsInfo newsinfo=null;
		String sql="select * from news_info where news_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			newsinfo=new NewsInfo();
			newsinfo.setNewsId(rs.getString(1));
			newsinfo.setNewsName(rs.getString(2));
			newsinfo.setNewsAbstract(rs.getString(3));
		}
		this.pstmt.close();
		return newsinfo;
	}
	public NewsInfo findByName(String name) throws Exception {
		NewsInfo newsinfo=null;
		String sql="select * from news_info where news_name=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, name);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			newsinfo=new NewsInfo();
			newsinfo.setNewsId(rs.getString(1));
			newsinfo.setNewsName(rs.getString(2));
			newsinfo.setNewsAbstract(rs.getString(3));
		}
		this.pstmt.close();
		return newsinfo;
	}
	@Override
	public List<NewsInfo> findBlur(String key) throws Exception {
		List<NewsInfo> all=new ArrayList<NewsInfo>();
		String sql="select * from news_info where news_name like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+key+"%");
		ResultSet rs=this.pstmt.executeQuery();
		NewsInfo newsinfo=null;
		while(rs.next()){
			newsinfo=new NewsInfo();
			newsinfo.setNewsId(rs.getString(1));
			newsinfo.setNewsName(rs.getString(2));
			newsinfo.setNewsAbstract(rs.getString(3));
			all.add(newsinfo);
		}
		this.pstmt.close();
		return all;
	}
	
}
