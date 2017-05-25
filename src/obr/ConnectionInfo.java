package obr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInfo {
//	 Connection conn;
		public static Connection connection() {
			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				System.out.println("InstantiationException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				System.out.println("IllegalAccessException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			try {
				conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
			} catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return conn;
		}
		
		public static void closeConnection(Connection conn){
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


