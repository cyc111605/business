package com.business.dao.proxy;

import java.util.List;

import com.business.dao.IUserLeave;
import com.business.dao.impl.UserLeaveDAOImpl;
import com.business.dbc.DatabaseConnection;
import com.business.vo.UserLeave;

public class UserLeaveDAOProxy implements IUserLeave{
	private DatabaseConnection dbc=null;
	private IUserLeave dao=null;
	public UserLeaveDAOProxy()throws Exception{
		this.dbc=new DatabaseConnection();
		this.dao=new UserLeaveDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doInsert(UserLeave userleave) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(userleave.getLeaveId())==false){
				flag=this.doInsert(userleave);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(UserLeave userleave) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(userleave.getLeaveId())){
				flag=this.doDelete(userleave);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(UserLeave userleave) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(userleave.getLeaveId())){
				flag=this.doUpdate(userleave);
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
	public List<UserLeave> findAll() throws Exception {
		List<UserLeave> all=null;
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
				flag=this.findById(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public UserLeave findByIdI(String id) throws Exception {
		UserLeave userleave=null;
		try{
			userleave=this.findByIdI(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return userleave;
	}

	@Override
	public List<UserLeave> findBlurText(String key) throws Exception {
		List<UserLeave> all=null;
		try{
			all=this.dao.findBlurText(key);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<UserLeave> findByName(String user) throws Exception {
		List<UserLeave> all=null;
		try{
			all=this.dao.findByName(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<UserLeave> findBlur(String key) throws Exception {
		List<UserLeave> all=null;
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
	public List<UserLeave> findFlag(int flag) throws Exception {
		List<UserLeave> all=null;
		try{
			all=this.dao.findFlag(flag);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
}
