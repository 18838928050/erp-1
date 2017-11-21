<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/add.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Assets/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
//正选反选
$(function() {
		$("#all").click(function() {
			$("[name=roleUuids]:checkbox").attr("checked",$("#all").attr("checked")=="checked");
		});
		$("#reverse").click(function() {
			$("[name=roleUuids]:checkbox").each(function () {
                $(this).attr("checked", !$(this).attr("checked"));
            });

		});
	});
</script>
</head>
<body>

<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：菜单维护>>添加菜单信息</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <s:form method="post" action="menu_save.action">
    <s:hidden name="mm.uuid"/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">菜单名称：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:textfield name="mm.name" cssClass="text-word" />
        </td>
        </tr>
        <tr>
        <td width="154" align="right" valign="middle" class="borderright borderbottom bggray">所属父菜单：</td>
        <td width="303" align="left" valign="middle" class="borderright borderbottom main-for">
        <s:select name="mm.parent.uuid" list="menuList" listKey="uuid" listValue="name" cssClass="text-word"></s:select>
        </td>
        </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">菜单链接：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:textfield name="mm.url" cssClass="text-word" />
        </td>
        </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">角色名称：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" colspan="3">
       	<input type="checkbox" id="all">全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="reverse">反选</td>
      </tr> 
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for" colspan="3">
       
       	 <s:checkboxlist name="roleUuids" list="roleList" listKey="uuid" listValue="name"></s:checkboxlist>
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