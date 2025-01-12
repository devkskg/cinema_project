package cinema_project.controller;

import java.util.Optional;

import cinema_project.model.dao.UserDao;
import cinema_project.model.vo.User;

public class UserController {
	 private UserDao userDao = new UserDao();

	    public boolean createUser(User user) {
	        return userDao.createUser(user);
	    }

	    public Optional<User> login(String userId, String userPw) {
	        return userDao.login(userId, userPw);
	    }

	    public Optional<User> findUserById(String userId) {
	        return userDao.findUserById(userId);
	    }

	    public boolean deleteUser(String userId, String userPw) {
	        return userDao.deleteUser(userId, userPw);
	    }
	}