package cinema_project.model.service;

import static cinema_project.common.TimeTableTemPlate.close;
import static cinema_project.common.TimeTableTemPlate.getConnection;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import cinema_project.common.TimeTableTemPlate;
import cinema_project.model.dao.Dao;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.Reservation;
import cinema_project.model.vo.TheaterVo;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.Timetableksk;
import cinema_project.model.vo.UserVo;


public class Service {
	private Dao dao = new Dao();
	

    // Timetable 생성
    public int createTimetable(String createmt, String tname, LocalDateTime starttime) {
    	Connection conn = getConnection();
    	int result = dao.createTimetable(createmt, tname, starttime, conn);
    	close(conn);
    	return result;
    	
//        try (Connection conn = getConnection()) {
//            return dao.createTimetable(createmt, tname, starttime, conn);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0; // 예외 처리 및 실패시 반환값 처리
//        }
    }
	

    // Timetable 수정
    public int editTimetable(int movieNo, String start, LocalDateTime starttime) {
       Connection conn = getConnection(); 
       int result = dao.editTimetable(movieNo, start, starttime, conn);
       close(conn);
       return result; // 예외 처리 및 실패시 반환값 처리
        }
    


    // Theater 목록 조회
    public List<TheaterVo> viewTheater() {
       Connection conn = getConnection(); 
       List<TheaterVo> result= dao.viewTheater(conn);
       close(conn);
            return result; // 예외 처리 및 실패시 반환값 처리
        }
    
	
	   // Movie 목록 조회
    public List<MovieVo> viewMovie() {
        Connection conn = getConnection(); 
        List<MovieVo> result = dao.viewMovie(conn);
        close(conn);
        return result; 
        }
    
	
	  // TimeTable 목록 조회
    public List<TimeTable> viewTimeTable() {
       Connection conn = getConnection(); 
       List<TimeTable> result = dao.viewTimeTable(conn);
        close(conn);
        return result;
        }
    
	  // TimeTable 삭제
    public int deleteTimeTable(int delete) {
       Connection conn = getConnection(); 
        int result = dao.deleteTimeTable(delete, conn);
        close(conn);
        return result; 
        }
    

    // 영화 추가
    public int addMovie(MovieVo movie) {
        Connection conn = getConnection();
        int result = dao.addMovie(movie.getmTitle(), movie.getmRuntime(), movie.getmPrice(), movie.getmRating(), conn);
        close(conn);
        return result;
    }
    
    // 영화 수정
    public int updateMovie(MovieVo movie) {
        Connection conn = getConnection();
        int result = dao.updateMovie(movie.getmNo(), movie.getmTitle(), movie.getmRuntime(), movie.getmPrice(), movie.getmRating(), conn);
        close(conn);
        return result;
    }
    
    // 영화 삭제
    public int deletMovie(int m_number) {
        Connection conn = getConnection();
        int result = dao.deleteMovie(m_number, conn);
        close(conn);
        return result;
    }
    
    // 상영관 추가
    public int addTheater(TheaterVo theater) {
        Connection conn = getConnection();
        int result = dao.addTheater(theater.gettName(), theater.gettSeat(), theater.gettLineseat(), conn);
        close(conn);
        return result;
    }
    
    // 상영관 수정
    public int updatetheater(TheaterVo theater) {
        Connection conn = getConnection();
        int result = dao.updateTheater(theater.gettNo(), theater.gettName(), theater.gettSeat(), theater.gettLineseat(), conn);
        close(conn);
        return result;
    }
    
    // 상영관 삭제
    public int deletTheater(int t_number) {
        Connection conn = getConnection();
        int result = dao.deleteTheater(t_number, conn);
        close(conn);
        return result;
    }
    
    // 영화 중복 검사
    public List<MovieVo> searchMovie() {
        Connection conn = getConnection();
        List<MovieVo> result = dao.searchMovie();
        close(conn);
        return result;
    }
    
    // 상영관 중복 검사
    public List<TheaterVo> searchTheater() {
        Connection conn = getConnection();
        List<TheaterVo> result = dao.searchTheater();
        close(conn);
        return result;
    }
    
    // 영화 전체 조회
    public List<MovieVo> getAllMovies() {
        Connection conn = getConnection();
        List<MovieVo> result = dao.getAllMovies();
        close(conn);
        return result;
    }
    
    // 상영관 전체 조회
    public List<TheaterVo> getAllTheaters() {
        Connection conn = getConnection();
        List<TheaterVo> result = dao.getAllTheaters();
        close(conn);
        return result;
    }
    
    public Connection getConnection() {
    	return TimeTableTemPlate.getConnection();  // TimeTableTemPlate 클래스의 getConnection() 호출
    }
//	public Connection getConnection() throws Exception {
//        Class.forName("org.mariadb.jdbc.Driver");
//        String url = "jdbc:mariadb://127.0.0.1:3306/10nema";
//       String id = "scott";
//       String pw = "tiger";
//       return DriverManager.getConnection(url, id, pw);
//    }


    
    
    // 로그인

    public int createUser(String uId,String uPw,String uName,String uSsn,String uPhone) {
        Connection conn = TimeTableTemPlate.getConnection();
        int result = dao.createUser(conn, uId, uPw, uName, uSsn, uPhone);
        close(conn);
        return result;
    }

    public UserVo loginUser(String uId, String uPw) {
        Connection conn = TimeTableTemPlate.getConnection();
        UserVo userLogin = dao.loginUser(conn, uId, uPw);
        close(conn);
        return userLogin;
    }

    public int deleteUser(String uId, String uPw) {
        Connection conn = TimeTableTemPlate.getConnection();
        int result = dao.deleteUser(conn, uId,uPw);
        close(conn);
        return result;
    }
    public UserVo searchUserInfossnph(String uName ,String uSsn, String uPhone) {
    	Connection conn = TimeTableTemPlate.getConnection();
    	UserVo searchuser = dao.searchUserInfossnph(conn ,uName,uSsn,uPhone);
    	close(conn);
    	return searchuser;
  
    	
    }
    
    
    
    
    
    
    
//	상영중인 영화 목록 조회
	public List<MovieVo> searchMovieList() {
		Connection conn = getConnection();
		List<MovieVo> list = dao.searchMovieList(conn);
		close(conn);
		return list;
	}
    

//	선택한 영화의 시간표 조회 영화 제목과 정해진 시간으로 조회
	public List<Timetableksk> searchTimetableListByMovieTitleDate(String movieTitle, int resSeatNum, String qualificationDateTime, int userAge) {
		Connection conn = getConnection();
		List<Timetableksk> list = dao.searchTimetableListByMovieTitleDate(conn, movieTitle, resSeatNum, qualificationDateTime, userAge);
		close(conn);
		return list;
	}
//	선택한 영화의 시간표 조회 시간표번호로 조회
	public Timetableksk searchTimetableListByTimeNo(int TimeNo) {
		Connection conn = getConnection();
		Timetableksk timetableByTimeNo = dao.searchTimetableListByTimeNo(conn, TimeNo);
		close(conn);
		return timetableByTimeNo;
	}
	
//	시간표로 예매 진행, Transaction 사용
	public int ticketRes(Timetableksk movieRes, int resSeatNum, UserVo userLogin) {
		Connection conn = getConnection();
		int result = dao.ticketRes(conn, movieRes, resSeatNum, userLogin);
		close(conn);
		return result;
	}
//	예매 내역 조회
	public List<Reservation> searchRes(UserVo userLogin) {
		Connection conn = getConnection();
		List<Reservation> list = dao.searchRes(conn, userLogin);
		close(conn);
		return list;
	}

//	예매 내역 취소
	public int deleteRes(Reservation res) {
		Connection conn = getConnection();
		int result = dao.deleteRes(conn, res);
		close(conn);
		return result;
	}
//	후기 남기기 자격 확인
	public List<Reservation> createReviewQualification(String qualificationDateTime, UserVo userLogin) {
		Connection conn = getConnection();
		List<Reservation> list = dao.createReviewQualification(conn, qualificationDateTime, userLogin);
		close(conn);
		return list;
	}
//	후기 남기기
	public int createReviewOne(Reservation reservation, String reviewStr, UserVo userLogin) {
		Connection conn = getConnection();
		int result = dao.createReviewOne(conn, reservation, reviewStr, userLogin);
		close(conn);
		return result;
	}
//	영화 후기 조회
	public MovieVo searchReviewOne(MovieVo searchReview) {
		Connection conn = getConnection();
		MovieVo searchReviewMovie = dao.searchReviewOne(conn, searchReview);
		close(conn);
		return searchReviewMovie;
	}
//	할인 조회 - 좌석 앞에서 3번째 줄 조회 - 를 위한 상영관 이름으로 상영관 정보 조회
	public TheaterVo searchTheaterBytName(String theaterName) {
		Connection conn = getConnection();
		TheaterVo thea = dao.searchTheaterBytName(conn, theaterName);
		close(conn);
		return thea;
	} 
    
    
    
    
    
    
    
    
    
    
    

	

}
