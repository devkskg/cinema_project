package cinema_project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cinema_project.common.JDBCTemplate;
import cinema_project.model.vo.User;

public class UserDao {
	public User findUserByIdAndPassword(String userId, String userPw) {
        User user = null;
        String query = "SELECT * FROM user WHERE u_id = ? AND u_pw = ?";

        try (Connection conn = JDBCTemplate.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean isUserExists(String userId, String userPhone) {
        String query = "SELECT COUNT(*) FROM user WHERE u_id = ? OR u_phone = ?";
        try (Connection conn = JDBCTemplate.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, userPhone);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertUser(User user) {
        String query = "INSERT INTO user (u_id, u_pw, u_name, u_ssn, u_phone, u_manager) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCTemplate.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getUserSsn());
            pstmt.setString(5, user.getUserPhone());
            pstmt.setString(6, user.getIsAdmin());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User searchUserInfoByIdPw(String userName, String userSsn, String userPhone) {
        User user = null;
        String query = "SELECT * FROM user WHERE u_name = ? AND u_ssn = ? AND u_phone = ?";
        try (Connection conn = JDBCTemplate.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, userSsn);
            pstmt.setString(3, userPhone);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    private User mapResultSetToUser(ResultSet rs) throws Exception {
        User user = new User();
        user.setUserNo(rs.getInt("u_no"));
        user.setUserId(rs.getString("u_id"));
        user.setUserPw(rs.getString("u_pw"));
        user.setUserName(rs.getString("u_name"));
        user.setUserSsn(rs.getString("u_ssn"));
        user.setUserPhone(rs.getString("u_phone"));
        user.setIsAdmin(rs.getString("u_manager"));
        return user;
    }
}
