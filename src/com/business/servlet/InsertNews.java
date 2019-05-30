package com.business.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.business.factory.DAOFactory;
import com.business.vo.NewsInfo;

public class InsertNews extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		NewsInfo news=new NewsInfo();
		try {
			int count=DAOFactory.getINews().findCount();
			if(count==0){
				String id=String.valueOf(count+1);
				news.setNewsId(id);
				news.setNewsName(title);
				news.setNewsAbstract(content);
				if(DAOFactory.getINews().doInsert(news)){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "编号为"+(count+1)+"的新闻发布成功");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
					resd.forward(req, resp);
				}else{
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "添加失败，请重试");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
					resd.forward(req, resp);
				}
			}else if(DAOFactory.getINews().findById(String.valueOf(count))==false){
				System.out.println(String.valueOf(count));
				String id=String.valueOf(count);
				news.setNewsId(id);
				news.setNewsName(title);
				news.setNewsAbstract(content);
				if(DAOFactory.getINews().doInsert(news)){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "编号为"+count+"的新闻发布成功");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
					resd.forward(req, resp);
				}else{
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "添加失败，请重试");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
					resd.forward(req, resp);
				}
			}else{
				while(DAOFactory.getINews().findById(String.valueOf(count))){
					count++;
				}
				String id=String.valueOf(count);
				news.setNewsId(id);
				news.setNewsName(title);
				news.setNewsAbstract(content);
				if(DAOFactory.getINews().doInsert(news)){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "编号为"+count+"的新闻发布成功");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
					resd.forward(req, resp);
				}else{
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "添加失败，请重试");
					RequestDispatcher resd=req.getRequestDispatcher("/end/newsManage.jsp");
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
