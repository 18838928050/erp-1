<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统</title>
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Assets/js/jquery-1.8.3.min.js"></script>
</head>
<!--框架样式-->
<frameset rows="95,*,30" cols="*" frameborder="no" border="0" framespacing="0">
<!--top样式-->
	<frame src="${pageContext.request.contextPath}/layout/top.jsp" name="topframe" scrolling="no" noresize id="topframe" title="topframe" />
<!--contact样式-->
	<frameset id="attachucp" framespacing="0" border="0" frameborder="no" cols="194,12,*" rows="*">
		<frame scrolling="auto" noresize="" frameborder="no" name="leftFrame" src="${pageContext.request.contextPath}/layout/left.jsp"></frame>
		<frame id="leftbar" scrolling="no" noresize="" name="switchFrame" src="${pageContext.request.contextPath}/layout/swich.jsp"></frame>
		<frame scrolling="auto" noresize="" border="0" name="mainFrame" src="${pageContext.request.contextPath}/layout/main.jsp"></frame>
	</frameset>
<!--bottom样式-->
	<frame src="${pageContext.request.contextPath}/layout/bottom.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset>
<!--不可以删除-->
</html>
