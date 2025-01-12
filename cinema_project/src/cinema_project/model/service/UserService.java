package cinema_project.model.service;

import java.sql.Connection;
import java.util.Optional;

import cinema_project.model.dao.UserDao;
import cinema_project.model.vo.User;

public class UserService {
	private UserDao userDao = new UserDao();

    /**
     * 회원가입 요청 처리
     * @param user 회원 정보를 담고 있는 User 객체
     * @return 회원가입 성공 여부
     */
    public boolean registerUser(User user) {
        // 비즈니스 로직: 입력값 검증
        if (user.getUserId() == null || user.getUserPw() == null || user.getUserName() == null) {
            System.err.println("회원가입 실패: 필수 입력값 누락");
            return false;
        }
        if (userDao.findUserById(user.getUserId()).isPresent()) {
            System.err.println("회원가입 실패: 중복된 아이디");
            return false;
        }

        // 데이터베이스에 사용자 추가
        return userDao.createUser(user);
    }

    /**
     * 로그인 요청 처리
     * @param userId 사용자 아이디
     * @param userPw 사용자 비밀번호
     * @return 로그인 성공 시 Optional<User>, 실패 시 Optional.empty()
     */
    public Optional<User> loginUser(String userId, String userPw) {
        // 비즈니스 로직: 입력값 검증
        if (userId == null || userPw == null) {
            System.err.println("로그인 실패: 아이디 또는 비밀번호 누락");
            return Optional.empty();
        }
        return userDao.login(userId, userPw);
    }

    /**
     * 아이디로 사용자 검색
     * @param userId 사용자 아이디
     * @return 검색된 사용자 정보 (Optional)
     */
    public Optional<User> findUserById(String userId) {
        // 비즈니스 로직: 입력값 검증
        if (userId == null || userId.isBlank()) {
            System.err.println("아이디 찾기 실패: 유효하지 않은 입력");
            return Optional.empty();
        }
        return userDao.findUserById(userId);
    }

    /**
     * 회원탈퇴 처리
     * @param userId 사용자 아이디
     * @param userPw 사용자 비밀번호
     * @return 회원탈퇴 성공 여부
     */
    public boolean deleteUser(String userId, String userPw) {
        // 비즈니스 로직: 입력값 검증
        if (userId == null || userPw == null) {
            System.err.println("회원탈퇴 실패: 아이디 또는 비밀번호 누락");
            return false;
        }
        return userDao.deleteUser(userId, userPw);
    }
}