package tn.ddops.demo.services;

import tn.ddops.demo.entities.User;

public interface IUserService {
	
	public User addUser(User user);
	
	public User getUserById(long id);
	
	public User findById(long id);

	public User findByUsername(String userName);
	
	
}
