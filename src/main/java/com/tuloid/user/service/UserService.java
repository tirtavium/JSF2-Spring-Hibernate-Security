package com.tuloid.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tuloid.model.User;
import com.tuloid.user.dao.IUserDAO;


@Transactional(readOnly = true)
public class UserService implements IUserService {

	// UserDAO is injected...
	IUserDAO userDAO;
	
	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void addUser(User user) {
		getUserDAO().addUser(user);
	}

	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}
	
	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	/**
	 * Get User List
	 * 
	 */
	public List<User> getUsers() {	
		return getUserDAO().getUsers();
	}

	/**
	 * Get User DAO
	 * 
	 * @return IUserDAO - User DAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 * 
	 * @param IUserDAO - User DAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
