package cinema_project.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import cinema_project.model.vo.User;

public class UserDao {
	private static final String url = "jdbc:mariadb://localhost:3306/cinema_project";
    private static final String user = "user";
    private static final String pw = "password";

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MariaDB Driver not found.");
            e.printStackTrace();
        }
    }

    public boolean createUser(User user) {
        String sql = "INSERT INTO user (u_id, u_pw, u_name, u_ssn, u_phone, u_manager) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getUserSsn());
            pstmt.setString(5, user.getUserPhone());
            pstmt.setString(6, user.getUserManager());
            return pstmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<User> login(String userId, String userPw) {
        String sql = "SELECT * FROM user WHERE u_id = ? AND u_pw = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pw);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = mapToUser(rs);
                return Optional.of(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> findUserById(String userId) {
        String sql = "SELECT * FROM user WHERE u_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pw);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = mapToUser(rs);
                return Optional.of(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean deleteUser(String userId, String userPw) {
        String sql = "DELETE FROM user WHERE u_id = ? AND u_pw = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pw);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);
            return pstmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private User mapToUser(ResultSet rs) throws Exception {
        User user = new User();
        user.setUserNo(rs.getInt("u_no"));
        user.setUserId(rs.getString("u_id"));
        user.setUserPw(rs.getString("u_pw"));
        user.setUserName(rs.getString("u_name"));
        user.setUserSsn(rs.getString("u_ssn"));
        user.setUserPhone(rs.getString("u_phone"));
        user.setUserManager(rs.getString("u_manager"));
        return user;
    }
}
