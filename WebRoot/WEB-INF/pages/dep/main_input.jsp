<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/add.css" type="text/css" rel="stylesheet" />
<!-- <link rel="shortcut icon" href="Assets/Assets/images/main/favicon.ico" /> -->

<%-- <script type="text/javascript">
$(function(){
	$("#commit").click(function(){
		//提交表单
		//$("#mainFrame").submit();
		$("form:first").submit();
	});
});
</script> --%>
</head>
<body>

<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：部门维护>>添加部门信息</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <s:form method="post" action="dep_save.action">
    <s:hidden name="dm.uuid"/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">部门名称：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <s:textfield name="dm.name" cssClass="text-word" />
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">电话：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
         <s:textfield name="dm.tele" cssClass="text-word"/>
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