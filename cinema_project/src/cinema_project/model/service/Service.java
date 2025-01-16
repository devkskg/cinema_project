package cinema_project.model.service;

import static cinema_project.common.TimeTableTemPlate.close;
import static cinema_project.common.TimeTableTemPlate.getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.List;

import cinema_project.model.dao.Dao;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.TheaterVo;
import cinema_project.model.vo.TimeTable;


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
        try (Connection conn = getConnection()) {
            return dao.editTimetable(movieNo, start, starttime, conn);
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // 예외 처리 및 실패시 반환값 처리
        }
    }


    // Theater 목록 조회
    public List<TheaterVo> viewTheater() {
        try (Connection conn = getConnection()) {
            return dao.viewTheater(conn);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // 예외 처리 및 실패시 반환값 처리
        }
    }
	
	   // Movie 목록 조회
    public List<MovieVo> viewMovie() {
        try (Connection conn = getConnection()) {
            return dao.viewMovie(conn);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // 예외 처리 및 실패시 반환값 처리
        }
    }
	
	  // TimeTable 목록 조회
    public List<TimeTable> viewTimeTable() {
        try (Connection conn = getConnection()) {
            return dao.viewTimeTable(conn);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // 예외 처리 및 실패시 반환값 처리
        }
    }
	  // TimeTable 삭제
    public int deleteTimeTable(int delete) {
        try (Connection conn = getConnection()) {
            return dao.deleteTimeTable(delete, conn);
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // 예외 처리 및 실패시 반환값 처리
        }
    }
	
//	public Connection getConnection() throws Exception {
//        Class.forName("org.mariadb.jdbc.Driver");
//        String url = "jdbc:mariadb://127.0.0.1:3306/10nema";
//       String id = "scott";
//       String pw = "tiger";
//       return DriverManager.getConnection(url, id, pw);
//    }



	

}
