package tn.ddops.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.ddops.demo.entities.User;
import tn.ddops.demo.repositories.UserRepository;



@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
		return userRepository.save(user);
	}


	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}


	@Override
	public User findByUsername(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(userName);
	}


	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
