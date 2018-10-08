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
	
</head>
<body>
	<%@include file="/static/js/msgbox.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h1>河北省重大技术需求列表</h1>
			</div>
		</div>
		<div style="text-align:center">
		<form action="NeedServlet?method=listneed&suoshu=all" method="post">
				技术需求名称：<input type="text" name="name" id="name" value="${param.name }" />
				需求状态：
				<!-- status=0未审核的   status=1已审核   status=2被退回   status=3显示全部 -->
				<select name="status" id="status2">
					<c:if test="${param.status2 == '0'}">
						<option value="0" selected="selected">未审核</option>
					</c:if>
					<c:if test="${param.status2 != '0'}">
						<option value="0">未审核</option>
					</c:if>
					<c:if test="${param.status2 == '1'}">
						<option value="1" selected="selected">已审核</option>
					</c:if>
					<c:if test="${param.status2 != '1'}">
						<option value="1">已审核</option>
					</c:if>
					<c:if test="${param.status2 == '2'}">
						<option value="2" selected="selected">被退回</option>
					</c:if>
					<c:if test="${param.status2 != '2'}">
						<option value="2">被退回</option>
					</c:if>
				</select>
			<button class="btnMy">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;
			</form>
			<a href="${pageContext.request.contextPath}/NeedServlet?method=listneed&status=3"><button class="btnMy">显示全部</button></a>
		</div>
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
</body>
</html>
