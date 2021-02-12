package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection DBConnectionManager() throws ClassNotFoundException, SQLException {
		String dbURL = "url";
		String user = "user";
		String pwd = "password";
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(dbURL,user,pwd);
	}
}
