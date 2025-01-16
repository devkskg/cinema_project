package cinema_project.controller;
import java.time.LocalDateTime;
import java.util.List;

import cinema_project.model.dao.Dao;
import cinema_project.model.service.Service;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.TheaterVo;
import cinema_project.model.vo.TimeTable;


public class Controller {

	//상영관 삭제
	public int deletTheater(int t_number) {
		 return service.deletTheater(t_number);
	}
	
	//상영관 수정
	public int updatetheater(int t_number, String t_name, int t_seat, int t_lineseat) {
		TheaterVo v = new TheaterVo(t_number, t_name, t_seat, t_lineseat);
        return service.updatetheater(v);
	}
	
	
	// 상영관 추가
	public int addTheater(TheaterVo theater) {
		 return service.addTheater(theater);
	}
	
	
	// 영화 추가
	public int addMovie(MovieVo movie) {
		return service.addMovie(movie);
	}

	
	
	private Service service = new Service();

	public int createTimetable(String createmt,String tname,LocalDateTime starttime) {
		int result = service.createTimetable(createmt,tname,starttime);
		return result;	
	}
	
	
	
	public int editTimetable(int movieNo,String start, LocalDateTime starttime) {
		int result = service.editTimetable(movieNo,start,starttime);
		return result;
	}
	
	
	// --상영관 테이블 전체 조회 메소드--
	public List<TheaterVo> viewTheater(){
		return service.viewTheater();
	}

	
	// --movie 테이블 전제 조회 메소드--
	public List<MovieVo> viewMovie(){
		return service.viewMovie();
	}
	
	
	// --timetable 전체 조회 메소드--
	public List<TimeTable> viewTimeTable(){
		return service.viewTimeTable();
	}
	
	// 9번 영화 시간표 삭제
	public int deleteTimetable(int delete) {
		int result = service.deleteTimeTable(delete);
		return result;
	}



	//영화 정보 수정
	public int updateMovie(int m_number, String m_name, int m_running, int m_price, int m_rating){
		MovieVo v = new MovieVo(m_number, m_name, m_running, m_price, m_rating);
	      return service.updateMovie(v);
	}

	// 영화 삭제
	public int deletMovie(int m_number) {
		 return service.deletMovie(m_number);
	}
	
	// 영화 중복 검사.
	public List<MovieVo> searchMovie() {
		 return service.searchMovie();
	}
	// 상영관 중복 검사.
	public List<TheaterVo> searchTheater() {
		return service.searchTheater();
	}
	
	 // 영화 전체 조회
    public List<MovieVo> getAllMovies() {
    	 return service.getAllMovies();
    }

    // 상영관 전체 조회
    public List<TheaterVo> getAllTheaters() {
    	 return service.getAllTheaters();
    }
	
}