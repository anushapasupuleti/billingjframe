import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	//create initial empty static instance
	
	private static ConnectionManager instance = null;
	
	//prevent creating object
	private ConnectionManager() {
		
	}
	
	private static String url = "jdbc:h2:~/test";
	private static String driverName = "org.h2.Driver";
	private static String username="sa";
	private static String password="";
	private static Connection connection;
	private static String urlstring;
	
	public static Connection getConnection() {
		
		if(null == instance) {
			
			synchronized(ConnectionManager.class) {
				
				if(null == instance) {
		
		
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, username ,password);
				System.out.println("Connection Sucessfull");
				}catch(SQLException ex) {
					ex.printStackTrace();
					System.out.println("Failed To Create the database connection");
				}
		}catch(ClassNotFoundException ex) {
			System.out.println("Driver not found.");
			
		}
	//	return connection;
	}
	
			
			}
		}
		return connection;
	}
}
