package cinema_project.model.service;

import cinema_project.model.dao.UserDao;
import cinema_project.model.vo.User;

public class UserService {
	private UserDao userDao = new UserDao();

    public User login(String userId, String userPw) {
        return userDao.findUserByIdAndPassword(userId, userPw);
    }

    public boolean createUser(User user) {
        if (!userDao.isUserExists(user.getUserId(), user.getUserPhone())) {
            return userDao.insertUser(user);
        }
        return false;
    }

    public User searchUserInfoByIdPw(String userName, String userSsn, String userPhone) {
        return userDao.searchUserInfoByIdPw(userName, userSsn, userPhone);
    }
}