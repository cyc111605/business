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
import com.business.vo.NewsInfo;

public class AllNews extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession sess=req.getSession();
		try{
			List<NewsInfo> all=new ArrayList<NewsInfo>();
			all=DAOFactory.getINews().findAll();
			Iterator<NewsInfo> iter=all.iterator();
			if(iter.hasNext()){
				sess.setAttribute("newsoutput", all);
				RequestDispatcher resd=req.getRequestDispatcher("/jsp/companyNews.jsp");
				resd.forward(req, resp);
			}
			else{
				sess.setAttribute("newsinfo", "ÔÝÎÞÐÂÎÅ");
				RequestDispatcher resd=req.getRequestDispatcher("/jsp/companyNews.jsp");
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
