package com.ahpu.erp.util.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtil {
	
	public static void sendMail(String to,String code) throws Exception{
		//1.Session 
		Properties props= new Properties();
		props.setProperty("mail.smtp", "localhost");
		
		Session session = Session.getInstance(props,new Authenticator() {
		
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("service@gfashion.com", "admin");
				
			}
		});
		
		
		Message message = new MimeMessage(session);
		
		
		message.setFrom(new InternetAddress("service@gfashion.com"));
		
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		
		//messagetitle
		message.setSubject("错误邮件");
		//messageContent
		message.setContent("系统发生错误，请立即修改！", "text/html;charset=UTF-8");
		
		Transport.send(message);
		
	}

}
