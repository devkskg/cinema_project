package cinema_project.run;

import cinema_project.view.MainMenu;

public class Run {
		// 지금은 관리자 메뉴 이지만 , 도영이형이 만든 메인메뉴에서 관리자 id로 로그인 할 시 관리자 메뉴로 들어가야함
		public static void main(String[] args) {
			new MainMenu().mainMenu();
	}
	
	}