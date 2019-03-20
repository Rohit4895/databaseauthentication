package com.example.basicauthentication;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.basicauthentication.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("from user where email=:emailId")
	User getUserByEmail(@Param("emailId")String emailId);
	  
}
