package cinema_project.model.dao;


import static cinema_project.common.TimeTableTemPlate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.service.Service;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.Reservation;
import cinema_project.model.vo.TheaterVo;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.Timetableksk;
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
//	            conn.close();
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
//	            conn.close();
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
//	            conn.close();
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
//	            conn.close();
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
	
//	 로그인
    public UserVo loginUser(Connection conn, String uId, String uPw) {
//        String userName = null;
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
	
	
	
	
	
	
	
//	상영중인!! 영화 목록 조회
	public List<MovieVo> searchMovieList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVo> list = new ArrayList<MovieVo>();
		try {
			String sql = "select m.* from movie m join timetable t on t.m_title = m.m_title group by m.m_title";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MovieVo(rs.getInt("m_no"), rs.getString("m_title"), rs.getInt("m_runtime"),
						rs.getInt("m_price"), rs.getInt("m_rating"), rs.getInt("m_count"), rs.getString("m_review")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	

//	선택한 영화의 시간표 조회 영화 제목과 정해진 시간으로 조회
	public List<Timetableksk> searchTimetableListByMovieTitleDate(Connection conn, String movieTitle, int resSeatNum, String qualificationDateTime, int userAge) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Timetableksk> list = new ArrayList<Timetableksk>();
		try {
			String sql = "select time.* ,t.t_seat ,m.m_rating from timetable time join theater t on time.t_name = t.t_name join movie m on time.m_title = m.m_title where time.m_title = ? and t.t_seat >= ? and time.time_start > str_to_date(?, '%Y-%m-%d %T') and m.m_rating <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieTitle);
			pstmt.setInt(2, resSeatNum);
			pstmt.setString(3, qualificationDateTime);
			pstmt.setInt(4, userAge);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Timetableksk(rs.getInt("time.time_no"), rs.getString("time.m_title"),
						rs.getString("time.t_name"), rs.getInt("t.t_seat"),
						rs.getTimestamp("time.time_start").toLocalDateTime(),
						rs.getTimestamp("time.time_end").toLocalDateTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

//	선택한 영화의 시간표 조회 시간표번호로 조회
	public Timetableksk searchTimetableListByTimeNo(Connection conn, int TimeNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Timetableksk timetableByTimeNo = null;
		try {
			String sql = "select * from timetable where time_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, TimeNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				timetableByTimeNo = new Timetableksk(rs.getInt("time_no"), rs.getString("m_title"),
						rs.getString("t_name"),
						rs.getTimestamp("time_start").toLocalDateTime(),
						rs.getTimestamp("time_end").toLocalDateTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return timetableByTimeNo;
	}
	
//	시간표로 예매 진행, Transaction 사용
//	현재 u_no = 2 (김철수)임임의로 test 진행 
	public int ticketRes(Connection conn, Timetableksk movieRes, int resSeatNum, UserVo userLogin) {
		PreparedStatement pstmt = null;
		int cnt1 = 0;
		int cnt2 = 0;
		int result = 0;

		try {
			if (conn != null)
				conn.setAutoCommit(false);

			String sql = "update theater set t_seat = t_seat - ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resSeatNum);
			cnt1 = pstmt.executeUpdate();

			if (cnt1 > 0) {
				sql = "insert into reservation(u_no, m_title, t_name, r_seat, time_no) values(?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
//				테스트 한번 필요
				pstmt.setInt(1, userLogin.getuNo());
				pstmt.setString(2, movieRes.getmTitle());
				pstmt.setString(3, movieRes.gettName());
				pstmt.setInt(4, resSeatNum);
				pstmt.setInt(5, movieRes.getTimeNo());
				cnt2 = pstmt.executeUpdate();
			}
			if (cnt2 > 0) {
				sql = "update movie set m_count = m_count + ? where m_title = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, resSeatNum);
				pstmt.setString(2, movieRes.getmTitle());
				result = pstmt.executeUpdate();
			}

		} catch (Exception e) {
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
		}

		return result;
	}

//	예매 내역 조회
	public List<Reservation> searchRes(Connection conn, UserVo userLogin) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reservation> list = new ArrayList<Reservation>();
		try {
//			테스트 필요
			String sql = "select * from reservation where u_no = ?";
//			String sql = "select r.* t.time_start from reservation r join timetable t r.time_no = t.time_no where u_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userLogin.getuNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Reservation(rs.getInt("r_no"), rs.getInt("u_no"), rs.getString("m_title"),
						rs.getString("t_name"), rs.getInt("r_seat"), rs.getTimestamp("r_date").toLocalDateTime(), rs.getInt("time_no")));
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
	public int deleteRes(Connection conn, Reservation res) {
		PreparedStatement pstmt = null;
		int result = 0;
		int cnt = 0;
		try {
			if (conn != null)
				conn.setAutoCommit(false);

			String sql = "delete from reservation where r_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, res.getrNo());
			cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				sql = "update movie set m_count = m_count - ? where m_title = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, res.getrSeat());
				pstmt.setString(2, res.getmTitle());
				result = pstmt.executeUpdate();
			}

		} catch (Exception e) {
			if (conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
		}
		return result;
	}

//	후기 남기기 자격 확인
//	reservation을 기반으로 한다 -> FK들 자식들 삭제 되더라도 기록 남아야함.
	public List<Reservation> createReviewQualification(Connection conn, String qualificationDateTime, UserVo userLogin) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reservation> list = new ArrayList<Reservation>();
		try {
//			String sql = "select * from reservation where u_no = ? and r_date > str_to_date(?, '%Y-%m-%d %T')";
			String sql = "select r.* from reservation r join timetable t on t.time_no = r.time_no where r.u_no = ? and t.time_end < str_to_date(?, '%Y-%m-%d %T')";
			pstmt = conn.prepareStatement(sql);
//			테스트용 철수의 u_no 사용
			pstmt.setInt(1, userLogin.getuNo());
			pstmt.setString(2, qualificationDateTime);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Reservation(rs.getInt("r.r_no"), rs.getInt("r.u_no"), rs.getString("r.m_title"),
						rs.getString("r.t_name"), rs.getInt("r.r_seat"), rs.getTimestamp("r.r_date").toLocalDateTime(), rs.getInt("time_no")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

//	리뷰 남기기
	public int createReviewOne(Connection conn, Reservation reservation, String reviewStr, UserVo userLogin) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "update movie m join reservation r on m.m_title = r.m_title "
					+ " set m.m_review = concat(m.m_review, ?) "
					+ " where r.u_no = ? "
					+ " and r.m_title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewStr);
//			테스트용 철수의 u_no 사용
			pstmt.setInt(2, userLogin.getuNo());
			pstmt.setString(3, reservation.getmTitle());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

//	리뷰 조회
	public MovieVo searchReviewOne(Connection conn, MovieVo searchReview) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieVo searchReviewMovie = null;
		try {
			String sql = "select * from movie where m_title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchReview.getmTitle());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				searchReviewMovie = new MovieVo(rs.getInt("m_no"), rs.getString("m_title"), rs.getInt("m_runtime"),
						rs.getInt("m_price"), rs.getInt("m_rating"), rs.getInt("m_count"), rs.getString("m_review"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return searchReviewMovie;
	}
	
//	할인 조회 - 좌석 앞에서 3번째 줄 조회 - 를 위한 상영관 이름으로 상영관 정보 조회
	public TheaterVo searchTheaterBytName(Connection conn, String theaterName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TheaterVo thea = null;
		try {
			String sql = "select * from theater where t_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theaterName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				thea = new TheaterVo(rs.getInt("t_no"), rs.getString("t_name"), rs.getInt("t_seat"), rs.getInt("t_lineseat"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		return thea;
	} 
	
////	유저 나이 조회
//	public int userAgeCheck(Connection conn, UserVo user) {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int userAge = -1;
//		try {
//			String sql = "select u_ssn";
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rs, pstmt);
//		}
//		return userAge;
//	}
	
	
	
	
	
	
	
	
	
	
}

