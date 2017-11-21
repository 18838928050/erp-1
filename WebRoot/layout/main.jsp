<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main1.css" type="text/css" rel="stylesheet" />
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="main">
  <tr>
    <td colspan="2" align="left" valign="top">
    <span class="time"><strong>上午好！${session['loginEm'].name}</strong><u>${session['loginEm'].userName}</u></span>
    <div class="top"><span class="left">您上次的登灵时间：
    <span>
<!-- 日历 -->
<SCRIPT type=text/javascript src="${pageContext.request.contextPath}/Assets/js/clock.js"></SCRIPT>
<SCRIPT type=text/javascript>showcal();</SCRIPT>
            </span> 登录IP：${session['loginEm'].lastLoginIp} &nbsp;&nbsp;&nbsp;&nbsp;如非您本人操作，请及时</span>
            <a href="index.html" target="mainFrame" onFocus="this.blur()">更改密码</a></div>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top" width="50%">
    <div class="main-tit">网站信息</div>
    <div class="main-con">
    会员注册：开启<br/>
会员投稿：开启<br/>
登陆者IP：${session['loginEm'].lastLoginIp}<br/>
程序编码：UTF-8<br/>
    </div>
    </td>
    <td align="left" valign="top" width="49%">
    <div class="main-tit">服务器信息</div>
    <div class="main-con">
服务器软件：Apache Tomcat 6.0<br/>
MYSQL版本：5.7.45-community-nt<br/>
魔术引用：开启 (建议开启)<br/>
    </div>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" valign="top">
    <div class="main-corpy">系统提示</div>
    <div class="main-order">1=>如您在使用过程有发现出错请及时与我们取得联系；为保证您得到我们的后续服务，强烈建议您购买我们的正版系统或向我们定制系统！<br/>
2=>强烈建议您将IE7以上版本或其他的浏览器</div>
    </td>
  </tr>
 
</table>
</body>
</html>