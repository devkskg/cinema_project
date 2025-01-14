package cinema_project.model.service;

import static cinema_project.common.TimeTableTemPlate.close;
import static cinema_project.common.TimeTableTemPlate.getConnection;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import cinema_project.model.dao.Dao;
import cinema_project.model.vo.Movie;
import cinema_project.model.vo.Theater;
import cinema_project.model.vo.TimeTable;


public class Service {
	private Dao dao = new Dao();
	
	public int createTimetable(int no, String name, String start, String convertEndtime) {
		Connection conn = getConnection();
		int result = dao.createTimetable(no,name,start,convertEndtime,conn);
		close(conn);
		return result;
	}
	
	public int  editTimetable(int movieNo,String name,String theater,String start,String end) {
		Connection conn = getConnection();
		int result = dao.editTimetable(movieNo,name,theater,start,end,conn);
		close(conn);
		return result;
	}
	
	
	
	// theater 테이블 목록 조회
	public List<Theater> viewTheater(){
		Connection conn = getConnection();
		List<Theater> list = dao.viewTheater(conn);
		close(conn);
		return list;
	}
	
	//movie 테이블 목록 조회
	public List<Movie> viewMovie(){
		Connection conn = getConnection();
		List<Movie> list = dao.viewMovie(conn);
		close(conn);
		return list;
	}
	
	//timetable 테이블 목록조회
	public  List<TimeTable> viewTimeTable(){
		Connection conn = getConnection();
		List<TimeTable> list = dao.viewTimeTable(conn);
		close(conn);
		return list;
	}
	
	//9번 영화 시간표 삭제
	public int deleteTimeTable(int delete) {
		Connection conn = getConnection();
		int result = dao.deleteTimeTable(delete , conn);
		close(conn);
		return result;
	}



	

}
