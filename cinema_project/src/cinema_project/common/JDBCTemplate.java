package cinema_project.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	 private static final String url = "jdbc:mariadb://localhost:3306/cinema_project";
	    private static final String user = "user";
	    private static final String pw = "password";

	    static {
	        try {
	            Class.forName("org.mariadb.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.err.println("JDBC Driver not found.");
	            e.printStackTrace();
	        }
	    }

	    public static Connection getConnection() {
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(url, user, pw);
	        } catch (SQLException e) {
	            System.err.println("Failed to connect to the database.");
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    public static void close(AutoCloseable ac) {
	        try {
	            if (ac != null) {
	                ac.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
