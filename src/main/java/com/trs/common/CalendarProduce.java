package com.trs.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author MFY
 * 日期生成类 生成两个日期之间的所有每天日期
 */
public class CalendarProduce {
	// 日期生成类 生成两个日期之间的所有每天日期 传进来的参数是开始日期和结束日期的字符串
	public LinkedList<String> dateProduce(String dateStart, String dateEnd) {
		LinkedList<String> date_list = new LinkedList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfformat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar calendar_start = Calendar.getInstance();
		Calendar calendar_end = Calendar.getInstance();
		try {
			Date begin_date = sdf.parse(dateStart);
			Date end_date = sdf.parse(dateEnd);
			calendar_start.setTime(begin_date);
			calendar_end.setTime(end_date);
			calendar_start.add(Calendar.DAY_OF_YEAR, -1);
			//此处是进行产生每天的日期 并放入到集合中去
			while (calendar_start.before(calendar_end)) {
				calendar_start.add(Calendar.DAY_OF_YEAR, 1);
				date_list.add(sdfformat.format(calendar_start.getTime()));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date_list;
	}
}
