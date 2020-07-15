package xroigmartin.userintegrationtest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import xroigmartin.userintegrationtest.entity.User;
import xroigmartin.userintegrationtest.hibernate.utils.HibernateUtils;
import xroigmartin.userintegrationtest.repository.UserRepository;
import xroigmartin.userintegrationtest.repository.impl.UserRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		
		UserRepository userRepository = new UserRepositoryImpl(HibernateUtils.getSessionFactory());
		
		User user1 = new User("Pepe", "pepe34");
		User user2 = new User("Monica", "monic65");
		
		userRepository.create(user1);
		userRepository.create(user2);
		
		System.out.println("---- Reading users from database ---");
		List<User> users = userRepository.read();
		users.forEach(user ->{
			System.out.println(user.toString());
		});
		
		user1.setName("Oscar");
		userRepository.update(user1);
		
		user2.setUsername("monicaAlvarez74");
		userRepository.update(user2);
		
		System.out.println("---- Reading users from database ---");
		List<User> users2 = userRepository.read();
		users2.forEach(user ->{
			System.out.println(user.toString());
		});
		
		userRepository.delete(user1);
		
		System.out.println("---- Reading users from database ---");
		List<User> users3 = userRepository.read();
		users3.forEach(user ->{
			System.out.println(user.toString());
		});
	}
}
