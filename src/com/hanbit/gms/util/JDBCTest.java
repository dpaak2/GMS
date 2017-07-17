package com.hanbit.gms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hanbit.gms.constant.DB;

public class JDBCTest {
/*	public static void main(String[] args) {
		String findName = "";
		Connection connection = null;
		try {
			Class.forName(DB.DRIVER);
			connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM Member WHERE id='hong'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				findName = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 다녀온 결과: " + findName);

	}*/
}
