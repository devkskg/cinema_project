package cinema_project.controller;



import java.util.List;

import cinema_project.model.service.Service;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.ViewTimeTable;

public class Controller {
	private Service service = new Service();
	
	//7번 영화 시간표 추가
	public int createTimetable(String movie,String theater,String start,String end) {
		TimeTable tm = new TimeTable(movie,theater,start,end);
		int result = service.createTimetable(tm);
		return result;
	}
	
	public List<ViewTimeTable> editTimeTable(){
		return service.editTimeTable();
	
	}


}
