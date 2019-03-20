package com.example.basicauthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.example.basicauthentication.User;
import com.example.basicauthentication.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
    UserRepository userRepository;

	@Override
	public void createUser(User user) {
		User userInsert = new User();
		userInsert.setEmail(user.getEmail());
		userInsert.setPassword(user.getPassword());
		userRepository.save(userInsert);
	}

	@Override
	public Iterable<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		Optional<User> user =  userRepository.findById(id);
		return user.orElse(null);
	}

	@Override
	public User update(User user, long id) {
		User userUpdate = findById(id);
		userUpdate.setEmail(user.getEmail());
		userRepository.save(userUpdate);
		return userUpdate;
	}

	@Override
	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userRepository.getUserByEmail(email);
		return user;
	}

}
