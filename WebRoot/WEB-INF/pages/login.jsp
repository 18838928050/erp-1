<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>后台管理登录界面</title>
    <link href="${pageContext.request.contextPath}/Assets/css/alogin.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<s:form id="form1" runat="server" action="emp_login" method="post">
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span><img src="${pageContext.request.contextPath}/Assets/images/login/logo.gif" alt="" style="" /></span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">
                    <li><span class="left login-text">用户名：</span> <span style="left">
                        <s:textfield name="em.userName" cssClass="txt"/> 
                     
                    </span></li>
                    <li><span class="left login-text">密码：</span> <span style="left">
                       <s:password name="em.pwd" cssClass="txt"/>
                    </span></li>
					
                </ul>
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>
            <li class="middle_C"><span class="btn"><input value="登录" type="image" src="${pageContext.request.contextPath}/Assets/images/login/btnlogin.gif" /></span></li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B">网站后台管理系统</li>
        </ul>
    </div>
    </s:form>
</body>
</html>
