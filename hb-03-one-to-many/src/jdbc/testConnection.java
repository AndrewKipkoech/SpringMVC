package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class testConnection {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection mycon = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful!");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
