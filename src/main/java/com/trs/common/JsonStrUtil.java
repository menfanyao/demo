package com.trs.common;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

public class JsonStrUtil {
	public static String jsonStr(List<HashMap<String, String>> list){
		String json_str = JSONObject.valueToString(list);
		return json_str;
	}
}
