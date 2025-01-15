package cinema_project.view;

import java.util.Scanner;

import cinema_project.controller.Controller;

public class Menu {
	 private Scanner sc = new Scanner(System.in);
	    private Controller userController = new Controller();

	    public void mainMenu() {
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
	                case 0: System.out.println("프로그램을 종료합니다."); return;
	                default: System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
	            }
	        }
	    }
	    private void searchUserInfossnph() {
	    	System.out.println("=== 아이디,비밀번호 찾기 ===");
	    	System.out.print("이름 : ");
	    	String userName = sc.nextLine();
	    	System.out.print("주민번호 : ");
	    	String userSsn = sc.nextLine();
	    	System.out.print("전화번호 : ");
	    	String userPhone = sc.nextLine();
	    	
	    	userController.searchUserInfossnph(userName,userSsn,userPhone);
	    }
	    private void createUser() {
	        System.out.println("=== 회원가입 ===");
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
	        
	        userController.createUser(userId, userPw, userName, userSsn, userPhone);
	        
	    }
	    private void loginUser() {
	        System.out.println("=== 로그인 ===");
	        System.out.print("아이디: ");
	        String userId = sc.nextLine();
	        System.out.print("비밀번호: ");
	        String userPw = sc.nextLine();

	        userController.loginUser(userId, userPw);
	    }
	  
	    
	    public void goodee() {}
	    
	}
	

