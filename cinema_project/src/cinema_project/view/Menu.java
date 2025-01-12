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
			case 7 : createTimetable();break;
			case 8 : editTimetable(); break;
			case 9 : break;
			case 10 : System.out.println("***로그아웃 완료***"); return;
			default : System.out.println("잘못된 번호를 입력하였습니다 다시 입력해주세요!!"); break;
			
			}
			}
			}
	
		
	
	// 7번 영화 시간표 추가
	public void createTimetable() {
		System.out.println("=========영화 시간표 추가=========");
//		List <TimeTable> list = controller.createTimeTable();
//		if(list.isEmpty()) {
//			System.out.println("조회된 결과가 없습니다.");
//		} else {
//			for(TimeTable m : list) {
//				System.out.println(m);
//		}
		System.out.println("어떤 영화를 추가하시겠습니까(번호) ? : ");
		int a = sc.nextInt();
		
		System.out.println("영화 제목 : ");
		String movie = sc.nextLine();
		sc.nextLine();
		System.out.println("상영관 이름 : ");
		String theater = sc.nextLine();
		System.out.print("상영 시작시간 : ");
		String start = sc.nextLine();
		System.out.print("상영 종료시간 : ");
		String end = sc.nextLine();
		
		int result = controller.createTimetable(movie ,theater ,start ,end);
		if(result > 0) {
			System.out.println("성공적으로 추가하였습니다");
		}else {
			System.out.println("추가 중 오류가 발생하였습니다 ㅠㅡㅠ");
		}	
		
		
		
		

		
		
	
	
	
	
//	public void dmlResultPrint(int result , String menuName) {
//		if(result > 0) System.out.println(menuName+"이(가) 정상 수행되었습니다");
//		else System.out.println(menuName + "중 오류가 발생하였습니다");
//	}
//	
		
	

}
	
	public void editTimetable() {
		List<ViewTimeTable>list = controller.editTimeTable();
		printList(list);
		System.out.println("어떤 영화를 수정하시겠습니까(번호) : ");
			
}

	
	public void printList(List<ViewTimeTable> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(ViewTimeTable m : list) {
				System.out.println(m);
		}
					
}
		
	}
}
