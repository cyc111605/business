package com.business.dao;

import java.util.List;

import com.business.vo.UserInfo;


public interface IUserInfo {
	public boolean doInsert(UserInfo user)throws Exception;
	public boolean doDelete(UserInfo user)throws Exception;
	public boolean doUpdate(UserInfo user)throws Exception;
	public boolean findById(String id)throws Exception;
	public List<UserInfo> findAll()throws Exception;
	public UserInfo findByIdI(String id)throws Exception;
	public int findCount()throws Exception;
	public List<UserInfo> findBlur(String key)throws Exception;
	public List<UserInfo> findBlurAdmin(String key)throws Exception;
	public List<UserInfo> findAdmin(int number)throws Exception;
}
