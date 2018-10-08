<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息管理</title>
<style type="text/css">
body {
	font: 14px/1.5 宋体, 宋体, \5b8b\4f53, sans-serif;
}

ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

a {
	margin-left: 5px;
	color: #07F;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}req

input {
	border: 1px solid #ccc;
	margin: 2px;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

td {
	margin: 0;
	padding: 10px;
}

th {
	border-color: #666666;
	background-color: #dedede;
}

#tj td {
	margin: 0;
	padding: 4px;
	border: 0px solid #ccc;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/js/msgbox.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/Calendar.js"></script>

	
	
<script type="text/javascript">
var tjNum = 1; //条件数量
var infoData = "";
var isPass = 1;<%//=request.getParameter("isPass")%>
//添加条件
function addTJ() {
    if (tjNum >= 3) {
    	alert("系统友情提示","最多选择三个条件");
        return;
    }
    tjNum = tjNum + 1;
    content = "<tr id='" + tjNum;
    content += "'><td></td>";
    //选择条件and or not下拉选
    content += "<td><select id='logical" + (tjNum - 1);  //第1,2个逻辑词
    content += "'onchange='showInfo(this)'>"+
    			"<option value='and'>并且</option>"+
    			"<option value='or'>或者</option>"+
    		    "<option value='not'>不含</option></select></td>";
    //选择项目下拉选	                            //第2/3个查询项目  search2，search3
    content += "<td><select class='i-text' id='search" + tjNum +"'onchange='showInfo(this.id);'>"+  
    "<option value='title'>主题</option>"+    //选择筛选项目
    "<option value='creatorId'";
    if (tjNum == 2) {                        //第二个筛选项目默认是发布人
        content += " selected='selected'";
    }
    content += ">发布人</option>"+
    "<option value='addDate'";               //第二个筛选项目默认是发布时间
    if (tjNum == 3) {
        content += " selected='selected'";
    }
    content += ">发布时间</option></select></td><td id='search" + tjNum + "td'>";
    
    
    if (tjNum == 2) {////第二个条件，默认获得发布人的所有集合
        content += "<select style='width:172px;' id='find" + tjNum + "'>";    //第2，3个发布人find2、find3
        content += infoData;
    } else {
        content += "<input size='6' onclick='new Calendar().show(this);' id='beforeFind" + tjNum; //第2/3个日期  beforeFind2,beforeFind3
        content += "' type='text'>---";
        content += "<input size='6' onclick='new Calendar().show(this);' id='afterFind" + tjNum;  //第2/3个日期  afterFind2,afterFind3
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

//根据选择的筛选项目不同，筛选项目的输入框也不同
function showInfo(id) {
    var idSelected = $("#" + id).val();
    if (idSelected == 'creatorId') {//发布人
        var content = "<select style='width:172px;' id='find" + id.substring(6, 7) + "'>";
        $("#" + id + "td").html(content + infoData);
    }else if(idSelected == 'addDate'){  	
    	$("#" + id + "td").html("<input size='6' onclick='new Calendar().show(this);' id='beforeFind" + id.substring(6,7) + "' type='text'>---<input size='6' onclick='new Calendar().show(this);' id='afterFind" + id.substring(6,7) + "' type='text'>");
    } else if(idSelected == 'title'){
    	$("#" + id + "td").html("<input class='demo2_class1'  id='find" + id.substring(6,7) + "' type='text'>"); //第2/3个主题
    }
}
 
//验证内容，进行提交,获得符合对应条件的记录
function getItem() {
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
    
    $.post('${pageContext.request.contextPath}/NeedServlet', 
    	{
    		'method': 'chaxunlist',
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
    
    function (data) {
        var content ="<tr align='center'><th width='5%'>序号</th><th width='35%'>主题</th><th>发布人</th><th>发布时间</th>";//"<th width='25%'>操作</th></tr>";
    	   index = 0;
    	  for (var item in data) {
            if (index % 2 == 1) {
                content += "<tr align='center' bgcolor='#ffffff'>";
            } else {
                content += "<tr align='center' bgcolor='#F0F0F0'>";
            }
            content += "<td>" + (index + 1) + "</td>";
            index += 1;
            content +=
                "<td style='overflow: hidden; text-overflow: ellipsis; word-break: keep-all; white-space: nowrap;text-align:left'>" +
                data[item].name + "</td>";
            content += "<td>" + data[item].userid + "</td>";
            content += "<td>" + data[item].date + "</td>";
        };
        $("#list").html(content);
    },"json");
}
 
//初始化该页面，首先获得发布人的集合,初始化了infoData;

//打开页面，首先运行

//获取  所有的发布人集合
function getInfoData() {                   
    $.post('${pageContext.request.contextPath}/UserServlet',{'method': 'getUserBean'}, function (data) {
        var content = "";
        for (var item in data) {
        	content += "<option  value='" + data[item].id + "'>" + data[item].username + "</option>";
        }
        content += "</select>";
        infoData = content;
       // var xueke = "";
       // var hangye = "";
       // var type = "";
        <% request.setCharacterEncoding("utf-8");
        	response.setContentType("text/html;charset=utf-8");
        %>
        //type 1基础研究 2应用研究 3试验发展 4研究发展与成果应用 5技术推广与科技服务 6生产性活动
        var type = "<%=request.getParameter("type")%>";
        var xueke = <%=request.getParameter("xueke")%>;
        var hangye = <%=request.getParameter("hangye")%>;
        if(type == 1) type = "基础研究";
        else if(type == 2) type = "应用研究";
        else if(type == 3) type = "试验发展";
        else if(type == 4) type = "研究发展与成果应用";
        else if(type == 5) type = "技术推广与科技服务";
        else if(type == 6) type = "生产性活动";
        //alert("xueke "+xueke);
        //alert("hangye "+hangye);
        //alert("type "+type);
        if(xueke != null && xueke != "")
        {
        	//alert("学科");
        	getXueke(xueke);
        }
        else if(hangye != null && hangye != "")
        {
        	//alert("行业");
        	getHangye(hangye,type);
        }
        else if(xueke == null && hangye == null && type != null && type != "null")
        {
        	//alert("总的type"+type)
        	getType(type);
       	}
        else
        {
        	//alert("所有");
        	getItem();
        }
        	
    },"json");
}

//获得该种类的所有的needbeans
function getType(type) {
		$.post(
			"${pageContext.request.contextPath}/NeedServlet",
			{
				method : "getTypeNeed",
				type : type
			},
			function(data) {
				var content ="<tr align='center'><th width='5%'>序号</th><th width='35%'>主题</th><th>发布人</th><th>发布时间</th>";//"<th width='25%'>操作</th></tr>";
		    	   index = 0;
		    	  for (var item in data) {
		            if (index % 2 == 1) {
		                content += "<tr align='center' bgcolor='#ffffff'>";
		            } else {
		                content += "<tr align='center' bgcolor='#F0F0F0'>";
		            }
		            content += "<td>" + (index + 1) + "</td>";
		            index += 1;
		            content +=
		                "<td style='overflow: hidden; text-overflow: ellipsis; word-break: keep-all; white-space: nowrap;text-align:left'>" +
		                data[item].name + "</td>";
		            content += "<td>" + data[item].userid + "</td>";
		            content += "<td>" + data[item].date + "</td>";
		        };
		        $("#list").html(content);
		        
			}, "json");
	
}

//获得基础研究中该学科id的needbeans
function getHangye(hangye,type) {
		$.post(
			"${pageContext.request.contextPath}/NeedServlet",
			{
				method : "gethangyeNeed",
				hangye : hangye,
				type : type
			},
			function(data) {
				var content ="<tr align='center'><th width='5%'>序号</th><th width='35%'>主题</th><th>发布人</th><th>发布时间</th>";//"<th width='25%'>操作</th></tr>";
		    	   index = 0;
		    	  for (var item in data) {
		            if (index % 2 == 1) {
		                content += "<tr align='center' bgcolor='#ffffff'>";
		            } else {
		                content += "<tr align='center' bgcolor='#F0F0F0'>";
		            }
		            content += "<td>" + (index + 1) + "</td>";
		            index += 1;
		            content +=
		                "<td style='overflow: hidden; text-overflow: ellipsis; word-break: keep-all; white-space: nowrap;text-align:left'>" +
		                data[item].name + "</td>";
		            content += "<td>" + data[item].userid + "</td>";
		            content += "<td>" + data[item].date + "</td>";
		        };
		        $("#list").html(content);
		        
			}, "json");
	
}

//获得基础研究中该学科id的needbeans
function getXueke(xueke) {
		$.post(
			"${pageContext.request.contextPath}/NeedServlet",
			{
				method : "getxuekeNeed",
				xueke : xueke
			},
			function(data) {
				var content ="<tr align='center'><th width='5%'>序号</th><th width='35%'>主题</th><th>发布人</th><th>发布时间</th>";//"<th width='25%'>操作</th></tr>";
		    	   index = 0;
		    	  for (var item in data) {
		            if (index % 2 == 1) {
		                content += "<tr align='center' bgcolor='#ffffff'>";
		            } else {
		                content += "<tr align='center' bgcolor='#F0F0F0'>";
		            }
		            content += "<td>" + (index + 1) + "</td>";
		            index += 1;
		            content +=
		                "<td style='overflow: hidden; text-overflow: ellipsis; word-break: keep-all; white-space: nowrap;text-align:left'>" +
		                data[item].name + "</td>";
		            content += "<td>" + data[item].userid + "</td>";
		            content += "<td>" + data[item].date + "</td>";
		        };
		        $("#list").html(content);
		        
			}, "json");
	
}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="#B1D8EA" bgcolor="#B1D8EA" onload="getInfoData();">	
	<div id="show" style="background-color: #ffffff; position: relative; margin-top: 5px; margin-left: 10px; border: #ffffff 2px solid">
		<div style="position: relative; min-height: 490px;">
			<div style="background: #C0E4FA; position: relative;" align="center">欢迎来到河北大气污染防治支撑管理系统</div>
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
											<option value="title">需求名称</option>
											<option value="creatorId">发布人</option>
											<option value="addDate">发布时间</option>
									</select>
								</td>	
								<!-- 第一个条件的输入 -->
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
			
			<div>
				动态信息：
				<div>
					<table width='100%' style="table-layout: fixed" id="list">
					</table>
				</div>
				<!-- <%//@include file="/common/paging.jsp"%> -->
				
			</div>
		</div>
	</div>
	

	
<c:if test="${param.status == 1}">
	<script type="text/javascript">
		alert("系统友情提示","修改成功");
	</script>
</c:if>
<c:if test="${param.status == 2}">
	<script type="text/javascript">
		alert("系统友情提示","修改失败");
	</script>
</c:if>	
<c:if test="${param.status == 3}">
	<script type="text/javascript">
		alert("系统友情提示","审核成功");
	</script>
</c:if>
<c:if test="${param.status == 4}">
	<script type="text/javascript">
		alert("系统友情提示","审核失败");
	</script>
</c:if>								
</body>
</html>