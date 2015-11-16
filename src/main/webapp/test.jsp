<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>trsdemo</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<!--测试一下github -->
</head>
<body>
<input type="text" id="searchtext">
<input type="button" id="uu" value="测试" onclick="aa()">
</body>
<script type="text/javascript">
function aa(){
	if($(searchtext).val()==""){
		alert("值为空不能为你进行搜索");
	}else{
		var search_key =$("#searchtext").val();
 		$.ajax({  
	        url: 'test01.do?search_key='+search_key,  
	        type: 'GET',  
	        dataType: 'json',  
	        success: function(data){
	        	//[{"num":"28","IR_CHANNEL":"菜谱网"}] num为数量 IR_CHANNEL为出处 只取了前五条数据
	        	var jsonStr = JSON.stringify( data );
	        	alert(jsonStr);
	        }   
	    })
		$.ajax({  
			 url: 'test02.do?search_key='+search_key, 
	        type: 'GET',  
	        dataType: 'json',  
	        success: function(data){
	        	var jsonStr = JSON.stringify( data );
	        	alert(jsonStr[0].name);
	        }   
	    })
		$.ajax({  
			 url: 'test03.do?search_key='+search_key, 
	        type: 'GET',  
	        dataType: 'json',  
	        success: function(data){
	        	var jsonStr = JSON.stringify( data );
	        	alert(jsonStr);
	        }   
	    })
		
	}
	
}
</script>
</html>