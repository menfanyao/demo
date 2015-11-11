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
  <link type="text/css" rel="stylesheet" href="css/nomal.css" />
  <script src="./js/echarts.js"></script>
  <script src="./js/jquery-1.7.1.min.js"></script>
  <script src="./js/bar.js" charset="utf-8"></script>
 
  <title>Document</title>
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
	  <div id="doc-bd" >
	    <!--检索条-->
	    <div id="jsuo">
	      <div class="jsuo_k" >
		    <div class="ipt">
	        <input class="search_str"  autocomplete="on" placeholder="你想找什么..."   type="text" id="searchtext"></input>
		    </div>
		    <div class="btn">
		    <input class="search_btn" type="button" value="开始检索" id="search_btn"></input>
		    </div>
		  </div>
	    </div>
	    <!--检索显示区-->
	    <div id="jsuo_x">
		  <div id="roll">
		     <div id="roll_date">
			   <div id="jdate">
			       从
			      <input  id="datF" type="date" value="2015-06-01" class="date"></input>
			       到
			      <input id="datL"  type="date" value="2015-08-01"  class="date"></input>
				  <input type="button" value="查询"  class="date" id="date_search_btn"></input>
			   </div>
			</div>
		     
		    <ul id="roll_ul">
			 <li><h1>该年每月的新闻总数并与上一年的对比</h1><div id="addS"></div></li>
			 <li><h1>你可能感兴趣的热点话题</h1><div id="cy"></div></li>
			 <li><h1>该时期数据中各关键词新闻所占比例</h1><div id="bt"></div></li>
			 <li><h1>该时期数据中各地区新闻总数</h1><div id="dt"></div></li>
			 <li class="ycshu" ><h1>该时期的今年与去年的对比以及变化</h1><div id="zx">4</div></li>
			 <li class="ycshu" ><h1>该时期的此时与前一天的对比</h1><div id="addF">5</div></li>
			 
			</ul>
		 </div>
		  <!--
	       <p>已到底部</p>
      -->
	    </div>
   </div>
   </div>
    <script src="./js/bar.js" charset="utf-8"></script>
     <script src="./js/json.js"  type="text/javascript"></script>
    <!--  
    <script type="text/javascript" Charset="utf-8">
        
//		comBT();
//		comCY();
//	    comDT();
//		comAddF();
    </script>
    </body>
    
    <script type="text/javascript">
    function aa(search_key) {

		if (search_key == "") {
			alert("值为空不能为你进行搜索");
		} else {
			var datF =$("#datF").val();
			var datL = $("#datL").val();
//			var search_key = $("#searchtext").val();
			//根据来源进行分类  根据（IR_CHANNEL）下面各自的统计出总个数即可
			$.ajax({
				url : 'piechart.do?search_key=' + search_key+"&datF="+datF+"&datL="+datL,
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
					r_strF= eval("(" + s + ")"),
					comBT(r_strF,data);
				}
			});
			//地图
			$.ajax({
				url : 'mapcount.do?search_key=' + search_key+"&datF="+datF+"&datL="+datL,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					comDT(data);
				}
			});
			//折线图那个   根据（IR_URLDATE）下面各自的统计出总个数即可
			
			$.ajax({
				url : 'linechart.do?search_key=' + search_key+"&datF="+datF+"&datL="+datL,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					var dat = eval(data["dat"]);
					var datF = eval(data["datF"]);
					    var datL = eval(data["datL"]);
					comAddF(dat,datF,datL);
//					var len = data["datL"].length;
//					alert(oriData);
//                      while(len--) {
//                    	  data["datL"][len] *= -1;
//                        alert(  oriData[len] *= -1);
//                       }

				//	var s = eval(data["name_d"]);
				//	var b = eval(data["name_n"]);
				//	linechart(s, b);
				}
			});
			//词云的ajax
			$.ajax({
				url : 'wordcloudchart.do?search_key=' + search_key+"&datF="+datF+"&datL="+datL,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					comCY(data);
				}
			});

		}
    }
    </script>
    -->
   
    <!--
    <script charset="utf-8">
		$("#search_btn").click(
		function(){
	//		alert($("#datF").val());
			aa($("#searchtext").val());
		});
    $("#date_search_btn").click(
    		function(){
    			if ($("#searchtext").val() == "") {
    				aa("*");
				}else{
    					aa($("#searchtext").val());
    				}});		
    
		<script type="text/javascript">

//		window.onload = function(){
//			aa("*");
//		};
		</script>
-->
</html>
