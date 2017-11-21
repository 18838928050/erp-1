<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/Assets/css/css.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/add.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Assets/js/Calendar.js"></script>
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
    <td width="99%" align="left" valign="top">您的位置：员工维护>>添加员工信息</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <s:form method="post" action="emp_save.action">
    <s:hidden name="em.uuid"/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">用户名：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:textfield name="em.userName" cssClass="text-word" />
        </td>
        <td width="154" align="right" valign="middle" class="borderright borderbottom bggray">真实姓名：</td>
        <td width="303" align="left" valign="middle" class="borderright borderbottom main-for">
        <s:textfield name="em.name" cssClass="text-word" />
        </td>
        </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">密码：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:password name="em.pwd" cssClass="text-word"/>
        </td>
        <td width="154" align="right" valign="middle" class="borderright borderbottom bggray">确认密码：</td>
        <td width="303" align="left" valign="middle" class="borderright borderbottom main-for">
        	<s:password  name="em.pwd" cssClass="text-word" />
        </td>
        </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td width="130" align="right" valign="middle" class="borderright borderbottom bggray">电子邮箱：</td>
        <td width="333" align="left" valign="middle" class="borderright borderbottom main-for">
          <s:textfield name="em.email" cssClass="text-word" />
        </td>
        <td width="154" align="right" valign="middle" class="borderright borderbottom bggray">电话号码：</td>
        <td width="303" align="left" valign="middle" class="borderright borderbottom main-for">
        <s:textfield name="em.tele" cssClass="text-word" />
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">性别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
         <s:select name="em.gender" list="@com.ahpu.erp.auth.emp.model.EmpModel@genderMap" headerKey="-1" headerValue="----请-选-择----" cssClass="text-word"></s:select>
        </td>
        <td width="154" align="right" valign="middle" class="borderright borderbottom bggray">地址：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        	<s:textfield name="em.address" cssClass="text-word" />
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">出生日期：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="c.showMoreDay=false;c.show(this);" readonly="true" value="${em.birthdayView}" class="text-word">
        <s:hidden name="em.birthday"/>
        </td>
        <td width="154" align="right" valign="middle" class="borderright borderbottom bggray">所属部门：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
       	<s:select name="em.dm.uuid" list="depList" listKey="uuid" listValue="name" headerValue="----请-选-择----"></s:select>
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