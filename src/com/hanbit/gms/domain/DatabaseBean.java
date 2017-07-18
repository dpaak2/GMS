package com.hanbit.gms.domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

import com.hanbit.gms.constant.DB;

public class DatabaseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String driver, url, username, password;
	private Connection connection;

	public DatabaseBean(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public Connection getConnection() {
		try {
			Class.forName(DB.ORACLE_DRIVER);
			connection = DriverManager.getConnection(DB.ORACLE_URL, DB.ID, DB.PW);
		} catch (Exception e) {
			System.out.println("DB bean FAILED");
			e.printStackTrace();
		}
		return connection;
	}

}
