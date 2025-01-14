package cinema_project.view;


import java.util.List;
import java.util.Scanner;

import cinema_project.controller.Controller;
import cinema_project.model.vo.Vo;


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
	
	public List<Vo> searchMovie() {
	    return controller.searchMovie();
	}
	
	private Controller controller = new Controller();
	public void addMovie() {
		int m_same = 0;
		System.out.print("중복 확인하실 영화 제목을 입력해주세요:");
		String m_title = sc.nextLine();
		
		List<Vo> list = searchMovie();
		
		for(Vo v : list) {
			if(v.getMovieName().equals(m_title)) {
				m_same++;
			}
		}
		if(m_same > 0) {
			System.out.println("이미 존재하는 영화 제목입니다. 다시 입력해주세요.");
			addMovie();
		}else {
			System.out.println("===영화 추가===");		
			System.out.print("영화 제목:");
			String m_name = sc.nextLine();
			System.out.print("러닝 타임:");
			int m_running = sc.nextInt();
			sc.nextLine();
			System.out.print("가격:");
			int m_price = sc.nextInt();
			System.out.print("상영등급:");
			int m_rating = sc.nextInt();
			int result = mc.addMovie(m_name,m_running,m_price,m_rating);
			if(result > 0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
		}
	}
	
	
	public void updateMovie(){
		System.out.println("===영화 정보 수정===");
		System.out.println("수정할 영화 번호를 입력하세요: ");
		System.out.print("영화 번호 : ");
		int m_number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("새 영화 제목 : ");
		String m_name = sc.nextLine();
		System.out.print("새 러닝 타임 : ");
		int m_running = sc.nextInt();	
		System.out.print("새 가격 : ");
		int m_price = sc.nextInt();
		System.out.print("새 상영 등급 : ");
		int m_rating = sc.nextInt();
	
		int result = mc.updateMovie(m_number,m_name,m_running,m_price,m_rating);
		if(result > 0) {
			System.out.println("영화 정보가 성공적으로 수정되었습니다.");
		}else {
			System.out.println("영화 정보 수정에 실패했습니다.");
		}
	}
	
	public void deletMovie(){
		System.out.println("===영화 삭제===");
		System.out.print("영화 번호 : ");
		int m_number = sc.nextInt();
		sc.nextLine();
		
		int result = controller.deletMovie(m_number);
		
		if(result > 0) {
			System.out.println("영화가 성공적으로 삭제되었습니다.");
		} else {
			System.out.println("영화 삭제에 실패했습니다.");
		}
	}
	
	public List<Vo> searchTheater() {
	    return controller.searchTheater();
	}
	public void addTheater() {
		int t_same = 0;
		System.out.print("중복 확인하실 상영관 제목을 입력해주세요:");
		String t_title = sc.nextLine();
		
		List<Vo> list = searchTheater();
		
		for(Vo v : list) {
			if(v.getTheaterName().equals(t_title)) {
				t_same++;
			}
		}
		if(t_same > 0) {
			System.out.println("이미 존재하는 상영관 이름입니다. 다시 입력해주세요.");
			addTheater();
		}else {
			System.out.println("===상영관 추가===");
			System.out.println("추가하실 상영관 이름, 좌석, 한 줄의 좌석 수를 입력해 주세요.");
			System.out.print("상영관 이름 : ");
			String t_name = sc.nextLine();
			System.out.print("좌석 수 : ");
			int t_seat = sc.nextInt();
			sc.nextLine();
			System.out.print("한 줄의 좌석 수 : ");
			int t_lineseat = sc.nextInt();
			
			int result = mc.addTheater(t_name,t_seat,t_lineseat);
			if(result > 0) {
				System.out.println("상영관이 성공적으로 추가되었습니다.");
			}else {
				System.out.println("상영관 추가에 실패했습니다.");
			}
		
		}
	}
	
	
	
//	public void addtheater(){
//		System.out.println("===상영관 추가===");
//		System.out.println("추가하실 상영관 이름, 좌석, 한 줄의 좌석 수를 입력해 주세요.");
//		System.out.print("상영관 이름 : ");
//		String t_name = sc.nextLine();
//		System.out.print("좌석 수 : ");
//		int t_seat = sc.nextInt();
//		sc.nextLine();
//		System.out.print("한 줄의 좌석 수 : ");
//		int t_lineseat = sc.nextInt();
//		
//		int result = mc.addtheater(t_name,t_seat,t_lineseat);
//		if(result > 0) {
//			System.out.println("상영관이 성공적으로 추가되었습니다.");
//		}else {
//			System.out.println("상영관 추가에 실패했습니다.");
//		}
//		
//	}
	
	public void updateTheater() {
		System.out.println("===상영관 정보 수정===");
		System.out.println("수정할 상영관 번호를 입력하세요: ");
		System.out.print("상영관 번호 : ");
		int t_number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("새 상영관 제목 : ");
		String t_name = sc.nextLine();
		System.out.print("새 좌석 : ");
		int t_seat = sc.nextInt();	
		System.out.print("새 한 줄 좌석 : ");
		int t_lineseat = sc.nextInt();

		int result = mc.updatetheater(t_number,t_name,t_seat,t_lineseat);
		if(result > 0) {
			System.out.println("상영관 정보가 성공적으로 수정되었습니다.");
		}else {
			System.out.println("상영관 정보 수정에 실패했습니다.");
		}
		
	}
	
	//상영관 삭제
	public void deletTheater() {
		System.out.println("===상영관 삭제===");
		System.out.print("상영관 번호 : ");
		int t_number = sc.nextInt();
		sc.nextLine();
		
		int result = controller.deletTheater(t_number);
		
		if(result > 0) {
			System.out.println("상영관이 성공적으로 삭제되었습니다.");
		} else {
			System.out.println("상영관 삭제에 실패했습니다.");
		}
		
	}
} 
