package cinema_project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.vo.Movieksk;
import cinema_project.model.vo.Reservationksk;
import cinema_project.model.vo.Timetableksk;

import static cinema_project.template.Templateksk.close;

public class Daoksk {
////	영화 목록 조회
//	public List<Movieksk> searchMovieList(Connection conn) {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Movieksk> list = new ArrayList<Movieksk>();
//		try {
//			String sql = "select * from movie";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				list.add(new Movieksk(rs.getInt("m_no"), rs.getString("m_title"), rs.getInt("m_runtime"), rs.getInt("m_price"), rs.getInt("m_rating"), rs.getInt("m_count"), rs.getString("m_review")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return list;
//	}
	
//	상영중인 영화 목록 조회
	public List<Movieksk> searchMovieList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movieksk> list = new ArrayList<Movieksk>();
		try {
			String sql = "select m.* from movie m join timetable t on t.m_title = m.m_title group by m.m_title";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Movieksk(rs.getInt("m_no"), rs.getString("m_title"), rs.getInt("m_runtime"), rs.getInt("m_price"), rs.getInt("m_rating"), rs.getInt("m_count"), rs.getString("m_review")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
//	선택한 영화의 영화 시간표 조회
	public List<Timetableksk> searchTimetableListByMovieTitle(Connection conn, String movieTitle, int resSeatNum) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Timetableksk> list = new ArrayList<Timetableksk>();
		try {
			String sql = "select time.* ,t.t_seat from timetable time join theater t on time.t_name = t.t_name where time.m_title = ? and t.t_seat >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieTitle);
			pstmt.setInt(2, resSeatNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Timetableksk(rs.getInt("time.time_no") ,rs.getString("time.m_title"), rs.getString("time.t_name"), rs.getInt("t.t_seat"), rs.getTimestamp("time.time_start").toLocalDateTime(), rs.getTimestamp("time.time_end").toLocalDateTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
//	시간표로 예매 진행, Transaction 사용
//	현재 u_no = 2 (김철수)임임의로 test 진행 
	public int ticketRes(Connection conn, Timetableksk movieRes, int resSeatNum) {
		PreparedStatement pstmt = null;
		int cnt1 = 0;
		int cnt2 = 0;
		int result = 0;
		
		try {
			if(conn != null) conn.setAutoCommit(false);
			
			String sql = "update theater set t_seat = t_seat - ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resSeatNum);
			cnt1 = pstmt.executeUpdate();
			
			
			if(cnt1 > 0) {
				sql = "insert into reservation(u_no, m_title, t_name, r_seat) values(?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
//				임의로 u_no = 2 설정
				pstmt.setInt(1, 2);
				pstmt.setString(2, movieRes.getmTitle());
				pstmt.setString(3, movieRes.gettName());
				pstmt.setInt(4, resSeatNum);
				cnt2 = pstmt.executeUpdate();
			}
			if(cnt2 > 0) {
				sql = "update movie set m_count = m_count + ? where m_title = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, resSeatNum);
				pstmt.setString(2, movieRes.getmTitle());
				result = pstmt.executeUpdate();
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
//	예매 내역 조회
	public List<Reservationksk> searchRes(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reservationksk> list = new ArrayList<Reservationksk>();
		try {
//			임의로 u_no = 2 설정
			String sql = "select * from reservation where u_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Reservationksk(rs.getInt("r_no"), rs.getInt("u_no"), rs.getString("m_title"),rs.getString("t_name"),rs.getInt("r_seat")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
//	예매 내역 취소
	public int deleteRes(Connection conn, Reservationksk res) {
		PreparedStatement pstmt = null;
		int result = 0;
		int cnt = 0;
		try {
			if(conn != null) conn.setAutoCommit(false);
			
			String sql = "delete from reservation where r_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, res.getrNo());
			cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				sql = "update movie set m_count = m_count - ? where m_title = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, res.getrSeat());
				pstmt.setString(2, res.getmTitle());
				result = pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			if(conn != null)
				try {
					conn.rollback();
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
