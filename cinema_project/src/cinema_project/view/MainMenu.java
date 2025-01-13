package cinema_project.view;

import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import cinema_project.vo.Vo;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	Vo v = new Vo();
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
			case 1 : addMovie break;
			case 2 : updateMovie break;
			case 3 : deletMovie break;
//			case 4 : break;
//			case 5 : break;
//			case 6 : break;
			case 7 : createTimetable();break;
			case 8 : editTimetable(); break;
			case 9 : break;
			case 10 : System.out.println("***로그아웃 완료***"); return;
			default : System.out.println("잘못된 번호를 입력하였습니다 다시 입력해주세요!!"); break;
			
			}
			}
			}
		public void addMovie() {
			System.out.println("영화 제목");
			String m_title = sc.nextLine();
			sc.nextLine();
			System.out.println("러닝 타임");
			int m_runtime = sc.nextInt();
			System.out.println("가격");
			int m_price = sc.nextInt();
			System.out.println("상영 등급");
			int m_rating = sc.nextInt();
			int result = controller.addMovie(m_title,m_runtime,m_price,m_rating);
			if(result > 0) {
				System.out.println("영화가 성공적으로 추가되었습니다.");
			}else {
				System.out.println("영화 추가에 실패하였습니다.");
			}
		}

}
