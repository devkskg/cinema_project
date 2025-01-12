package cinema_project.view;

import java.util.Optional;
import java.util.Scanner;

import cinema_project.controller.UserController;
import cinema_project.model.vo.User;

public class UserMenu {
	 private Scanner sc = new Scanner(System.in);
	    private UserController userController = new UserController();

	    public void mainMenu() {
	        while (true) {
	            System.out.println("=== 사용자 메뉴 ===");
	            System.out.println("1. 회원가입");
	            System.out.println("2. 로그인");
	            System.out.println("3. 아이디 찾기");
	            System.out.println("4. 회원탈퇴");
	            System.out.println("0. 종료");
	            System.out.print("선택: ");

	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1 : createUser(); break;
	                case 2 : login(); break;
	                case 3 : findUserById(); break;
	                case 4 : deleteUser(); break;
	                case 0 : System.out.println("프로그램 종료."); return;
	                default : System.out.println("잘못된 입력입니다.");
	            }
	        }
	    }

	    private void createUser() {
	        System.out.println("[회원가입]");
	        System.out.print("아이디: ");
	        String userId = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String userPw = sc.nextLine();
	        System.out.print("이름: ");
	        String userName = sc.nextLine();
	        System.out.print("주민등록번호: ");
	        String userSsn = sc.nextLine();
	        System.out.print("전화번호: ");
	        String userPhone = sc.nextLine();

	        User user = new User(userId, userPw, userName, userSsn, userPhone);
	        if (userController.createUser(user)) {
	            System.out.println("회원가입 성공!");
	        } else {
	            System.out.println("회원가입 실패!");
	        }
	    }

	    private void login() {
	        System.out.println("[로그인]");
	        System.out.print("아이디: ");
	        String userId = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String userPw = sc.nextLine();

	        Optional<User> user = userController.login(userId, userPw);
	        if (user.isPresent()) {
	            System.out.println("로그인 성공! 환영합니다, " + user.get().getUserName() + "님.");
	        } else {
	            System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인해주세요.");
	        }
	    }

	    private void findUserById() {
	        System.out.println("[아이디 찾기]");
	        System.out.print("아이디 입력: ");
	        String userId = sc.nextLine();

	        Optional<User> user = userController.findUserById(userId);
	        if (user.isPresent()) {
	            System.out.println("사용자 정보: " + user.get());
	        } else {
	            System.out.println("해당 아이디의 사용자를 찾을 수 없습니다.");
	        }
	    }

	    private void deleteUser() {
	        System.out.println("[회원탈퇴]");
	        System.out.print("아이디: ");
	        String userId = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String userPw = sc.nextLine();

	        if (userController.deleteUser(userId, userPw)) {
	            System.out.println("회원탈퇴 성공!");
	        } else {
	            System.out.println("회원탈퇴 실패! 아이디 또는 비밀번호를 확인해주세요.");
	        }
	    }

}
