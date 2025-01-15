package cinema_project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static cinema_project.common.JDBCTemplate.close;
import cinema_project.model.vo.User;

public class Dao {
    public int createUser(Connection conn, User user) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO user (u_id, u_pw, u_name, u_ssn, u_phone, u_manager) VALUES (?, ?, ?, ?, ?, 'N')";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getUserSsn());
            pstmt.setString(5, user.getUserPhone());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    public String loginUser(Connection conn, User user) {
        String userName = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT u_name FROM user WHERE u_id = ? AND u_pw = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                userName = rs.getString("u_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return userName;
    }
    public int deleteUser(Connection conn, User user) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM user WHERE u_id = ? AND u_pw = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
	public User searchUserInfossnph(Connection conn, User user) {
		User searchuser = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user WHERE u_name =? AND u_ssn = ? AND u_phone = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserSsn());
            pstmt.setString(3, user.getUserPhone());
            rs = pstmt.executeQuery();
			if(rs.next()) {
				searchuser = new User(rs.getInt("u_no"),
						rs.getString("u_id"),
						rs.getString("u_pw"),
						rs.getString("u_name"),
						rs.getString("u_ssn"),
						rs.getString("u_phone"),
						rs.getString("u_manager"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return searchuser;
	}
}