<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd";>
<html xmlns="http://www.w3.org/1999/xhtml";>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/Assets/js/jquery-1.8.3.min.js"	type="text/javascript"></script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(${pageContext.request.contextPath}/Assets/images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
       <div><img src="${pageContext.request.contextPath}/Assets/images/main/member.gif" width="44" height="44" /></div>
    <span><a>${session['loginEm'].name}</a><br>角色：${session['loginEm'].userName}</span>
</div>
    <div style="float: left;">
      <%@include file="/WEB-INF/pages/menu/menu.jsp"%>
    </div>
</body>
</html>