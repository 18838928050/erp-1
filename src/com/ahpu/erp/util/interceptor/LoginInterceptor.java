package com.ahpu.erp.util.interceptor;

import com.ahpu.erp.auth.emp.model.EmpModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
		//ִ�г��˵�¼����֮ǰ�����в�������¼У��
		//��ȡ���β�������Ϣ
		/*
		System.out.println(invocation.getProxy().getAction());
		System.out.println(invocation.getProxy().getActionName());		emp_login
		System.out.println(invocation.getProxy().getMethod());
		*/
		String actionName = invocation.getProxy().getAction().getClass().getName();
		String methodName = invocation.getProxy().getMethod();
		String allName = actionName+"."+methodName;
		
		if("com.ahpu.erp.auth.emp.action.EmpAction.login".equals(allName)){
			return invocation.invoke();
		}
		
		//��ȡ��ǰ��¼����Ϣ
		EmpModel loginEm = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
		//�����ǰû�е�¼����ת����¼ҳ��
		if(loginEm == null){
			//��ת����¼
			return "noLogin";
		}
		
		//ִ��ԭʼ����
		return invocation.invoke();
	}

	
}
