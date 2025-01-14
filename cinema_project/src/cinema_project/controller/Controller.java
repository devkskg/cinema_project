package cinema_project.controller;
import java.util.List;

import cinema_project.model.dao.Dao;
import cinema_project.model.vo.Vo;
public class Controller {
	//상영관 삭제
	public int deletTheater(int t_number) {
		int result = new Dao().deletTheater(t_number);
		return result;
	}
	
	//상영관 수정
	public int updatetheater(int t_number, String t_name, int t_seat, int t_lineseat) {
		Vo v = new Vo(t_number,t_name,t_seat,t_lineseat);
		int result = new Dao().updatetheater(v);
		return result;
	}
	
	
	// 상영관 추가
	public int addTheater(String t_name, int t_seat, int t_lineseat) {
		Vo v = new Vo(t_name,t_seat,t_lineseat);
		int result = new Dao().addtheater(v);
		return result;
	}
	
	
	// 영화 추가
	public int addMovie(String m_name, int m_running, int m_price, int m_rating) {
		Vo v = new Vo(m_name,m_running,m_price,m_rating);
		int result = new Dao().addMovie(v);
		return result;
	}

	//영화 정보 수정
	public int updateMovie(int m_number, String m_name, int m_running, int m_price, int m_rating){
		Vo v = new Vo(m_number, m_name, m_running, m_price, m_rating);
		int result = new Dao().updateMovie(v);
		return result;
	}

	// 영화 삭제
	public int deletMovie(int m_number) {
		int result = new Dao().deletMovie(m_number);
		return result;
	}
	
	// 영화 중복 검사.
	public List<Vo> searchMovie() {
	    return new Dao().searchMovie();
	}
	// 상영관 중복 검사.
	public List<Vo> searchTheater() {
		return new Dao().searchTheater();
	}
} 