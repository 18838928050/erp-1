package com.ahpu.erp.util.interceptor;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.ahpu.erp.auth.resource.model.ResourceModel;
import com.ahpu.erp.auth.resource.service.service.ResourceService;
import com.ahpu.erp.util.exception.AppException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	/**
	 * 角色对应的权限校验器
	 */
	private ResourceService resourceService;
	
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
/*
	public String intercept1(ActionInvocation invocation) throws Exception {
		//获取本次操作
		String actionName = invocation.getProxy().getAction().getClass().getName();//action
		String methodName = invocation.getProxy().getMethod();//method
		String allName = actionName+"."+methodName;
		
		List<ResourceModel> resAll = resourceService.getAll();
		StringBuilder sbf = new StringBuilder();
		for(ResourceModel temp : resAll){
			sbf.append(temp.getUrl());
			sbf.append(",");
		}
		//sbf中保存有所有的需要校验的资源
		if(sbf.indexOf(allName)< 0 ){
			return invocation.invoke();
		}
		//校验
		//确认登录,获取登录人信息
		EmpModel loginEm = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
		List<ResourceModel> resourceList = resourceService.getAllById(loginEm.getUuid());
		for(ResourceModel rsm : resourceList){
			if(rsm.getUrl().equals(allName)){
				return invocation.invoke();
			}
		}
		throw new AppException("对不起,权限不足,请不要进行非法操作！");
		//判断是否拥有权限
	}
*/
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取本次操作
		String actionName = invocation.getProxy().getAction().getClass()
				.getName();// action
		String methodName = invocation.getProxy().getMethod();// method
		String allName = actionName + "." + methodName;

		String resAll = ServletActionContext.getServletContext().getAttribute("resAll").toString();
		// sbf中保存有所有的需要校验的资源
		if (!resAll.contains(allName)) {
			return invocation.invoke();
		}
		// 校验
		// 确认登录,获取登录人信息
		EmpModel loginEm = (EmpModel) ActionContext.getContext().getSession()
				.get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
		List<ResourceModel> resourceList = resourceService.getAllById(loginEm
				.getUuid());
		for (ResourceModel rsm : resourceList) {
			if (rsm.getUrl().equals(allName)) {
				return invocation.invoke();
			}
		}
		throw new AppException("对不起,权限不足,请不要进行非法操作！");
		// 判断是否拥有权限
	}

}
