package cinema_project.view;

import java.util.Scanner;

import cinema_project.controller.UserController;
import cinema_project.model.vo.User;

public class MainMenu {
	 private Scanner sc = new Scanner(System.in);
	    private UserController userController = new UserController();

	    public void mainMenu() {
	        while (true) {
	            System.out.println("===== 10nema 영화관 =====");
	            System.out.println("1. 로그인");
	            System.out.println("2. 회원가입");
	            System.out.println("3. 아이디, 비밀번호 찾기");
	            System.out.println("0. 종료");
	            System.out.print("메뉴 선택: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1: login(); break;
	                case 2: createUser(); break;
	                case 3: searchUserInfoByIdPw(); break;
	                case 0: System.out.println("프로그램을 종료합니다."); return;
	                default: System.out.println("잘못된 입력입니다.");
	            }
	        }
	    }

	    private void login() {
	        System.out.print("아이디: ");
	        String userId = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String userPw = sc.nextLine();

	        User user = userController.login(userId, userPw);
	        if (user != null) {
	            System.out.println(user.getUserName() + "님, 환영합니다!");
	        } else {
	            System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
	        }
	    }

	    private void createUser() {
	        System.out.print("아이디: ");
	        String userId = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String userPw = sc.nextLine();
	        System.out.print("이름: ");
	        String userName = sc.nextLine();
	        System.out.print("주민등록번호: ");
	        String userSsn = sc.nextLine();
	        System.out.print("핸드폰 번호: ");
	        String userPhone = sc.nextLine();

	        User user = new User();
	        user.setUserId(userId);
	        user.setUserPw(userPw);
	        user.setUserName(userName);
	        user.setUserSsn(userSsn);
	        user.setUserPhone(userPhone);
	        user.setIsAdmin("N");

	        if (userController.createUser(user)) {
	            System.out.println("회원가입 성공!");
	        } else {
	            System.out.println("중복된 아이디 또는 핸드폰 번호입니다.");
	        }
	    }

	    private void searchUserInfoByIdPw() {
	        System.out.print("이름: ");
	        String userName = sc.nextLine();
	        System.out.print("주민등록번호: ");
	        String userSsn = sc.nextLine();
	        System.out.print("핸드폰 번호: ");
	        String userPhone = sc.nextLine();

	        User user = userController.searchUserInfoByIdPw(userName, userSsn, userPhone);
	        if (user != null) {
	            System.out.println(userName + "님의 사용자 정보 조회 결과입니다.");
	            System.out.println("아이디: " + user.getUserId());
	            System.out.println("비밀번호: " + user.getUserPw());
	        } else {
	            System.out.println("일치하는 정보의 사용자가 없습니다.");
	        }
	    }
	}