package com.dxl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetStarGameVersion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int version = -1;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String versionStr = request.getParameter("version");
		try{
			version = Integer.parseInt(versionStr);
		}catch(Exception e){
			response.getWriter().append("参数输入错误，请填写一个数字！");
			return;
		}
		if(version > 0){
			response.getWriter().append("设置成功！版本号为 ").append(versionStr).append(" 的版本将屏蔽分享按钮！");
		}else{
			response.getWriter().append("设置成功！已取消所有版本的分享屏蔽");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
