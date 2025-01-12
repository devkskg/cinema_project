package cinema_project.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	 private static final String URL = "jdbc:mariadb://localhost:3306/cinema_project";
	    private static final String USER = "user";
	    private static final String PASSWORD = "password";

	    static {
	        try {
	            // MariaDB 드라이버 로드
	            Class.forName("org.mariadb.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.err.println("MariaDB Driver not found.");
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 데이터베이스 연결을 반환합니다.
	     * @return Connection 객체
	     */
	    public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            conn.setAutoCommit(false); // 트랜잭션 수동 제어
	        } catch (SQLException e) {
	            System.err.println("Database connection failed.");
	            e.printStackTrace();
	        }
	        return conn;
	    }

	    /**
	     * 커밋을 수행합니다.
	     * @param conn Connection 객체
	     */
	    public static void commit(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.commit();
	            } catch (SQLException e) {
	                System.err.println("Commit failed.");
	                e.printStackTrace();
	            }
	        }
	    }

	    /**
	     * 롤백을 수행합니다.
	     * @param conn Connection 객체
	     */
	    public static void rollback(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (SQLException e) {
	                System.err.println("Rollback failed.");
	                e.printStackTrace();
	            }
	        }
	    }

	    /**
	     * Connection 자원을 해제합니다.
	     * @param conn Connection 객체
	     */
	    public static void close(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                System.err.println("Connection close failed.");
	                e.printStackTrace();
	            }
	        }
	    }

	    /**
	     * AutoCloseable 자원을 해제합니다.
	     * @param ac AutoCloseable 객체 (Statement, ResultSet 등)
	     */
	    public static void close(AutoCloseable ac) {
	        if (ac != null) {
	            try {
	                ac.close();
	            } catch (Exception e) {
	                System.err.println("Resource close failed.");
	                e.printStackTrace();
	            }
	        }
	    }
	}

