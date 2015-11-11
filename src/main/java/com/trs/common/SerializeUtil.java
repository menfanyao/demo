package com.trs.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * @author MFY
 * 对象序列化类
 */
public class SerializeUtil {
	public byte[] serialize(List<HashMap<String, String>> list) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		baos = new ByteArrayOutputStream();
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(list);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return  ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		return null;
		
	}
}
