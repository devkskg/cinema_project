package cinema_project.model.service;

import java.sql.Connection;

import cinema_project.common.JDBCTemplate;
import cinema_project.model.dao.Dao;
import cinema_project.model.vo.User;

public class Service {
	 private Dao userDao = new Dao();

	    public int createUser(User user) {
	        Connection conn = JDBCTemplate.getConnection();
	        int result = userDao.createUser(conn, user);
	        JDBCTemplate.close(conn);
	        return result;
	    }

	    public String loginUser(User user) {
	        Connection conn = JDBCTemplate.getConnection();
	        String name = userDao.loginUser(conn, user);
	        JDBCTemplate.close(conn);
	        return name;
	    }

	    public int deleteUser(User user) {
	        Connection conn = JDBCTemplate.getConnection();
	        int result = userDao.deleteUser(conn, user);
	        JDBCTemplate.close(conn);
	        return result;
	    }
	    public User searchUserInfossnph(User user) {
	    	Connection conn = JDBCTemplate.getConnection();
	    	User searchuser = userDao.searchUserInfossnph(conn ,user);
	    	JDBCTemplate.close(conn);
	    	return searchuser;
	  
	    	
	    }
	}