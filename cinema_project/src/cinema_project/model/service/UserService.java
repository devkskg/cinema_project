package cinema_project.model.service;

import cinema_project.model.dao.UserDao;
import cinema_project.model.vo.User;

public class UserService {
	private UserDao userDao = new UserDao();

    // 로그인
    public User login(String id, String pw) {
        return userDao.login(id, pw);
    }

    // 회원가입
    public int createUser(User user) {
        return userDao.createUser(user);
    }

    // 아이디, 비밀번호 찾기
    public User searchUserInfoIdPw(String id) {
        return userDao.searchUserInfoIdPw(id);
    }

    // 회원탈퇴
    public int deleteUser(String id, String pw) {
        return userDao.deleteUser(id, pw);
    }
}