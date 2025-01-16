package cinema_project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.TheaterVo;
import cinema_project.service.Service;

public class Dao {
	//상영관 전체 조회
	public List<TheaterVo> getAllTheaters() {
	    List<TheaterVo> theaterList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM theater"; 
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int theaterNumber = rs.getInt("t_no");
	            String theaterName = rs.getString("t_name");
	            int theaterSeat = rs.getInt("t_seat");
	            int theaterLineseat = rs.getInt("t_lineseat");

	            TheaterVo theater = new TheaterVo(theaterNumber, theaterName, theaterSeat, theaterLineseat);
	            theaterList.add(theater);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return theaterList;
	}
	
	//영화 전체 조회
	public List<MovieVo> getAllMovies() {
	    List<MovieVo> movieList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM movie"; 
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int movieNumber = rs.getInt("m_no");
	            String movieName = rs.getString("m_title");
	            int movieRuntime = rs.getInt("m_runtime");
	            int moviePrice = rs.getInt("m_price");
	            int movieRating = rs.getInt("m_rating");

	            MovieVo movie = new MovieVo(movieNumber, movieName, movieRuntime, moviePrice, movieRating);
	            movieList.add(movie);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return movieList;
	}
	
	// 중복 확인
	public List<MovieVo> searchMovie() {
	    List<MovieVo> movieList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM movie";
	        pstmt = conn.prepareStatement(sql);
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            int movieNumber = rs.getInt("m_no");
	            String movieName = rs.getString("m_title");
	            int movieRuntime = rs.getInt("m_runtime");
	            int moviePrice = rs.getInt("m_price");
	            int movieRating = rs.getInt("m_rating");
	            
	            MovieVo movie = new MovieVo(movieNumber, movieName, movieRuntime, moviePrice, movieRating);
	            movieList.add(movie);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return movieList;
	}
	// 상영관 중복 확인
	public List<TheaterVo> searchTheater() {
	    List<TheaterVo> theaterList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = new Service().getConnection();
	        String sql = "SELECT * FROM theater";
	        pstmt = conn.prepareStatement(sql);
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            int theaterNumber = rs.getInt("t_no");
	            String teaterName = rs.getString("t_name");
	            int teaterSeat = rs.getInt("t_seat");
	            int teaterLineseat = rs.getInt("t_lineseat");
	            
	            TheaterVo theater = new TheaterVo(theaterNumber, teaterName, teaterSeat, teaterLineseat);
	            theaterList.add(theater);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return theaterList;
	}
	
	
	
	public int updatetheater(TheaterVo v) {	
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
		conn = new Service().getConnection();
		String sql = "UPDATE theater SET t_name = ?, t_seat = ?, t_lineseat = ? WHERE t_no = ?";
		pstmt = conn.prepareStatement(sql);			
		pstmt.setString(1, v.getTheaterName()); 
		pstmt.setInt(2, v.getTheaterSeat()); 
		pstmt.setInt(3, v.getTheaterLineseat()); 
		pstmt.setInt(4, v.getTheaterNumber()); 
		result = pstmt.executeUpdate();    
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try{
			pstmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return result;		
	}
	
	// 상영관 추가
	public int addTheater(TheaterVo v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = new Service().getConnection();
			String sql = "INSERT INTO theater(t_name,t_seat,t_lineseat) VALUES(?,?,?);";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, v.getTheaterName()); 
	        pstmt.setInt(2, v.getTheaterSeat());
	        pstmt.setInt(3, v.getTheaterLineseat()); 
			result = pstmt.executeUpdate();		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;	
	}
	
	// 영화 추가
	public int addMovie(MovieVo v) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int result = 0;
	    try {	     
	        conn = new Service().getConnection(); 
	    
	        String sql = "INSERT INTO movie(m_title,m_runtime,m_price,m_rating) VALUES(?,?,?,?);";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, v.getMovieName()); 
	        pstmt.setInt(2, v.getMovieRuntime()); 
	        pstmt.setInt(3, v.getMoviePrice()); 
	        pstmt.setInt(4, v.getMovieRating()); 	
	        result = pstmt.executeUpdate();
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return result;
	}
	
	// 영화 업데이트
	public int updateMovie(MovieVo v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = new Service().getConnection();
			String sql = "UPDATE movie SET m_title = ?, m_runtime = ?, m_price = ?, m_rating = ? WHERE m_no = ?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, v.getMovieName());
            pstmt.setInt(2, v.getMovieRuntime()); 
            pstmt.setInt(3, v.getMoviePrice());
            pstmt.setInt(4, v.getMovieRating()); 
            pstmt.setInt(5, v.getMovieNumber());
            result = pstmt.executeUpdate();    
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				pstmt.close();
				conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;		
	}
	
	// 영화 삭제
	public int deletMovie(int m_number){
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 int result = 0;
		  try {
			    conn = new Service().getConnection();
		        String sql = "DELETE FROM movie WHERE m_no = ?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, m_number); 
		        result = pstmt.executeUpdate();
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            pstmt.close();
		            conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    return result;
		}
	// 상영관 삭제
	public int deletTheater(int t_number){
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 int result = 0;
		  try {
			    conn = new Service().getConnection();
		        String sql = "DELETE FROM theater WHERE t_no = ?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, t_number);  
		        result = pstmt.executeUpdate();
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            pstmt.close();
		            conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    return result;
		}
	} 