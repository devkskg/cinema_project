package cinema_project.view;


import java.util.List;
import java.util.Scanner;

import cinema_project.controller.Controller;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.TheaterVo;



public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private Controller mc = new Controller();
	public void mainMenu() {
		while(true) {
			System.out.println("=====관리자 메뉴에 오신 걸 환영합니다=====");
			System.out.println("1. 영화 추가");
			System.out.println("2. 영화 정보 수정");
			System.out.println("3. 영화 삭제");
			System.out.println("4. 상영관 추가");
			System.out.println("5. 상영관 정보 수정");
			System.out.println("6. 상영관 삭제");
			System.out.println("7. 영화 시간표 추가");
			System.out.println("8. 영화 시간표 수정");
			System.out.println("9. 영화 시간표 삭제");
			System.out.println("10. 로그아웃");
			
			System.out.print("선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			//1~6 정현 담당
			switch(menu) {
			case 1 : addMovie(); break;
			case 2 : updateMovie(); break;
			case 3 : deletMovie(); break;
 			case 4 : addTheater(); break;
			case 5 : updateTheater();break;
			case 6 : deletTheater(); break;
//			case 7 : createTimetable();break;
//			case 8 : editTimetable(); break;
			case 9 : break;
			case 10 : System.out.println("***로그아웃 완료***"); return;
			default : System.out.println("잘못된 번호를 입력하였습니다 다시 입력해주세요!!"); break;
			
			}
		}
	}
	
	// 영화 목록 
    public void showAllMovies() {
        List<MovieVo> movies = mc.getAllMovies();
        if (movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
        } else {
            System.out.println("=== 영화 목록 ===");
            for (MovieVo movie : movies) {
                System.out.println("영화 번호: " + movie.getMovieNumber() + ", 제목: " + movie.getMovieName() +
                        ", 러닝타임: " + movie.getMovieRuntime() + "분, 가격: " + movie.getMoviePrice() + ", 상영등급: " + movie.getMovieRating());
            }
        }
    }
	
    // 상영관 목록 
    public void showAllTheaters() {
        List<TheaterVo> theaters = mc.getAllTheaters();
        if (theaters.isEmpty()) {
            System.out.println("등록된 상영관이 없습니다.");
        } else {
            System.out.println("=== 상영관 목록 ===");
            for (TheaterVo theater : theaters) {
                System.out.println("상영관 번호: " + theater.getTheaterNumber() + ", 이름: " + theater.getTheaterName() +
                        ", 좌석 수: " + theater.getTheaterSeat() + ", 한 줄 좌석 수: " + theater.getTheaterLineseat());
            }
        }
    }
	
    public List<MovieVo> searchMovie() {
	    return controller.searchMovie();
	}
	
	private Controller controller = new Controller();
		public void addMovie() {
		    showAllMovies();
		    System.out.println("=== 영화 추가 ===");

		    String m_name;
		    System.out.print("영화 제목을 입력하세요: ");
		    m_name = sc.nextLine();

		    List<MovieVo> movieList = controller.searchMovie();
		    for (MovieVo movie : movieList) {
		        if (movie.getMovieName().equals(m_name)) {
		            System.out.println("영화 제목이 중복되어 추가 불가능합니다.");
		            return;
		        }
		    }
		    System.out.print("러닝타임(분) : ");
		    int m_runtime = sc.nextInt();
		    System.out.print("영화 가격 : ");
		    int m_price = sc.nextInt();
		    System.out.print("상영등급 : ");
		    int m_rating = sc.nextInt();
		    sc.nextLine(); 
		    MovieVo movie = new MovieVo(m_name, m_runtime, m_price, m_rating);
		    
		    int result = controller.addMovie(movie);
		    if (result > 0) {
		        System.out.println("영화가 추가되었습니다.");
		    } else {
		        System.out.println("영화 추가에 실패했습니다.");
		    }
		}
	
	//영화 수정
	public void updateMovie(){
		 showAllMovies();
		    System.out.println("===영화 정보 수정===");

		    int m_number = -1;
		    boolean valid = false;

		    while (!valid) {
		        System.out.print("수정할 영화 번호를 입력하세요: ");
		        m_number = sc.nextInt();
		        sc.nextLine();  
		        
		        List<MovieVo> movieList = mc.getAllMovies();
		        for (MovieVo movie : movieList) {
		            if (movie.getMovieNumber() == m_number) {
		                valid = true; 
		                break;
		            }
		        }
		        if (!valid) {
		            System.out.println("잘못된 영화 번호입니다. 다시 입력해주세요.");
		        }
		    }

		    System.out.print("새 영화 제목 : ");
		    String m_name = sc.nextLine();
		    System.out.print("새 러닝 타임 : ");
		    int m_running = sc.nextInt();    
		    System.out.print("새 가격 : ");
		    int m_price = sc.nextInt();
		    System.out.print("새 상영 등급 : ");
		    int m_rating = sc.nextInt();

		    int result = mc.updateMovie(m_number, m_name, m_running, m_price, m_rating);
		    if(result > 0) {
		        System.out.println("영화 정보가 성공적으로 수정되었습니다.");
		    } else {
		        System.out.println("영화 정보 수정에 실패했습니다.");
		    }
	}
	//영화 삭제
	public void deletMovie(){
		showAllMovies();
		System.out.println("===영화 삭제===");
		System.out.print("영화 번호 : ");
		int m_number = sc.nextInt();
		sc.nextLine();
		
		List<MovieVo> movieList = controller.searchMovie();
		MovieVo movieToDelete = null;
	    
	    for (MovieVo movie : movieList) {
	        if (movie.getMovieNumber() == m_number) {
	            movieToDelete = movie;
	            break; 
	        }
	    }
	    
	    if (movieToDelete != null) {
	        String yn;
	        while (true) {
	            System.out.println("정말 삭제하시겠습니까? (Y/N)");
	            yn = sc.nextLine().toUpperCase();

	            if (yn.equals("Y")) {
	                int result = controller.deletMovie(m_number);
	                if(result > 0) {
	                    System.out.println("영화가 삭제되었습니다.");
	                } else {
	                    System.out.println("삭제 실패.");
	                }
	                break;
	            } else if (yn.equals("N")) {
	                System.out.println("삭제를 취소하였습니다.");
	                break;
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	            }
	        }
	    } else {
	        System.out.println("존재하지 않는 영화 번호입니다.");
	    }
	}
	
	public List<TheaterVo> searchTheater() {
	    return controller.searchTheater();
	}
	//상영관 추가
	public void addTheater() {
	    showAllTheaters();
	    System.out.println("=== 상영관 추가 ===");

	    String t_name;
	    System.out.print("상영관 이름을 입력하세요: ");
	    t_name = sc.nextLine();

	    List<TheaterVo> theaterList = controller.searchTheater();
	    for (TheaterVo theater : theaterList) {
	        if (theater.getTheaterName().equals(t_name)) {
	            System.out.println("상영관 이름이 중복되어 추가 불가능합니다.");
	            return; 
	        }
	    }
	    System.out.print("좌석 수 : ");
	    int t_seat = sc.nextInt();
	    System.out.print("한 줄의 좌석 수 : ");
	    int t_lineseat = sc.nextInt();
	    sc.nextLine();

	    TheaterVo theater = new TheaterVo(t_name, t_seat, t_lineseat);

	    int result = controller.addTheater(theater);
	    if (result > 0) {
	        System.out.println("상영관이 성공적으로 추가되었습니다.");
	    } else {
	        System.out.println("상영관 추가에 실패했습니다.");
	    }
	}
	//상영관 업데이트
	public void updateTheater() {
		showAllTheaters();
	    System.out.println("===상영관 정보 수정===");

	    int t_number = -1;
	    boolean valid = false;

	   
	    while (!valid) {
	        System.out.print("수정할 상영관 번호를 입력하세요: ");
	        t_number = sc.nextInt();
	        sc.nextLine();  

	        
	        List<TheaterVo> theaterList = mc.getAllTheaters();
	        for (TheaterVo theater : theaterList) {
	            if (theater.getTheaterNumber() == t_number) {
	                valid = true; 
	                break;
	            }
	        }
	        if (!valid) {
	            System.out.println("잘못된 상영관 번호입니다. 다시 입력해주세요.");
	        }
	    }

	    System.out.print("새 상영관 제목 : ");
	    String t_name = sc.nextLine();
	    System.out.print("새 좌석 : ");
	    int t_seat = sc.nextInt();    
	    System.out.print("새 한 줄 좌석 : ");
	    int t_lineseat = sc.nextInt();

	    int result = mc.updatetheater(t_number, t_name, t_seat, t_lineseat);
	    if(result > 0) {
	        System.out.println("상영관 정보가 성공적으로 수정되었습니다.");
	    } else {
	        System.out.println("상영관 정보 수정에 실패했습니다.");
	    }
	}
	
	//상영관 삭제
	public void deletTheater() {
		showAllTheaters();
		System.out.println("===상영관 삭제===");
		System.out.print("상영관 번호 : ");
		int t_number = sc.nextInt();
		sc.nextLine();
		
		List<TheaterVo> theaterList = controller.searchTheater();
		TheaterVo theaterToDelete = null;
		
		    for (TheaterVo theater : theaterList) {
		        if (theater.getTheaterNumber() == t_number) {
		        	theaterToDelete = theater;
		            break;  
		        }
		    }
		if(theaterToDelete != null) {
			String yn;
			while(true) {
				System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
				yn = sc.nextLine().toUpperCase();
				if("Y".equals(yn)) {
					int result = controller.deletTheater(t_number);
					System.out.println("상영관이 성공적으로 삭제되었습니다.");
					break;
				}else if("N".equals(yn)){
					System.out.println("삭제를 취소하셨습니다.");
					break;
				}else {
					System.out.println("잘못된 입력 방식입니다. 다시 입력해주세요.");
				}
			}
			}else {
				System.out.println("존재하지 않는 상영관 번호입니다.");
			}
		}
	} /* 테스트 주석*/
