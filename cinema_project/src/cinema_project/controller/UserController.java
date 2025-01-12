package cinema_project.controller;

import cinema_project.model.service.UserService;
import cinema_project.model.vo.User;

public class UserController {
	 private UserService userService = new UserService();

	    // 로그인
	    public User login(String id, String pw) {
	        return userService.login(id, pw);
	    }

	    // 회원가입
	    public int createUser(User user) {
	        return userService.createUser(user);
	    }

	    // 아이디, 비밀번호 찾기
	    public User searchUserInfoIdPw(String id) {
	        return userService.searchUserInfoIdPw(id);
	    }

	    // 회원탈퇴
	    public int deleteUser(String id, String pw) {
	        return userService.deleteUser(id, pw);
	    }
	}