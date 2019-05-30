package com.business.dao.proxy;

import java.util.List;

import com.business.dao.INewsInfo;
import com.business.dao.impl.NewsInfoDAOImpl;
import com.business.dbc.DatabaseConnection;
import com.business.vo.NewsInfo;

public class NewsInfoDAOProxy implements INewsInfo{
	private DatabaseConnection dbc=null;
	private INewsInfo dao=null;
	public NewsInfoDAOProxy()throws Exception{
		this.dbc=new DatabaseConnection();
		this.dao=new NewsInfoDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doInsert(NewsInfo newsinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(newsinfo.getNewsId())==false){
				flag=this.dao.doInsert(newsinfo);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public boolean doDelete(NewsInfo newsinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(newsinfo.getNewsId())==true){
				flag=this.dao.doDelete(newsinfo);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public boolean doUpdate(NewsInfo newsinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(newsinfo.getNewsId())==true){
				flag=this.dao.doUpdate(newsinfo);
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
	public List<NewsInfo> findAll() throws Exception {
		List<NewsInfo> all=null;
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
	public NewsInfo findByIdI(String id) throws Exception {
		NewsInfo newsinfo=null;
		try{
			newsinfo=this.dao.findByIdI(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return newsinfo;
	}
	@Override
	public List<NewsInfo> findBlur(String key) throws Exception {
		List<NewsInfo> all=null;
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
	public NewsInfo findByName(String name) throws Exception {
		NewsInfo newsinfo=null;
		try{
			newsinfo=this.dao.findByName(name);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return newsinfo;
	}
}
