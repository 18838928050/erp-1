<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/Assets/css/css.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/css/main.css"
	type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/Assets/css/align.css"
	type="text/css" rel="stylesheet" />
<!-- <link rel="shortcut icon" href="Assets/Assets/images/main/favicon.ico" /> -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Assets/js/jquery-1.8.3.min.js"></script>
<link href="${pageContext.request.contextPath}/Assets/css/pop.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function showMsg(uuid){
		$(".pop").fadeIn('fast');
		$(".popBottom").on('click', 'span', function(event) {
			event.preventDefault();
			if($(this).hasClass('confirm')){
				window.location = "dep_delete.action?dm.uuid="+uuid;
				$(".pop").fadeOut();
			}else{
				$(".pop").fadeOut();
			}
	});
}
</script>
</head>
<body>
	<!--main_top-->
	<s:form method="post" action="dep_list">
		<table width="99%" border="0" cellspacing="0" cellpadding="0"
			id="searchmain">
			<tr>
				<td width="99%" align="left" valign="top">您的位置：部门管理</td>
			</tr>
			<tr>
				<td align="left" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						id="search">
						<tr>
							<td width="90%" align="left" valign="middle"><span>部门名称：</span>
							
								<s:textfield name="dqm.name" size="18" cssClass="text-word" /> 
								<span>电话：</span> 
								<s:textfield name="dqm.tele" size="18" cssClass="text-word" /> 
								&nbsp;&nbsp;&nbsp;
								<input name="" type="image" value="查询" style="width: 100;height: 30px;" src="${pageContext.request.contextPath}/Assets/images/serach.jpg"></td>
								<td width="10%" align="center" valign="middle"
								style="text-align:right; width:150px;"><a
								href="dep_input.action" target="mainFrame" onFocus="this.blur()"
								class="add">新增部门</a></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="left" valign="top">

					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						id="main-tab">
						<tr>
							<th align="center" valign="middle" class="borderright">编号</th>
							<th align="center" valign="middle" class="borderright">部门名称</th>
							<th align="center" valign="middle" class="borderright">电话</th>
							<th align="center" valign="middle">操作</th>
						</tr>
						<tr>
						<s:if test="#depList.size() == 0">
							<center>
								<span style="font-size:20px;color:#96D34A;font-weight:bold">没有查找到满足条件的数据！</span>
							</center>
						</s:if>
						</tr>
						<s:else>
						<s:iterator value="#depList" var="dep">
							<tr onMouseOut="this.style.backgroundColor='#ffffff'"
								onMouseOver="this.style.backgroundColor='#edf5ff'">
								<td align="center" valign="middle"
									class="borderright borderbottom">${dep.uuid}</td>
								<td align="center" valign="middle"
									class="borderright borderbottom">${dep.name}</td>
								<td align="center" valign="middle"
									class="borderright borderbottom">${dep.tele}</td>
								<td align="center" valign="middle" class="borderbottom"><s:a
										action="dep_input" cssClass="add" target="mainFrame"
										onFocus="this.blur()">
										<s:param name="dm.uuid" value="uuid" />
								编辑
								</s:a> <span class="gray">&nbsp;|&nbsp;</span> <a
										herf="javascript:void(0)" class="add" target="mainFrame"
										onFocus="this.blur()" onclick="showMsg(${uuid})">删除 <s:param name="dm.uuid" value="uuid" /></a></td>
							</tr>
						</s:iterator>
						</s:else>
					</table>
				</td>
			</tr>
			<tr>
				<td align="left" valign="top" class="fenye">${dataTotal}条数据 ${pageNum}/${maxPageNum}
					页&nbsp;&nbsp;<a href="#" id="fir" target="mainFrame"
					onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="#" id="pre"
					target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp; <a
					id="next" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a
					href="#" id="last" target="mainFrame" onFocus="this.blur()">尾页</a>
				</td>
			</tr>
			<s:hidden name="pageNum" />
		</table>
		<script type="text/javascript">
		//最大页=1，都隐藏
		
		var pageNum = ${pageNum};
		var maxPageNum = ${maxPageNum};
		if(maxPageNum == 1){
			$("#fir").css("display","none");
			$("#pre").css("display","none");
			$("#next").css("display","none");
			$("#last").css("display","none");
		}else if(pageNum==1){
			$("#fir").css("display","none");
			$("#pre").css("display","none");
			$("#next").css("display","inline");
			$("#last").css("display","inline");
			
		}else if(maxPageNum == pageNum){
			$("#fir").css("display","inline");
			$("#pre").css("display","inline");
			$("#next").css("display","none");
			$("#last").css("display","none");
			
		}else{
			$("#fir").css("display","inline");
			$("#pre").css("display","inline");
			$("#next").css("display","inline");
			$("#last").css("display","inline");
			
		}
			//首页
			$(function() {
				$("#fir").click(function() {
					$("[name=pageNum]").val(1);
					$("form:first").submit();
				});
			});
			//下一页
			$(function() {
				$("#next").click(function() {
					//收集页码值
					$("[name=pageNum]").val($("[name=pageNum]").val() * 1 + 1);
					$("form:first").submit();
				});
			});
			//上一页
			$(function() {
				$("#pre").click(function() {
					//收集页码值
					$("[name=pageNum]").val($("[name=pageNum]").val() - 1);
					$("form:first").submit();
				});
			});
			//末页
			$(function() {
				$("#last").click(function() {
					//收集页码值
					$("[name=pageNum]").val(maxPageNum);
					$("form:first").submit();
				});
			});
		</script>
	</s:form>
<div class="pop">
	<div class="popMain">
		<div class="popTop"></div>
		<div class="popMiddle">
			<p>是否确认删除？</p>
		</div>
		<div class="popBottom">
			<span class="confirm">确认</span>
			<span class="cancel">取消</span>
		</div>
	</div>
</div>
</body>
</html>