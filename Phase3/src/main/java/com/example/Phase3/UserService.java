package com.example.Phase3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<Users> showAll() {
		List<Users> users= userRepository.findAll();
		return users;
	}
	
	public String showUserName(long id) {
		Optional<Users> user = userRepository.findById(id);
		if(user.isEmpty()) {
			return "USER_NOT_FOUND";
		}
		else {
			return user.get().getName();
		}
	}
}
