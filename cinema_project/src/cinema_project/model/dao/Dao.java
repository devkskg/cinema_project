package cinema_project.model.dao;
import static cinema_project.common.TimeTableTemPlate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.vo.Movie;
import cinema_project.model.vo.Theater;
import cinema_project.model.vo.TimeTable;


public class Dao {
	
	
	public int createTimetable(String createmt,String tname,LocalDateTime start, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO timetable(m_title ,t_name ,time_start) "
						+ "VALUES(?,?,STR_TO_DATE(?,'%Y-%m-%d %T'))";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, no);
//			pstmt.setString(2, name);
//			pstmt.setString(1, name);
			pstmt.setString(1, createmt);
			pstmt.setString(2, tname);
			pstmt.setTimestamp(3, Timestamp.valueOf(start));
			result = pstmt.executeUpdate();		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int editTimetable(int movieNo,String start,String end,Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE timetable SET time_start = STR_TO_DATE(?,'%Y-%m-%d %T') ,time_end= STR_TO_DATE(?,'%Y-%m-%d %T') WHERE time_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, start);
			pstmt.setString(2, end);
			pstmt.setInt(3, movieNo);
			result=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	




	//theater 테이블 목록조회
	public List<Theater> viewTheater(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Theater> list = new ArrayList<Theater>();
		try {
			String sql = "SELECT * FROM theater ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			Theater tm = new Theater();
			tm.settNo(rs.getInt("t_no"));
			tm.settName(rs.getString("t_name"));
			tm.settSeat(rs.getInt("t_seat"));
			tm.settLineseat(rs.getInt("t_lineseat"));
			list.add(tm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
		
	
	
	
	//movie 테이블 목록조회
	public List<Movie> viewMovie (Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList<Movie>();
		try {
			String sql = "SELECT * FROM movie ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			Movie tm = new Movie();
			tm.setmNo(rs.getInt("m_no"));
			tm.setmTitle(rs.getString("m_title"));
			tm.setmRuntime(rs.getInt("m_runtime"));
			tm.setmPrice(rs.getInt("m_price"));
			tm.setmRating(rs.getInt("m_rating"));
			tm.setmCount(rs.getInt("m_count"));
			tm.setmReview(rs.getString("m_review"));
			list.add(tm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	// timetable 목록조회
	public List<TimeTable> viewTimeTable(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TimeTable> list = new ArrayList<TimeTable>();
		try {
			String sql = "SELECT * FROM timetable ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			TimeTable tm = new TimeTable();
			tm.setTimeNo(rs.getInt("time_no"));
			tm.setmTitle(rs.getString("m_title"));
			tm.settName(rs.getString("t_name"));
			tm.setTimeStart(rs.getTimestamp("time_start").toLocalDateTime());
			tm.setTimeEnd(rs.getTimestamp("time_end").toLocalDateTime());
			list.add(tm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	// 9번 영화시간표 삭제
	public int deleteTimeTable(int delete , Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "DELETE FROM timetable WHERE time_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, delete);
			result = pstmt.executeUpdate();		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
