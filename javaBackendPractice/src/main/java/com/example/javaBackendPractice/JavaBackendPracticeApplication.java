package com.example.javaBackendPractice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaBackendPracticeApplication {
	public static class CreateUser {
		public static String Username;
		public static String Password;

		public CreateUser(String Username, String Password) {
			this.Username = Username;
			this.Password = Password;
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(JavaBackendPracticeApplication.class, args);
		CreateUser user = new CreateUser("Bob","Password");
		System.out.println(user.Username);
}
	}