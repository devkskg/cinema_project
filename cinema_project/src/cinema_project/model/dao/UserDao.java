package cinema_project.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cinema_project.model.vo.User;

public class UserDao {
	private static final String url = "jdbc:mariadb://localhost:3306/cinema_project"; // DB URL
    private static final String user = "user"; // DB 사용자명
    private static final String pw = "pw"; // DB 비밀번호

    // MySQL 연결
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, pw);
    }

    // 사용자 로그인
    public User login(String id, String pw) {
        String query = "SELECT * FROM user WHERE u_id = ? AND u_pw = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.setString(2, pw);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("u_no"),
                        rs.getString("u_id"),
                        rs.getString("u_pw"),
                        rs.getString("u_name"),
                        rs.getString("u_ssn"),
                        rs.getString("u_phone"),
                        rs.getString("u_manager")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 회원가입
    public int createUser(User user) {
        String query = "INSERT INTO user(u_id, u_pw, u_name, u_ssn, u_phone, u_manager) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getuId());
            stmt.setString(2, user.getuPw());
            stmt.setString(3, user.getuName());
            stmt.setString(4, user.getuSsn());
            stmt.setString(5, user.getuPhone());
            stmt.setString(6, user.getuManager());

            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 아이디, 비밀번호 찾기
    public User searchUserInfoIdPw(String id) {
        String query = "SELECT * FROM user WHERE u_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("u_no"),
                        rs.getString("u_id"),
                        rs.getString("u_pw"),
                        rs.getString("u_name"),
                        rs.getString("u_ssn"),
                        rs.getString("u_phone"),
                        rs.getString("u_manager")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 회원탈퇴
    public int deleteUser(String id, String pw) {
        String query = "DELETE FROM user WHERE u_id = ? AND u_pw = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.setString(2, pw);

            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
