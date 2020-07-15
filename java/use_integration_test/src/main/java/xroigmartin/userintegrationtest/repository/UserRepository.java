package xroigmartin.userintegrationtest.repository;

import java.util.List;

import xroigmartin.userintegrationtest.entity.User;

public interface UserRepository {
	void create(User user);
	List<User> read();
	User findUserById(Long id);
	void update(User user);
	void delete(User user);
}
