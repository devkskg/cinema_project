package cinema_project.controller;

import java.util.List;

import cinema_project.model.service.Serviceksk;
import cinema_project.model.vo.Movieksk;
import cinema_project.model.vo.Timetableksk;

public class Controllerksk {
	private Serviceksk se = new Serviceksk();

	public List<Movieksk> searchMovieList() {
		return se.searchMovieList();
	}


	public List<Timetableksk> searchTimetableListByMovieTitle(String movieTitle, int resSeatNum) {
		return se.searchTimetableListByMovieTitle(movieTitle, resSeatNum);
	}

	public int ticketRes(Timetableksk movieRes, int resSeatNum) {
		return se.ticketRes(movieRes, resSeatNum);
	}
}
