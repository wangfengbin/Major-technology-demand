<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/echarts.js"></script>
</head>
<script
	src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/js/jquery.validate.js"type="text/javascript"></script>
	<script
	src="${pageContext.request.contextPath}/static/js/myValidate.js"type="text/javascript">
	</script>
	
<body>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        //app.title = '环形图';

		var option = {
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'left',
		        data:['独立开发','委托研发','合作研发','其他','搜索引擎']
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '70%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                /*{value:335, name:'直接访问'},
		                {value:310, name:'邮件营销'},
		                {value:234, name:'联盟广告'},
		                {value:135, name:'视频广告'},
		                {value:1548, name:'搜索引擎'}*/
		            ]
		        }
		    ]
		};

		
        
        
        $(function(){
			$.post(
					"${pageContext.request.contextPath}/NeedServlet",
					{
						method : "display",
					},
					function(data) {
						//alert("123");
						if (data != null && data.length > 0) {
							var num = data.split(",");
						//	alert("123");
							//alert(num[0]);
							option.series[0].data.push({value:num[0], name:"独立开发"});
							option.series[0].data.push({value:num[1], name:"委托研发"});
							option.series[0].data.push({value:num[2], name:"合作研发"});
							option.series[0].data.push({value:num[3], name:"其他"});
							
							
							myChart.setOption(option);
						}
					}, "json");
		})
          
		 
        
		 //myChart.setOption(option);
        // 使用刚指定的配置项和数据显示图表。
        
    </script>
</body>
</html>