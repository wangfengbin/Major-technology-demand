<%@page isErrorPage="true"%>
<%@page errorPage="/login.jsp" pageEncoding="UTF-8"%>
<head>
<title>河北省重大技术需求征集系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/menu.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />

<liNK href="images/style.css" type=text/css rel=stylesheet>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-size: 8px;
	font-family: "Microsoft Yahei", Verdana, Arial, Helvetica, sans-serif
}

.leftMenu {
	min-width: 200px;
	width: 250px;
	margin: 40px auto 0 auto;
}

.menu {
	border: #bdd7f2 1px solid;
	border-top: #0080c4 3px solid;
	border-bottom: #0080c4 3px solid;
	background: #B1D8EA repeat-y right;
	margin-left: 0px;
}

.menu .ListTitle {
	border-bottom: 1px #98c9ee solid;
	display: block;
	text-align: center;
	/*position: relative;*/
	height: 25px;
	line-height: 25px;
	cursor: pointer;
	/*+min-width:220px;*/ +
	width: 100%;
}

.ListTitlePanel {
	position: relative;
}

.leftbgbt {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 52px;
	left: -11px;
	top: -4px;
}

.leftbgbt2 {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 48px;
	left: -11px;
	top: -1px;
}

.menuList {
	display: block;
	height: auto;
}

.menuList div {
	height: 25px;
	line-height: 24px;
	border-bottom: 1px #98c9ee dotted;
}

.menuList div a {
	display: block;
	background: #fff;
	line-height: 25px;
	height: 25px;
	text-align: center;
	color: #185697;
	text-decoration: none;
}

.menuList div a:hover {
	color: #f30;
	background: #0080c4;
	color: #fff;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var menuParent = $('.menu > .ListTitlePanel > div'); //获取menu下的父层的DIV
		var menuList = $('.menuList');
		$('.menu > .menuParent > .ListTitlePanel > .ListTitle').each(function(i) { //获取列表的大标题并遍历
			$(this).click(function() {
				if ($(menuList[i]).css('display') == 'none') {
					$(menuList[i]).slideDown(300);
				} else {
					$(menuList[i]).slideUp(300);
				}
			});
		});
	});
</script>
</head>
<script type="text/javascript">
	$(function(){
		var juese = "${userbean.juese }";
		//alert(juese);
		if(juese == "普通用户")
		{
			$("#xuqiu").css("display","none");
			$("#wangluo").css("display","none");
			$("#quanxian").css("display","none");
		}
		else if(juese == "超级用户")
		{
			$("#quanxian").css("display","none");
			$("#addneed").css("display","none");
		}
		
	})
</script>
</script>
<body class="panel" background="#B1D8EA">
	<div id="body">
		<div style="background: #3FA0F1;; position: relative; height: 30px;"
			align="center">
			<font color="#ffffff" style="top: 4px; position: relative; font-size: 15px;">系统菜单</font>
		</div>	
 		
		<div class="menu">
			<div class="menuParent">
				<div class="ListTitlePanel">
					<div class="ListTitle">
						<strong >需求管理</strong>
						<div class="leftbgbt"></div>
					</div>
				</div>
				<div class="menuList">
					<div id="addneed">
						<a target="mainAction"
							href="${pageContext.request.contextPath }/NeedServlet?method=add">需求征集</a>
					</div>
					<div>
						<a  target="mainAction"
							href="${pageContext.request.contextPath }/NeedServlet?method=listneed&suoshu=me&status=4">我的需求</a>
					</div>
					<div>
						<a  target="mainAction"
							href="${pageContext.request.contextPath }/NeedServlet?method=listneed&status=3">浏览需求</a>
					</div>
					<div>
						<a  target="mainAction"
							href="${pageContext.request.contextPath }/NeedServlet?method=fenye&currPage=1">浏览需求分页</a>
					</div>
					<div id="xuqiu">
						<a  target="mainAction"
							href="${pageContext.request.contextPath }/NeedServlet?method=listneed&status=0&shenhe=0">需求审核</a>
					</div>
					<div id="wangluo">
						<a  target="mainAction"
							href="${pageContext.request.contextPath }/NeedServlet?method=listneed&status=0&shenhe=1">网络审核</a>
					</div>
					<!-- ${pageContext.request.contextPath }/NeedServlet?method=add&sta=5" -->
					<div id="wangluo">
						<a  target="mainAction"
							href="tongji1.jsp">数据统计</a>
					</div>
					<div id="wangluo">
						<a  target="mainAction"
							href="${pageContext.request.contextPath }/Main.jsp">查询</a>
					</div>
					
					<div id="wangluo">
						<a  target="mainAction"
							href="${pageContext.request.contextPath }/UserServlet?method=fenye&currPage=1">分页</a>
					</div>
					
				</div>
			</div>
			
			<div class="menuParent">
				<div class="ListTitlePanel">
					<div class="ListTitle">
						<strong>用户管理</strong>
						<div class="leftbgbt2"></div>
					</div>
				</div>
				<div class="menuList">
					<div>
						<a target="mainAction"
							href="register.jsp">用户注册</a>
					</div>
					<div id="userinfo">
						<a target="mainAction"
							href="userinfo.jsp">用户详情</a>
					</div>
					<div id="quanxian">
						<a target="mainAction"
							href="addjuese.jsp">权限管理</a>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	

</body>
</html>