<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'系统菜单');
		d.add('0101','01','需求填报','${pageContext.request.contextPath}/need.jsp','','mainAction');
		d.add('0102','01','查看需求','${pageContext.request.contextPath}/needservlet?method=find','','mainAction');
		d.add('0103','01','分类浏览','${pageContext.request.contextPath}/typefind.jsp','','_blank');
		d.add('0104','01','分类浏览2');
		
		
		d.add('010401','0104','基础研究','','','mainAction');
		d.add('010402','0104','其他研究','','','mainAction');
		d.add('0040101','010401','数学','','','mainAction')
		d.add('0040102','010401','英语','','','mainAction')
		
		d.add('010402','0104','应用研究','','','mainAction');
		d.add('010403','0104','试验发展','','','mainAction');
		d.add('010404','0104','研究发展与成果应用','','','mainAction');
		d.add('010405','0104','技术推广与科技服务','','','mainAction');
		d.add('010406','0104','其他类型研究','','','mainAction');
		
		d.add('01040601','010406','农林牧渔业','','','mainAction');
		d.add('0104060101','01040601','农业','','','mainAction');
		d.add('0104060102','01040601','林业','','','mainAction');
		d.add('0104060103','01040601','渔业','','','mainAction');
		d.add('0104060104','01040601','畜牧业','','','mainAction');
		
		d.add('01040602','010406','采矿业','','','mainAction');
		d.add('0104060201','01040602','煤矿','','','mainAction');
		d.add('0104060202','01040602','石油','','','mainAction');
		d.add('0104060203','01040602','有色金属','','','mainAction');
		d.add('0104060204','01040602','非金属','','','mainAction');
		
		d.add('01040603','010406','制造业','','','mainAction');
		d.add('0104060301','01040603','食品','','','mainAction');
		d.add('0104060302','01040603','纺织','','','mainAction');
		
		d.add('01040604','010406','建筑业','','','mainAction');
		d.add('0104060401','01040604','房屋建筑','','','mainAction');
		d.add('0104060402','01040604','建筑装修','','','mainAction');
		
		d.add('01040605','010406','批发零售业','','','mainAction');
		d.add('0104060501','010406'+'05','批发业','','','mainAction');
		d.add('0104060502','010406'+'05','零售业','','','mainAction');
		
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
