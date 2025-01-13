package cinema_project.controller;



import java.util.List;

import cinema_project.model.service.Service;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.ViewTimeTable;

public class Controller {
	private Service service = new Service();
	

	
	// --타임테이블 전체 조회 메소드--
	public List<TimeTable> viewTimeTable(){
		return service.viewTimeTable();
	}
	
	// 9번 영화 시간표 삭제
	public int deleteTimetable(int delete) {
		int result = service.deleteTimeTable(delete);
		return result;
	}


}
