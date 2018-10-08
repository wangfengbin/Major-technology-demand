<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="88%">
		<tr>
			<th>id</th>
			<th>用户名</th>
			<th>密码</th>
			

		</tr>
		<c:forEach items="${page.list }" var="p">
			<tr>
				<td width='8%'>${p.id }</td>
				<td width='8%'>${p.username}</td>
				<td width='8%'>${p.password }</td>

			</tr>
		</c:forEach>
	</table>
	<center>
		<!-- 若是第一页 首页和上一页不展示 -->
		<c:if test="${page.currPage!=1 }">
			<a href='${pageContext.request.contextPath}/UserServlet?method=fenye&currPage=1'>[首页]  </a>
			<a href='${pageContext.request.contextPath}/UserServlet?method=fenye&currPage=${page.currPage-1}'>[上一页]</a>
		</c:if>
		
		<!-- 将所有的页码展示出来 -->
		<c:forEach begin="1" end="${page.totalPage }" var="n">
			<!-- 若是当前页 不可点 -->
			<c:if test="${page.currPage == n }">
				${n }
			</c:if>
			
			<!-- 若不是当前页 可点 -->
			<c:if test="${page.currPage != n }">
				<a href="${pageContext.request.contextPath}/UserServlet?method=fenye&currPage=${n}">${n }</a>
			</c:if>
		</c:forEach>
		
		<!-- 若是最后一页 尾页和下一页不展示 -->
		<c:if test="${pb.currPage!=pb.totalPage }">
			<a href='${pageContext.request.contextPath}/UserServlet?method=fenye&currPage=${page.currPage+1}'>[下一页]</a>
			<a href='${pageContext.request.contextPath}/UserServlet?method=fenye&currPage=${page.totalPage}'>[尾页]  </a>
		</c:if>
		第${page.currPage }页/共${page.totalPage }页
	</center>
</body>
</html>