package xroigmartin.userintegrationtest.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import xroigmartin.userintegrationtest.entity.User;
import xroigmartin.userintegrationtest.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{

	private final SessionFactory sessionFactory;
	
	public UserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void create(User user) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<User> read() {
		List<User> users = new ArrayList<>();
		try(Session session = sessionFactory.openSession()){
			users = session.createQuery("from User", User.class).list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public void update(User user) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public User findUserById(Long id) {
		User user = null;
		try(Session session = sessionFactory.openSession()){
			user = session.get(User.class, id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
