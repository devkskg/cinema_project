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

	
	
	public  List<TimeTable> viewTimeTable(){
		Connection conn = getConnection();
		List<TimeTable> list = dao.viewTimeTable(conn);
		close(conn);
		return list;
	}
	
	public int deleteTimeTable(int delete) {
		Connection conn = getConnection();
		int result = dao.deleteTimeTable(delete , conn);
		close(conn);
		return result;
	}
	
	

}
