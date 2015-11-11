package com.trs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trs.common.CityHandle;
import com.trs.common.RedisCache;
import com.trs.common.Time_Handle;
import com.trs.dao.DaoInf;

/**
 * @author mfy
 * 日期处理类 
 */
@Component
public class ServiceImp implements ServiceT {
@Autowired
	private DaoInf daoInf;
	public List<HashMap<String, String>> query01(String search_key,
		String ob_coulumn,String datF,String datL) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		Iterator<Entry<String, Long>> iter = daoInf.daoquery(search_key,ob_coulumn,datF,datL);
		while (iter.hasNext()) {
			Entry<String, Long> entry = iter.next();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("value", entry.getValue().toString());
			map.put("name", entry.getKey());
			list.add(map);
		}
		return list;
	}

	public List<HashMap<String, String>> query02(String search_key,
			String ob_coulumn,String datF,String datL) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		Iterator<Entry<String, Long>> iter1 = daoInf.daoquery(search_key,ob_coulumn,datF,datL);
		HashMap<String, Long> map_da =  new CityHandle().city_do(iter1);
		for (String s: map_da.keySet()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("value", map_da.get(s).toString());
			map.put("name", s);
			list.add(map);
		}
		
		return list;
	}

	public HashMap<String, LinkedList<String>> query03(String search_key,
			String ob_coulumn,String datF, String datL) {
		Iterator<Entry<String, Long>> iter = daoInf.daoquery(search_key,ob_coulumn,datF,datL);
		HashMap<String, LinkedList<String>> map_ht = new Time_Handle().timeHandle(iter,datF,datL);
		
		return map_ht;
	}

	public String query04(String search_key,String datF,String datL) {
		String json_str = new RedisCache().redisca(search_key,datF,datL);
		return json_str;
	}


}
