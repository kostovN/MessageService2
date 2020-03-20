package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.UserDao;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public void save(User user) {
		System.out.println(userDao.getClass().getCanonicalName());
		userDao.save(user);
	}

	public void print() {
		userDao.print();
		
	}
//	@Autowired
//	@Qualifier(value = "arrayListDao")
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
	

	//print
}
