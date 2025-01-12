package cinema_project.view;

import java.util.Scanner;

import cinema_project.controller.UserController;
import cinema_project.model.vo.User;

public class UserMenu {
	 private Scanner sc = new Scanner(System.in);
	    private UserController uc = new UserController();

	    public void MainMenu() {
	        while (true) {
	            System.out.println("=== 10nema 영화관 ===");
	            System.out.println("1. 로그인");
	            System.out.println("2. 회원가입");
	            System.out.println("3. 아이디, 비밀번호 찾기");
	            System.out.println("4. 회원탈퇴");
	            System.out.println("0. 종료");
	            System.out.print("선택: ");
	            int menu = sc.nextInt();
	            sc.nextLine();

	            switch (menu) {
	                case 1: login(); break;
	                case 2: createUser(); break;
	                case 3: searchUserInfoIdPw(); break;
	                case 4: deleteUser(); break;
	                case 0: System.out.println("이용해주셔서 감사합니다."); return;
	                default: System.out.println("잘못된 입력입니다.");
	            }
	        }
	    }

	    private void login() {
	        System.out.print("아이디: ");
	        String id = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String pw = sc.nextLine();

	        User user = uc.login(id, pw);
	        if (user != null) {
	            System.out.println(user.getuName() + "님, 로그인 성공!");
	        } else {
	            System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
	        }
	    }

	    private void createUser() {
	        System.out.print("아이디: ");
	        String id = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String pw = sc.nextLine();
	        System.out.print("이름: ");
	        String name = sc.nextLine();
	        System.out.print("주민등록번호: ");
	        String ssn = sc.nextLine();
	        System.out.print("전화번호: ");
	        String phone = sc.nextLine();

	        User user = new User(0, id, pw, name, ssn, phone, "N");
	        int result = uc.createUser(user);
	        if (result > 0) {
	            System.out.println("회원가입 성공!");
	        } else {
	            System.out.println("회원가입 실패.");
	        }
	    }

	    private void searchUserInfoIdPw() {
	        System.out.print("아이디를 입력하세요: ");
	        String id = sc.nextLine();

	        User user = uc.searchUserInfoIdPw(id);
	        if (user != null) {
	            System.out.println("아이디: " + user.getuId());
	            System.out.println("이름: " + user.getuName());
	            System.out.println("전화번호: " + user.getuPhone());
	        } else {
	            System.out.println("정보를 찾을 수 없습니다.");
	        }
	    }

	    private void deleteUser() {
	        System.out.print("아이디: ");
	        String id = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String pw = sc.nextLine();

	        int result = uc.deleteUser(id, pw);
	        if (result > 0) {
	            System.out.println("회원탈퇴 성공!");
	        } else {
	            System.out.println("회원탈퇴 실패.");
	        }
	    }
	}
	
