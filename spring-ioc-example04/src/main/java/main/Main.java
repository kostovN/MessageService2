package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyConfig;
import domain.User;
import service.UserService;
@Component(value = "main")
public class Main {
	
	public static void main(String[] args) {
		//kreirairati kontejner
		BeanFactory container = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService userService = container.getBean("userServiceArrayList",UserService.class);
		//iz kontejnera uzeti main objekat
		Main main = container.getBean("main",Main.class);
		//dohvatim user i posatavim vrednosti....
		User user1 = container.getBean("user",User.class);
		user1.setFirstname("Natalija");
		user1.setLastname("Kostov");
		user1.setUsername("nata");
		user1.setPassword("nata");
		main.addUser(userService,user1);
		
		User user2 = container.getBean("user",User.class);
		user2.setFirstname("Natalija2");
		user2.setLastname("Kostov2");
		user2.setUsername("nata2");
		user2.setPassword("nata2");
		main.addUser(userService,user2);
		//pozvati metodu: void addUser(User user)
		
		//pozovem metodu: void printUsers()
		main.printUsers(userService);
		
		
	}
	
	void addUser(UserService userService, User user) {
		//poziv service-a
		System.out.println("=================void addUser(UserService userService, User user)========================");
		userService.save(user);
	}
	void printUsers(UserService userService) {
		userService.print();
		
	}
	
	

}
