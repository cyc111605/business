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

public class ShowNews extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession sess=req.getSession();
		String newsid=req.getParameter("newsid");
		System.out.println(newsid);
		try{
			NewsInfo news=DAOFactory.getINews().findByIdI(newsid);
			DAOFactory.getINews().findByIdI(newsid);
			sess.setAttribute("newsinfoout", news);
			System.out.println(news.getNewsAbstract());
			RequestDispatcher resd=req.getRequestDispatcher("/jsp/shownews.jsp");
			resd.forward(req, resp);
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
