package com.gcp.db.services.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcp.db.services.model.User;

public class CloudSqlService {
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/azure";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	public void saveUser(User user) throws SQLException {
		
		Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO users (id, name, email) VALUES (?, ?, ?)");
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
}
