package com.trs.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.trs.common.TRSConnectionCommon;
import com.trs.hybase.client.TRSConnection;
import com.trs.hybase.client.TRSException;
import com.trs.hybase.client.TRSRecord;
import com.trs.hybase.client.TRSResultSet;
import com.trs.hybase.client.params.SearchParams;
@Component
public class DaoT implements DaoInf {

	public Iterator<Entry<String, Long>> daoquery(String search_key,
			String ob_coulumn,String datF,String datL) {
		TRSConnectionCommon common = new TRSConnectionCommon();
		TRSConnection connection = common.getConn();
		Iterator<Entry<String, Long>> iter = null;
		try {
			TRSResultSet result = connection.categoryQuery(
					"smas_chuantong_0701", "(IR_CONTENT:" + search_key+") AND (IR_URLDATE:["+datF+" TO "+datL+"])", "",
					ob_coulumn, Long.MAX_VALUE);
			System.out.println("result numFound:" + result.getNumFound());
			Map<String, Long> category = result.getCategoryMap();
			iter = category.entrySet().iterator();

		} catch (TRSException e) {
			System.out.println("出错了");
			// TODO Auto-generated catch block
			System.out.println(e.getErrorCode() + ":" + e.getErrorString());
		}
		common.connClose(connection);
		return iter;
	}
	//词云搜索关键词 是采用快速搜索
	public HashMap<String, Integer> daoQuickquery(String search_key,String datF,String datL) {
		TRSConnectionCommon common = new TRSConnectionCommon();
		TRSConnection connection = common.getConn();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> mapUpdate = new HashMap<String, Integer>();
		try {
			SearchParams params = new SearchParams();
			TRSResultSet result = connection.executeSelectQuick(
					"smas_chuantong_0701", "(IR_CONTENT:"+search_key+ ") AND (IR_KEYWORDS:{* TO *})"+" AND (IR_URLDATE:["+datF+" TO "+datL+"])",2000,0,
					 100,params);
			while (result.moveNext()) 
			{
				TRSRecord record = result.get();				
				String [] s = record.getString("IR_KEYWORDS").split(";");
				for (int i = 0; i < s.length; i++) 
				{
					if (!map.containsKey(s[i])) {
						map.put(s[i],1);
					}else {
						map.put(s[i], map.get(s[i])+1);
//通过这步进行优化 可以筛选掉将近百分之八十的数据 之后在进行对mapUpdate这个集合进行排序 再取出  前二十条数据
						mapUpdate.put(s[i], map.get(s[i]));
					      }
				}
				
			}
		} catch (TRSException e) {
			System.out.println("出错了");
			Logger.getLogger( e.getErrorString());
			System.out.println(e.getErrorCode() + ":" + e.getErrorString());
		}
		common.connClose(connection);
		return mapUpdate;
	}
}
