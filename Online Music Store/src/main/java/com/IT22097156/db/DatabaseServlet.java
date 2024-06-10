package com.IT22097156.db;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private String URL = "jdbc:mysql://localhost:3306/onlineMusicStore";
	private String username = "rd927";
	private String password = "rd927";

	public Connection getConnection() throws ServletException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,username,password);
			System.out.println("db connection sucessfully!!!");
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
    }
}
