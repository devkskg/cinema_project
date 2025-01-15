package cinema_project.controller;

import cinema_project.model.service.Service;
import cinema_project.model.vo.User;

public class Controller {
	private Service userService = new Service();

    public void createUser(String userId, String userPw, String userName, String userSsn, String userPhone) {
        User user = new User();
        user.setUserId(userId);
        user.setUserPw(userPw);
        user.setUserName(userName);
        user.setUserSsn(userSsn);
        user.setUserPhone(userPhone);

        int result = userService.createUser(user);
        if (result > 0) {
            System.out.println("회원가입 성공!");
        } else {
            System.out.println("회원가입 실패!");
        }
    }

    public void loginUser(String userId, String userPw) {
        User user = new User();
        user.setUserId(userId);
        user.setUserPw(userPw);

        String name = userService.loginUser(user);
        if (name == null) {
            System.out.println("로그인 실패: 잘못된 아이디 또는 비밀번호입니다.");
        } else {
            System.out.println(name + "님, 환영합니다!");
        }
    }

    public void deleteUser(String userId, String userPw) {
        User user = new User();
        user.setUserId(userId);
        user.setUserPw(userPw);

        int result = userService.deleteUser(user);
        if (result > 0) {
            System.out.println("회원탈퇴 성공!");
        } else {
            System.out.println("회원탈퇴 실패!");
        }
    }
    public void searchUserInfossnph(String userName ,String userSsn, String userPhone) {
    	User user = new User();
    	user.setUserName(userName);
    	user.setUserSsn(userSsn);
    	user.setUserPhone(userPhone);
    	User name = userService.searchUserInfossnph(user);
    	if(name == null) {
    		System.out.println("아이디, 비밀번호 찾기 실패 : 일치하는 정보의 사용자가 없습니다.");
    	} else {
    		System.out.println(name+"\n정보조회가 완료되었습니다.");
    	}
    	User searchuser = userService.searchUserInfossnph(user);
    	
    	
    }
}