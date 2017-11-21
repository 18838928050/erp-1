<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/add.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Assets/js/jquery-1.8.3.js"></script>
</head>
<body>

<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：角色维护>>添加角色信息</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <s:form method="post" action="resource_save.action">
    <s:hidden name="rsm.uuid"/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">资源名称：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:textfield name="rsm.name" cssClass="text-word" />
        </td>
        <td width="154" align="right" valign="middle" class="borderright borderbottom bggray">资源链接：</td>
        <td width="303" align="left" valign="middle" class="borderright borderbottom main-for">
        <s:textfield name="rsm.url" cssClass="text-word" />
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