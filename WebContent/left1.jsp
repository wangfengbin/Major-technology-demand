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
		//d.add('0101','01','需求填报','${pageContext.request.contextPath}/need.jsp','','mainAction');
		//d.add('0102','01','查看需求','${pageContext.request.contextPath}/needservlet?method=find','','mainAction');
		//d.add('0103','01','分类浏览','${pageContext.request.contextPath}/typefind.jsp','','_blank');
		d.add('0101','01','分类浏览');
		
		//d.add('节点编号','父节点编号','节点名称','地址','','mainAction');  type 1基础研究 2应用研究 3试验发展 4研究发展与成果应用 5技术推广与科技服务 6生产性活动
		d.add('010101','0101','基础研究','${pageContext.request.contextPath}/chaxun2.jsp?type=1','','main');
		d.add('01010101','010101','第一学科','${pageContext.request.contextPath}/chaxun2.jsp?type=1','','main');
		d.add('0101010101','01010101','数学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=1','','main');
		d.add('0101010102','01010101','信息科学与系统科学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=2','','main');
		d.add('0101010103','01010101','力学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=3','','main');
		d.add('0101010104','01010101','物理学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=4','','main');
		d.add('0101010105','01010101','化学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=5','','main');
		d.add('0101010106','01010101','天文学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=6','','main');
		d.add('0101010107','01010101','地球科学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=7','','main');
		d.add('0101010108','01010101','生物学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=8','','main');
		d.add('0101010109','01010101','心理学','${pageContext.request.contextPath}/chaxun2.jsp?xueke=9','','main');
		
		d.add('010102','0101','应用研究','${pageContext.request.contextPath}/chaxun2.jsp?type=2','','main');
		d.add('01010201','010102','第一行业','${pageContext.request.contextPath}/chaxun2.jsp?type=2','','main');
		d.add('0101020101','01010201','谷物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=1','','main');
		d.add('0101020102','01010201','豆类、油料和薯类种植','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=2','','main');
		d.add('0101020103','01010201','棉、麻、糖、烟草种植','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=3','','main');
		d.add('0101020104','01010201','蔬菜、食用菌及园艺作物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=4','','main');
		d.add('0101020105','01010201','水果种植','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=5','','main');
		d.add('0101020106','01010201','林木育种和育苗','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=6','','main');
		d.add('0101020107','01010201','木材和竹材采运','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=7','','main');
		d.add('0101020108','01010201','林产品采集','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=8','','main');
		d.add('0101020109','01010201','常用有色金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=9','','main');
		d.add('01010201010','01010201','贵金属采选','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=10','','main');
		d.add('01010201011','01010201','稀有稀土金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=2&hangye=11','','main');
		
		d.add('010103','0101','试验发展','${pageContext.request.contextPath}/chaxun2.jsp?type=3','','main');
		d.add('01010301','010103','第一行业','${pageContext.request.contextPath}/chaxun2.jsp?type=3','','main');
		d.add('0101030101','01010301','谷物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=1','','main');
		d.add('0101030102','01010301','豆类、油料和薯类种植','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=2','','main');
		d.add('0101030103','01010301','棉、麻、糖、烟草种植','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=3','','main');
		d.add('0101030104','01010301','蔬菜、食用菌及园艺作物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=4','','main');
		d.add('0101030105','01010301','水果种植','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=5','','main');
		d.add('0101030106','01010301','林木育种和育苗','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=6','','main');
		d.add('0101030107','01010301','木材和竹材采运','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=7','','main');
		d.add('0101030108','01010301','林产品采集','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=8','','main');
		d.add('0101030109','01010301','常用有色金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=9','','main');
		d.add('01010301010','01010301','贵金属采选','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=10','','main');
		d.add('01010301011','01010301','稀有稀土金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=3&hangye=11','','main');
		
		d.add('010104','0101','研究发展与成果应用','${pageContext.request.contextPath}/chaxun2.jsp?type=4','','main');
		d.add('01010401','010104','第一行业','${pageContext.request.contextPath}/chaxun2.jsp?type=4','','main');
		d.add('0101040101','01010401','谷物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=1','','main');
		d.add('0101040102','01010401','豆类、油料和薯类种植','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=2','','main');
		d.add('0101040103','01010401','棉、麻、糖、烟草种植','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=3','','main');
		d.add('0101040104','01010401','蔬菜、食用菌及园艺作物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=4','','main');
		d.add('0101040105','01010401','水果种植','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=5','','main');
		d.add('0101040106','01010401','林木育种和育苗','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=6','','main');
		d.add('0101040107','01010401','木材和竹材采运','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=7','','main');
		d.add('0101040108','01010401','林产品采集','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=8','','main');
		d.add('0101040109','01010401','常用有色金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=9','','main');
		d.add('01010401010','01010401','贵金属采选','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=10','','main');
		d.add('01010401011','01010401','稀有稀土金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=4&hangye=11','','main');
		
		d.add('010105','0101','技术推广与科技服务','${pageContext.request.contextPath}/chaxun2.jsp?type=5','','main');
		d.add('01010501','010105','第一行业','${pageContext.request.contextPath}/chaxun2.jsp?type=5','','main');
		d.add('0101050101','01010501','谷物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=1','','main');
		d.add('0101050102','01010501','豆类、油料和薯类种植','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=2','','main');
		d.add('0101050103','01010501','棉、麻、糖、烟草种植','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=3','','main');
		d.add('0101050104','01010501','蔬菜、食用菌及园艺作物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=4','','main');
		d.add('0101050105','01010501','水果种植','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=5','','main');
		d.add('0101050106','01010501','林木育种和育苗','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=6','','main');
		d.add('0101050107','01010501','木材和竹材采运','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=7','','main');
		d.add('0101050108','01010501','林产品采集','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=8','','main');
		d.add('0101050109','01010501','常用有色金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=9','','main');
		d.add('01010501010','01010501','贵金属采选','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=10','','main');
		d.add('01010501011','01010501','稀有稀土金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=5&hangye=11','','main');
		
		d.add('010106','0101','生产性活动','${pageContext.request.contextPath}/chaxun2.jsp?type=6','','main');
		d.add('01010601','010106','第一行业','${pageContext.request.contextPath}/chaxun2.jsp?type=6','','main');
		d.add('0101060101','01010601','谷物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=1','','main');
		d.add('0101060102','01010601','豆类、油料和薯类种植','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=2','','main');
		d.add('0101060103','01010601','棉、麻、糖、烟草种植','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=3','','main');
		d.add('0101060104','01010601','蔬菜、食用菌及园艺作物种植','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=4','','main');
		d.add('0101060105','01010601','水果种植','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=5','','main');
		d.add('0101060106','01010601','林木育种和育苗','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=6','','main');
		d.add('0101060107','01010601','木材和竹材采运','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=7','','main');
		d.add('0101060108','01010601','林产品采集','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=8','','main');
		d.add('0101060109','01010601','常用有色金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=9','','main');
		d.add('01010601010','01010601','贵金属采选','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=10','','main');
		d.add('01010601011','01010601','稀有稀土金属矿采选','${pageContext.request.contextPath}/chaxun2.jsp?type=6&hangye=11','','main');
		
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
