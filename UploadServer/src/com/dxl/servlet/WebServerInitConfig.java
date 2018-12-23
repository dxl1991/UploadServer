package com.dxl.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebServerInitConfig implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
//		PropertyConfigurator.configure("");
		System.out.println("初始化");
//		File dir = new File("log");
//		if(!dir.exists()){
//			dir.mkdirs();
//		}
//		File file = new File("log" + File.separator + "debug.log");
//		if(file.exists()){
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(file.getAbsolutePath());
	}

}
