package com.business.dao;

import java.util.List;

import com.business.vo.ProductsInfo;

public interface IProductsInfo {
	public boolean doInsert(ProductsInfo productsinfo)throws Exception;
	public boolean doDelete(ProductsInfo productsinfo)throws Exception;
	public boolean doUpdate(ProductsInfo productsinfo)throws Exception;
	public int findCount()throws Exception;
	public List<ProductsInfo> findAll()throws Exception;
	public boolean findById(String id)throws Exception;
	public ProductsInfo findByIdI(String id)throws Exception;
	public List<ProductsInfo> findBlurName(String key)throws Exception;
	public List<ProductsInfo> findBlurText(String key)throws Exception;
}
