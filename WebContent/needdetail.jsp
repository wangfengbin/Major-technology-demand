<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"content="width=device-width, initial-scale=1.0">
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
		
		var moshi = "${needbean.moshi}"
		if(moshi == "独立开发")
			$("#duli").attr("checked","checked");
		if(moshi == "委托研发")
			$("#zhuanrang").attr("checked","checked");
		if(moshi == "合作研发")
			$("#rugu").attr("checked","checked");
		if(moshi == "其他")
			$("#hezuo").attr("checked","checked");
		
		
		$("#firstxueke").val("${needbean.xueke }");
		twoxueke(document.getElementById('firstxueke'));
		
		$("#firsthangye").val("${needbean.yingyong }");
		twohangye(document.getElementById('firsthangye'));
		
		var type = "${needbean.type }"
			if(type == "基础研究")
			{
				$("#jichu").attr("checked","checked");
				$("#xueke").css("display","block");
				$("#lingyu").css("display","none");
				$("#hangye").css("display","none");
			}
			if(type == "应用研究")
			{
				$("#yingyong").attr("checked","checked");
				if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
				{
					$("#xueke").css("display","none");
					$("#lingyu").css("display","block");
					$("#hangye").css("display","block");
				}
			}
				
			if(type == "试验发展")
			{
				if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
				{
					$("#shiyan").attr("checked","checked");
					$("#xueke").css("display","none");
					$("#lingyu").css("display","block");
					$("#hangye").css("display","block");
				}
			}
				
			if(type == "研究发展与成果应用")
			{
				$("#yanjiu").attr("checked","checked");
				if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
				{
					$("#xueke").css("display","none");
					$("#lingyu").css("display","block");
					$("#hangye").css("display","block");
				}
			}
				
			if(type == "技术推广与科技服务")
			{
				$("#jishu").attr("checked","checked");
				if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
				{
					$("#xueke").css("display","none");
					$("#lingyu").css("display","block");
					$("#hangye").css("display","block");
				}
			}
				
			if(type == "生产性活动 ")
			{
				$("#shengchan").attr("checked","checked");
				if($("#lingyu").css("display") == "none")//如果领域不显示，则学科不显示，领域显示，否则不边变
				{
					$("#xueke").css("display","none");
					$("#lingyu").css("display","block");
					$("#hangye").css("display","block");
				}
			}
		
		
		var lingyu = "${needbean.lingyu }";
		var lingyu1 = lingyu.split(",");
		for(var i=0;i<lingyu1.length;i++)
		{
			$("#"+lingyu1[i]).attr("checked","checked");
		}
		 
				
		
		$("#jichu").click(function(){
			$("#xueke").css("display","block");
			$("#lingyu").css("display","none");
			$("#hangye").css("display","none");
		});
		$("#yingyong").click(function(){
			//alert($("#lingyu").css("display"));
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
		
		$("#up").click(function(){
			confirm("确认修改",function(){
				$("#form2").submit();
			})
		})
		
	});
</script>
<script type="text/javascript">
var isInit = 1;
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
						if(isInit == 1){
							var t = "${needbean.twoxueke }";
							$("#twxueke").val(t);
							isInit = 0;
						}
					}
				}, "json");
	}

}

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
<script type="text/javascript">
var isInit1 = 1;
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
						var content = "";
						for (var city in data) {
							content += "<option value='" + data[city].twohangye + "'>"
								+ data[city].twohangye + "</option>";
						}
						$("#twhangye").html(content);
						if(isInit1 == 1){
							var t = "${needbean.twohangye }";
							$("#twhangye").val(t);
							isInit = 0;
						}
					}
				}, "json");
	}
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
<c:if test="${param.msg.equals('0') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('该需求已被审核，不能修改', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
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
	.inp2{
		height:100%;
		width:20%;
	}
	.inp3{
		height:100%;
		width:70%;
	}
</style>
<!--  -->
<body style="background-color:#dceefc">
<%@include file="/static/js/msgbox.jsp"%>
	<h3 align="center">河北省重大技术需求征集表</h3>
	<div class="container">
	<hr>
	<center>
	<!-- 修改用户信息和需求信息 onsubmit="return check()" -->
	<form action="NeedServlet?method=updateneed&needid=${needbean.id }&userid=${userbean.id }" method="post" id="form2" onsubmit="return check()">
		<table width="800" height="550" border="1px"  cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
			<tr>
				<td width="120"><font style="color:red">*</font>机构全称</td>
				<td width="190"><input class="inp" type="text"  name="depart" style="border:0" value="${userbean.depart }"></td>
				<td width="120">归口管理部门</td>
				<td width="350"><input class="inp" type="text" name="departname" style="border:0" value="${userbean.departname }"></td>
			</tr>
			<tr>
				<td rowspan="2"><font style="color:red">*</font>联系人</td>
				<td rowspan="2"><input class="inp" type="text" name="truename" style="border:0" value="${userbean.truename }"></td>
				<td><font style="color:red">*</font>电话</td>
				<td>
					1.固定<input class="inp1" type="text" name="dianhua" style="border:0;" value="${userbean.dianhua }">
					2.手机<input class="inp1"  type="text" name="phnumber" style="border:0;" value="${userbean.phnumber }">
				</td>
			</tr>
			
			<tr>
				<td>传真</td>
				<td><input class="inp" type="text" name="chuanzhen" style="border:0" value="${userbean.chuanzhen }"></td>
			</tr>
			<tr>
				<td><font style="color:red">*</font>机构属性</td>
				<td colspan="3">
					 
					<input type="radio" name="jigoushuxing" id="qi" value="企业">企业
					<input type="radio" name="jigoushuxing" id="xiao" value="高等院校">高等院校
					<input type="radio" name="jigoushuxing" id="yan" value="研究机构">研究机构
					<input type="radio" name="jigoushuxing" id="ta" value="其他">其他
				</td>
			</tr>
			<tr>
				<td><strong><font style="color:red">*</font>技术需求名称</strong></td>
				<td><input class="inp" type="text" name="name" id="name" style="border:0;" value="${needbean.name }"></td>
				<td><strong><font style="color:red">*</font>需求时限<strong></td>
				<td><input class="inp1" type="text" id="qiannian" name="qiannian"style="border:0" value="${needbean.qiannian }">年至
					<input class="inp1" type="text" id="hounian" name="hounian"style="border:0" value="${needbean.hounian }">年	
				</td>
			</tr>
			<tr><td colspan="4" style="border:0"><strong><font style="color:red">*</font>技术需求概述(1、主要问题;2、技术关键;3、预期目标)</td></tr>
			
			<tr>
				<td colspan="4">
					<textarea name="descrpt" rows="8" cols="120" style="border:0">${needbean.descrpt }</textarea>
				</td>
			</tr>
			<tr>
				<td><font style="color:red">*</font><strong>关键字:</strong>
				<td colspan="3">
				1.<input type="text" class="inp2" style="border:1px;width:110px" id="guanjian1" name="guanjian1" value="${needbean.guanjian1 }">
				2.<input type="text" class="inp2" style="border:1px;width:110px" id="guanjian2" name="guanjian2" value="${needbean.guanjian2 }">
				3.<input type="text" class="inp2" style="border:1px;width:110px" id="guanjian3" name="guanjian3" value="${needbean.guanjian3 }">
				4.<input type="text" class="inp2" style="border:1px;width:110px" id="guanjian4" name="guanjian4" value="${needbean.guanjian4 }">
				5.<input type="text" class="inp2" style="border:1px;width:110px" id="guanjian5" name="guanjian5" value="${needbean.guanjian5 }">
				</td>
			</tr>
			<tr>
				<td><strong>拟投资金额</strong>
				<td colspan="3" ><input class="inp3" type="text" id="money" name="money" value="${needbean.money }">万元</td>
			</tr>
			<tr>
				<td rowspan="2"><strong><font style="color:red">*</font>技术需求解决方式</strong></td>
				<td colspan="3">
					<input type="radio" name="moshi" id="duli" value="独立开发">独立开发
					<input type="radio" name="moshi" id="zhuanrang" value="委托研发">委托研发
					<input type="radio" name="moshi" id="rugu" value="合作研发">合作研发
					<input type="radio" name="moshi" id="hezuo" value="其他">其他
				</td>
			</tr>
			<tr>	
				<td colspan="3">合作意向单位<input class="inp1" type="text" id="hezuo" name="hezuo" value="${needbean.hezuo }">(选填)</td>
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
			 <table id="xueke" style="display:block" width="800"  height="45"  border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;"> 
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
			<table width="800" style="display:none" id="lingyu" border="2px"  cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
			<tr>
				<td width="125"><strong>需求技术所属领域</strong></td>
				<td width="700">
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
			<table align="center" id="hangye" style="display:none" width="800" height="45"  border="1" cellpadding="0" cellspacing="0" >
				<tr>
					<td width="125" height="45"><strong>需求技术应用行业</strong></td>
					<td width="350" height="45">
						<select name="firsthangye" style="width:100%;height:100%" class="form-control" onchange="twohangye(this)" id="firsthangye">
								<option value="0">-- 请选择一级行业 --</option>
								<c:forEach items="${hangyeBeans }" var="item">
									<option value="${item.id}">${item.hangye }</option>
								</c:forEach>
						</select>
					</td>
					<td id="hangye2" width="350" height="45">
						<select name='twhangye' id='twhangye' style="width:100%;height:100%" class="form-control"> 
							<option value='0'>-- 请选择二级行业 --</option>
						</select>
					</td>
				</tr>
			</table>
			<button type="button"   onclick="update()" >修改</button>
			
			
			
	</form>
	</center>
	</div>
</body>
</html>