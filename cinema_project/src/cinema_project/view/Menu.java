package cinema_project.view;


import java.util.List;
import java.util.Scanner;

import cinema_project.controller.Controller;
import cinema_project.model.vo.TimeTable;
import cinema_project.model.vo.ViewTimeTable;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	public void managerMenu() {
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
			//1~6 정현 담당
			switch(menu) {
			case 1 : break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
//			case 7 : createTimetable();break;
//			case 8 : editTimetable(); break;
			case 9 : deleteTimetable(); break;
			case 10 : System.out.println("***로그아웃 완료***"); return;
			default : System.out.println("잘못된 번호를 입력하였습니다 다시 입력해주세요!!"); break;
			
			}
			}
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
	
	
	public void deleteTimetable() {
		List<TimeTable> list = controller.viewTimeTable();
		printList(list);
		System.out.println("삭제하고자 하는 영화번호를 입력해주세요 : ");
		int delete = sc.nextInt();
		int result = controller.deleteTimetable(delete);
		if(result > 0) {
			System.out.println("성공적으로 삭제했습니다!");
		}else {
			System.out.println("!!!!삭제 중 오류!!!!");
		}
		}
	
	}
