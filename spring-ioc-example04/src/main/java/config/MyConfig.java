package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import dao.UserDao;
import dao.impl.UserArrayListDao;
import dao.impl.UserLinkedListDao;
import domain.User;
import main.Main;
import service.UserService;
import service.impl.UserServiceImpl;

@ComponentScan(basePackages = {
		"domain",
		"dao.impl",
		"main",
		
})
public class MyConfig {
	
	@Bean (name = "userServiceLinkedList")
	public UserService getUserServiceLinkedList (@Qualifier("linkedListDao")UserDao userDao) {
		return new UserServiceImpl(userDao);
	}
	
	@Bean (name = "userServiceArrayList")
	public UserService getUserServiceArrayList (@Qualifier("arrayListDao")UserDao userDao) {
		return new UserServiceImpl(userDao);
	}
	
	
}
