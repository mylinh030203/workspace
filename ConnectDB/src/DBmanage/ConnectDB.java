package DBmanage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	Connection conn;
	public void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getConstructor().newInstance();
			String connectionUrl = "jdbc:sqlserver://DESKTOP-TM4S549\\SQLEXPRESS:1433;databaseName=Student;user=sa;password=123456789";
			conn = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}