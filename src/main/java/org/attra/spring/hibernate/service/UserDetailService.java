package org.attra.spring.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.attra.spring.hibernate.dao.*;
import org.attra.spring.hibernate.model.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userDetailService")
public class UserDetailService {
	
	@Autowired
	UserDetailDAO userDetailDao;
	
	@Transactional
	public List<UserDetails> getAllUsers() {
		// TODO Auto-generated method stub
		return userDetailDao.getAllUsers();
	}

	@Transactional
	public UserDetails getUser(int id) {
		// TODO Auto-generated method stub
		return userDetailDao.getUser(id);
	}

	@Transactional
	public void addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		userDetailDao.addUser(userDetails);
	}

	@Transactional
	public void updateUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		userDetailDao.updateUser(userDetails);
	}

	@Transactional
	public void deleteuser(int id) {
		// TODO Auto-generated method stub
		userDetailDao.deleteUser(id);
	}

}
