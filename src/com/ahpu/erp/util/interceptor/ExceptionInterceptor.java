package com.ahpu.erp.util.interceptor;

import com.ahpu.erp.util.exception.AppException;
import com.ahpu.erp.util.mail.MailUtil;
import com.ahpu.erp.util.uuid.UUIDutil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			return invocation.invoke();
		} catch (AppException e) {
			//��¼��־
			//������־������
			ActionSupport as = (ActionSupport) invocation.getAction();
			as.addActionError(as.getText(e.getMessage()));
			String code = UUIDutil.getUUID();
			MailUtil.sendMail("hr@gfashion.com", code);
			return "error";
		}catch (Exception e) {
			ActionSupport as = (ActionSupport) invocation.getAction();
			as.addActionError("�������ѹرգ�����ϵ����Ա��");
			String code = UUIDutil.getUUID();
			MailUtil.sendMail("hr@gfashion.com", code);
			e.printStackTrace();
			return "error";
		}
		
	}
	
}
