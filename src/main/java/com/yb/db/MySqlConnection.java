package com.yb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {

	@org.junit.Test
	public void Test() throws SQLException, ClassNotFoundException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://114.215.185.130:3306/cas";
		String user = "root";
		String password = "yt2015";	
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement statement = con.createStatement();
		String sql = "select * from t_user";
		ResultSet rs = statement.executeQuery(sql);

		String job = null;
		String id = null;
		while (rs.next()) {
			System.out.println(rs.getString("id") + "\t" + rs.getString("account") + "\t" + rs.getString(3));
		}
		rs.close();
		con.close();
	}
}
