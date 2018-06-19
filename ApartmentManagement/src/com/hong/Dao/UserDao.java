package com.hong.Dao;

import com.hong.bean.User;

public interface UserDao {
	public User getUserbyUsername(String name);	
	public void ChangeUser(User user);
}