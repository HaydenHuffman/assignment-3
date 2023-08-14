package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
		String username;
		String password;
		
		String[] userList = new String[4];
		User[] users = new User[4];
		
		int count = 0;
		
		UserService userService = new UserService();
	
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line = "";
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				userList[i] = line;
				i++;
			}
		} finally {
			fileReader.close();
		}
		
		
		for (int i = 0; i < userList.length; i++) {
		    String[] userInfo = userList[i].split(",");
			users[i] = userService.createUser(userInfo);
		}
		
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		
		while (count < 5 && flag == false) {
			System.out.println("Enter your email:");
			username = (scanner.nextLine()).toLowerCase();
			System.out.println("Enter your password:");
			password = scanner.nextLine();
			
			for (int i = 0; i < userList.length; i++ ) {
				if (username.equals(users[i].getUsername())  && password.equals(users[i].getPassword())) {
					flag = true;
					System.out.println("Welcome: " + users[i].getName());
			}
		} 
		
			if (!flag && count < 5) {
				count++;
				if (count < 5 ) {
					System.out.println("Invalid login, please try again");
				} else {
					System.out.println("Too many failed login attempts, you are now locked out");
				}
			}
			
		}
	}
}
	
				
		


