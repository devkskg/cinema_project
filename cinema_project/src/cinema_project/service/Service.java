package cinema_project.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Service {

	public Connection getConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://127.0.0.1:3306/10nema";
        String id = "scott";
        String pw = "tiger";
        return DriverManager.getConnection(url, id, pw);
    }

} 
