package cinema_project.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import cinema_project.controller.Controller;
import cinema_project.model.vo.MovieVo;
import cinema_project.model.vo.Reservation;
import cinema_project.model.vo.TheaterVo;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.Timetableksk;
import cinema_project.model.vo.UserVo;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private Controller mc = new Controller();
	
//	private LocalDateTime ldtNow = LocalDateTime.of(2025, 01, 17, 13, 0, 0);
	private LocalDateTime ldtNow = LocalDateTime.now();
//	test용 현재 시간
	private DateTimeFormatter testdtf = DateTimeFormatter.ofPattern("yyyy년-MM월-dd일, a KK시:mm분:SS초");
	private DateTimeFormatter qualification = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
	private String panelNowDateTime = ldtNow.format(testdtf);
	private String qualificationDateTime = ldtNow.format(qualification);
	
	// 메인 메뉴 페이지
		public void mainMenu() {
			while(true) {
				System.out.println("=== 10nema ===");
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 아이디,비밀번호 찾기");
				System.out.println("4. 회원탈퇴");
				System.out.println("0. 종료");
				System.out.print("선택 : ");
				int menu = sc.nextInt();
				sc.nextLine(); 

	        switch (menu) {
	            case 1: createUser(); break;
	            case 2: loginUser(); break;
	            case 3: searchUserInfossnph(); break;
	            case 4: deleteUser(); return;
	            case 0: System.out.println("프로그램을 종료합니다."); return;
	            default: System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
	          }
		  }
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void managerMenu() {
		while (true) {
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
			// 1~6 정현 담당
			switch (menu) {
			case 1:
				addMovie();
				break;
			case 2:
				updateMovie();
				break;
			case 3:
				deletMovie();
				break;
			case 4:
				addTheater();
				break;
			case 5:
				updateTheater();
				break;
			case 6:
				deletTheater();
				break;
			case 7:
				createTimetable();
				break;
			case 8:
				editTimetable();
				break;
			case 9:
				deleteTimetable();
				break;
			case 10:
				System.out.println("***로그아웃 완료***");
				return;
			default:
				System.out.println("잘못된 번호를 입력하였습니다 다시 입력해주세요!!");
				break;

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
				System.out.println("영화 번호: " + movie.getmNo() + ", 제목: " + movie.getmTitle() + ", 러닝타임: "
						+ movie.getmRuntime() + "분, 가격: " + movie.getmPrice() + ", 상영등급: " + movie.getmRating());
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
				System.out.println("상영관 번호: " + theater.gettNo() + ", 이름: " + theater.gettName() + ", 좌석 수: "
						+ theater.gettSeat() + ", 한 줄 좌석 수: " + theater.gettLineseat());
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
			if (movie.getmTitle().equals(m_name)) {
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

	// 영화 수정
	public void updateMovie() {
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
				if (movie.getmNo() == m_number) {
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
		if (result > 0) {
			System.out.println("영화 정보가 성공적으로 수정되었습니다.");
		} else {
			System.out.println("영화 정보 수정에 실패했습니다.");
		}
	}

	// 영화 삭제
	public void deletMovie() {
		showAllMovies();
		System.out.println("===영화 삭제===");
		System.out.print("영화 번호 : ");
		int m_number = sc.nextInt();
		sc.nextLine();

		List<MovieVo> movieList = controller.searchMovie();
		MovieVo movieToDelete = null;

		for (MovieVo movie : movieList) {
			if (movie.getmNo() == m_number) {
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
					if (result > 0) {
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

	// 상영관 추가
	public void addTheater() {
		showAllTheaters();
		System.out.println("=== 상영관 추가 ===");

		String t_name;
		System.out.print("상영관 이름을 입력하세요: ");
		t_name = sc.nextLine();

		List<TheaterVo> theaterList = controller.searchTheater();
		for (TheaterVo theater : theaterList) {
			if (theater.gettName().equals(t_name)) {
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

	// 상영관 업데이트
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
				if (theater.gettNo() == t_number) {
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
		if (result > 0) {
			System.out.println("상영관 정보가 성공적으로 수정되었습니다.");
		} else {
			System.out.println("상영관 정보 수정에 실패했습니다.");
		}
	}

	// 상영관 삭제
	public void deletTheater() {
		showAllTheaters();
		System.out.println("===상영관 삭제===");
		System.out.print("상영관 번호 : ");
		int t_number = sc.nextInt();
		sc.nextLine();

		List<TheaterVo> theaterList = controller.searchTheater();
		TheaterVo theaterToDelete = null;

		for (TheaterVo theater : theaterList) {
			if (theater.gettNo() == t_number) {
				theaterToDelete = theater;
				break;
			}
		}
		if (theaterToDelete != null) {
			String yn;
			while (true) {
				System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
				yn = sc.nextLine().toUpperCase();
				if ("Y".equals(yn)) {
					int result = controller.deletTheater(t_number);
					System.out.println("상영관이 성공적으로 삭제되었습니다.");
					break;
				} else if ("N".equals(yn)) {
					System.out.println("삭제를 취소하셨습니다.");
					break;
				} else {
					System.out.println("잘못된 입력 방식입니다. 다시 입력해주세요.");
				}
			}
		} else {
			System.out.println("존재하지 않는 상영관 번호입니다.");
		}
	}

//타임테이블 추가
	public void createTimetable() {
		List<MovieVo> list = controller.viewMovie();
		System.out.println("===영화 정보===");
		printList2(list);

		System.out.println("======영화 시간표 추가======");
		System.out.print("영화 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		List<TheaterVo> list1 = controller.viewTheater();
		System.out.println("===상영관 정보===");
		printList3(list1);

		System.out.print("상영관 이름 : ");
		String tname = sc.nextLine();
		System.out.print("시작시간 (yyyy-MM-dd HH:mm:ss) : ");
		String start = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime starttime = LocalDateTime.parse(start, formatter);
		LocalDateTime endtime = starttime.plusMinutes(list.get(no - 1).getmRuntime());
		System.out.print("끝나는 시간 (yyyy-MM-dd HH:mm:ss) : " + endtime);
		String createmt = list.get(no - 1).getmTitle();

//		String convertEndtime = start + list.get(no).getmRuntime(); 

		int result = controller.createTimetable(createmt, tname, starttime);
		if (result > 0) {
			System.out.println("성공적으로 추가하였습니다!");
		} else {
			System.out.println("추가 실패 ㅠㅡㅠ");
		}

	}

	// 타임테이블 수정
	public void editTimetable() {
		List<TimeTable> list = controller.viewTimeTable();
		System.out.println("=====영화 시간표 정보=====");
		printList(list);
		System.out.println("어떤 영화의 정보를 수정하시겠습니가");
		System.out.print("번호 : ");
		int movieNo = sc.nextInt();
		sc.nextLine();

		System.out.print("수정 시작시간 (yyyy-MM-dd HH:mm:ss) : ");
		String start = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime starttime = LocalDateTime.parse(start, formatter);
		LocalDateTime endtime = starttime.plusMinutes(viewMovie().get(movieNo - 1).getmRuntime());
		System.out.print("끝나는 시간 (yyyy-MM-dd HH:mm:ss) : " + endtime);
		int result = controller.editTimetable(movieNo, start, starttime);
		if (result > 0) {
			System.out.print("୧〳 ” ʘ̆ ᗜ ʘ̆ ” 〵୨");
			System.out.print("성공적으로 수정!");
		} else {
			System.out.println("수정 실패 ㅠㅠ");
		}

	}

	// -상영관(theater) 테이블 전체 조회 메소드-
	public List<TheaterVo> viewTheater() {
		List<TheaterVo> list = controller.viewTheater();
		return list;
	}

	// -상영관(theater) 테이블 전체 조회 결과 메소드-
	public void printList3(List<TheaterVo> list) {
		if (list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for (TheaterVo m : list) {
				System.out.println(m);
			}
		}
	}

	// -타임테이블 전체 조회 메소드-
	public List<TimeTable> viewTimeTable() {
		List<TimeTable> list = controller.viewTimeTable();
		return list;
	}

	// -타임테이블 전체 결과 메소드-
	public void printList(List<TimeTable> list) {
		if (list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for (TimeTable m : list) {
				System.out.println(m);
			}
		}
	}

	// --movie 테이블 전체 조회 메소드--
	public List<MovieVo> viewMovie() {
		List<MovieVo> list = controller.viewMovie();
		return list;
	}

	// -movie 테이블 전체 결과 메소드-
	public void printList2(List<MovieVo> list) {
		if (list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for (MovieVo m : list) {
				System.out.println(m);
			}
		}
	}

	// 9번 delete
	public void deleteTimetable() {
		List<TimeTable> list = controller.viewTimeTable();
		printList(list);
		System.out.print("삭제하고자 하는 영화번호를 입력해주세요 : ");
		int delete = sc.nextInt();
		int result = controller.deleteTimetable(delete);
		if (result > 0) {
			System.out.println("성공적으로 삭제했습니다!");
		} else {
			System.out.println("!!!!삭제 중 오류!!!!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 아이디,비밀번호 찾기

	private void searchUserInfossnph() {
		System.out.println("=== 아이디,비밀번호 찾기 ===");
		System.out.print("이름 : ");
		String uName = sc.nextLine();
		System.out.print("주민번호 : ");
		String uSsn = sc.nextLine();
		System.out.print("전화번호 : ");
		String uPhone = sc.nextLine();
		
		UserVo name = mc.searchUserInfossnph(uName,uSsn,uPhone);
		if(name == null) {
			System.out.println("아이디, 비밀번호 찾기 실패 : 일치하는 정보의 사용자가 없습니다.");
		} else {
			System.out.println(name+"\n정보조회가 완료되었습니다.");
		}
	//	User searchuser = userService.searchUserInfossnph(user);
	//	mc.searchUserInfossnph(uName,uSsn,uPhone);
	}


//회원가입
	private void createUser() {
	    System.out.println("=== 회원가입 ===");
	    System.out.print("아이디: ");
	    String uId = sc.nextLine();
	    System.out.print("비밀번호: ");
	    String uPw = sc.nextLine();
	    System.out.print("이름: ");
	    String uName = sc.nextLine();
	    System.out.print("주민등록번호: ");
	    String uSsn = sc.nextLine();
	    System.out.print("핸드폰 번호: ");
	    String uPhone = sc.nextLine();
	    int result = mc.createUser(uId,uPw,uName,uSsn,uPhone);
	    if (result > 0) {
	        System.out.println("회원가입 성공!");
	    } else {
	        System.out.println("회원가입 실패!");
	 }
	}

// 로그인
	private void loginUser() {
	    System.out.println("=== 로그인 ===");
	    System.out.print("아이디: ");
	    String uId = sc.nextLine();
	    System.out.print("비밀번호: ");
	    String uPw = sc.nextLine();
	
	    UserVo userLogin = mc.loginUser(uId, uPw);
	    
	    if(userLogin == null) {
	    	System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
	//    	return;
	    } else {
	    	if(userLogin.getuManager().equals("Y")) {
	    		managerMenu();
	    	} else {
	    		System.out.println("로그인 성공!");
	    		userMenu(userLogin);
	    	}
	  }
	}

//회원 탈퇴
	private void deleteUser() {
	    System.out.println("=== 회원탈퇴 ===");
	    System.out.print("아이디: ");
	    String uId = sc.nextLine();
	    System.out.print("비밀번호: ");
	    String uPw = sc.nextLine();
	
	//    mc.deleteUser(uId, uPw); -> 주석처리한 이유(회원탈퇴 실패로 뜨는 원인)
	    
	    int result = mc.deleteUser(uId,uPw);
	    if (result > 0) {
	        System.out.println("회원탈퇴 성공!");
	    } else {
	        System.out.println("회원탈퇴 실패!");
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	유저 메뉴
	public void userMenu(UserVo userLogin) {
		System.out.println(userLogin.getUserName() + "님 환영합니다!");
		System.out.println(panelNowDateTime);

		while (true) {
			System.out.println("1. 티켓 예매");
			System.out.println("2. 예매 내역 조회");
			System.out.println("3. 예매 내역 취소");
			System.out.println("4. 후기 남기기");
			System.out.println("5. 영화 후기 조회");
			System.out.println("10. 로그아웃");

			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				ticketRes(userLogin);
				break;
			case 2:
				searchRes(userLogin);
				break;
			case 3:
				deleteRes(userLogin);
				break;
			case 4:
				createReviewOne(userLogin);
				break;
			case 5:
				searchReviewOne();
				break;
			case 10:
				System.out.println("로그아웃");
				return;
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				break;
			}
		}
	}

//		티켓 예매
	public void ticketRes(UserVo userLogin) {
//		영화 목록 조회
		System.out.println("*** 상영중인 영화 목록 ***");
		List<MovieVo> movieList = searchMovieList();

		System.out.println("*** 티켓 예매 ***");
		int resSeatNum = 0;
		int resMovieNum = 0;
		while (true) {
			System.out.print("예매하실 영화 번호를 선택해주세요. : ");
			resMovieNum = sc.nextInt();
			sc.nextLine();

			if (resMovieNum <= 0 || movieList.size() < resMovieNum) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				break;
			}
		

		}
		while (true) {
//			선택한 영화의 시간표 조회 시간표번호로 조회
			
			System.out.print("예매하실 \"좌석 수\"를 입력해주세요. : ");
			resSeatNum = sc.nextInt();
			if (resSeatNum <= 0) {
				System.out.println("잘못된 인원입니다.");
			} else {
				
				int userAge = userAgeCheck(userLogin);
				
//				선택한 영화의 영화 시간표 조회
//				연령제한 -- 처음부터 사용자의 나이 정보를 인자로 넣어서 timetableList 가져오자.
				List<Timetableksk> timetableList = mc.searchTimetableListByMovieTitleDate(movieList.get(resMovieNum - 1).getmTitle(), resSeatNum, qualificationDateTime, userAge);
				if (timetableList.isEmpty()) {
					System.out.println("예매할 수 없는 영화입니다.");
					return;
				} else {
					System.out.println("*** [" + movieList.get(resMovieNum - 1).getmTitle() + "]의 상영 시간표 ***");
					for (int i = 1; i <= timetableList.size(); i++) {
						System.out.println("[" + i + "번] " + timetableList.get(i - 1));
					}
					while (true) {
						System.out.print("예매하실 시간을 선택해주세요. : ");
						int timeNum = sc.nextInt();
						sc.nextLine();

						if (timeNum <= 0 || timetableList.size() < timeNum) {
							System.out.println("예매하실 시간을 잘못 입력하셨습니다.");
						} else {

							int ticketPrice = movieList.get(resMovieNum-1).getmPrice();
							
								if(disCountCheckBirthDay(userLogin) && disCountCheckThirdLineSeat(timetableList.get(timeNum - 1).gettName(), resSeatNum)) {
							System.out.println("생일을 축하드립니다!\n생일 할인과 앞좌석 할인을 적용했습니다.\n할인 전 가격 : " +ticketPrice+ "원, 할인 적용 가격 : " + (int)(ticketPrice * (1-0.1-0.1)) + "원 입니다."+"\n예매 하시겠습니까?(Y/N) : ");
								} else if (disCountCheckBirthDay(userLogin)) {
							System.out.println("생일을 축하드립니다!\n생일 할인을 적용했습니다.\n할인 전 가격 : " +ticketPrice+ "원, 할인 적용 가격 : " + (int)(ticketPrice * (1-0.1)) + "원 입니다."+"\n예매 하시겠습니까?(Y/N) : ");
							} else if(disCountCheckThirdLineSeat(timetableList.get(timeNum - 1).gettName(), resSeatNum)) {
							System.out.println("앞좌석 할인을 적용했습니다.\n할인 전 가격 : " +ticketPrice+ "원, 할인 적용 가격 : " + (int)(ticketPrice * (1-0.1)) + "원 입니다."+"\n예매 하시겠습니까?(Y/N) : ");
							
							} else {
							System.out.print("가격은 " + ticketPrice * (1) + "입니다."+"\n예매 하시겠습니까?(Y/N) : ");
							}
							String yn = sc.nextLine().toUpperCase();
							
							if("Y".equals(yn)) {
//							시간표로 예매 진행, Transaction 사용
								
								int ticketResResult = mc.ticketRes(timetableList.get(timeNum - 1), resSeatNum, userLogin);
								if (ticketResResult <= 0) {
									System.out.println("예매에 실패했습니다.");
								} else {
									System.out.println("예매가 완료되었습니다.");
								}
								
							}else {
								System.out.println("예매를 취소합니다.");
								return;
							}
							return;
						}
					}
				}

			}
		}
	}

//	상영중인 영화 목록 조회
	public List<MovieVo> searchMovieList() {
//		System.out.println("*** 상영중인 영화 목록 ***");
		List<MovieVo> movieList = mc.searchMovieList();
		if (movieList.isEmpty()) {
			System.out.println("상영중인 영화가 없습니다.");
		} else {
			for (int i = 1; i <= movieList.size(); i++) {
				System.out.println("[" + i + "번] " + movieList.get(i - 1).toStringForUser());
			}
		}
		return movieList;
	}

//	예매 내역 조회
	public List<Reservation> searchRes(UserVo userLogin) {
		System.out.println("*** 예매 내역 조회 ***");
		
//		비밀번호 일치시 예매 내역 조회
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = sc.nextLine();
		
		List<Reservation> searchResList = null;
		if(pw.equals(userLogin.getUserPw())) {

			searchResList = mc.searchRes(userLogin);
			if (searchResList.isEmpty()) {
				System.out.println("예매 내역이 없습니다.");
			} else {
//			기능 추가
//			현재 시간 이전/이후로 나눠서 목록 조회
//			reservation 테이블에 컬럼 하나 만들어서 default로 시간값 넣어주기 필요
				Timetableksk timetableByTimeNo = null;
				System.out.println("=== 상영 시간이 지난 영화 내역입니다. ===");
				for (int i = 1; i <= searchResList.size(); i++) {
					timetableByTimeNo = mc.searchTimetableListByTimeNo(searchResList.get(i-1).getTimeNo());
//					if(ChronoUnit.SECONDS.between(searchResList.get(i-1).getrDate(), ldtNow)>0) {
					if(ChronoUnit.SECONDS.between(timetableByTimeNo.getTimeStart(), ldtNow)>0) {
						System.out.println("["+i+"번] " + searchResList.get(i - 1) + ", 상영 시간 : " + timetableByTimeNo.getTimeStart().format(testdtf) + " ~ " + timetableByTimeNo.getTimeEnd().format(testdtf));
					}
					
				}
				System.out.println("=== 상영 시작 예정인 영화입니다. ===");
				int temp = 1;
				for (int i = 1; i <= searchResList.size(); i++) {
					timetableByTimeNo = mc.searchTimetableListByTimeNo(searchResList.get(i-1).getTimeNo());
					if(ChronoUnit.SECONDS.between(timetableByTimeNo.getTimeStart(), ldtNow)<=0){
						System.out.println("["+temp+"번] " + searchResList.get(i - 1) + ", 상영 시간 : " + timetableByTimeNo.getTimeStart().format(testdtf) + " ~ " + timetableByTimeNo.getTimeEnd().format(testdtf));
						temp++;
					}
				}
			}
//			return searchResList;
			
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		return searchResList;
				
		
		
	}

//	예매 내역 취소
	public void deleteRes(UserVo userLogin) {
		List<Reservation> searchResList = searchRes(userLogin);
		if(searchResList != null) {
			System.out.println("*** 예매 내역 취소 ***");
			while (true) {
				System.out.print("취소할 예매 내역을 선택해주세요 : ");
				int deleteNum = sc.nextInt();
				sc.nextLine();
				if (deleteNum <= 0 || searchResList.size() < deleteNum) {
					System.out.println("잘못 입력하셨습니다.");
				} else {
					int result = mc.deleteRes(searchResList.get(deleteNum - 1));
					if (result > 0) {
						System.out.println("예매 내역 취소가 완료되었습니다.");
					} else {
						System.out.println("예매 내역이 없습니다.");
					}
					return;
				}
				
			}
		}
	}

//	후기 남기기 자격 확인 // 리뷰 자격 - 예매 기록이 있고 그 기록이 3시간 이상 흐를 것
//	위 조건 안됨. 예매를 하루 전에 하는 경우도 있으니까. -> 예매한 영화의 시작시간 + 3시간 이상 흐를 것.
	public List<Reservation> createReviewQualification(UserVo userLogin) {
		List<Reservation> qualifList = mc.createReviewQualification(qualificationDateTime, userLogin);
		return qualifList;
	}

//	후기 남기기
	public void createReviewOne(UserVo userLogin) {
		System.out.println("*** 후기 남기기 ***");
		int result = 0;
		List<Reservation> qualifList = createReviewQualification(userLogin);
		if (qualifList.isEmpty()) {
			System.out.println("후기를 작성할 수 있는 영화가 없습니다.");
		} else {
			for (int i = 1; i <= qualifList.size(); i++) {
				System.out.println("[" + i + "번] " + qualifList.get(i - 1));
			}
			while (true) {
				System.out.print("후기를 작성할 영화를 선택해주세요. : ");
				int reviewNum = sc.nextInt();
				sc.nextLine();
				if (reviewNum <= 0 || qualifList.size() < reviewNum) {
					System.out.println("잘못 입력하셨습니다.");
				} else {
					StringBuilder hideName = new StringBuilder();
					hideName.append(userLogin.getUserName().charAt(0));
					hideName.append("*");
					hideName.append(userLogin.getUserName().charAt(userLogin.getUserName().length()-1));
					hideName.append(" : ");
					String reviewStr = hideName.toString();
					System.out.print("후기 작성 : ");
					reviewStr += sc.nextLine() + "\n";
					result = mc.createReviewOne(qualifList.get(reviewNum - 1), reviewStr, userLogin);
					if (result > 0) {
						System.out.println("후기 작성이 완료되었습니다.");
					} else {
						System.out.println("후기 작성에 실패하였습니다.");
					}
					return;
				}
			}
		}
	}

//	영화 후기 조회
	public void searchReviewOne() {
		System.out.println("*** 후기 조회 ***");
		List<MovieVo> list = searchMovieList();
		while (true) {
			System.out.print("후기를 조회할 영화를 선택해주세요. : ");
			int reviewNum = sc.nextInt();
			sc.nextLine();
			if (reviewNum <= 0 || list.size() < reviewNum) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				MovieVo searchReviewMovie = mc.searchReviewOne(list.get(reviewNum-1));
//				Movieksk searchReviewMovie = co.searchReviewOne(list.get(reviewNum-1, 유저의 정보(이름)));
//				이런식으로 해볼까?
				if (searchReviewMovie.getmReview().length() == 0 || searchReviewMovie == null) {
					System.out.println("--작성된 후기가 없습니다.--");
				} else {
					System.out.println("\n" + searchReviewMovie.getmReview());
				}
				return;
			}
		}
	}
	
//	할인 조회 - 생일 조회
	public boolean disCountCheckBirthDay(UserVo userLogin) {
		boolean result = false;
		String userBirthDay = userLogin.getUserSsn().substring(2, 6);
		String toDay = String.valueOf(panelNowDateTime.substring(6, 8));
		toDay += String.valueOf(panelNowDateTime.substring(10, 12));
		if(userBirthDay.equals(toDay)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
//	할인 조회 - 좌석 앞에서 3번째 줄 조회
	public boolean disCountCheckThirdLineSeat(String theaterName, int resSeat) {
		boolean result = false;
		TheaterVo thea = searchTheaterBytName(theaterName);
		int lineSeat = thea.gettLineseat();
		int leftSeat = thea.gettSeat();
		if(leftSeat <= lineSeat * 3) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
//	할인 조회 - 좌석 앞에서 3번째 줄 조회 - 를 위한 상영관 이름으로 상영관 정보 조회
	public TheaterVo searchTheaterBytName(String theaterName) {
		return mc.searchTheaterBytName(theaterName);
	}
	
//	유저 나이 조회
	public int userAgeCheck(UserVo userLogin) {
//		메소드 시작시 유저의 나이를 -1로 선언 및 초기화함으로 나중에 오류 잡을 때 사용 가능할 듯
		int userAge = -1;
		String ssn = userLogin.getUserSsn();
		String ob = "19";
		String yb = "20";
		String birthStr = ssn.substring(0, 2); 
		String genderStr = ssn.substring(7, 8);
		int birthInt = -1;
		int genderInt = Integer.parseInt(genderStr);
		if(genderInt == 1 || genderInt == 2) {
			ob += birthStr;
			birthInt = Integer.parseInt(ob);
		} else {
//			유저 정보 중 주민등록번호의 8번째 숫자가 1,2를 제외한 사람들은 전부 2000년생 취급
			yb += birthStr;
			birthInt = Integer.parseInt(yb);
		}
		userAge = ldtNow.getYear() - birthInt;
		return userAge;
	}
	
	
	
	
	
	

}
