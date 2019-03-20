package com.example.basicauthentication;

import java.util.List;
import com.example.basicauthentication.User;

public interface UserService {
	 public void createUser(User user);
	    public Iterable<User> getUser();
	    public User findById(long id);
	    public User update(User user, long l);
	    public void deleteUserById(long id);
	    public User findUserByEmail(String email);
}
