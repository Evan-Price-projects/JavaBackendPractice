package com.example.javaBackendPractice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JavaBackendPracticeApplication {
	public static class User {
		private static String Username;

		public User(String Username) {
			this.Username = Username;
		}
	}
	public static class CreateGame {
		private static Integer PlayerNumber;
		private static List PlayerNames;
		public CreateGame (Integer PlayerNumber, List PlayerNames) {
			this.PlayerNumber = PlayerNumber;
			this.PlayerNames = PlayerNames;
		}
	public static class GameLobby{

	}
	}
	public static void main(String[] args) {
		SpringApplication.run(JavaBackendPracticeApplication.class, args);
		User user = new User("Bob");
		System.out.println(user.Username);
		List<String> list = new ArrayList<String>();
		list.add("Evan");
		list.add("Andrew");
		list.add("Jacob");
		list.add("Rachel");
		list.add("Eli");
		CreateGame game = new CreateGame (5, list);
		System.out.println(game.PlayerNames);
}
	}