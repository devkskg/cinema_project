package cinema_project.view;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import cinema_project.controller.Controller;
import cinema_project.model.vo.Movie;
import cinema_project.model.vo.Theater;
import cinema_project.model.vo.TimeTable;


public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	public void managerMenu() {
		while(true) {
			System.out.println(" ୧〳 ” ʘ̆ ᗜ ʘ̆ ” 〵୨");
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
			case 1 : break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			case 7 : createTimetable();break;
			case 8 : editTimetable(); break;
			case 9 : deleteTimetable(); break;
			case 10 : System.out.println("***로그아웃 완료***"); return;
			default : System.out.println("잘못된 번호를 입력하였습니다 다시 입력해주세요!!"); break;
			
		}
	}
}
	public void createTimetable() {
		List<Movie> list = controller.viewMovie();
		System.out.println("===영화 정보===");
		printList2(list);
		
		System.out.println("======영화 시간표 추가======");
		System.out.print("영화 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		List<Theater> list1 = controller.viewTheater();
		System.out.println("===상영관 정보===");
		printList3(list1);
		
		System.out.print("상영관 이름 : ");
		String tname = sc.nextLine();
		System.out.print("시작시간 (yyyy-MM-dd HH:mm:ss) : ");
		String start = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime starttime = LocalDateTime.parse(start,formatter);
		LocalDateTime endtime = starttime.plusMinutes(list.get(no-1).getmRuntime());
		System.out.print("끝나는 시간 (yyyy-MM-dd HH:mm:ss) : " + endtime);
		String createmt = list.get(no-1).getmTitle();
		
		
//		String convertEndtime = start + list.get(no).getmRuntime(); 
		
		int result = controller.createTimetable(createmt,tname,starttime);
		if(result > 0 ) {
			System.out.println("성공적으로 추가하였습니다!");
		}else {
			System.out.println("추가 실패 ㅠㅡㅠ");
		}
		
		
	}
	
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
		LocalDateTime starttime = LocalDateTime.parse(start,formatter);
		LocalDateTime endtime = starttime.plusMinutes(viewMovie().get(movieNo-1).getmRuntime());
		System.out.print("끝나는 시간 (yyyy-MM-dd HH:mm:ss) : " + endtime);
		int result = controller.editTimetable(movieNo,start,starttime);
		if(result > 0 ) {
			System.out.print("୧〳 ” ʘ̆ ᗜ ʘ̆ ” 〵୨");
			System.out.print("성공적으로 수정!");
		}else {
			System.out.println("수정 실패 ㅠㅠ");
		}
		
		}
	
	
		
	
	
	
	
	
	// -상영관(theater) 테이블 전체 조회 결과 메소드-
	public void printList3(List <Theater> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(Theater m : list) {
				System.out.println(m);
			}			
		}
	}
	
	// -상영관(theater) 테이블 전체 조회 메소드-
	public List<Theater> viewTheater(){
		List<Theater> list = controller.viewTheater();
		return list;
	}
	
	

	// -타임테이블 전체 조회 메소드-
	public List<TimeTable> viewTimeTable() {
		List<TimeTable>list = controller.viewTimeTable();
		return list;
	}
	// -타임테이블 전체 결과 메소드-
	public void printList(List<TimeTable> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(TimeTable m : list) {
				System.out.println(m);
			}	
		}	
	}
	
	
	// --movie 테이블 전체 조회 메소드--
	public List<Movie>viewMovie(){
		List<Movie>list = controller.viewMovie();
		return list;
	}
	// -movie 테이블 전체 결과 메소드-
	public void printList2(List <Movie> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(Movie m : list) {
				System.out.println(m);
			}			
		}
	}
	//9번 delete		
	public void deleteTimetable() {
		List<TimeTable> list = controller.viewTimeTable();
		printList(list);
		System.out.print("삭제하고자 하는 영화번호를 입력해주세요 : ");
		int delete = sc.nextInt();
		int result = controller.deleteTimetable(delete);
		if(result > 0) {
			System.out.println("성공적으로 삭제했습니다!");
		}else {
			System.out.println("!!!!삭제 중 오류!!!!");
		}
		}
	
	}

