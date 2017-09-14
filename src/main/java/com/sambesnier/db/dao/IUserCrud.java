package com.sambesnier.db.dao;

import com.sambesnier.db.models.User;

public interface IUserCrud {
	
	public void createUser(User user);
	
	public void getUser(int id);
	
	public void upduateUser(User user);
	
	public void deleteUser(User user);

	
}
