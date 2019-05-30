package com.business.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import com.business.dao.IUserInfo;
import com.business.dao.impl.UserInfoDAOImpl;
import com.business.dbc.DatabaseConnection;
import com.business.vo.UserInfo;

public class UserInfoDAOProxy implements IUserInfo{
	private DatabaseConnection dbc=null;
	private IUserInfo dao=null;
	public UserInfoDAOProxy()throws Exception{
		this.dbc=new DatabaseConnection();
		this.dao=new UserInfoDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doInsert(UserInfo user) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(user.getUserId())==false){
				flag=this.dao.doInsert(user);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(UserInfo user) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(user.getUserId())){
				flag=this.dao.doDelete(user);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(UserInfo user) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(user.getUserId())){
				flag=this.dao.doUpdate(user);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
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
	public List<UserInfo> findAll() throws Exception {
		List<UserInfo> all=new ArrayList<UserInfo>();
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
	public UserInfo findByIdI(String id) throws Exception {
		UserInfo  user=new UserInfo();
		try{
			user=this.dao.findByIdI(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return user;
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
	public List<UserInfo> findBlur(String key) throws Exception {
		List<UserInfo> all=null;
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
	public List<UserInfo> findAdmin(int number) throws Exception {
		List<UserInfo> all=null;
		try{
			all=this.dao.findAdmin(number);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
	@Override
	public List<UserInfo> findBlurAdmin(String key) throws Exception {
		List<UserInfo> all=null;
		try{
			all=this.dao.findBlurAdmin(key);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

}
