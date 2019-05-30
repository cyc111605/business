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

public class DeleteMember extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserInfo user=new UserInfo();
		String id=req.getParameter("uid");
		try {
			if(DAOFactory.getIUserInfo().findById(id)){
				user.setUserId(id);
				if(DAOFactory.getIUserInfo().findByIdI(id).getAdmin()==0){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "��û��Ȩ��ɾ������Ա");
					RequestDispatcher resd=req.getRequestDispatcher("/end/memberManage.jsp");
					resd.forward(req, resp);
				}else{
					if(DAOFactory.getIUserInfo().doDelete(user)){
						HttpSession sess=req.getSession();
						sess.setAttribute("info", "ɾ���ɹ�");
						RequestDispatcher resd=req.getRequestDispatcher("/end/memberManage.jsp");
						resd.forward(req, resp);
					}else{ 
						HttpSession sess=req.getSession();
						sess.setAttribute("info", "ɾ��ʧ�ܣ�������");
						RequestDispatcher resd=req.getRequestDispatcher("/end/memberManage.jsp");
						resd.forward(req, resp);
					}
				}
			}else{
				HttpSession sess=req.getSession();
				sess.setAttribute("info", "���Ҳ�����ID");
				RequestDispatcher resd=req.getRequestDispatcher("/end/memberManage.jsp");
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
