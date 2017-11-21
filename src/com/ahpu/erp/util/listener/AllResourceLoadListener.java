package com.ahpu.erp.util.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.service.service.ResourceService;

public class AllResourceLoadListener implements ServletContextListener {
	//œ˙ªŸ
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext sc = event.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		ResourceService resourceService = (ResourceService) ctx.getBean("resourceService");
		List<ResourceModel> resourceList = resourceService.getAll(); 
		StringBuilder sbf = new StringBuilder();
		for (ResourceModel temp : resourceList) {
			sbf.append(temp.getUrl());
			sbf.append(",");
		}
		//∑≈»Îsc
		sc.setAttribute("resAll", sbf.toString());
	}
	
}
