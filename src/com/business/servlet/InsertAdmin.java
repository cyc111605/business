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

public class InsertAdmin extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserInfo user=new UserInfo();
		String username=req.getParameter("uname");
		String upass1=req.getParameter("upass1");
		try {
			int count=DAOFactory.getIUserInfo().findCount();
			if(DAOFactory.getIUserInfo().findById(String.valueOf(count))==false){
				System.out.println(String.valueOf(count));
				String id=String.valueOf(count);
				user.setUserId(id);
				user.setUserName(username);
				user.setUserPass(upass1);
				user.setAdmin(0);
				if(DAOFactory.getIUserInfo().doInsert(user)){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "添加成功,此管理员ID是"+count+"请牢记！");
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}else{
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "添加失败，请重试");
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}
			}else{
				while(DAOFactory.getIUserInfo().findById(String.valueOf(count))){
					count++;
				}
				String id=String.valueOf(count);
				user.setUserId(id);
				user.setUserName(username);
				user.setUserPass(upass1);
				user.setAdmin(0);
				if(DAOFactory.getIUserInfo().doInsert(user)){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "添加成功,此管理员ID是"+count+"请牢记！");
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}else{
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "添加失败，请重试");
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}
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
