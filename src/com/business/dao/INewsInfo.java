package com.business.dao;

import java.util.List;

import com.business.vo.NewsInfo;

public interface INewsInfo {
	public boolean doInsert(NewsInfo newsinfo)throws Exception;
	public boolean doDelete(NewsInfo newsinfo)throws Exception;
	public boolean doUpdate(NewsInfo newsinfo)throws Exception;
	public int findCount()throws Exception;
	public List<NewsInfo> findAll()throws Exception;
	public boolean findById(String id)throws Exception;
	public NewsInfo findByIdI(String id)throws Exception;
	public List<NewsInfo> findBlur(String key)throws Exception;
	public NewsInfo findByName(String name) throws Exception;
}
