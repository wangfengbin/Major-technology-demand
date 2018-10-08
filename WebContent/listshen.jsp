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
	<script
	src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"type="text/javascript"></script>
	<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css"/>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h1>河北省重大技术需求审核单</h1>
			</div>
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
					
				</tr>
				  
				<!-- forEach遍历出adminBeans -->
				
				<c:forEach items="${needbeans }" var="item" varStatus="status">
				<tr>
					<td>${item.id }</td>
					<td><a href="${pageContext.request.contextPath}/NeedServlet?method=add&sta=1&sta10=0&id=${item.id }&shenhe=${param.shenhe }">${item.name }</a></td>
					<td>${item.date }</td>
					<td>未审核</td>
				</tr>
				
				</c:forEach>
				</table>
				<c:if test="${param.status.equals('2')}">
					<div class="alert alert-success"role="alert">修改成功</div>
				</c:if>
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-success"role="alert">删除成功</div>
				</c:if>
				<c:if test="${param.status.equals('4')}">
					<div class="alert alert-success"role="alert">删除失败</div>
				</c:if>
				<c:if test="${param.status.equals('3')}">
					<div class="alert alert-info"role="alert">修改失败</div>
				</c:if>
				
			</div>
			<div class=" col-md-1"></div>
		</div>
		
	</div>
</body>
</html>
