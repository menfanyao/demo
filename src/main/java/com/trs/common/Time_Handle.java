package com.trs.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
//日期时间数量提取
public class Time_Handle {
	public HashMap<String, LinkedList<String>> timeHandle(Iterator<Entry<String, Long>> iter,String datF,String datL) {
		LinkedHashMap<String,LinkedList<String>> map = new LinkedHashMap<String, LinkedList<String>>();
		HashMap<String,Long> sortmap = new HashMap<String, Long>();
		while (iter.hasNext()) {
			Entry<String, Long> entry = iter.next();
			sortmap.put(entry.getKey(), entry.getValue());
		}
		LinkedList<String> all_date = new CalendarProduce().dateProduce(datF, datL);
		LinkedList<String> previousDateList = new LinkedList<String>();
		LinkedList<String> afterDateList = new LinkedList<String>();
//		Iterator<String> iterator = sortmap.keySet().iterator();
		for (int i = 0; i < all_date.size(); i++) {
			String str = all_date.get(i);
			if (sortmap.containsKey(str)) {
				previousDateList.add((sortmap.get(str)).toString());
				afterDateList.add((sortmap.get(str)).toString());
			}else{
				previousDateList.add("0");
				afterDateList.add("0");
			}
		}
		previousDateList.remove(0);
		afterDateList.remove(afterDateList.size()-1);
		System.out.println(previousDateList.toString());
		System.out.println(afterDateList.toString());
//   是把treemap中的值拿出来 
//		while (iterator.hasNext()) {
//			String key = iterator.next();
//			l1.add(key);
//			l2.add(sortmap.get(key).toString());
//			
//		}
		map.put("dat", all_date);
		map.put("datF", previousDateList);
		map.put("datL", afterDateList);

		return map;
	}

}
