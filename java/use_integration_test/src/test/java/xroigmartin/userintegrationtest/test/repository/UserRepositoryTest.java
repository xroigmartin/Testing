package xroigmartin.userintegrationtest.test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import xroigmartin.userintegrationtest.entity.User;
import xroigmartin.userintegrationtest.repository.UserRepository;
import xroigmartin.userintegrationtest.repository.impl.UserRepositoryImpl;
import xroigmartin.userintegrationtest.test.hibernate.util.HibernateUtilTest;

class UserRepositoryTest {

	UserRepository userRepository;
	
	@BeforeEach
	public void init_repository() {
		userRepository = new UserRepositoryImpl(HibernateUtilTest.getSessionFactory());
	}
	
	@AfterEach
	public void destroy_repository() {
		HibernateUtilTest.closeSessionFactory();
	}
	
	@Test
	public void itShouldFindUsers() {
		User user = new User("Jose", "jose34");
		
		userRepository.create(user);
		
		List<User> users = userRepository.read();
		
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void itShouldNotFindUsers() {	
		List<User> users = userRepository.read();
		
		assertTrue(users.size() == 0);
	}
	
	@Test
	public void itShouldCreateUser() {
		User user = new User("Jose", "jose34");
		
		userRepository.create(user);
	}
	
	public void itShouldFindUser() {
		User user = new User("Jose", "jose34");
		
		userRepository.create(user);
		
		assertEquals(user, userRepository.findUserById(user.getId()));
	}
	
	@Test
	public void itShouldNotFindUser() {
		assertNull(userRepository.findUserById(1L));
	}
	
	@Test
	public void itShouldUpdateUser() {
		User user = new User("Manuel", "manuel75");
		userRepository.create(user);
		
		assertNotNull(userRepository.findUserById(user.getId()));
		
		user.setName("Oscar");
		user.setUsername("oscar342");
		
		userRepository.update(user);

		assertEquals(user, userRepository.findUserById(user.getId()));
	}
	
	@Test
	public void itShouldDeleteUser() {
		User user = new User("Manuel", "manuel75");
		userRepository.create(user);
		
		assertNotNull(userRepository.findUserById(user.getId()));
		
		userRepository.delete(user);
		
		assertNull(userRepository.findUserById(user.getId()));
	}

}
