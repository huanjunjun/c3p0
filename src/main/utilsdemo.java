package main;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import c3p0.c3p0utils;

public class utilsdemo {
	@Test
	public void demo() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;

		try {
			connection = c3p0utils.getConnection();
			preparedStatement = connection.prepareStatement("select * from user");
			rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				System.out.println(rSet.getInt("id") + " " + rSet.getString("username") + " " + rSet.getString("password")
						+ " " + rSet.getString("name") + " ");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
			rSet.close();
			connection.close();
		}
	}
}
