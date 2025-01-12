package cinema_project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.vo.Movieksk;
import cinema_project.model.vo.Timetableksk;

import static cinema_project.template.Templateksk.close;

public class Daoksk {
//	영화 리스트 조회
	public List<Movieksk> searchMovieList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movieksk> list = new ArrayList<Movieksk>();
		try {
			String sql = "select m_title ,m_runtime ,m_price ,m_rating from movie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Movieksk(rs.getString("m_title"), rs.getInt("m_runtime"), rs.getInt("m_price"), rs.getInt("m_rating")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
//	영화 제목으로 타임테이(상영 시간표)블 조회
	public List<Timetableksk> searchTimetableListByMovieTitle(Connection conn, String movieTitle, int resSeatNum) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Timetableksk> list = new ArrayList<Timetableksk>();
		try {
			String sql = "select time.m_title ,time.t_name ,time.time_start ,time.time_end ,t.t_seat from timetable time join theater t on time.t_name = t.t_name where time.m_title = ? and t.t_seat >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieTitle);
			pstmt.setInt(2, resSeatNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Timetableksk(rs.getString("time.m_title"), rs.getString("time.t_name"), rs.getInt("t.t_seat"), rs.getTimestamp("time.time_start").toLocalDateTime(), rs.getTimestamp("time.time_end").toLocalDateTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
//	시간표로 예매 진행
//	현재 u_no = 2 (김철수)임임의로 test 진행 
	public int ticketRes(Connection conn, Timetableksk movieRes, int resSeatNum) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int result = 0;
		
		try {
			if(conn != null) conn.setAutoCommit(false);
			
			String sql1 = "update theater set t_seat = t_seat - " + resSeatNum;
			pstmt1 = conn.prepareStatement(sql1);
			result = pstmt1.executeUpdate();
			
			if(result > 0) {
				String sql2 = "insert into reservation(u_no, m_title, t_name, r_seat) values(?, ?, ?, ?)";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, 2);
				pstmt2.setString(2, movieRes.getmTitle());
				pstmt2.setString(3, movieRes.gettName());
				pstmt2.setInt(4, resSeatNum);
				result = pstmt2.executeUpdate();
			}
			
		} catch (Exception e) {
			try {
				if(conn != null) conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
