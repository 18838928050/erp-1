<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/add.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：修改个人密码</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <s:form method="post" action="emp_changePwd.action">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">原密码：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:password name="em.pwd" cssClass="text-word" />
        </td>
         <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <span style="color:red"><s:actionerror/></span>
        </td>
        </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">新密码：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:password name="newPwd" cssClass="text-word"/>
        </td>
        </tr>
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">确认密码：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:password name="renewPwd" cssClass="text-word"/>
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input id="commit" type="submit" value="提交" class="text-but">
        <input name="" type="reset" value="重置" class="text-but"></td>
        </tr>
    </table>
    </s:form>
    </td>
    </tr>
</table>
</body>
</html>