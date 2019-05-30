package com.business.dao;

import java.util.List;

import com.business.vo.UserLeave;

public interface IUserLeave {
	public boolean doInsert(UserLeave userleave)throws Exception;
	public boolean doDelete(UserLeave userleave)throws Exception;
	public boolean doUpdate(UserLeave userleave)throws Exception;
	public int findCount()throws Exception;
	public List<UserLeave> findAll()throws Exception;
	public boolean findById(String id)throws Exception;
	public UserLeave findByIdI(String id)throws Exception;
	public List<UserLeave> findBlurText(String key)throws Exception;
	public List<UserLeave> findByName(String user)throws Exception;
	public List<UserLeave> findBlur(String key)throws Exception;
	public List<UserLeave> findFlag(int flag)throws Exception;
}
