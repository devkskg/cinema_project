package cinema_project.model.service;

import static cinema_project.common.TimeTableTemPlate.close;
import static cinema_project.common.TimeTableTemPlate.getConnection;

import java.sql.Connection;
import java.util.List;

import cinema_project.model.dao.Dao;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.ViewTimeTable;

public class Service {
	private Dao dao = new Dao();
	public int createTimetable(TimeTable tm) {
		Connection conn = getConnection();
		int result = dao.createTimetable(tm , conn);
		close(conn);
		return result;
	}
	
	public List<ViewTimeTable> editTimeTable(){
		Connection conn = getConnection();
		List<ViewTimeTable> list = dao.editTimeTable(conn);
		close(conn);
		return list;
	}
	
	

}
