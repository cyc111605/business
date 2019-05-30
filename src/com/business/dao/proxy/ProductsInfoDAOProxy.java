package com.business.dao.proxy;
import java.util.List;

import com.business.dao.IProductsInfo;
import com.business.dao.impl.ProductsInfoDAOImpl;
import com.business.dbc.DatabaseConnection;
import com.business.vo.ProductsInfo;
public class ProductsInfoDAOProxy implements IProductsInfo{
	private DatabaseConnection dbc=null;
	private IProductsInfo dao=null;
	public ProductsInfoDAOProxy()throws Exception{
		this.dbc=new DatabaseConnection();
		this.dao=new ProductsInfoDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doInsert(ProductsInfo productsinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(productsinfo.getProductId())==false){
				flag=this.dao.doInsert(productsinfo);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(ProductsInfo productsinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(productsinfo.getProductId())==true){
				flag=this.dao.doDelete(productsinfo);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(ProductsInfo productsinfo) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(productsinfo.getProductId())==true){
				flag=this.dao.doUpdate(productsinfo);
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
	public List<ProductsInfo> findAll() throws Exception {
		List<ProductsInfo> all=null;
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
	public ProductsInfo findByIdI(String id) throws Exception {
		ProductsInfo productsinfo=null;
		try{
			productsinfo=this.dao.findByIdI(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return productsinfo;
	}

	@Override
	public List<ProductsInfo> findBlurName(String key) throws Exception {
		List<ProductsInfo> all=null;
		try{
			all=this.dao.findBlurName(key);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<ProductsInfo> findBlurText(String key) throws Exception {
		List<ProductsInfo> all=null;
		try{
			all=this.dao.findBlurText(key);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

}
