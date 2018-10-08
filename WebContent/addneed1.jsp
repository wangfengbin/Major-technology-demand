<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css"/>-->

<title>Insert title here</title>
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
	<script
		src="${pageContext.request.contextPath}/static/js/msgbox.js"type="text/javascript">
	</script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/msgbox.css">
	

<!-- jquer blur事件，当鼠标焦点失去时触发,("#123").blur(function(){ ....})-->
<script type="text/javascript">
	$(function(){
		var shuxing = "${userbean.jigoushuxing }";
		//alert(shuxing);
		if(shuxing == "企业")
			$("#qi").attr("checked","checked");
		if(shuxing == "高等院校")
			$("#xiao").attr("checked","checked");
		if(shuxing == "研究机构")
			$("#yan").attr("checked","checked");
		if(shuxing == "其他")
			$("#ta").attr("checked","checked");
				
		$("#jichu").click(function(){
			$("#xueke").css("display","block");
			$("#lingyu").css("display","none");
			$("#hangye").css("display","none");
		});
		$("#yingyong").click(function(){
			
			if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
			{
				$("#xueke").css("display","none");
				$("#lingyu").css("display","block");
				$("#hangye").css("display","block");
			}
		});
		$("#shiyan").click(function(){
			if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
			{
				$("#xueke").css("display","none");
				$("#lingyu").css("display","block");
				$("#hangye").css("display","block");
			}
		});
		$("#yanjiu").click(function(){
			if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
			{
				$("#xueke").css("display","none");
				$("#lingyu").css("display","block");
				$("#hangye").css("display","block");
			}
		});
		$("#jishu").click(function(){
			if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
			{
				$("#xueke").css("display","none");
				$("#lingyu").css("display","block");
				$("#hangye").css("display","block");
			}
		});
		$("#shengchan").click(function(){
			if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
			{
				$("#xueke").css("display","none");
				$("#lingyu").css("display","block");
				$("#hangye").css("display","block");
			}
		});
		/*
		$("#name").blur(function(){
			if($("#name").val() == "")
				alert("需求名称不能为空");
		});
		*/
		
	})
	function guanjian()
	{
		if($("#guanjian1").val() != "")
		{
			$("#guanjian2").attr("readonly","false");
		}
		if($("#guanjian2").val() != "")
			$("#guanjian3").attr("readonly","false");
		if($("#guanjian3").val() != "")
			$("#guanjian4").attr("readonly","false");
		if($("#guanjian4").val() != "")
			$("#guanjian5").attr("readonly","false");
	}
</script>
<script type="text/javascript">
function twoxueke(obj) {
	var id = obj.value;
	if (id > 0) {
		$.post(
				"${pageContext.request.contextPath}/NeedServlet",
				{
					method : "getTwoxueke",
					id : id
				},
				function(data) {
					if (data != null && data.length > 0) {
						var content = "";
						for (var city in data) {
							content += "<option value='" + data[city].name + "'>"
								+ data[city].name + "</option>";
						}
						$("#twxueke").html(content);
					}
				}, "json");
	}
}
</script>
<script type="text/javascript">
function twohangye(obj) {
	var id = obj.value;
	if (id > 0) {
		$.post(
				"${pageContext.request.contextPath}/NeedServlet",
				{
					method : "getTwohangye",
					id : id
				},
				function(data) {
					if (data != null && data.length > 0) {
						var content = "";
						for (var city in data) {
							content += "<option value='" + data[city].twohangye + "'>"
								+ data[city].twohangye + "</option>";
						}
						$("#twhangye").html(content);
					}
				}, "json");
	}
}
</script>

<script type="text/javascript">
	//获得最新的需求id
	$(function(){
		$.post(
				"${pageContext.request.contextPath}/NeedServlet",
				{
					method : "getneedid",
				},
				function(data) {
					if (data != null && data.length > 0) {
						//document.getElementById('numInput').value=data;
						
						var numbe = document.getElementById('num');
							numbe.innerHTML=data;
						//$("#num").innerHTML=data;
						$("#numInput").val(data);
					}
				}, "json");
	})

</script>
<script type="text/javascript">
function check(){
	var name = $("#name").val();
	if(name=="")
	{
		alert("友情提示","技术需求名称不能为空");
		return false;
	}
	else if($("#qiannian").val() == "")
	{
		alert("友情提示","开始年限不能为空");
		return false;
	}
	else if($("#hounian").val() == "")
	{
		alert("友情提示","结束年限不能为空");
		return false;
	}
	else if(isNaN($("#qiannian").val()))
	{
		alert("友情提示","开始年限必须为数字");
		return false;
	}
	else if(isNaN($("#hounian").val()))
	{
		alert("友情提示","结束年限必须为数字");
		return false;
	}
	
	else if($("#hounian").val() < $("#qiannian").val())
	{
		alert("友情提示","开始年限不能大于结束年限");
		return false;
	}
	else if($("友情提示","#descrpt").val() == "")
	{
		alert("友情提示","开始年限不能大于结束年限");
		return false;
	}
	else if($("#guanjian1").val() == "")
	{
		alert("友情提示","关键字1不能为空");
		return false;
	}
	else if($("#guanjian2").val() == "")
	{
		alert("友情提示","关键字2不能为空");
		return false;
	}
	else if($("#guanjian3").val() == "")
	{
		alert("友情提示","关键字3不能为空");
		return false;
	}
	else if($("#guanjian4").val() == "")
	{
		alert("友情提示","关键字4不能为空");
		return false;
	}
	else if($("#guanjian5").val() == "")
	{
		alert("友情提示","关键字5不能为空");
		return false;
	}
	else if($("#money").val() == "")
	{
		alert("友情提示","投资金额不能为空");
		return false;
	}
	else if(isNaN($("#money").val()))
	{
		alert("友情提示","投资金额必须是数字");
		return false;
	}
	return true;
}
</script>
<style type="text/css">
	.inp{
		height:100%;
		width:100%;
	}
	.inp1{
		height:100%;
		width:35%;
	}
	.inp2{
		height:100%;
		width:20%;
	}
	.inp3{
		height:100%;
		width:70%;
	}
</style>
<!-- 需求编号  从数据中找到最大的数字。或找到今天填报的最大数量， -->
<body style="background-color:#dceefc" >
<%@include file="/static/js/msgbox.jsp"%>
	                
	<h2 align="center">河北省重大技术需求征集表</h2>
	<center>
	<!--  -->
	<form action="NeedServlet?method=addneed&id=${userbean.id }" method="post" id="123" onsubmit="return check()">
		需求编号:<span id="num" name="number"></span><input type="hidden" name="numInput" id="numInput" >
		<br><br>
		<!-- <table border="1px"  cellpadding="0" cellspacing="0" style="border-collapse:collapse;"width="800" height="570"> -->
			
			<table width="785" height="500" border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
			  <tr>
			    <td width="120"><font style="color:red">*</font>机构全称</td>
			    <td width="190"><input class="inp" type="text" name="depart" style="border:1px solid #378888;" value="${userbean.depart }"></td>
			    <td width="120">归口管理部门</td>
			    <td width="350"><input class="inp" type="text" name="departname" style="border:1px solid #378888;" value="${userbean.departname }"></td>
			  </tr>
			  <tr>
			    <td><font style="color:red">*</font>联系人</td>
			    <td><input class="inp" type="text" name="truename" style="border:1px solid #378888;" value="${userbean.truename }"></td>
			    <td><font style="color:red">*</font>电话</td>
			    <td>1.固定<input class="inp1" type="text" name="dianhua" style="border:1px solid #378888;" value="${userbean.dianhua }">
					2.手机<input class="inp1" type="text" name="phnumber" style="border:1px solid #378888;" value="${userbean.phnumber }"></td>
			  </tr>
			  <tr>
			    <td><font style="color:red">*</font>机构属性</td>
			    <td colspan="3"><input type="radio" name="jigoushuxing" id="qi" value="企业">企业
								<input type="radio" name="jigoushuxing" id="xiao" value="高等院校">高等院校
								<input type="radio" name="jigoushuxing" id="yan" value="研究机构">研究机构
								<input type="radio" name="jigoushuxing" id="ta" value="其他">其他</td>
			  </tr>
			  <tr>
			    <td><strong><font style="color:red">*</font>技术需求名称</strong></td>
			    <td><input class="inp" type="text" id="name" name="name"style="border:1px solid #378888;"></td>
			    <td><strong><font style="color:red">*</font>需求时限</strong></td>
			    <td><input class="inp1" type="text" id="qiannian" name="qiannian"style="border:1px solid #378888">年至
								<input class="inp1" type="text" id="hounian" name="hounian"style="border:1px solid #378888">年</td>
			  </tr>
			  <tr>
			    <td colspan="4"><strong><font style="color:red">*</font>技术需求概述(主要包括基本情况、现有研究基础等，<font style="color:red">限500字以内</font>)</td>
			  </tr>
			  <tr>
			    <td colspan="4"><textarea name="descrpt" id="descrpt" rows="8" cols="120" style="border:0" maxlength="500" 
										onchange="this.value=this.value.substring(0, 500)" 
										onkeydown="this.value=this.value.substring(0, 500)" 
										onkeyup="this.value=this.value.substring(0, 500)"></textarea></td>
			  </tr>
			  <tr>
			    <td><font style="color:red">*</font><strong>关键字:</strong></td>
			    <td colspan="3">1.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian1" name="guanjian1">
							2.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian2" name="guanjian2" ><!-- readonly="true" -->
							3.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian3" name="guanjian3" >
							4.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian4" name="guanjian4" >
							5.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian5" name="guanjian5" ></td>
			  </tr>
			  <tr>
			  	<td><strong>投资金额</strong></td>
			  	<td colspan="3"><input class="inp3" type="text" id="money" name="money">万元</td>
			  </tr>
			  <tr>
			    <td rowspan="2"><strong><font style="color:red">*</font>技术需求解决方式</strong></td>
			    <td colspan="3">
			    	<input type="radio" name="moshi" id="duli" checked="checked" value="独立开发">独立开发
					<input type="radio" name="moshi" id="zhuanrang" value="委托研发">委托研发
					<input type="radio" name="moshi" id="rugu" value="合作研发">合作研发
					<input type="radio" name="moshi" id="hezuo" value="其他">其他
				</td>   
			  </tr>
			  <tr>
			  	<td colspan="3">合作意向单位<input class="inp1" type="text" id="hezuo" name="hezuo">(选填)</td>
			  </tr>
			  <tr>
				<td><strong><font style="color:red">*</font>科技活动类型</strong></td>
				<td colspan="3">
					<input type="radio" name="type" id="jichu" value="基础研究" checked="checked">基础研究
					<input type="radio" name="type" id="yingyong" value="应用研究">应用研究
					<input type="radio" name="type" id="shiyan" value="试验发展">试验发展
					<input type="radio" name="type" id="yanjiu" value="研究发展与成果应用">研究发展与成果应用
					<input type="radio" name="type" id="jishu" value="技术推广与科技服务">技术推广与科技服务
					<input type="radio" name="type" id="shengchan" value="生产性活动">生产性活动
				</td>
			  </tr>
			</table>
			 
			 <table id="xueke" style="display:block" width="785"  height="45"  border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;"> 
			<tr>
				<td width="125" height="45"><strong>学科分类</strong></td>
				<td width="350" height="45">
					<select name="firstxueke" style="width:100%;height:100%" class="form-control" onchange="twoxueke(this)" id="firstxueke">
							<option value="0">-- 请选择一级学科 --</option>
							<c:forEach items="${xuekeBeans }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
					</select>
				</td>
				<td id="xueke2" width="350" height="45">
					<select name='twxueke' id='twxueke' style="width:100%;height:100%" class="form-control"> 
						<option value='0'>-- 请选择二级学科 --</option>
					</select>
				</td>
			</tr>
			</table>
			<!--style="display:none"  -->
			<table  align="center" id="lingyu" style="display:none"width="785" height="60"  border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
			<tr>
				<td width="125" height="60"><strong>需求技术所属领域</strong></td>
				<td width="700" height="60">
					<input type="checkbox" name="lingyu" id="dianzixinxi" value="dianzixinxi">电子信息
					<input type="checkbox" name="lingyu" id="guangjidian" value="guangjidian">光机电一体化 
					<input type="checkbox" name="lingyu" id="shengwu" value="shengwu">生物技术与制药
					<input type="checkbox" name="lingyu" id="xincailiao" value="xincailiao">新材料及应用
					<input type="checkbox" name="lingyu" id="xiandai" value="xiandai">现代农业
					<input type="checkbox" name="lingyu" id="xinnengyuan" value="xinnengyuan">新能源与高效节能
					<input type="checkbox" name="lingyu" id="ziyuan" value="ziyuan">资源与环境
					<input type="checkbox" name="lingyu" id="gaojishu" value="gaojishu">高技术服务业
					<input type="checkbox" name="lingyu" id="haiyang" value="haiyang">海洋
					<input type="checkbox" name="lingyu" id="shehui" value="shehui">社会公共事业
					<input type="checkbox" name="lingyu" id="yiliao" value="yiliao">医疗卫生
					<input type="checkbox" name="lingyu" id="qita"   value="qita">其它（注明）
				</td>
			</tr>
			</table>
			<table align="center" id="hangye" style="display:none" width="785" height="45"  border="1" cellpadding="0" cellspacing="0" >
				<tr>
					<td width="120" height="45"><strong>需求技术应用行业</strong></td>
					<td width="300" height="45">
						<select name="firsthangye" style="width:100%;height:100%" class="form-control" onchange="twohangye(this)" id="firsthangye">
								<option value="0">-- 请选择一级行业 --</option>
								<c:forEach items="${hangyeBeans }" var="item">
									<option value="${item.id}">${item.hangye }</option>
								</c:forEach>
						</select>
					</td>
					<td id="hangye2" width="300" height="45">
						<select name='twhangye' id='twhangye' style="width:100%;height:100%" class="form-control"> 
							<option value='0'>-- 请选择二级行业 --</option>
						</select>
					</td>
				</tr>
			</table>
		<br>
		 	<button type="submit">保存并提交</button>
		 <br><br><br><br><br><br>
		
		 
	</form>
	</center>
</body>
</html>