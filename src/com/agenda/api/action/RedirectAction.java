package com.agenda.api.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RedirectAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//http://www.changanfordclub.com/infocollection/potentialcustomer/2016taurus/index.jspx?channel=48&utm_source=Dealer&utm_medium=H5
		String channel = req.getParameter("channel");
		String utm_source = req.getParameter("utm_source");
		String utm_medium = req.getParameter("utm_medium");
		
		String redurl = "http://fordclub.changanford.cn/infocollection/potentialcustomer/2016taurus/index.jspx?channel=" + channel + "&utm_source=" + utm_source + "&utm_medium=" + utm_medium;
		resp.sendRedirect(redurl);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
