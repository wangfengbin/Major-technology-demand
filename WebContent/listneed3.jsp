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
<script type="text/javascript">
var tjNum = 1; //条件数量
var infoData = "";

//添加条件
function addTJ() {
    if (tjNum >= 3) {
    	alert("系统友情提示","最多选择三个条件");
        return;
    }
    tjNum = tjNum + 1;//条件2，条件3
    content = "<tr id='" + tjNum;
    content += "'><td></td>";
    content += "<td><select id='logical" + (tjNum - 1);//逻辑1/2/
    content += "'onchange='showInfo(this)'>"+
    			"<option value='and'>并且</option>"+
    			"<option value='or'>或者</option>"+
    		    "<option value='not'>不含</option></select></td>";
    content += "<td><select class='i-text' id='search" + tjNum +"'onchange='showInfo(this.id);'>"+
    "<option value='title'>主题</option>"+
    "<option value='creatorId'";
    if (tjNum == 2) {
        content += " selected='selected'";
    }
    content += ">发布人</option>"+
    "<option value='addDate'";
    if (tjNum == 3) {
        content += " selected='selected'";
    }
    content += ">发布时间</option></select></td><td id='search" + tjNum + "td'>";
    if (tjNum == 2) {
        content += "<select style='width:172px;' id='find" + tjNum + "'>";
        content += infoData;
    } else {
        content += "<input size='6' onclick='new Calendar().show(this);' id='beforeFind" + tjNum;
        content += "' type='text'>---";
        content += "<input size='6' onclick='new Calendar().show(this);' id='afterFind" + tjNum;
        content += "' type='text'>";
    }
    content += "</td><td></td></tr>";
    $("#tj").append(content);
}
 
//删除条件
function minusTJ() {
    if (tjNum == 1) {
    	alert("系统友情提示","最少选择一个条件");
        return;
    }
    $("#" + tjNum).remove();
    tjNum = tjNum - 1;
}

function showInfo(id) {
    var idSelected = $("#" + id).val();
    if (idSelected == 'creatorId') {
        var content = "<select style='width:172px;' id='find" + id.substring(6, 7) + "'>";
        $("#" + id + "td").html(content + infoData);
    }else if(idSelected == 'addDate'){  	
    	$("#" + id + "td").html("<input size='6' onclick='new Calendar().show(this);' id='beforeFind" + id.substring(6,7) + "' type='text'>---<input size='6' onclick='new Calendar().show(this);' id='afterFind" + id.substring(6,7) + "' type='text'>");
    } else if(idSelected == 'title'){
    	$("#" + id + "td").html("<input class='demo2_class1'  id='find" + id.substring(6,7) + "' type='text'>");
    }
}

function getItem(page) {
    var search1 = $("#search1").val();
    var search2 = $("#search2").val();
    var search3 = $("#search3").val();
    var find1 = $("#find1").val();
    var find2 = $("#find2").val();
    var find3 = $("#find3").val();
    var logical1 = $("#logical1").val();
    var logical2 = $("#logical2").val();

    var beforeFind3 = $("#beforeFind3").val();
    var afterFind3 = $("#afterFind3").val();
 
    var beforeFind2 = $("#beforeFind2").val();
    var afterFind2 = $("#afterFind2").val();
 
    var beforeFind1 = $("#beforeFind1").val();
    var afterFind1 = $("#afterFind1").val();
    
    if(beforeFind1 > afterFind1 && beforeFind1 != "" && afterFind1 != "" ){
        alert("系统友情提示","结束日期不能在开始日期之前!");
        return;
    }
    if(beforeFind2 > afterFind2 && beforeFind2 != "" && afterFind2 != "" ){
        alert("系统友情提示","结束日期不能在开始日期之前!");
        return;
    }
    if(beforeFind3 > afterFind3 && beforeFind3 != "" && afterFind3 != "" ){
        alert("系统友情提示","结束日期不能在开始日期之前!");
        return;
    }
    
    //alert("获取参数完成");
    $.post('${pageContext.request.contextPath}/publishinfo/InfoServlet', 
    	{
    		'method': 'list',
	    	'currentPage': page,
	    	'isPass': isPass,
	    	'search1':search1,
	    	'find1':find1,
	    	'beforeFind1':beforeFind1,
	    	'afterFind1':afterFind1,
	    	'search2':search2,
	    	'find2':find2,
	    	'beforeFind2':beforeFind2,
	    	'afterFind2':afterFind2,
	    	'search3':search3,
	    	'find3':find3,
	    	'beforeFind3':beforeFind3,
	    	'afterFind3':afterFind3,
	    	'logical1':logical1,
	    	'logical2':logical2
    },
    function (data, textStatus, xhr) {
        var content ="<tr align='center'><th width='5%'>序号</th><th width='35%'>主题</th><th>发布人</th><th>发布时间</th><th width='25%'>操作</th></tr>";
        var json = eval("(" + data + ")");
        
        
    });
}
</script>
<body>
	<%@include file="/static/js/msgbox.jsp"%>

		<div class="row-fluid">
			<div class="span12">
				<h1>河北省重大技术需求列表</h1>
			</div>
		</div>
		
		<div id="show" style="background-color: #ffffff; position: relative; margin-top: 5px; margin-left: 10px; border: #ffffff 2px solid">
		<div style="position: relative; min-height: 490px;">
			<!-- <div style="background: #C0E4FA; position: relative;" align="center">欢迎来到河北大气污染防治支撑管理系统</div> -->
			<fieldset>
				<legend>
					<strong>选择筛选条件：</strong>
				</legend>
				<div style="background-color: #ffffff; position: relative; margin-top: 8px; margin-left: 12px; border: #ffffff 2px solid;">
					<table bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" id="tj">
							<tr>
								<td><span style="margin-left: 29px"><strong>条件:</strong></span></td>
								<td><img
									src="${pageContext.request.contextPath}/images/01.gif"
									onclick="addTJ()" style="cursor: hand;">&nbsp;&nbsp;<img
									src="${pageContext.request.contextPath}/images/02.gif"
									onclick="minusTJ()" style="cursor: hand;">
								</td>
								<td>
									<select class="i-text" name="search1" id="search1" onchange="showInfo(this.id);">
											<option value="title">主题</option>
											<option value="creatorId">发布人</option>
											<option value="addDate">发布时间</option>
									</select>
								</td>	
								<td id="search1td">
									<input class="demo2_class1" maxlength="15" name="find1" id="find1" type="text">	
								</td>																	
								<td>
									<input type="submit" class="submit" onclick="getItem(0)" value="&nbsp;查&nbsp;询&nbsp;" size="30">
								</td>								
							</tr>
					</table>
				</div>
			</fieldset>
			
		</div>
	</div>
			<!-- status=0未审核的   status=1已审核   status=2被退回   status=3显示全部 -->
			<!-- 
		<form action="NeedServlet?method=listneed" method="post">
				技术需求名称：<input type="text" name="name" id="name" value="${param.name }" />
				需求状态：
				
				<select name="status" id="status2">
					<c:if test="${param.status2 == '0'}">
						<option value="0" selected="selected">未审核</option>
					</c:if>
					<c:if test="${status2 != '0'}">
						<option value="0">未审核</option>
					</c:if>
					<c:if test="${status2 == '1'}">
						<option value="1" selected="selected">已审核</option>
					</c:if>
					<c:if test="${status2 != '1'}">
						<option value="1">已审核</option>
					</c:if>
					<c:if test="${status2 == '2'}">
						<option value="2" selected="selected">被退回</option>
					</c:if>
					<c:if test="${status2 != '2'}">
						<option value="2">被退回</option>
					</c:if>
				</select>
			<button class="btnMy">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;
			</form>
	 
			<a href="${pageContext.request.contextPath}/NeedServlet?method=listneed&status=3"><button class="btnMy">显示全部</button></a>
		</div>-->
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
			</table>
			
			</div>
			<div class=" col-md-1"></div>
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
