package com.trs.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface ServiceT {
public List<HashMap<String,String>> query01(String search_key,
		String ob_coulumn,String datF,String datL);
public List<HashMap<String,String>> query02(String search_key,
		String ob_coulumn,String datF,String datL);
public HashMap<String, LinkedList<String>> query03(String search_key,
		String ob_coulumn,String datF,String datL);
public String query04(String search_key,String datF,String datL);
}
