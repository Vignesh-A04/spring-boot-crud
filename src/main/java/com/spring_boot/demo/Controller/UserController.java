package com.spring_boot.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		

}
