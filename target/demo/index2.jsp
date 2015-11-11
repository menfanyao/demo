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
	   <!--顶部导航-->
       <div id="topbar">
		  <div id="top-menu" class="theme-text">
		    <a id="weblogo" href="#" title="数据检索网站">数据检索网站</a>
		  </div>
		  <div id="top-tool">
		    <ul>
		     
		     <li><a id="email" href="#" title="邮箱">邮箱</a><span class="sline">|</span></li>
		     <li> <a id="reset" href="#" title="设置">设置</a> <span class="sline">|</span></li>
			 <li><a id="download" href="#" title="下载区">下载区</a><span class="sline">|</span></li>
			 <li><a id="login" href="#" title="登陆">登陆</a></li>
			
			</ul>
		  </div>
	   </div>
	  </div>
	  <!--主内容-->
	  <div id="doc-bd" >
	    <!--检索条-->
	    <div id="search">
		  <!--检索条-->
	      <div class="search_bar" >
		    <div class="ipt">
	        <input class="search_str"  autocomplete="on" placeholder="你想找什么..."   type="text" id="searchtext"></input>
		    </div>
		    <div class="btn">
		    <input class="search_btn" type="button" value="开始检索" id="search_btn"></input>
		    </div>
		  </div>
	    </div>
	    <!--检索显示区-->
	    <div id="search_content">
		  <div id="content">
		     <!--日历选择区-->
		     <div id="calender_container">
			   <div id="calender_content">
			       从
			      <input id="startdate" type="date" value="2015-06-01" class="date"></input>
			       到
			      <input id="enddate" type="date" value="2015-08-01"  class="date"></input>
				  <input type="button" value="查询"  class="date" id="date_search_btn"></input>
			   </div>
			 </div>
		     <!--图表-->
		     <ul id="content_ul">
			  <li><h1>该年每月的新闻总数并与上一年的对比</h1><div id="chartOne"></div></li>
			  <li><h1>你可能感兴趣的热点话题</h1><div id="wordcloud"></div></li>
			  <li><h1>该时期数据中各关键词新闻所占比例</h1><div id="pie"></div></li>
			  <li><h1>该时期数据中各地区新闻总数</h1><div id="map"></div></li>
			  <li class="samechart" ><h1>该时期的今年与去年的对比以及变化</h1><div id="line">4</div></li>
			  <li class="samechart" ><h1>该时期的此时与前一天的对比</h1><div id="addF">5</div></li>
			 
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
   </body>
</html>
