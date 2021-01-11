package com.example.javaBackendPractice;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.Hashtable;

@SpringBootApplication
public class JavaBackendPracticeApplication {
	public static class UserInfo  implements Serializable {
		private static String Username;
		private static String Address;
		private static String Birthdate;
		private static String City;
		private static String State;
		private static String Zip;
		private static Document UserInformation;
		private static Hashtable<String, Document> Collection;

		public String getUsername() {
			return Username;
		}

		public UserInfo(String Username, String Address, String Birthdate, String City, String State, String Zip) {
			this.Username = Username;
			this.Address = Address;
			this.Birthdate = Birthdate;
			this.City = City;
			this.State = State;
			this.Zip = Zip;
			this.Collection = new Hashtable<String,Document>();
			this.UserInformation = new Document();
			this.UserInformation.put("Birthdate",this.Birthdate);
			this.UserInformation.put("Address",this.Address);
			this.UserInformation.put("City",this.City);
			this.UserInformation.put("State",this.State);
			this.UserInformation.put("Zip",this.Zip);
			this.Collection.put(this.Username,this.UserInformation);
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

	/*
	public static void main(String[] args) {
		SpringApplication.run(JavaBackendPracticeApplication.class, args);
		UserInfo user = new UserInfo("Boba","123 Fake St", "1/11/11","Iowa City","Iowa", "52245");
		System.out.println(user.Collection);
		//Game();
		com.example.javaBackendPractice.User newUser = new com.example.javaBackendPractice.User();
		//User.CreateUser(user.Collection);
		//User.EditUser(user.Username,user.UserInformation);
	}*/
	}