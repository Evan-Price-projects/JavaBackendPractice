package com.example.javaBackendPractice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.attribute.standard.Chromaticity;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Hashtable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
@SpringBootApplication
public class JavaBackendPracticeApplication {
	public static class User {
		private static String Username;
		private static String Address;
		private static String Birthdate;
		private static String City;
		private static String State;
		private static String Zip;
		private static Hashtable<String, ArrayList> Collection;



		public User(String Username, String Address, String Birthdate, String City, String State, String Zip) {
			this.Username = Username;
			this.Address = Address;
			this.Birthdate = Birthdate;
			this.City = City;
			this.State = State;
			this.Zip = Zip;
			this.Collection = new Hashtable<String,ArrayList>();
			ArrayList<String> combo = new ArrayList<String>();
			combo.add(this.Username);
			combo.add(this.Address);
			combo.add(this.Birthdate);
			combo.add(this.City);
			combo.add(this.State);
			combo.add(this.Zip);
			this.Collection.put(this.Username,combo);
		}
	}
//********************************************************************
//	Game: Created by Evan Price
//  Inputs: System in
//  Outputs: System out
//	Goal: choose a number that is the same as the random number generated
//********************************************************************
	public static class Game{
		private static Integer Guesses;
		private static Integer Solution;

		public void setGuesses(Integer guess)
		{ if (guess != null){
			this.Guesses = guess;}
		}
		public Integer getGuesses(){return Guesses;}

		public void setSolution(Integer solution){
			Random rand = new Random();
			this.Solution = rand.nextInt(solution);
		}
		public Integer getSolution(){return Solution;}
	}
	public static void Game(){
		Game newGame = new Game();
		Integer x = -100; int z;

		System.out.println("Guess a number between 1 and ?");
		Scanner in = new Scanner(System.in);
		String guess = in.nextLine();
		newGame.setGuesses(Integer.parseInt(guess));
		if (newGame.Guesses == null){return;}
		else{
			newGame.setSolution(newGame.Guesses);
		}
		for(int i = 0; i< 5; i++) {
			try {
				guess = in.nextLine();
				newGame.setGuesses(Integer.parseInt(guess));
				if (newGame.getGuesses() == null | newGame.getGuesses() == 0) {
					return;
				} else if (newGame.getGuesses()== newGame.getSolution()) {
					System.out.println("WINNER");
					return;
				}
				else if ( newGame.getGuesses()  > newGame.getSolution()){
					System.out.println("Lower");
				}
				else {
					System.out.println("Higher");
				}
			} catch (Exception e) {
				System.out.print(e);
			}
		}
		System.out.println("The Solution was:" + newGame.getSolution());
	}

	public static void main(String[] args) {
		MongoDatabase
		SpringApplication.run(JavaBackendPracticeApplication.class, args);
		User user = new User("Bob","123 Fake St", "1/11/11","Iowa City","Iowa", "52245");
		System.out.println(user.Collection);
		//Game();
		MongoClient mongoClient = new MongoClient();
	}
	}