package com.malachai.DojoAndNinja.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.malachai.DojoAndNinja.models.LoginUser;
import com.malachai.DojoAndNinja.models.User;
import com.malachai.DojoAndNinja.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User user, BindingResult result) {
		//Check for errors
		if (result.hasErrors()) {
			return null;
		}
		//check if passwords match
		if (!user.getConfirmPassword().equals(user.getPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Passwords do not match");
		}
		//check for email already in the database
		User emailCheck = userRepo.findByEmail(user.getEmail()).orElse(null);
		if (emailCheck != null) {
			result.rejectValue("email", "unique", "Email already in use");
		}
		//Check for errors again after looking at password and email
		if (result.hasErrors()) {
			return null;
		}
		//hash password
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		//returns new saved user
		return userRepo.save(user);
	}
	
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	//login and authentication area
	public User authenticate(LoginUser login, BindingResult result) {
		User userInDb = userRepo.findByEmail(login.getEmail()).orElse(null);
		
		if (userInDb == null) {
			result.rejectValue("email", "exists", "Invalid login attempt");
			return null;
		}
		if (!BCrypt.checkpw(login.getPassword(), userInDb.getPassword())) {
			result.rejectValue("email", "auth", "Invalid login attempt");
		}
		if (result.hasErrors()) {
			return null;
		}
		
		return userInDb;
	}
}
