package com.trs.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.trs.hybase.client.TRSConnection;
import com.trs.hybase.client.params.ConnectParams;

/**
 * @author mfy 数据库连接 开启和关闭的公共类
 */
@Component
public class TRSConnectionCommon {

	public TRSConnection getConn() {
		System.out.println(TRSConnPropety.url);
		TRSConnection connection = new TRSConnection(TRSConnPropety.url,
				TRSConnPropety.username, TRSConnPropety.password,
				new ConnectParams());
		return connection;

	}

	public void connClose(TRSConnection connection) {

		if (connection != null) {
			connection.close();
		}
	}
}
