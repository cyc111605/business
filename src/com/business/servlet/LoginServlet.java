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

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uid=req.getParameter("uid");
		String upass=req.getParameter("upass");
		HttpSession sess=req.getSession();
		sess.removeAttribute("info");
		try{	
			if(DAOFactory.getIUserInfo().findById(uid)){
				UserInfo user=new UserInfo();
				user=DAOFactory.getIUserInfo().findByIdI(uid);
				if(user.getUserPass().equals(upass)){
					if(user.getAdmin()==1){
						req.getSession().setAttribute("loginduser",user.getUserName());
						sess.setAttribute("inname",user.getUserName());
						RequestDispatcher resd=req.getRequestDispatcher("/index.jsp");
						resd.forward(req, resp);
					}else{
						req.getSession().setAttribute("loginduser",user.getUserName());
						req.getSession().setAttribute("logindadmin",user.getUserName());
						sess.setAttribute("inname",user.getUserName());
						RequestDispatcher resd=req.getRequestDispatcher("/end/adminLogin.jsp");
						resd.forward(req, resp);
					}
				}else{
					sess.setAttribute("info","µ«¬º ß∞‹£¨«Î÷ÿ ‘");
					RequestDispatcher resd=req.getRequestDispatcher("/jsp/Fail.jsp");
					resd.forward(req, resp);
				}
			}else{
				sess.setAttribute("info", "√ª”–¥À’À∫≈");
				RequestDispatcher resd=req.getRequestDispatcher("/jsp/Fail.jsp");
				resd.forward(req, resp);
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
