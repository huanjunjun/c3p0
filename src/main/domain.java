package main;

import java.beans.*;
import java.sql.*;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class domain {
	@Test
	public void domain() throws SQLException {
		// TODO Auto-generated constructor stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;

		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); // º”‘ÿjdbc«˝∂Ø≥Ã–Ú
			cpds.setJdbcUrl("jdbc:mysql:///db1?serverTimezone=UTC"); // localhost
																		// /
																		// testdb
			cpds.setUser("root");
			cpds.setPassword("123456");
			connection = cpds.getConnection();

			preparedStatement = connection.prepareStatement("select * from user");
			rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				System.out.println(rSet.getInt("id") + " " + rSet.getString("username") + ""
						+ rSet.getString("password") + " " + rSet.getString("name") + " ");

			}
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cpds.close();
		}
	}

	@Test
	public void demo2() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			
			connection = cpds.getConnection();

			preparedStatement = connection.prepareStatement("select * from user");
			rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				System.out.println(rSet.getInt("id") + " " + rSet.getString("username") + ""
						+ rSet.getString("password") + " " + rSet.getString("name") + " ");

			}
		} finally {
			cpds.close();
		}
	}

}
