<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.validate.js"type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/myValidate.js"type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/msgbox.js"type="text/javascript">
	</script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/msgbox.css">
	<script
		src="${pageContext.request.contextPath}/static/layer/layer.js"type="text/javascript">
	</script>
	
<script type="text/javascript">
	$(function(){
		var shuxing = "${userbean.jigoushuxing }";
		if(shuxing == "企业")
			$("#qi").attr("checked","checked");
		if(shuxing == "高等院校")
			$("#xiao").attr("checked","checked");
		if(shuxing == "研究机构")
			$("#yan").attr("checked","checked");
		if(shuxing == "其他")
			$("#ta").attr("checked","checked");
		
		$("#upd").click(function(){
			confirm("确认修改",function(){
				$("#form2").submit();
			})
		})	
	})
	
		
	function check(){
		if($("#depart").val()=="")
		{
			alert("友情提示","机构全称不能为空");
			return false;
		}
		else if($("#address").val() == "")
		{
			alert("友情提示","通讯地址不能为空");
			return false;
		}
		else if($("#email").val() == "")
		{
			alert("友情提示","邮箱地址不能为空");
			return false;
		}
		else if($("#faren").val() == "")
		{
			alert("友情提示","法人代表不能为空");
			return false;
		}
		else if($("#phnumber").val() == "")
		{
			alert("友情提示","手机号不能为空");
			return false;
		}
		else if($("#jigoujianjie").val() == "")
		{
			alert("友情提示","机构简介不能为空");
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript">

		function update() {
			layer
					.open({
						content : '你确定要修改吗?',
						btn : [ '确认', '取消' ],
						yes : function(index, layero) {
							//location.href = "${pageContext.request.contextPath }/UserServlet?method=updateuser&id="+${userbean.id };
							$("#form2").submit();		
						},
						btn2 : function(index, layero) {

						},
						cancel : function() {
							//右上角关闭回调  
						}
					});
		}
</script>
 	
	<c:if test="${param.msg.equals('1') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('修改成功', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
	
<style>
	.inp{
		height:100%;
		width:100%;
	}
	.inp1{
		height:100%;
		width:35%;
	}
</style>
<body style="background-color:#dceefc">
<%@include file="/static/js/msgbox.jsp"%>
<center>
	<h1>用户详细信息</h1>
	<hr>
	<br>
	<!-- border-collapse:collapse; -->
	<form action="UserServlet?method=updateuser&id=${userbean.id }" id="form2" method="post" id="123" submit="return check()">
		<table border="1px"  cellpadding="0" cellspacing="0"  style="border-collapse:collapse;width:30%" height="450" submit="return up()">
			
			<tr>
				<td  ><font style="color:red">*</font>机构全称</td>
				<td  ><input class="inp" type="text" id="depart" name="depart" style="border:1px solid #378888;" value="${userbean.depart }"></td>
				<td  >归口管理部门</td>
				<td  ><input class="inp" type="text" id="departname" name="departname" style="border:1px solid #378888;" value="${userbean.departname }"></td>
			</tr>
			<tr>
				<td ><font style="color:red">*</font>通讯地址</td>
				<td ><input class="inp" type="text" id="address" name="address" style="border:1px solid #378888;" value="${userbean.address }"></td>
				<td ><font style="color:red">*</font>所在地域</td>
				<td ><input class="inp" type="text" id="city" name="city" style="border:1px solid #378888;" value="${userbean.city }"></td>
			</tr>
			<tr>
				<td >&nbsp;网址</td>
				<td ><input class="inp" type="text" id="wangzhi" name="wangzhi" style="border:1px solid #378888;" value="${userbean.wangzhi }"></td>
				<td ><font style="color:red">*</font>电子信箱</td>
				<td ><input class="inp" type="text" id="email" name="email" style="border:1px solid #378888;" value="${userbean.email}"></td>
			</tr>
			<tr>
				<td ><font style="color:red">*</font>法人代表</td>
				<td ><input class="inp" type="text" id="faren" name="faren" style="border:1px solid #378888;" value="${userbean.faren }"></td>
				<td >邮政编码</td>
				<td ><input class="inp" type="text" id="e_code" name="e_code" style="border:1px solid #378888;" value="${userbean.e_code }"></td>
			</tr>
			
			<tr>
				<td rowspan="2" ><font style="color:red">*</font>联系人</td>
				<td rowspan="2" ><input class="inp" type="text" id="truename" name="truename" style="border:1px solid #378888;" value="${userbean.truename }"></td>
				<td ><font style="color:red">*</font>电话</td>
				<td >
					1.固定<input class="inp1" type="text" id="dianhua" name="dianhua" style="border:1px solid #378888;" value="${userbean.dianhua }">
					2.手机<input class="inp1" type="text" id="phnumber" name="phnumber" style="border:1px solid #378888;" value="${userbean.phnumber }">
				</td>
			</tr>
			
			<tr>
				<td >传真</td>
				<td><input class="inp" type="text" id="chuanzhen" name="chuanzhen" style="border:1px solid #378888;" value="${userbean.chuanzhen }"></td>
			</tr>
			
			<tr>
				<td colspan="1"><font style="color:red">*</font>机构属性</td>
				<td colspan="3">
					<input type="radio" name="jigoushuxing" id="qi" value="企业" checked="checked">企业
					<input type="radio" name="jigoushuxing" id="xiao" value="高等院校">高等院校
					<input type="radio" name="jigoushuxing" id="yan" value="研究机构">研究机构
					<input type="radio" name="jigoushuxing" id="ta" value="其他">其他
				</td>
			</tr>
			
			<tr>
				<td colspan="4"><font style="color:red">*</font>机构简介(主要包括基本情况、现有研究基础等，<font style="color:red">限500字以内</font>)</td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea id="jigoujianjie" name="jigoujianjie"rows="8" cols="120" style="border:0" maxlength="500" 
						onchange="this.value=this.value.substring(0, 500)" 
						onkeydown="this.value=this.value.substring(0, 500)" 
						onkeyup="this.value=this.value.substring(0, 500)">${userbean.jigoujianjie }</textarea>
				</td>
			</tr>
		</table>
		<br>
			<input type="button"  onclick="update()" value="修改">
			<!-- id="upd" -->
		<br><br><br><br>	
	</form>
</center>

</body>
</html>