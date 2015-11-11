package com.trs.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MFY
 * 中国地图处理 进行提取省份和数量
 */
public class CityHandle {
	public HashMap<String, Long> city_do(Iterator<Entry<String, Long>> iter) {
		HashMap<String, Long> statistic_map = new HashMap<String, Long>();
		String regex_city = "北京|广东|山东|江苏|河南|上海|河北|浙江|香港|陕西|湖南|重庆|福建|天津|云南|四川|广西|安徽|海南|江西|湖北|山西|辽宁|台湾|黑龙江|内蒙古|澳门|贵州|甘肃|青海|新疆|西藏|吉林|宁夏";
		while (iter.hasNext()) {
			Entry<String, Long> entry = iter.next();
			//把城市的字符串进行分割 并且字符串能够识别
			String convert_str = entry.getKey().replace("\\", "|")
					.replace(" ", "|");
			Matcher matcher = Pattern.compile(regex_city).matcher(convert_str);
			//进行城市数量的统计
			if (matcher.find()) {
				//把城市的名称和数量放到hashmap中 采用的是hash算法 所以效率较高
				if (statistic_map.containsKey(matcher.group(0))) {
					statistic_map.put(matcher.group(0), entry.getValue()
							+ statistic_map.get(matcher.group(0)));
				} else {
					statistic_map.put(matcher.group(0), entry.getValue());
				}
			} else {
			}
		}
		return statistic_map;
	}
}
