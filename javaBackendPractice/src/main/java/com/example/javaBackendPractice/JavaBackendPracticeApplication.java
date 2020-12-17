package com.example.javaBackendPractice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
	public static class Game{
		private static Integer Guesses;
		public void setGuesses(Integer guess){
			this.Guesses = guess;
		}
		public Integer getGuesses(){return Guesses;}
	}
	}
	public static void Game(){
		System.out.println("Guess a number between 1 and ?");
		Integer x = -100; Integer z ;
		Scanner in = new Scanner(System.in);
		String y = in.nextLine();
		Random randomGenerator = new Random();
		x = Integer.parseInt(y);
		if (x == null){return;}
		else{
			z = randomGenerator.nextInt(x);
		}
		x = -100;
		for(int i = 0; i< 5; i++) {
			try {
				y = in.nextLine();
				x = Integer.parseInt(y);
				if (x == null | x == 0) {
					return;
				} else if (x == z) {
					System.out.println("WINNER");
					return;
				}
				else if ( x > z){
					System.out.println("Lower");
				}
				else {
					System.out.println("Higher");
				}
			} catch (Exception e) {
				System.out.print("Exception");
			}
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
		Game();
	}
	}