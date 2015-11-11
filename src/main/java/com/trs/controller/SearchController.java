package com.trs.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trs.service.ServiceT;

@Controller
public class SearchController {
	@Autowired
	private ServiceT service;
	//根据来源进行分类  根据（IR_CHANNEL）下面各自的统计出总个数即可
	@RequestMapping(value = "piechart.do", method = RequestMethod.GET)
	public @ResponseBody List<HashMap<String,String>> piechart(@RequestParam("search_key") String search_key,@RequestParam("datF") String datF,@RequestParam("datL") String datL) {
//		Service service = new ServiceImp();
		try {
			
			search_key =	new String(search_key.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println("search_key"+search_key);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		List<HashMap<String,String>> list = service.query01(search_key, "IR_GROUPNAME",datF,datL);
		
		return list;
	}
	//第二个：地图那个   根据（CATALOG_AREA）下面各自的统计出总个数即可
	@RequestMapping(value = "mapcount.do", method = RequestMethod.GET)
	public @ResponseBody List<HashMap<String,String>> mapcount(@RequestParam("search_key") String search_key,@RequestParam("datF") String datF,@RequestParam("datL") String datL) {
//		Service service = new ServiceImp();
		try {
			search_key =	new String(search_key.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<HashMap<String,String>> list = service.query02(search_key, "CATALOG_AREA",datF,datL);
		return list;
	}
	//折线图那个   根据（IR_URLDATE）下面各自的统计出总个数即可
	@RequestMapping(value = "linechart.do", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, LinkedList<String>> linechart(@RequestParam("search_key") String search_key,@RequestParam("datF") String datF,@RequestParam("datL") String datL) {
//		Service service = new ServiceImp();
		System.out.println("Test");
		try {
			search_key =	new String(search_key.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(datF);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HashMap<String, LinkedList<String>> map = service.query03(search_key, "IR_URLDATE",datF,datL);
		return map;
	}
// 词云显示关键词并设为 你可能感兴趣的关键词
	@RequestMapping(value = "wordcloudchart.do", method = RequestMethod.GET)
	@ResponseBody
	public  String wordcloudchart(@RequestParam("search_key") String search_key,@RequestParam("datF") String datF,@RequestParam("datL") String datL) {
//		Service service = new ServiceImp();
		try {
			search_key =	new String(search_key.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println("词云测试");
		} catch (UnsupportedEncodingException e) {
			Log
			e.printStackTrace();
		}
		String json_str = service.query04(search_key,datF,datL);
		System.out.println("json_str:"+json_str);
		return json_str;
	}
	
}
