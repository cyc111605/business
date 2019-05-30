package com.business.factory;

import com.business.dao.INewsInfo;
import com.business.dao.IOrderInfo;
import com.business.dao.IProductsInfo;
import com.business.dao.IUserInfo;
import com.business.dao.IUserLeave;
import com.business.dao.proxy.NewsInfoDAOProxy;
import com.business.dao.proxy.OrderInfoDAOProxy;
import com.business.dao.proxy.ProductsInfoDAOProxy;
import com.business.dao.proxy.UserInfoDAOProxy;
import com.business.dao.proxy.UserLeaveDAOProxy;

public class DAOFactory {
	public static INewsInfo getINews() throws Exception{
		return new NewsInfoDAOProxy();
	}
	public static IProductsInfo getIProducts() throws Exception{
		return new ProductsInfoDAOProxy();
	}
	public static IUserInfo getIUserInfo() throws Exception{
		return new UserInfoDAOProxy();
	}
	public static IOrderInfo getOrderInfo() throws Exception{
		return new OrderInfoDAOProxy();
	}
	public static IUserLeave getUserLeave() throws Exception{
		return new UserLeaveDAOProxy();
	}
}
