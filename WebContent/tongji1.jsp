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
 <!-- 
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
        	    backgroundColor: '#2c343c',

        	    title: {
        	        text: 'Customized Pie',
        	        left: 'center',
        	        top: 20,
        	        textStyle: {
        	            color: '#ccc'
        	        }
        	    },

        	    tooltip : {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
        	    },

        	    visualMap: {
        	        show: false,
        	        min: 1,
        	        max: 15,
        	        inRange: {
        	            colorLightness: [0, 1]
        	        }
        	    },
        	    series : [
        	        {
        	            name:'访问来源',
        	            type:'pie',
        	            radius : '55%',
        	            center: ['50%', '50%'],
        	            data:[
							
        	            ].sort(function (a, b) { return a.value - b.value; }),
        	            roseType: 'radius',
        	            label: {
        	                normal: {
        	                    textStyle: {
        	                        color: 'rgba(255, 255, 255, 0.3)'
        	                    }
        	                }
        	            },
        	            labelLine: {
        	                normal: {
        	                    lineStyle: {
        	                        color: 'rgba(255, 255, 255, 0.3)'
        	                    },
        	                    smooth: 0.2,
        	                    length: 10,
        	                    length2: 20
        	                }
        	            },
        	            itemStyle: {
        	                normal: {
        	                    color: '#c23531',
        	                    shadowBlur: 200,
        	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
        	                }
        	            },

        	            animationType: 'scale',
        	            animationEasing: 'elasticOut',
        	            animationDelay: function (idx) {
        	                return Math.random() * 200;
        	            }
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
						if (data != null && data.length > 0) {
							var num = data.split(",");
							option.series[0].data.push({value:9, name:"独立开发"});
							option.series[0].data.push({value:15, name:"委托研发"});
							option.series[0].data.push({value:6, name:"合作研发"});
							option.series[0].data.push({value:10, name:"其他"});
							option.series[0].data.push({value:20, name:"其他"});
							myChart.setOption(option);
						}
					}, "json");
		})
    </script>
     -->
    <div id="main1" style="width: 600px;height:400px;" ></div>
   
    <script type="text/javascript">
   		
        var myChart = echarts.init(document.getElementById('main1'));
		
        var option1 = {
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'left',
		        data:['独立开发','委托研发','合作研发','其他']
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
						if (data != null && data.length > 0) {
							var num = data.split(",");
							option1.series[0].data.push({value:num[0], name:"独立开发"});
							option1.series[0].data.push({value:num[1], name:"委托研发"});
							option1.series[0].data.push({value:num[2], name:"合作研发"});
							option1.series[0].data.push({value:num[3], name:"其他"});
							myChart.setOption(option1);
						}
					}, "json");
		})
    </script>
    
</body>
</html>