package cinema_project.model.service;

import static cinema_project.common.TimeTableTemPlate.getConnection;
import static cinema_project.common.TimeTableTemPlate.close;

import java.sql.Connection;

import cinema_project.model.dao.Dao;
import cinema_project.model.vo.TimeTable;

public class Service {
	private Dao dao = new Dao();
	public int createTimetable(TimeTable tm) {
		Connection conn = getConnection();
		int result = dao.createTimetable(tm , conn);
		close(conn);
		return result;
	}
	
	

}
