package cinema_project.model.dao;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinema_project.model.vo.Vo;
import cinema_project.service.Service;

public class Dao {
	
	// 중복 확인
	public List<Vo> searchMovie() {
	    List<Vo> movieList = new ArrayList<>();
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
	            
	            Vo movie = new Vo(movieNumber, movieName, movieRuntime, moviePrice, movieRating);
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
	public List<Vo> searchTheater() {
	    List<Vo> theaterList = new ArrayList<>();
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
	            
	            Vo theater = new Vo(theaterNumber, teaterName, teaterSeat, teaterLineseat);
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
	
	
	
	public int updatetheater(Vo v) {	
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
		//id = "scott";
//		String pw = "tiger";
//		conn = DriverManager.getConnection(url, id, pw);
		conn = new Service().getConnection();
		String sql = "UPDATE theater SET t_name = ?, t_seat = ?, t_lineseat = ? WHERE t_no = ?";
		pstmt = conn.prepareStatement(sql);			
		pstmt.setString(1, v.getTheaterName()); // 영화 제목
		pstmt.setInt(2, v.getTheaterSeat()); // 러닝타임
		pstmt.setInt(3, v.getTheaterLineseat()); // 가격
		pstmt.setInt(4, v.getTheaterNumber()); // 수정할 영화 번호
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
	public int addtheater(Vo v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = new Service().getConnection();
			String sql = "INSERT INTO theater(t_name,t_seat,t_lineseat) VALUES(?,?,?);";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, v.getTheaterName()); // 상영관 제목
	        pstmt.setInt(2, v.getTheaterSeat()); // 상영관 자리
	        pstmt.setInt(3, v.getTheaterLineseat()); // 한 줄 좌석
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
	public int addMovie(Vo v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/10nema";
//			String id = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url,id,pw);
			conn = new Service().getConnection();
			
			String sql = "INSERT INTO movie(m_title,m_runtime,m_price,m_rating) VALUES(?,?,?,?);";
			pstmt= conn.prepareStatement(sql);
			 
			 pstmt.setString(1, v.getMovieName()); // 영화 제목
	         pstmt.setInt(2, v.getMovieRuntime()); // 러닝타임
	         pstmt.setInt(3, v.getMoviePrice()); // 가격
	         pstmt.setInt(4, v.getMovieRating());
			result = pstmt.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 영화 업데이트
	public int updateMovie(Vo v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/10nema";
//			String id = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url, id, pw);
			conn = new Service().getConnection();
			String sql = "UPDATE movie SET m_title = ?, m_runtime = ?, m_price = ?, m_rating = ? WHERE m_no = ?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, v.getMovieName()); // 영화 제목
            pstmt.setInt(2, v.getMovieRuntime()); // 러닝타임
            pstmt.setInt(3, v.getMoviePrice()); // 가격
            pstmt.setInt(4, v.getMovieRating()); // 상영등급
            pstmt.setInt(5, v.getMovieNumber()); // 수정할 영화 번호
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
//		        Class.forName("org.mariadb.jdbc.Driver");
//		        String url = "jdbc:mariadb://127.0.0.1:3306/10nema";
//		        String id = "scott";
//		        String pw = "tiger";
//		        conn = DriverManager.getConnection(url, id, pw);
			    conn = new Service().getConnection();
		        String sql = "DELETE FROM movie WHERE m_no = ?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, m_number); // 삭제할 영화 번호
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
//		        Class.forName("org.mariadb.jdbc.Driver");
//		        String url = "jdbc:mariadb://127.0.0.1:3306/10nema";
//		        String id = "scott";
//		        String pw = "tiger";
//		        conn = DriverManager.getConnection(url, id, pw);
			    conn = new Service().getConnection();
		        String sql = "DELETE FROM theater WHERE t_no = ?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, t_number); // 삭제할 영화 번호
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
