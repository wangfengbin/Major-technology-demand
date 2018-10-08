<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<meta name="viewport"content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"type="text/css"href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css"/>
<style type="text/css">

.code {
	background-image: url(code.jpg);
	font-family: Arial;
	font-style: italic;
	color: Red;
	border: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
}

.unchanged {
	border: 0;
}
</style>
<script type="text/javascript">
	var code; //在全局 定义验证码   
	function createCode() {
		code = "";
		var codeLength = 6;//验证码的长度   
		var checkCode = document.getElementById("checkCode");
		var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//所有候选组成验证码的字符，当然也可以用中文的   

		for (var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 36);
			code += selectChar[charIndex];   //随机生成六个符号
		}
		//  alert(code);   
		if (checkCode) {
			checkCode.className = "code";
			checkCode.value = code;
		}

	}
</script>
	<script
	src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/js/jquery.validate.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/js/myValidate.js"type="text/javascript"></script>
	<script type="text/javascript">
	function check(){
		var code = $("#codeCheck").val();
		var code1 = $("#checkCode").val();
		if(code=="")
		{
			alert("系统消息","验证码不能为空");
			return false;
		}
		else if(code != code1)
		{
			alert("系统消息","验证码错误");
			return false;
		}
		return true;
	}
	</script>
</head>
<body bgcolor="#FFFFFF" onLoad="createCode();MM_preloadImages('images/login000_06.jpg','images/loging000_07.jpg')"onload="createCode()">

<form action="UserServlet?method=login" method="post" id="checkForm">
	<table width="795" height="475" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
		<tr>
			<td colspan="5">
				<img src="images/login_01.jpg" width="795" height="159" alt="">
			</td>
		</tr>
		<tr>
			<td rowspan="2">
				<img src="images/login_02.jpg" width="269" height="174" alt="">
			</td>
			<td bgcolor="#CFE5F2">
				<img src="images/login_03.jpg" width="66" height="115" alt=""></td>
			<td colspan="2" bgcolor="#D0E6F3">
			<table width="100%" height="116" border="0" cellpadding="0" cellspacing="0">
		      	<tr>
		      	  <td colspan="2" align="left" valign="bottom">
		      	  	<input id="username" name="username" type="text" class="STYLE1" style="width:180px; height:17px; border:#336699 1px solid" tabindex="1" MAXLENGTH="26">
		      	  </td>
	         	</tr>
		      	<tr>
		     	   <td height="32" colspan="2" align="left" valign="bottom">
		     	   		<input id="password" name="password" type="password" class="STYLE1" style="width:180px; height:17px; border:#336699 1px solid" tabindex="1" MAXLENGTH="26">
		     	   </td>
	            </tr>
		        <tr>
		      	  <td width="50%" height="29" align="left" valign="bottom">
		      	  		<INPUT NAME="code" TYPE="text" id="codeCheck" CLASS="STYLE1" STYLE="width:100px; height:17px; border:#336699 1px solid" tabindex="1" MAXLENGTH="26">
		      	  </td>
	          	  <td width="50%" align="left" valign="bottom">
	          	  		<input type="text" onclick="createCode()" readOnly="true" name="checkCode" id="checkCode" class="unchanged" style="width: 80px" />
	          	  </td>
	            </tr>
		        <tr>
		      	   <td height="30" colspan="1" align="left" valign="bottom">&nbsp;</td>
		        </tr>
     		 </table>
     		 </td>
			<td rowspan="2">
	 			<img src="images/login_05.jpg" width="262" height="174" alt=""></td>
	   </tr>
		<tr>
			<td colspan="2">
				<a onclick="sub()" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image12','','images/loging000_06.jpg',1)">
					<img src="images/login_06.jpg" name="Image12" width="135" height="59" border="0">
				</a>
			</td>
			<td>
				<a href="register.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image13','','images/loging000_07.jpg',1)">
					<img src="images/login_07.jpg" name="Image13" width="129" height="59" border="0">
				</a>
			</td>
  		</tr>
		<tr>
			<td colspan="5">
				<img src="images/login_08.jpg" width="795" height="141" alt=""></td>
		</tr>
		<tr>
			<td>
				<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="269" height="1" alt=""></td>
			<td>
				<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="66" height="1" alt=""></td>
			<td>
				<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="69" height="1" alt=""></td>
			<td>
				<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="129" height="1" alt=""></td>
			<td>
				<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="262" height="1" alt=""></td>
		</tr>
</table>
			<c:if test="${param.status.equals('1')}">
				<script type="text/javascript">
					alert("该用户不存在，请注册")
				</script>
			</c:if>
			<c:if test="${param.status.equals('2')}">
				<script type="text/javascript">
					alert("密码错误,请重新录入")
				</script>
				
			</c:if> 
</form>
<!-- End Save for Web Slices -->
</body>
<script type="text/javascript">
function sub(){
	if(!check()){
		return false;
	}
	var form = document.getElementById("checkForm");
	form.submit();
}
</script>
</html>