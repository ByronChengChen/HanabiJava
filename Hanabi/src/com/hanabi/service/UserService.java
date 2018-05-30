package com.hanabi.service;

import java.sql.SQLException;

import com.hanabi.dao.UserDao;
import com.hanabi.domain.User;

public class UserService {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return new UserDao().getUserByUsernameAndPwd(username,password);
	}

}
