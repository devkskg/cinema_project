package cinema_project.controller;

import java.util.List;

import cinema_project.model.service.Serviceksk;
import cinema_project.model.vo.Movieksk;
import cinema_project.model.vo.Reservationksk;
import cinema_project.model.vo.Timetableksk;

public class Controllerksk {
	private Serviceksk se = new Serviceksk();
	
//	상영중인 영화 목록 조회
	public List<Movieksk> searchMovieList() {
		return se.searchMovieList();
	}

//	선택한 영화의 영화 시간표 조회
	public List<Timetableksk> searchTimetableListByMovieTitle(String movieTitle, int resSeatNum) {
		return se.searchTimetableListByMovieTitle(movieTitle, resSeatNum);
	}
//	시간표로 예매 진행, Transaction 사용
	public int ticketRes(Timetableksk movieRes, int resSeatNum) {
		return se.ticketRes(movieRes, resSeatNum);
	}
//	예매 내역 조회
	public List<Reservationksk> searchRes() {
		return se.searchRes();
	}
//	예매 내역 취소
	public int deleteRes(Reservationksk res) {
		return se.deleteRes(res);
	}
}
