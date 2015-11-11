<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<link type="text/css" rel="stylesheet" href="css/head.css" />
<script src="./js/echarts.js"></script>
<script src="./js/jquery-1.7.1.min.js"></script>
<script src="./js/h.js" charset="utf-8"></script>
<script type="text/javascript">
	//#doc-bd{height:1140px;background-color:green;}
</script>
<title>图表制作</title>
</head>
<body>
	 <!--整体页面-->
   <div id="doc-view" class="wrap theme-doc">
      <!--头部-->
	  <div id="doc-hd" role="navigation">
       <div id="topbar">
		  <div id="top-menu" class="theme-text">
		    <a id="gw" href="#" title="数据检索网站">数据检索网站</a>
		  </div>
		  <div id="top-tool">
		    <ul>
		     <li><a id="toor_1" href="#" title="工具1">邮箱</a><span class="sline">|</span></li>
		     <li> <a id="toor_2" href="#" title="工具1">设置</a> <span class="sline">|</span></li>
			 <li><a id="toor_3" href="#" title="工具2">下载区</a><span class="sline">|</span></li>
			 <li><a id="toor_4" href="#" title="工具2">登陆</a></li>
			</ul>
		  </div>
	   </div>
	  </div>
		<!--主内容-->
		<div id="doc-bd" style="background-color: red;">
			<!--检索条-->
			<div id="jsuo" style="background-color: white;">
				<div class="c">
					<div class="ipt">
						<input class="search_str" autocomplete="on" placeholder="你想找什么..."
							 type="text" id="searchtext"></input>
					</div>
					<div class="btn">
						<input class="search_btn" type="button" value="开始检索" id="search_btn"
							></input>
					</div>
				</div>
			</div>
			<!--检索显示区-->
			<div id="jsuo_x">
				<div id="zx" class="child"
					style="height: 450px; background-color: white;">
					<div id="zx_1"
						style="height: 100%; background-color: white; margin: 0 2px;">
					</div>
				</div>

				<div id="bt" class="child"
					style="height: 450px; width: 392px; background-color: white; float: left;"></div>
				<div id="dt" class="child"
					style="height: 450px; width: 700px; background-color: black; float: right;"></div>

			</div>

		</div>
		<script type="text/javascript">
		$("#search_btn").click(
		function(){
			aa($("#searchtext").val());
		});
			function aa(search_key) {

				if (search_key == "") {
					alert("值为空不能为你进行搜索");
				} else {
//					var search_key = $("#searchtext").val();
					//根据来源进行分类  根据（IR_CHANNEL）下面各自的统计出总个数即可
					$.ajax({
						url : 'piechart.do?search_key=' + search_key,
						type : 'GET',
						dataType : 'json',
						success : function(data) {
							//[{"num":"28","IR_CHANNEL":"菜谱网"}] num为数量 IR_CHANNEL为出处 只取了前五条数据
							var str = new Array();
							var i =0;
							for(var o in data){  
								//把所有的name变量值放入js数组中去
						       str[i] = data[o].name;  
						       i++;
						      }  
							var s ="['"+str.join("','")+"']";
							piechart(s,data);
						}
					});
					//地图
					$.ajax({
						url : 'mapcount.do?search_key=' + search_key,
						type : 'GET',
						dataType : 'json',
						success : function(data) {
							mapcount(data);
						}
					});
					//折线图那个   根据（IR_URLDATE）下面各自的统计出总个数即可
					$.ajax({
						url : 'linechart.do?search_key=' + search_key,
						type : 'GET',
						dataType : 'json',
						success : function(data) {
							var s = eval(data["name_d"]);
							var b = eval(data["name_n"]);
							linechart(s, b);
						}
					});

				}

			}
		</script>
		<script type="text/javascript">
		window.onload = function(){
			aa("*");
		};
		</script>
</body>
</html>
