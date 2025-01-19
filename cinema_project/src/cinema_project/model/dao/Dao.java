package cinema_project.model.dao;


import static cinema_project.common.TimeTableTemPlate.close;
import static cinema_project.common.TimeTableTemPlate.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.service.Service;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.TheaterVo;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.UserVo;

public class Dao {
	//상영관 전체 조회
	public List<TheaterVo> getAllTheaters() {
	    List<TheaterVo> theaterList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM theater"; 
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int theaterNumber = rs.getInt("t_no");
	            String theaterName = rs.getString("t_name");
	            int theaterSeat = rs.getInt("t_seat");
	            int theaterLineseat = rs.getInt("t_lineseat");

	            TheaterVo theater = new TheaterVo(theaterNumber, theaterName, theaterSeat, theaterLineseat);
	            theaterList.add(theater);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return theaterList;
	}
	
	//영화 전체 조회
	public List<MovieVo> getAllMovies() {
	    List<MovieVo> movieList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM movie"; 
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int movieNumber = rs.getInt("m_no");
	            String movieName = rs.getString("m_title");
	            int movieRuntime = rs.getInt("m_runtime");
	            int moviePrice = rs.getInt("m_price");
	            int movieRating = rs.getInt("m_rating");

	            MovieVo movie = new MovieVo(movieNumber, movieName, movieRuntime, moviePrice, movieRating);
	            movieList.add(movie);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return movieList;
	}
	
	// 영화 중복 확인
	public List<MovieVo> searchMovie() {
	    List<MovieVo> movieList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM movie";
	        pstmt = conn.prepareStatement(sql);
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            int movieNumber = rs.getInt("m_no");
	            String movieName = rs.getString("m_title");
	            int movieRuntime = rs.getInt("m_runtime");
	            int moviePrice = rs.getInt("m_price");
	            int movieRating = rs.getInt("m_rating");
	            
//	            MovieVo movie = new MovieVo(movieName, movieRuntime, moviePrice, movieRating);
	            MovieVo movie = new MovieVo(movieNumber, movieName, movieRuntime, moviePrice, movieRating);
	            movieList.add(movie);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return movieList;
	}
	// 상영관 중복 확인
	public List<TheaterVo> searchTheater() {
	    List<TheaterVo> theaterList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM theater";
	        pstmt = conn.prepareStatement(sql);
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            int theaterNumber = rs.getInt("t_no");
	            String teaterName = rs.getString("t_name");
	            int teaterSeat = rs.getInt("t_seat");
	            int teaterLineseat = rs.getInt("t_lineseat");
	            
	            TheaterVo theater = new TheaterVo(theaterNumber, teaterName, teaterSeat, teaterLineseat);
	            theaterList.add(theater);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return theaterList;
	}
	
	// 영화 추가
	public int addMovie(String title, int runtime, int price, int rating, Connection conn) {
	    PreparedStatement pstmt = null;
	    int result = 0;
	    try {
	        String sql = "INSERT INTO movie(m_title, m_runtime, m_price, m_rating) VALUES(?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, title);
	        pstmt.setInt(2, runtime);
	        pstmt.setInt(3, price);
	        pstmt.setInt(4, rating);
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}
	
	// 영화 업데이트
	public int updateMovie(int movieNo, String title, int runtime, int price, int rating, Connection conn) {
	    PreparedStatement pstmt = null;
	    int result = 0;
	    try {
	        String sql = "UPDATE movie SET m_title = ?, m_runtime = ?, m_price = ?, m_rating = ? WHERE m_no = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, title);
	        pstmt.setInt(2, runtime);
	        pstmt.setInt(3, price);
	        pstmt.setInt(4, rating);
	        pstmt.setInt(5, movieNo); 
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt); 
	    }
	    return result;
	}
	
	// 영화 삭제
	public int deleteMovie(int movieNo, Connection conn) {
	    PreparedStatement pstmt = null;
	    int result = 0;
	    try {
	        String sql = "DELETE FROM movie WHERE m_no = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, movieNo); 
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt); 
	    }
	    return result;
	}
	
	// 상영관 추가
	
	public int addTheater(String name, int seat, int lineSeat, Connection conn) {
	    PreparedStatement pstmt = null;
	    int result = 0;
	    try {
	        String sql = "INSERT INTO theater(t_name, t_seat, t_lineseat) VALUES(?, ?, ?)";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name);
	        pstmt.setInt(2, seat);
	        pstmt.setInt(3, lineSeat);
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt); 
	    }
	    return result;
	}
	
	//상영관 수정
	public int updateTheater(int theaterNo, String name, int seat, int lineSeat, Connection conn) {
	    PreparedStatement pstmt = null;
	    int result = 0;
	    try {
	        String sql = "UPDATE theater SET t_name = ?, t_seat = ?, t_lineseat = ? WHERE t_no = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name);
	        pstmt.setInt(2, seat);
	        pstmt.setInt(3, lineSeat);
	        pstmt.setInt(4, theaterNo); // 상영관 번호로 조건 설정
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt); 
	    }
	    return result;
	}
	
	// 상영관 삭제
	
	public int deleteTheater(int theaterNo, Connection conn) {
	    PreparedStatement pstmt = null;
	    int result = 0;
	    try {
	        String sql = "DELETE FROM theater WHERE t_no = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, theaterNo); 
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}

	

	// timetable 추가
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
	// timetable 수정
	public int editTimetable(int movieNo,String start, LocalDateTime starttime,Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE timetable SET time_start = STR_TO_DATE(?,'%Y-%m-%d %T') WHERE time_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, Timestamp.valueOf(start));
			pstmt.setInt(2, movieNo);
			result=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	//theater 테이블 목록조회
	public List<TheaterVo> viewTheater(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TheaterVo> list = new ArrayList<TheaterVo>();
		try {
			String sql = "SELECT * FROM theater ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			TheaterVo tm = new TheaterVo();
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
	public List<MovieVo> viewMovie (Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVo> list = new ArrayList<MovieVo>();
		try {
			String sql = "SELECT * FROM movie ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			MovieVo tm = new MovieVo();
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
	
	// 회원가입
	public int createUser(Connection conn, String uId,String uPw,String uName,String uSsn,String uPhone) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO user (u_id, u_pw, u_name, u_ssn, u_phone, u_manager) VALUES (?, ?, ?, ?, ?, 'N')";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);
            pstmt.setString(2, uPw);
            pstmt.setString(3, uName);
            pstmt.setString(4, uSsn);
            pstmt.setString(5, uPhone);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
	
	// 로그인
    public UserVo loginUser(Connection conn, String uId, String uPw) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserVo userLogin = null;
        String sql = "SELECT * FROM user WHERE u_id = ? AND u_pw = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);
            pstmt.setString(2, uPw);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            	userLogin = new UserVo(rs.getInt("u_no"), rs.getString("u_id"), rs.getString("u_pw"), rs.getString("u_name"), rs.getString("u_ssn"), rs.getString("u_phone"), rs.getString("u_manager"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return userLogin;
    }
    
    // 회원탈퇴
    public int deleteUser(Connection conn, String uId, String uPw) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM user WHERE u_id = ? AND u_pw = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);
            pstmt.setString(2, uPw);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    // 아이디,비밀번호 찾기 페이지
	public UserVo searchUserInfossnph(Connection conn, String uName ,String uSsn, String uPhone) {
		UserVo searchuser = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user WHERE u_name =? AND u_ssn = ? AND u_phone = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uName);
            pstmt.setString(2, uSsn);
            pstmt.setString(3, uPhone);
            rs = pstmt.executeQuery();
			if(rs.next()) {
				searchuser = new UserVo(rs.getInt("u_no"),
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
	

	
	
	