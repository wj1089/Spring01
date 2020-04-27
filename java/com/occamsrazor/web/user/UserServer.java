package com.occamsrazor.web.user;

import java.util.List;

public interface UserServer {
	
	public void add(User user);
	public User login(User user);
	public User detail(String userid);
	public int count();
	public boolean update(User user);
	public boolean remove(String userid);
	public List<User> list();
	public void saveFile(User user);
	public List<User>readFile();
	
}
