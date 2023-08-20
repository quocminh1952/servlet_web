package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Util {
	
	public static Connection getConnection() {
		Connection connect = null;
		try {
			
			//step_1: register connection driver: 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step_2: parameters:
			String url ="jdbc:mySQL://localhost:3306/web_servlet";
			String username ="root";
			String pasword ="";
			
			//step_3:create connection
			connect = DriverManager.getConnection(url, username, pasword);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		} 
		
		return connect;
	}
	
	public static void closeConnection(Connection connect) {
		if(connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
		}
	}
	
	public static void infoConnection(Connection connect) {
		if(connect != null) {
			try {
				connect.getMetaData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
