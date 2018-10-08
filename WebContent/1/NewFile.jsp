<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>-->
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
<!-- jquer blur事件，当鼠标焦点失去时触发,("#123").blur(function(){ ....})-->
<script type="text/javascript">
	
	$(function(){
		/*	
		$.validator.addMethod("number", function(value, element) {   
			var numberReg = /^[1][3458][0-9]{9}$/;
			return this.optional(element) || (numberReg.test(value));
		}, "请正确填写您的手机号码");
		
		$.validator.addMethod("bigger", function(value, element) {  
			var returnVal = false;  
			var amountStart = $("#qiannian").val();
			var amountEnd = $("#hounian").val();
			if(parseFloat(amountEnd)>parseFloat(amountStart)){
				returnVal = true;
			}
			return returnVal;   
		},"结束年限必须大于开始年限"); 		
		
		$("#123").validate({
			rules:{
				depart:{
				required:true
				},
				address:{
					required:true
				},
				city:{
					required:true
				},
				email:{
					required:true
				},
				faren:{
					required:true
				},
				truename:{
					required:true
				},
				phnumber:{
					required:true,
					number:true
				},
				dianhua:{
					required:true
				},
				jigoushuxing:{
					required:true
				},
				jigoujianjie:{
					required:true
				},
				name:{
					required:true
				},
				qiannian:{ 
					required:true,
				}, 
				
				hounian: {
					required:true,
					bigger:true
				},
				guanjian1:{
					required:true
				},
				guanjian2:{
					required:true
				},
				guanjian3:{
					required:true
				},
				guanjian4:{
					required:true
				},
				guanjian5:{
					required:true
				},
				moshi:{
					required:true
				},
				type:{
					required:true
				},
				money:{
					digits:true
				}
			},
			messages:{
				money:{
					digits:"金额必须是数字"
				},			
				depart:{
					required:"机构名称不能为空"
				},
				address:{
					required:"通讯地址不能为空"
				},
				city:{
					required:"地域不能为空"
				},
				email:{
					required:"电子信箱不能为空"
				},
				faren:{
					required:"法人代表不能为空"
				},
				truename:{
					required:"联系人不能为空"
				},
				phnumber:{
					required:"手机号不能为空",
					number:"手机号错误"
				},
				dianhua:{
					required:"电话不能为空"
				},
				jigoushuxing:{
					required:"机构属性没选中"
				},
				jigoujianjie:{
					required:"机构简介不能为空"
				},
				name:{
					required:"技术需求名称不能为空"
				},
				qiannian:{ 
					required:"开始年限不能为空",
				}, 
				
				hounian: {
					required:"年限不能为空",
					bigger:"结束年限必须大于开始年限"
				},
				guanjian1:{
					required:"关键字1不能为空"
				},
				guanjian2:{
					required:"关键字2不能为空"
				},
				guanjian3:{
					required:"关键字3不能为空"
				},
				guanjian4:{
					required:"关键字4不能为空"
				},
				guanjian5:{
					required:"关键字5不能为空"
				},
				moshi:{
					required:"技术需求解决方式没选中"
				},
				type:{
					required:"科技活动类型没选中"
				}
				
			},
			errorPlacement: function (error, element) {
		           alert(error.html()); 
		    }		
		})*/
		
		var shuxing = "${userbean.jigoushuxing }";
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
		
		
		$("#name").blur(function(){
			if($("#name").val() == "")
				alert("需求名称不能为空");
		});
		$("#qiannian").blur(function(){
			if($("#qiannian").val() == "")
				alert("开始年限不能为空");
			if($("#qiannian").val() > $("#hounian").val())
				alert("开始年限不能大于结束年限");
		});
		$("#hounian").blur(function(){
			if($("#hounian").val() == "")
				alert("结束年限不能为空");
			if($("#qiannian").val() > $("#hounian").val())
				alert("开始年限不能大于结束年限");
		});
		$("#descrpt").blur(function(){
			if($("#descrpt").val() == "")
				alert("技术需求概述不能为空");
		});
		$("#guanjian1").blur(function(){
			if($("#guanjian1").val() == "")
				alert("关键字1不能为空");
			//$("#guanjian1").focus();
		});
		$("#guanjian2").blur(function(){
			if($("#guanjian2").val() == "")
				alert("关键字2不能为空");
			//$("#guanjian2").focus();
		});
		$("#guanjian3").blur(function(){
			if($("#guanjian3").val() == "")
				alert("关键字3不能为空");
			//$("#guanjian3").focus();
		});
		$("#guanjian4").blur(function(){
			if($("#guanjian4").val() == "")
				alert("关键字4不能为空");
			//$("#guanjian4").focus();
		});
		$("#guanjian5").blur(function(){
			if($("#guanjian5").val() == "")
				alert("关键字5不能为空");
			//$("#guanjian5").focus();
		});
		$("#money").blur(function(){
			if($("#money").val() == "")
				alert("金额不能为空");
			//$("#money").focus();
		});
		
	})
	
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
						//content += "</select>";
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
						//alert(data.length);
						var content = "<select name='twhangye' id='twhangye'> <option value='0'>-- 请选择二级行业 --</option>";
						for (var city in data) {
							content += "<option value='" + data[city].twohangye + "'>"
								+ data[city].twohangye + "</option>";
						}
						content += "</select>";
						$("#hangye2").html(content);
					}
				}, "json");
	}

}
function createnumber(){
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	if(m<10)
		m = "0"+m;
	var d = date.getDate();
	if(d<10)
		d = "0"+d;
	var num = ""+y+m+d;
	var numbe = document.getElementById('num');
	numbe.innerHTML=num;//20101024
	document.getElementById('numInput').value=num;
}

</script>
<style>
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
<body style="background-color:#dceefc" onload="createnumber()">
	                <%  
					  int num=0;   //访问网页次数计数
					  String num1 = "000";
				      if(application.getAttribute("number")==null){   //application为全局对象，适合保存网页访问次数
				    	  num=1;
				  		  num1 ="001";
				      }
				      else{
				    	    num=Integer.parseInt(application.getAttribute("number").toString());  //获取number属性的值，方便记录
				      		if(num >0&&num<10)
				      			num1="00"+num;
				      		else if(num>=10&&num<=99)
				      			num1="0"+num;
				      }    
				      application.setAttribute("number",num);
				      application.setAttribute("number1",num1); 
				     %>
	<h2 align="center">河北省重大技术需求征集表</h2>
	<center>
	<form action="NeedServlet?method=addneed&id=${userbean.id }" method="post" id="123">
		需求编号<span id="num" name="number"></span><input type="hidden" name="numInput" id="numInput"><%=application.getAttribute("number1") %>
		<table border="1px"  cellpadding="0" cellspacing="0" style="border-collapse:collapse;"width="1326" height="570">
			
			<tr height="35px">
				<td colspan="4"><font style="color:red">*</font>机构全称</td>
				<td colspan="2"><input class="inp" type="text" name="depart" style="border:1px solid #378888;" value="${userbean.depart }"></td>
				<td colspan="4">归口管理部门</td>
				<td width="764" colspan="2"><input class="inp" type="text" name="departname" style="border:1px solid #378888;" value="${userbean.departname }"></td>
			</tr>
			<tr height="35px">
				<td colspan="4"><font style="color:red">*</font>联系人</td>
				<td colspan="2"><input class="inp" type="text" name="truename" style="border:1px solid #378888;" value="${userbean.truename }"></td>
				<td colspan="3"><font style="color:red">*</font>电话</td>
				<td colspan="3">
					1.固定<input class="inp1" type="text" name="dianhua" style="border:1px solid #378888;" value="${userbean.dianhua }">
					2.手机<input class="inp1" type="text" name="phnumber" style="border:1px solid #378888;" value="${userbean.phnumber }">
				</td>
			</tr>
			<tr height="35px">
				<td colspan="4"><font style="color:red">*</font>机构属性</td>
				<td colspan="8">
					<input type="radio" name="jigoushuxing" id="qi" value="企业">企业
					<input type="radio" name="jigoushuxing" id="xiao" value="高等院校">高等院校
					<input type="radio" name="jigoushuxing" id="yan" value="研究机构">研究机构
					<input type="radio" name="jigoushuxing" id="ta" value="其他">其他
				</td>
			</tr>
			<tr height="35px">
				<td colspan="4"><strong><font style="color:red">*</font>技术需求名称</strong></td>
				<td colspan="3"><input class="inp" type="text" id="name" name="name"style="border:1px solid #378888;"></td>
				<td colspan="2"><strong><font style="color:red">*</font>需求时限</strong></td>
				<td colspan="3"><input class="inp1" type="text" id="qiannian" name="qiannian"style="border:1px solid #378888">年至
					<input class="inp1" type="text" id="hounian" name="hounian"style="border:1px solid #378888">年	
				</td>
			</tr>
			
			<tr>
				<tr><td colspan="12" style="border:0"><strong><font style="color:red">*</font>技术需求概述</td></tr>
				<tr><td colspan="12" style="border:0">1、主要问题（需要解决的重大技术问题，<font style="color:red">限500字以内</font>）</td></tr>
				<tr>
					<td colspan="12" style="height: 150px">
						<textarea name="descrpt" id="descrpt" rows="8" cols="120" style="border:0" maxlength="500" 
							onchange="this.value=this.value.substring(0, 500)" 
							onkeydown="this.value=this.value.substring(0, 500)" 
							onkeyup="this.value=this.value.substring(0, 500)"></textarea>
					</td>
				</tr>
			<td width="206"></tr>
			
			<tr>
				<td colspan="4"><font style="color:red">*</font><strong>关键字:</strong></td>
				<td colspan="8">
				1.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian1" name="guanjian1">
				2.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian2" name="guanjian2">
				3.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian3" name="guanjian3">
				4.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian4" name="guanjian4">
				5.<input class="inp2" type="text" style="border:1px solid #378888 ;width:90px" id="guanjian5" name="guanjian5">
				</td>
			</tr>
			
			<tr>
				<td colspan="4"><strong>拟投资金额</strong>
				<td colspan="8" ><input class="inp3" type="text" id="money" name="money">万元</td>
			</tr>
			
			<tr>
				<td rowspan="2" colspan="4"><strong><font style="color:red">*</font>技术需求解决方式</strong></td>
				<td colspan="8">
					<input type="radio" name="moshi" id="duli" value="独立开发">独立开发
					<input type="radio" name="moshi" id="zhuanrang" value="委托研发">委托研发
					<input type="radio" name="moshi" id="rugu" value="合作研发">合作研发
					<input type="radio" name="moshi" id="hezuo" value="其他">其他
				</td>
			</tr>
				
			<tr>
				
				<td colspan="8">合作意向单位<input class="inp3" type="text" name="hezuo">(选填)</td>
			</tr>
			
			<tr>
				<td colspan="4"><strong><font style="color:red">*</font>科技活动类型</strong></td>
				<td colspan="8">
					<input type="radio" name="type" id="jichu" value="基础研究" checked="checked">基础研究
					<input type="radio" name="type" id="yingyong" value="应用研究">应用研究
					<input type="radio" name="type" id="shiyan" value="试验发展">试验发展
					<input type="radio" name="type" id="yanjiu" value="研究发展与成果应用">研究发展与成果应用
					<input type="radio" name="type" id="jishu" value="技术推广与科技服务">技术推广与科技服务
					<input type="radio" name="type" id="shengchan" value="生产性活动">生产性活动
				</td>
			</tr>
			 
			<tr id="xueke">
				<td colspan="4"><strong>学科分类()</strong></td>
				
				<td colspan="4">
					<select name="firstxueke" style="width:100%;height:100%" class="form-control" onchange="twoxueke(this)" id="firstxueke">
							<option value="0">-- 请选择学科 --</option>
							<c:forEach items="${xuekeBeans }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
				</td>
				
				<td id="xueke2" colspan="4">
					<select name='twxueke' id='twxueke' style="width:50%;height:100%" class="form-control"> 
						<option value='0'>-- 请选择二级学科 --</option>
					</select>
				</td>
			</tr>
			
			</table>
			
			<table  align="center"  style="display:none" id="lingyu" border="2px"  cellpadding="0" cellspacing="0" style="border-collapse:collapse;width:600px">
			<tr>
				<td colspan="4"><strong>需求技术所属领域(非基础研究)</strong></td>
				<td colspan="8">
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
			<table align="center" style="display:none" id="hangye" border="2px"  cellpadding="0" cellspacing="0" style="border-collapse:collapse;width:600px">
				<tr>
					<td colspan="4"><strong>需求技术应用行业（非基础研究）</strong></td>
					<td colspan="4">
						<select name="firsthangye" class="form-control"
								onchange="twohangye(this)" id="firsthangye">
								<option value="0">-- 请选择行业 --</option>
								<c:forEach items="${hangyeBeans }" var="item">
									<option value="${item.id}">${item.hangye }</option>
								</c:forEach>
							</select>
					</td>
					<td id="hangye2" colspan="4"></td>
				</tr>
			</table>
		<br>
		<div>
		 	<button type="submit" class="btn btn-primary">保存并提交</button>
		</div>
	</form>
	</center>
</body>
</html>