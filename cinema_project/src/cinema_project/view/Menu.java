package cinema_project.view;

public class Menu {

	public static void main(String[] args) {
		public void mainMenu1() {
	        while (true) {
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
	                case 4: deleteUser(); break;
	                case 0: System.out.println("프로그램을 종료합니다."); return;
	                default: System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
	            }
	        }
	    }
	}

}
