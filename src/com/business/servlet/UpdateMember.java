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

public class UpdateMember extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserInfo user=new UserInfo();
		String username=req.getParameter("uname");
		String upass1=req.getParameter("upass1");
		String id=req.getParameter("uid");
		try {
			if(DAOFactory.getIUserInfo().findById(id)){
				user.setUserId(id);
				user.setUserName(username);
				user.setUserPass(upass1);
				user.setAdmin(1);
				if(DAOFactory.getIUserInfo().findByIdI(id).getAdmin()==0){
					HttpSession sess=req.getSession();
					sess.setAttribute("info", "��û��Ȩ���޸Ĺ���Ա��Ϣ");
					RequestDispatcher resd=req.getRequestDispatcher("/end/memeberManage.jsp");
					resd.forward(req, resp);
				}else{
					if(DAOFactory.getIUserInfo().doUpdate(user)){
						HttpSession sess=req.getSession();
						sess.setAttribute("info", "��Ա��Ϣ�޸ĳɹ�");
						RequestDispatcher resd=req.getRequestDispatcher("/end/memberManage.jsp");
						resd.forward(req, resp);
					}else{ 
						HttpSession sess=req.getSession();
						sess.setAttribute("info", "��Ա��Ϣ�޸�ʧ�ܣ�������");
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
