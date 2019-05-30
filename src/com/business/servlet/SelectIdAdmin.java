package com.business.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.business.factory.DAOFactory;
import com.business.vo.UserInfo;

public class SelectIdAdmin extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession sess=req.getSession();
		String flag=req.getParameter("flag");
		try{
			if(flag.equals("key")){
				String key=req.getParameter("key");
				List<UserInfo> all=new ArrayList<UserInfo>();
				all=DAOFactory.getIUserInfo().findBlurAdmin(key);
				Iterator<UserInfo> iter=all.iterator();
					if(iter.hasNext()){
					sess.setAttribute("resultlist", all);
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}else{
					sess.setAttribute("info", "查询无结果");
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}
			}else{
				String uid=req.getParameter("uid");
				if(DAOFactory.getIUserInfo().findById(uid)){
					if(DAOFactory.getIUserInfo().findByIdI(uid).getAdmin()==0){
						UserInfo user=new UserInfo();
						if(DAOFactory.getIUserInfo().findById(uid)){
							user=DAOFactory.getIUserInfo().findByIdI(uid);
							sess.setAttribute("result", user);
							RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
							resd.forward(req, resp);
						}
					}else{
						sess.setAttribute("info", "查询无结果");
						RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
						resd.forward(req, resp);
					}
				}else{
					sess.setAttribute("info", "查询不到该ID");
					RequestDispatcher resd=req.getRequestDispatcher("/end/adminManage.jsp");
					resd.forward(req, resp);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		this.doGet(req, resp);
	}
}
