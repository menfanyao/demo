function com(){
	   var title="新闻数据",
           subtitle="各个阶段的",
		  strR="['2013/1/24', '2013/1/25', '2013/1/28', '2013/1/29','2013/1/30','20 13/1/31', '2013/2/1', '2013/2/4', '2013/2/5', '2013/2/6','2013/2/7', '2013/2/8', '2013/2/18', '2013/2/19', '2013/2/20','2013/2/21', '2013/2/22', '2013/2/25', '2013/2/26', '2013/2/27','2013/2/28', '2013/3/1', '2013/3/4', '2013/3/5']",
		 str="[1500,3500,2000,1300,2400,1000,900,1200,1500,2100,1300,3400,2300,4500,2800,3300,3200,2800,1600,1500,2130,2690,3400,9800]"
		 rowValueS= eval("(" + str + ")"),  
	     
		 r_strR= eval("(" + strR + ")"),
         
		 chart1 = document.getElementById('zx_1'),
		 //chart2 = document.getElementById('main2');
	 
 require.config({  
        paths:{   
            'echarts' : 'js',  
        }
    });  
 require(
        [
         'echarts',
         'echarts/chart/line',
         'echarts/chart/bar',//使用什么就加载什么，这是柱状图
        ],
        function(ec){
        var myChart = ec.init(chart1);
		//var myChart2 = ec.init(chart2);
		//alert(rowName);
		//alert(rowValueS);
		//alert(r_strR);

        option = {
    	    title : {
    	        text: title,
    	        subtext: subtitle
    	    },
    	    tooltip : {
    	        trigger: 'item',
				showDelay: 0,
				//formatter:"{b}<br/>{a}[0]:{c}[0]<br>{a}[1]:{c}[1] °C",
				
    	    },
    	    legend: {
    	        data:['新闻总数'],
				//selectedMode:'single', 只选择某一条线
    	    },
			color: ["#43d454"],
			/*
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            magicType : {show: true, type: ['line', 'bar']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
			*/
    	    calculable : true,
			grid: {                             
				x: 70,
				y: 60,
				x2: 50,
				y2: 25,
				//height:350,
				//width:300,
			},
    	    xAxis : [
    	        {
    	            type : 'category',
    	            boundaryGap : false,
    	            data : r_strR,
					/*axisLine: {
					show: false, //消除x,y轴的颜色；
					},*/
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value',
    	            axisLabel : {
    	                formatter: '{value} 条'
    	            }
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'新闻总数',
    	            type:'line',
					smooth: true,//折现变曲线
    	            data:rowValueS,
    	            markPoint : {
    	                data : [
    	                    {type : 'max', name: '最大值'},
    	                    {type : 'min', name: '最小值'}
    	                ]
    	            },
    	            markLine : {
    	                data : [
    	                    {type : 'average', name: '平均值'}
    	                ]
    	            }
    	        },
		        
    	       ],
    	   
    	};
       
    myChart.setOption(option);
    }
      
    );	
 }




function comB(){
  var chart1 = document.getElementById('bt');
      strF="['娱乐新闻','财经新闻','社会新闻','公司内部','时尚新闻','军事新闻','喜闻乐见','生活常识']"
      strS="[{value:10, name:'娱乐新闻'},{value:5, name:'财经新闻'},{value:15, name:'社会新闻'},{value:25, name:'公司内部'},{value:20, name:'时尚新闻'},{value:35, name:'军事新闻'},{value:30, name:'喜闻乐见'},{value:40, name:'生活常识'}]"
      r_strF= eval("(" + strF + ")"),
	  r_strS= eval("(" + strS + ")"),
  require.config({  
        paths:{   
            echarts: 'js',  
        }
    }); 
  require(
        [
         'echarts',
         'echarts/chart/line',
         'echarts/chart/bar',//使用什么就加载什么，这是柱状图
         
         'echarts/chart/funnel',//饼图的
		 'echarts/chart/pie',
        ],
		function(ec){
		    var myChart1=ec.init(chart1);
			
		    option1={
				/*
		        title : {
                  text: '南丁格尔玫瑰图',
                  subtext: '纯属虚构',
                  x:'center',//水平安放位置
                },
				*/
                tooltip : {
                  trigger: 'item',
                  formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
				
                legend: {//图例
                    x : 'center',//水平安放位置
                    y : '80%',//垂直安放位置
                    data:r_strF,
                },
			    /*
                toolbox: {
                  show : true,
                  feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                    show: true, 
                    type: ['pie', 'funnel']
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                 }
                },
                */
                calculable : true,
                series : [
					/*
                    {
                      name:'半径模式',
                      type:'pie',
                      radius : [20, 110],//半径[内半径，外半径]
                      center : ['25%', 200],//圆心坐标
                      roseType : 'radius',
                      width: '40%',       // for funnel
                      max: 40,            // for funnel
					  legendHoverLink:false,
                      itemStyle : {
                        normal : {
                          label : {
                            show : false
                          },
                          labelLine : {
                            show : false
                          }
                        },
                        emphasis : {
                          label : {
                            show : true
                          },
                          labelLine : {
                           show : true
                          }
                        }
                      },
                     data:r_strS,
                    },*/
                    {
                      name:'新闻总数',
                      type:'pie',
                      radius : [30, 70],
                      center : ['50%', '40%'],
                      roseType : 'area',
                      //x: '10%',               // for funnel左上角横坐标
                      //max: 40,                // for funnel指定的最大值
                     // sort : 'ascending',     // for funnel数据排序  升序 默认为降序
                      data:r_strS,
                    }
                ]
		    };

             // 为echarts对象加载数据 
                myChart1.setOption(option1); 
		}
		
    );
}



function comD(){
   var  strS="[{selected:true,value:87, name:'北京'},{value:87, name:'上海'},{value:15, name:'广东'},{value:37, name:'河南'},{value:20, name:'四川'},{value:35, name:'吉林'},{value:30, name:'台湾'},{value:40, name:'新疆'}]"
        r_str= eval("(" + strS + ")"),
	   Chart3=document.getElementById('dt');
  require.config({  
        paths:{   
            'echarts' : 'js',  
        }
    });  
  require(
        [
         'echarts',
         'echarts/chart/map',
         //使用什么就加载什么，这是柱状图
        ],
		function(ec){
		  var myChart3=ec.init(Chart3);
		  option3={
			    
                tooltip : {
                  trigger: 'item',
                   formatter : function (params) {
                     var value = (params.value + '').split('.');
                         value = value[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1,');
                     return params.seriesName + '<br/>' + params.name + ' : ' + value;
                     }
                },
              series : [
                {
                  name: '中国',
                  type: 'map',
                  mapType: 'china',
                  selectedMode : 'single',
                  itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                  },
                  data:r_str,
                }
                ]
            };
		 

		  myChart3.setOption(option3)
		}
	);
}
