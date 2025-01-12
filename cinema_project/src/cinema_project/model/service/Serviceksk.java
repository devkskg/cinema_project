package cinema_project.model.service;

import static cinema_project.template.Templateksk.getConnection;
import static cinema_project.template.Templateksk.close;

import java.sql.Connection;
import java.util.List;

import cinema_project.model.dao.Daoksk;
import cinema_project.model.vo.Movieksk;
import cinema_project.model.vo.Timetableksk;

public class Serviceksk {
	private Daoksk dao = new Daoksk();

	public List<Movieksk> searchMovieList() {
		Connection conn = getConnection();
		List<Movieksk> list = dao.searchMovieList(conn);
		close(conn);
		return list;
	}


	public List<Timetableksk> searchTimetableListByMovieTitle(String movieTitle, int resSeatNum) {
		Connection conn = getConnection();
		List<Timetableksk> list = dao.searchTimetableListByMovieTitle(conn, movieTitle, resSeatNum);
		close(conn);
		return list;
	}

	public int ticketRes(Timetableksk movieRes, int resSeatNum) {
		Connection conn = getConnection();
		int result = dao.ticketRes(conn, movieRes, resSeatNum);
		close(conn);
		return result;
	}
}
