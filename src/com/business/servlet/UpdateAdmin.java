package com.business.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.business.factory.DAOFactory;
import com.business.vo.UserInfo;

public class UpdateAdmin extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserInfo user=new UserInfo();
		String upass1=req.getParameter("upass1");
		String id=req.getParameter("uid");
		try {
			if(DAOFactory.getIUserInfo().findById(id)){ 
				user.setUserId(id);
				user.setUserName(DAOFactory.getIUserInfo().findByIdI(id).getUserName());
				user.setUserPass(upass1);
				user.setAdmin(0);
				if(DAOFactory.getIUserInfo().findByIdI(id).getAdmin()==1){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "请在会员管理页面进行修改");
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}else{
					if(DAOFactory.getIUserInfo().doUpdate(user)){
						HttpSession sess=req.getSession();
						sess.setAttribute("info", "修改成功");
						RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
						resd.forward(req, resp);
					}else{
						HttpSession sess=req.getSession();
						sess.setAttribute("info", "修改失败，请重试");
						RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
						resd.forward(req, resp);
					}
				}
			}else{
				HttpSession sess=req.getSession();
				sess.setAttribute("info", "查找不到该ID");
				RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
				resd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException ,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		this.doGet(req, resp);
	}
}
