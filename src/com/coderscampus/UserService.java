package com.coderscampus;

public class UserService {
	
	public User createUser(String[] input) {
		User user = new User();
		user.setUsername(input[0]);
		user.setPassword(input[1]);
		user.setName(input[2]);
		System.out.println("this users name is: " + user.getName());
		return user;
	}
	
	public String[] parseText(String input) {
		String[] output = input.split(",");
		System.out.println(output);
		return output;
	}
}
