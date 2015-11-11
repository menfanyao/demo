package com.trs.common;

import java.util.HashMap;
import java.util.List;

import redis.clients.jedis.Jedis;

import com.trs.dao.DaoInf;
import com.trs.dao.DaoT;

public class RedisCache {
	public String redisca(String search_key ,String datF,String datL) {
		RedisCnonnectionCommon common = new RedisCnonnectionCommon();
		Jedis jedis = common.redisConnection();
		//序列化工具 是进行序列化的
		//SerializeUtil serializeUtil = new SerializeUtil();
		//判断redis库中是否存在 如果存在走的是redis缓存  如果不存在把进行查询 并放入到redis库中
		if (jedis.exists(search_key.getBytes())) {
//			byte bytes[] = jedis.get(search_key.getBytes());
//这种方式是进行把对象进行序列化 进行存储
//			List<HashMap<String, String>> listmap = (List<HashMap<String, String>>) serializeUtil.unserialize(bytes);
			String json_str = jedis.get(search_key.getBytes()).toString();
			System.out.println("json_str:"+json_str);
			common.jedisClose(jedis);
			return json_str;
		} else {
			DaoInf daoInf = new DaoT();
			HashMap<String, Integer> map = daoInf.daoQuickquery(search_key,datF,datL);
			List<HashMap<String, String>> listmap = new MapSort().valueCompare(map);
			jedis.set(search_key.getBytes(), JsonStrUtil.jsonStr(listmap).getBytes());
			String json_str = JsonStrUtil.jsonStr(listmap);
			System.out.println("json_str:"+json_str);
			common.jedisClose(jedis);
			return json_str;
		}
	}
}
