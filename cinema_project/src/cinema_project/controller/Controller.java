package cinema_project.controller;
import java.util.List;

import cinema_project.model.dao.Dao;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.TheaterVo;

public class Controller {
	//상영관 삭제
	public int deletTheater(int t_number) {
		int result = new Dao().deletTheater(t_number);
		return result;
	}
	
	//상영관 수정
	public int updatetheater(int t_number, String t_name, int t_seat, int t_lineseat) {
		TheaterVo v = new TheaterVo(t_number,t_name,t_seat,t_lineseat);
		int result = new Dao().updatetheater(v);
		return result;
	}
	
	
	// 상영관 추가
	public int addTheater(TheaterVo theater) {
	    int result = new Dao().addTheater(theater);  // Dao에서 Theater 추가
	    return result;
	}
	
	
	// 영화 추가
	public int addMovie(MovieVo movie) {
	    int result = new Dao().addMovie(movie);  
	    return result;
	}

	//영화 정보 수정
	public int updateMovie(int m_number, String m_name, int m_running, int m_price, int m_rating){
		MovieVo v = new MovieVo(m_number, m_name, m_running, m_price, m_rating);
		int result = new Dao().updateMovie(v);
		return result;
	}

	// 영화 삭제
	public int deletMovie(int m_number) {
		int result = new Dao().deletMovie(m_number);
		return result;
	}
	
	// 영화 중복 검사.
	public List<MovieVo> searchMovie() {
	    return new Dao().searchMovie();
	}
	// 상영관 중복 검사.
	public List<TheaterVo> searchTheater() {
		return new Dao().searchTheater();
	}
	
	 // 영화 전체 조회
    public List<MovieVo> getAllMovies() {
        return new Dao().getAllMovies();
    }

    // 상영관 전체 조회
    public List<TheaterVo> getAllTheaters() {
        return new Dao().getAllTheaters();
    }
	
}