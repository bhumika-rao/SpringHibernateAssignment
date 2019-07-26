package org.attra.spring.hibernate.dao;

import java.util.List;

import org.attra.spring.hibernate.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<UserDetails> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UserDetails> userList = session.createQuery("from UserDetails").list();
		return userList;
	}

	public UserDetails getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails user = (UserDetails) session.get(UserDetails.class, new Integer(id));
		return user;
	}

	public void addUser(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(userDetails);
	}

	public void updateUser(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userDetails);
		
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails user = (UserDetails) session.load(UserDetails.class, new Integer(id));
		if (null != user) {
			session.delete(user);
		}
	}

}
