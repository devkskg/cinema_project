package cinema_project.controller;

import cinema_project.model.service.UserService;
import cinema_project.model.vo.User;

public class UserController {
	private UserService userService = new UserService();

    public User login(String userId, String userPw) {
        return userService.login(userId, userPw);
    }

    public boolean createUser(User user) {
        return userService.createUser(user);
    }

    public User searchUserInfoByIdPw(String userName, String userSsn, String userPhone) {
        return userService.searchUserInfoByIdPw(userName, userSsn, userPhone);
    }
}