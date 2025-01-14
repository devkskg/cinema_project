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

//	선택한 영화의 시간표 조회 영화 제목과 정해진 시간으로 조회
	public List<Timetableksk> searchTimetableListByMovieTitleDate(String movieTitle, int resSeatNum, String qualificationDateTime) {
		Connection conn = getConnection();
		List<Timetableksk> list = dao.searchTimetableListByMovieTitleDate(conn, movieTitle, resSeatNum, qualificationDateTime);
		close(conn);
		return list;
	}
//	선택한 영화의 시간표 조회 시간표번호로 조회
	public Timetableksk searchTimetableListByTimeNo(int TimeNo) {
		Connection conn = getConnection();
		Timetableksk timetableByTimeNo = dao.searchTimetableListByTimeNo(conn, TimeNo);
		close(conn);
		return timetableByTimeNo;
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
//	후기 남기기 자격 확인
	public List<Reservationksk> createReviewQualification(String qualificationDateTime) {
		Connection conn = getConnection();
		List<Reservationksk> list = dao.createReviewQualification(conn, qualificationDateTime);
		close(conn);
		return list;
	}

	public int createReviewOne(Reservationksk reservationksk, String reviewStr) {
		Connection conn = getConnection();
		int result = dao.createReviewOne(conn, reservationksk, reviewStr);
		close(conn);
		return result;
	}

	public Movieksk searchReviewOne(Movieksk searchReview) {
		Connection conn = getConnection();
		Movieksk searchReviewMovie = dao.searchReviewOne(conn, searchReview);
		close(conn);
		return searchReviewMovie;
	}
}
