package com.spring_boot.demo.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.demo.Exception.ResourceNotFoundException;
import com.spring_boot.demo.Model.User;
import com.spring_boot.demo.entity.UserEntity;
import com.spring_boot.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/users")

public class UserController {
	@Autowired
	private UserRepository userRepository;
//	@GetMapping
//	public String getUSer() {
//		return "Hello world";
		
		@GetMapping
		public List<UserEntity> getUsers() {
//			return Arrays.asList(
//					new User(1L,"Vicky","vicky@gmail.com"),
//					new User(2L,"Yogi","yogi@gmail.com"),
//					new User(3L,"Diney","Diney@gmail.com"),
//					new User(3L,"Surey","Surey@gmail.com"));
			return userRepository.findAll();
	}
		@PostMapping
		public UserEntity createUser(@RequestBody UserEntity user) {
			return userRepository.save(user);
			
		}
		
		@GetMapping("/{id}")
		public UserEntity getUserById(@PathVariable Long id) {
			return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id : "+id));
		}
		
		@PutMapping("/{id}")
		public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
			UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id : "+id));
			userData.setEmail(user.getEmail());
			userData.setName(user.getName());
			return userRepository.save(userData);
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteUser(@PathVariable Long id) {
			UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id : "+id));
			userRepository.delete(userData);
			return ResponseEntity.ok().build();
		}
		

}
