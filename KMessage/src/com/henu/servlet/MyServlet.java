package com.henu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Message;
import com.henu.dao.MessageDao;
import com.henu.factory.MessageDaoFactory;

/**
 * Servlet implementation class MyServlet
 */
/*@WebServlet({ "/MyServlet", "/*" })*/
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charset=UTF-8");
		String action=request.getParameter("action");
		if(action.equals("mydel"))
		{
			MessageDaoFactory.getMessageInstance().delete(request.getParameter("del"));
			RequestDispatcher dispatcher=request.getRequestDispatcher("sel.jsp");
			dispatcher.forward(request,response);
		}
		if(action.equals("add"))
		{
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date currentTime = new java.util.Date();//得到当前系统时间
			String date = formatter.format(currentTime); //将日期时间格式化 
			
			Message meg=new Message();
			meg.setMessage(request.getParameter("content"));
			meg.setUsername(request.getParameter("name"));
			meg.setSubmitTime(date);
			MessageDaoFactory.getMessageInstance().save(meg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("sel.jsp");
			dispatcher.forward(request,response);
		
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
