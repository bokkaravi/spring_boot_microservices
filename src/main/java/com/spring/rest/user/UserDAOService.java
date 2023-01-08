package com.spring.rest.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.criteria.Predicate;

@Component
public class UserDAOService {
	
	private static int id = 0;
	
	private static List<User> users = new ArrayList<>();
	
	static {
		
		users.add(new User("ravi",++id,LocalDate.now().minusYears(24)));
		users.add(new User("sai",++id,LocalDate.now().minusYears(23)));
		users.add(new User("bingi",++id,LocalDate.now().minusYears(22)));
		
	}
	
	public User createUser(User user) {
		user.setId(++id);
		users.add(user);
		return user;
	}

	public List<User> findAll() {
			return users;
	}

	public User findOne(int id) {
		return users.stream().filter(user-> user.getId() == id).findFirst().orElse(null);
	}

	public void deleteById(int id) {
		users.removeIf(user -> user.getId() ==id);	
	}

}
