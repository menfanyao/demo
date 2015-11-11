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