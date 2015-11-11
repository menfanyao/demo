package com.trs.common;
import redis.clients.jedis.Jedis;

public class RedisCnonnectionCommon {
	
	public final Jedis redisConnection(){
	Jedis	jedis = new Jedis("127.0.0.1",6379);
			return jedis;
	}
	public final void jedisClose(Jedis jedis) {
		if (jedis!=null) {
			jedis.close();
		}
	}
}
