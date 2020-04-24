package com.occamsrazor.web.user;

public interface UserServer {
	
	public void add(User user);
	public User login(User user);
	public User detail(String userid);
	public int count();
	public boolean update(User user);
	public boolean remove(String userid);
}
