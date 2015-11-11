package com.trs.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapSort {
	public  List<HashMap<String, String>> valueCompare(HashMap<String, Integer> map) 
	{
		//存储词云的集合 
		List<HashMap<String, String>> remword_list = new ArrayList<HashMap<String,String>>();
		List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); 
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() 
		{
			//按value的值进行排序  从大到小进行排序
			public int compare(Map.Entry<String, Integer> value1,  
		            Map.Entry<String, Integer> value2) 
			{
				   return ( value2.getValue()-value1.getValue());
			}
		});
		int i= 0;
		//设置词云的条数 显示的词云最多为40条
		while (i < infoIds.size()&&i<40) {
			Entry<String, Integer> entry = infoIds.get(i);
			HashMap<String, String> hashm = new HashMap<String, String>();
			hashm.put("name", entry.getKey());
			hashm.put("value", entry.getValue().toString());
			System.out.println(map.get(entry.getKey()));
			remword_list.add(hashm);
			i++;
		}
		return remword_list;
		
 	}
}
