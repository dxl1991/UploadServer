package com.dxl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class GetStarGameVersion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(GetStarGameVersion.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String checkType = request.getParameter("checkType");
		LOGGER.info("checkType = " + checkType);
		if("1".equals(checkType)){
			String referer = request.getHeader("Referer");
			if(referer == null){
				LOGGER.info("referer = null");
				response.getWriter().append("0");
			}
			LOGGER.info(referer);
			try{
				String[] temps = referer.split("/");
				String version = temps[temps.length - 2];
				//版本号为 0 表示为开发版、体验版以及审核版本，版本号为 devtools 表示为开发者工具，其余为正式版本
				if("0".equals(version)){
					response.getWriter().append("1");
					LOGGER.info("屏蔽分享按钮");
				}else{
					response.getWriter().append("0");
				}
			}catch (Exception e) {
				response.getWriter().append("0");
				LOGGER.info(e.getMessage());
			}
		}else{
			String versionStr = request.getParameter("version");
			int version = 0;
			try{
				version = Integer.parseInt(versionStr);
			}catch(Exception e){
				response.getWriter().append("0");
				return;
			}
			
			if(version == SetStarGameVersion.version){
				response.getWriter().append("1");
				LOGGER.info("屏蔽分享按钮");
			}else{
				response.getWriter().append("0");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
