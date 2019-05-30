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
import com.business.vo.*;

public class SelectNews extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession sess=req.getSession();
		String flag=req.getParameter("flag");
		try{
			if(flag.equals("key")){
				String key=req.getParameter("name");
				System.out.println(key);
				System.out.println(DAOFactory.getINews().findBlur("陈"));
				List<NewsInfo> all=DAOFactory.getINews().findBlur(key);
				
				Iterator<NewsInfo> iter=all.iterator();
				if(iter.hasNext()){
					sess.setAttribute("resultkey", all);
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
					resd.forward(req, resp);
				}else{
					sess.setAttribute("info", "查询无结果");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
					resd.forward(req, resp);
				}
			}else if(flag.equals("id")){
				String uid=req.getParameter("uid");
				if(DAOFactory.getINews().findById(uid)){
						NewsInfo news=new NewsInfo();
						if(DAOFactory.getINews().findById(uid)){
							news=DAOFactory.getINews().findByIdI(uid);
							sess.setAttribute("result", news);
							RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
							resd.forward(req, resp);
					}else{
						sess.setAttribute("info", "查询无结果");
						RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
						resd.forward(req, resp);
					}
				}else{
					sess.setAttribute("info", "查询不到该ID");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
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
