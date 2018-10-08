<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<meta name="viewport"content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"type="text/css"href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css"/>
</head>
<script
	src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/js/jquery.validate.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/js/myValidate.js"type="text/javascript">
</script>
<script type="text/javascript">
$(function(){
	$.post(
			"${pageContext.request.contextPath}/UserServlet",
			{
				method : "getUserBean"
			},
			function(data) {
				if (data != null && data.length > 0) {
					var content = "";
					for (var i in data) {
						content += "<option value='" + data[i].username + "'>"
							+ data[i].username + "("+data[i].juese+")"+"</option>";
					}
					$("#username").append(content);
					//$("#seljuese1").append(content);
				}
			}, "json");
		})	
</script>
<script type="text/javascript">
$(function(){
	$.post(
		"${pageContext.request.contextPath}/JueseServlet",
		{
			method : "getJueseBeans"
		},
		function(data) {
			if (data != null && data.length > 0) {
				var content = "";
				for (var i in data) {
					content += "<option value='" + data[i].juese + "'>"
						+ data[i].juese + "</option>";
				}
				$("#seljuese").append(content);
				$("#seljuese1").append(content);
			}
		}, "json");
	})	
	
	function getjuseBean(juesena) {
	$("#need").removeAttr("checked");
	$("#userinfo1").removeAttr("checked");
	$("#wangluo").removeAttr("checked");
	$("#xuqiu").removeAttr("checked");
	$("#upmima").removeAttr("checked");
	$("#addneed").removeAttr("checked");
	$("#dealneed").removeAttr("checked");
	$("#userinfo").removeAttr("checked");
	$("#weishenhe").removeAttr("checked");
	$("#tongguo").removeAttr("checked");
	$("#tuihui").removeAttr("checked");
	
	$.post(
			"${pageContext.request.contextPath}/JueseServlet",
			{
				method : "getJuese",
				juesena : juesena
			},
			function(data) {
				if (data != null) {
					if(data.wangluo == "1")
						$("#wangluo").prop("checked","true");
					if(data.xuqiu == "1")
						$("#xuqiu").prop("checked","true");
					if(data.upmima == "1")
						$("#upmima").prop("checked","true");
					if(data.addneed == "1")
						$("#addneed").prop("checked","true");
					if(data.dealneed == "1")
						$("#dealneed").prop("checked","true");
					if(data.userinfo == "1")
						$("#userinfo").prop("checked","true");
					if(data.weishenhe == "1")
						$("#weishenhe").prop("checked","true");
					if(data.tongguo == "1")
						$("#tongguo").prop("checked","true");
					if(data.tuihui == "1")
						$("#tuihui").prop("checked","true");
					if(data.upmima == "1" && data.userinfo == "1" && data.dealneed == "1")
						$("#userinfo1").prop("checked","true");
					if(data.wangluo == "1" && data.xuqiu == "1" && data.addneed == "1" && data.weishenhe == "1" && data.tongguo == "1" && data.tuihui == "1")
						$("#need").prop("checked","true");
				}
			}, "json");
	
}
</script>
<script type="text/javascript">
 	$(function(){
 		$("#userinfo1").click(function(){
 			$(".userinfo1").prop("checked",$(this).prop("checked"));
 		})
 		//控制全选，全不选
 		$("#need").click(function(){
 			$(".needinfo").prop("checked",$(this).prop("checked"));
 		})
 		//控制添加角色
 		$("#but").click(function(){
 			//添加新角色，将复选框清空
 			$("#need").removeAttr("checked");
 			$("#userinfo1").removeAttr("checked");
 			$("#wangluo").removeAttr("checked");
 			$("#xuqiu").removeAttr("checked");
 			$("#upmima").removeAttr("checked");
 			$("#addneed").removeAttr("checked");
 			$("#dealneed").removeAttr("checked");
 			$("#userinfo").removeAttr("checked");
 			$("#weishenhe").removeAttr("checked");
 			$("#tongguo").removeAttr("checked");
 			$("#tuihui").removeAttr("checked");
 			//将下拉选隐藏
 			$("#jueserole").css("display","none");
			$("#name").css("display","block");
			$("#user").css("display","none");
		})
		//自动显示选中的角色对象的权限
		$("#seljuese").change(function(){
			var nam = $("#seljuese").val();
			getjuseBean(nam);
		})
		//角色分配
		$("#but1").click(function(){
			$("#user").css("display","block");
			$("#jueserole").css("display","none");
			$("#name").css("display","none");
		})
		
		$("#but2").click(function(){
			$("#user").css("display","none");
			$("#name").css("display","none");
			$("#jueserole").css("display","block");
		})
	
		
 	});
</script>
<style type="text/css">
	#table{
		width: 850px !important;
	}
	select{
		width: 150px !important;
		display:inline
	}
</style>
	
<body>
	<center>
		<h3>角色管理</h3>
		<button class="btn btn-danger" name="but2" id="but2">角色权限</button>
		<button class="btn btn-danger" name="but" id="but">新增角色</button>
		<button class="btn btn-danger" name="but1" id="but1">角色分配</button>
		<hr>
			<div style="display:none" id="user">
				<form action="UserServlet?method=upjuese" method="post" id="form2">
						用户名：
						<select id="username" name="username">
							<option value="0">请选择用户</option>	
						</select>
						请选择角色:
						<select id="seljuese1" name="juese1" >
							<option value="0">请选择角色</option>	
						</select>
					<button type="submit" onclick="form2.action='UserServlet?method=upjuese">分配</button>
				</form>
			</div>
		
		<form action="JueseServlet?method=addjuese" method="post" id="Form">
		<div style="display:none" id="name">
			角色名称<input type="text"  name="juesename" >
		</div>
		<!-- <input type="text"  name="username" value=${userbean.username }><br> -->
		<div style="display:block" id="jueserole">
			请选择角色:
			<select id="seljuese" name="juese">
				<option value="0">请选择角色</option>	
			</select>
		</div>
			<table border="1" id="table" class="table">
				<tr class="active">
					<td width="100">权限名称</td>
					<td width="200">权限描述</td>
					<td width="50">是否赋予</td>
				</tr>
				<tr class="active">
					<td colspan="2">用户信息</td>
					<td><input type="checkbox" id="userinfo1" ></checked></td>
				</tr>
				<tr>
					<td class="text-center">用户密码重置</td>
					<td>可以修改自己的密码</td>
					<td><input class="userinfo1" type="checkbox" name="upmima" id="upmima" value="1"></checked></td>
				</tr>
				<tr>
					<td class="text-center">用户信息</td>
					<td>可以查看自己的信息</td>
					<td><input class="userinfo1" type="checkbox" name="userinfo" id="userinfo" value="1"></checked></td>
				</tr>
				<tr>
					<td class="text-center">需求管理</td>
					<td>可以查看自己提交的需求信息</td>
					<td><input class="userinfo1" type="checkbox" name="dealneed" id="dealneed" value="1"></checked></td>
				</tr>
				
				<tr class="active">
					<td colspan="2">需求信息</td>
					<td><input type="checkbox" id="need"></checked></td>
				</tr>
				<tr>
					<td class="text-center">需求征集</td>
					<td>可以录入自己需求信息</td>
					<td><input class="needinfo" type="checkbox" name="addneed" id="addneed" value="1"></checked></td>
				</tr>
				
				<tr>
					<td class="text-center">网络审核</td>
					<td>可以查看网络审核未审核的需求信息并进行审核</td>
					<td><input class="needinfo" type="checkbox" name="wangluo" id="wangluo" value="1"></checked></td>
				</tr>
				<tr>
					<td class="text-center">需求审核</td>
					<td>可以查看需求审核未审核的需求信息并进行审核</td>
					<td><input class="needinfo" type="checkbox" name="xuqiu" id="xuqiu" value="1"></checked></td>
				</tr>
				<tr>
					<td class="text-center">未审核需求</td>
					<td>可以查看未审核的需求信息</td>
					<td><input class="needinfo" type="checkbox" name="weishenhe" id="weishenhe" value="1"></checked></td>
				</tr>
				
				<tr>
					<td class="text-center">通过审核需求</td>
					<td>可以查看审核通过的需求信息</td>
					<td><input class="needinfo" type="checkbox" name="tongguo" id="tongguo" value="1"></checked></td>
				</tr>
				<tr>
					<td class="text-center">被退回需求</td>
					<td>可以查看被退回的需求信息</td>
					<td><input class="needinfo" type="checkbox" name="tuihui" id="tuihui" value="1"></checked></td>
				</tr>
			</table>
			<button type="submit" >添加</button>
			<br><br><br><br><br><br><br><br>
			<!-- <button type="submit" class="btn btn-primary" >添加</button> -->
		</form>
	</center>
</body>
</html>