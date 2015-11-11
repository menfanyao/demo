package com.trs.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public interface DaoInf {
	public Iterator<Entry<String, Long>> daoquery(String search_key,String ob_coulumn,String datF,String datL);
	public HashMap<String, Integer> daoQuickquery(String search_key,String datF,String datL) ;
}
