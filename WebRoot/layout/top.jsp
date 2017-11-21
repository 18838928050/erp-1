<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Assets/js/jquery-1.8.3.min.js"></script>
</head>
<body onselectstart="return false" oncontextmenu=return(false) style="overflow-x:hidden;">
<!--禁止网页另存为-->
<noscript><iframe scr="*.htm"></iframe></noscript>
<!--禁止网页另存为-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="header">
  <tr>
    <td rowspan="2" align="left" valign="top" id="logo"><img src="${pageContext.request.contextPath}/Assets/images/logo.jpg" width="74" height="64"></td>
    <td align="left" valign="bottom">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="bottom" id="header-name">仓库后台管理系统</td>
        <td align="right" valign="top" id="header-right">
        	<a href="${pageContext.request.contextPath}/emp_quit.action" target="topFrame" onFocus="this.blur()" class="admin-out">注销</a>
            <a href="${pageContext.request.contextPath}/emp_tochangePwd.action" target="mainFrame" onFocus="this.blur()" class="admin-home">修改密码</a>
        	 <a href="${pageContext.request.contextPath}/layout/main.jsp" target="mainFrame" onFocus="this.blur()" class="admin-index">管理首页</a>       	
            <span>
<!-- 日历 -->
<SCRIPT type=text/javascript src="${pageContext.request.contextPath}/Assets/js/clock.js"></SCRIPT>
<SCRIPT type=text/javascript>showcal();</SCRIPT>
            </span>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="left" valign="bottom">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="bottom" id="header-menu">
        <a href="#" target="left" onFocus="this.blur()" id="menuon">后台首页</a>
        <a href="#" target="left" onFocus="this.blur()">用户管理</a>
        <a href="#" target="left" onFocus="this.blur()">栏目管理</a>
        <a href="#" target="left" onFocus="this.blur()">信息管理</a>
        <a href="#" target="left" onFocus="this.blur()">留言管理</a>
        <a href="#" target="left" onFocus="this.blur()">附件管理</a>
        <a href="#" target="left" onFocus="this.blur()">站点管理</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
