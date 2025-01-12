package cinema_project.model.service;

import static cinema_project.template.Templateksk.getConnection;
import static cinema_project.template.Templateksk.close;

import java.sql.Connection;
import java.util.List;

import cinema_project.model.dao.Daoksk;
import cinema_project.model.vo.Movieksk;
import cinema_project.model.vo.Reservationksk;
import cinema_project.model.vo.Timetableksk;

public class Serviceksk {
	private Daoksk dao = new Daoksk();

//	상영중인 영화 목록 조회
	public List<Movieksk> searchMovieList() {
		Connection conn = getConnection();
		List<Movieksk> list = dao.searchMovieList(conn);
		close(conn);
		return list;
	}

//	선택한 영화의 영화 시간표 조회
	public List<Timetableksk> searchTimetableListByMovieTitle(String movieTitle, int resSeatNum) {
		Connection conn = getConnection();
		List<Timetableksk> list = dao.searchTimetableListByMovieTitle(conn, movieTitle, resSeatNum);
		close(conn);
		return list;
	}
//	시간표로 예매 진행, Transaction 사용
	public int ticketRes(Timetableksk movieRes, int resSeatNum) {
		Connection conn = getConnection();
		int result = dao.ticketRes(conn, movieRes, resSeatNum);
		close(conn);
		return result;
	}
//	예매 내역 조회
	public List<Reservationksk> searchRes() {
		Connection conn = getConnection();
		List<Reservationksk> list = dao.searchRes(conn);
		close(conn);
		return list;
	}

//	예매 내역 취소
	public int deleteRes(Reservationksk res) {
		Connection conn = getConnection();
		int result = dao.deleteRes(conn, res);
		close(conn);
		return result;
	}
}
