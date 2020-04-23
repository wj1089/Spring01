package com.occamsrazor.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private Map<String, Object> map;//한건물이 아니라 더넓은 영역으로 확장
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public User login(User user) {
		User returnUser = null;
		if(map.containsKey(user.getUserid())){
			System.out.println();
			User u = detail(user.getUserid());
			if(user.getPasswd().equals(u.getPasswd())) {
			returnUser = u;
			}
		}
		return returnUser;
	}
	@Override
	public User detail(String userid) {
		return (User) map.get(userid);//(User) cast하기!
		
	}
	
}
