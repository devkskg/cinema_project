package cinema_project.controller;





import java.util.List;

import cinema_project.model.service.Service;
import cinema_project.model.vo.Movie;
import cinema_project.model.vo.Theater;
import cinema_project.model.vo.TimeTable;


public class Controller {
	private Service service = new Service();

	public int createTimetable(int no, String name, String start, String convertEndtime) {
		int result = service.createTimetable(no,name,start,convertEndtime);
		return result;	
	}
	
	
	// --상영관 테이블 전체 조회 메소드--
	public List<Theater> viewTheater(){
		return service.viewTheater();
	}

	
	// --movie 테이블 전제 조회 메소드--
	public List<Movie> viewMovie(){
		return service.viewMovie();
	}
	
	
	// --timetable 전체 조회 메소드--
	public List<TimeTable> viewTimeTable(){
		return service.viewTimeTable();
	}
	
	// 9번 영화 시간표 삭제
	public int deleteTimetable(int delete) {
		int result = service.deleteTimeTable(delete);
		return result;
	}


}
