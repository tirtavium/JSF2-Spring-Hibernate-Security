package com.tuloid.user.dao;

import java.util.List;

import com.tuloid.model.User;


public interface IUserDAO {

	/**
	 * Add User
	 * 
	 * @param  User user
	 */
	public void addUser(User user);
	
	/**
	 * Update User
	 * 
	 * @param  User user
	 */
	public void updateUser(User user);
	
	/**
	 * Delete User
	 * 
	 * @param  User user
	 */
	public void deleteUser(User user);
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	public User getUserById(int id);
	
	/**
	 * Get User List
	 * 
	 */
	public List<User> getUsers();
	
	public User findUser(String username);
}
