 //document.write("<script language=javascript src='./js/jquery-1.7.1.min.js'></script>");

 $("#search_btn").click(
			function(){
			//alert($("#datF").val());
			aa($("#searchtext").val());
		});
		$("#date_search_btn").click(
		    function(){
		    	if ($("#searchtext").val() == "") {
		    		aa("*");
				}else{
		            aa($("#searchtext").val());
		    				}
		});		
		window.onload = function(){
			aa("*");
		};
 function aa(search_key) {
	// $("#searchtext").val("adsf");
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
					datfl (dat,datF,datL);
					comAddS();
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
