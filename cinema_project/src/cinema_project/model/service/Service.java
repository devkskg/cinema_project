package cinema_project.model.service;

import static cinema_project.common.TimeTableTemPlate.close;
import static cinema_project.common.TimeTableTemPlate.getConnection;

import java.sql.Connection;
import java.util.List;

import cinema_project.model.dao.Dao;
import cinema_project.model.vo.Movie;
import cinema_project.model.vo.Theater;
import cinema_project.model.vo.TimeTable;


public class Service {
	private Dao dao = new Dao();
	
	
	
	public List<Theater> viewTheater(){
		Connection conn = getConnection();
		List<Theater> list = dao.viewTheater(conn);
		close(conn);
		return list;
	}
	
	
	public List<Movie> viewMovie(){
		Connection conn = getConnection();
		List<Movie> list = dao.viewMovie(conn);
		close(conn);
		return list;
	}
	
	
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


	public int TimeTable(int no, String name, String start, String end) {
		
		return 0;
	}
	
	

}
