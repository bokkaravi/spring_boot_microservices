package com.spring.rest.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.rest.user.exception.UserNotFoundException;

import jakarta.validation.Valid;



@RestController
public class UserController {
	
	@Autowired
	UserDAOService userdaoService;
	
	
	@GetMapping(path = "/users")
	public List<User> getAllusers(){
		return userdaoService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getOneUser(@PathVariable int id) {
		
		User user = userdaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id");
		}
		return user;
	}
	

	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		
		User savedUser = userdaoService.createUser(user);
		
		//return URI as response in headers in location path
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
						.path("/{id}").
						buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userdaoService.deleteById(id);
	}

}
