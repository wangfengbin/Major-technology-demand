<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<title>查看需求信息</title>
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css"/>
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
	
	<link rel="StyleSheet" href="dtree.css" type="text/css" />
	<script type="text/javascript" src="dtree.js"></script>
</head>
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
						var numbe = document.getElementById('num');
							numbe.innerHTML=data;
						$("#numInput").val(data);
					}
				}, "json");
	})

</script>
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
		
	})
</script>
<body>
<div class="dtree">

<!--	<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>
 d.add(自己的编号，父编号，编号名称，链接地址) -->
	<script type="text/javascript">
		

		d = new dTree('d');
		
		d.add(0,-1,'综合查询');
		d.add(1,0,'Node1基础研究','example01.html');
		d.add(2,0,'Node 2','example01.html');
		d.add(3,1,'Node 1.1','example01.html');
		d.add(4,0,'Node 3','example01.html');
		d.add(5,3,'Node 1.1.1','example01.html');
		d.add(6,5,'Node 1.1.1.1','example01.html');
		d.add(7,0,'Node 4','example01.html');
		d.add(8,1,'Node 1.2','example01.html');
		d.add(9,0,'My Pictures','example01.html','Pictures I\'ve taken over the years','','','img/imgfolder.gif');
		d.add(10,9,'The trip to Iceland','example01.html','Pictures of Gullfoss and Geysir');
		d.add(11,9,'Mom\'s birthday','example01.html');
		d.add(12,0,'Recycle Bin','example01.html','','','img/trash.gif');

		document.write(d);

		
	</script>

</div>
<center>
	<%@include file="/static/js/msgbox.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h1>河北省重大技术需求列表</h1>
			</div>
		</div>
		<table width="900" border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;"> 
		     <tr>
				<td width="120"><strong><font style="color:red">*</font>科技活动类型</strong></td>
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
		 <table id="xueke" style="display:block" width="900"  height="45"  border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;"> 
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
			<table  align="center" id="lingyu" style="display:none"width="900" height="60"  border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
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
			<table align="center" id="hangye" style="display:none" width="900" height="45"  border="1" cellpadding="0" cellspacing="0" >
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
		<div class="row-fluid">
			<div class="col-md-1 "></div>
			<div class="col-md-10 ">
				<table class="table table-striped">
				<tr>
					<td>需求编号</td>
					<td>技术需求名称</td>
					<td>填报日期</td>
					<td>需求审核</td>
					<td>网络审核</td>
				</tr>
				  
				<!-- forEach遍历出adminBeans -->
				
				<c:forEach items="${needbeans }" var="item" varStatus="status">
				<tr>
					<td>${item.id }</td>
					<td><a href="${pageContext.request.contextPath}/NeedServlet?method=add&sta=1&sta10=1&id=${item.id }">${item.name }</a></td>
					<td>${item.date }</td>
					
					<c:if test="${item.status==0}">
						<td>未审核</td>
					</c:if>
					<c:if test="${item.status==1}">
						<td>已审核</td>
					</c:if>
					<c:if test="${item.status==2}">
						<td>被退回</td>
					</c:if>
					
					<c:if test="${item.status1==0}">
						<td>未审核</td>
					</c:if>
					<c:if test="${item.status1==1}">
						<td>已审核</td>
					</c:if>
					<c:if test="${item.status1==2}">
						<td>被退回</td>
					</c:if>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4">总共有${page.sum }条数据，每页有${page.everypage }条记录，共${page.pagenum }页，当前是第${page.currentPage }页，</td>
				</tr>
			</table>
			
			</div>
			<div class=" col-md-1"></div>
		</div>
		
		<div class="row-fluid">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div>
					<util:page pagingBean="${pagingBean }"/>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
		
	</div>
			<c:if test="${param.info.equals('1')}">
				<script type="text/javascript">
					confirm("是否继续填报？",function(){
						window.location.href='NeedServlet?method=add'
					});
				</script>
			</c:if>
</center>
</body>
</html>
