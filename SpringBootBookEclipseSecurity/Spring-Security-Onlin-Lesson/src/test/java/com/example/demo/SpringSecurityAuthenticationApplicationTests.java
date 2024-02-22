package com.example.demo;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SpringSecurityAuthenticationApplicationTests {	
	public static void main(String[] args) {
		// Hashing Algorithm - BCrypt
		/*
		 * Introduction of BCrypt:
		 * 		
		 * 		BCrypt is a one-way hashing algorithm, meaning that it converts the input (password) into a fixed-size hash, 
		 * 		but it is computationally infeasible to reverse this process or to determine the original input from the hash alone. 
		 * 
		 * 		This makes it suitable for securely storing passwords in databases.
		 * 
		 * PasswordEncoder Interface Implementation:
		 * 		
		 * 		BCryptPasswordEncoder implements the PasswordEncoder interface provided by Spring Security. 
		 * 		This interface defines methods for encoding and verifying passwords.
		 * 
		 * Salting: 
		 * 		
		 * 		BCrypt automatically handles salting, which is a technique used to add randomness to the hashing process. Salting prevents attackers from using precomputed hash tables (rainbow tables) to crack passwords more easily.
		 * 
		 * Strength Configuration:
		 * 		
		 * 		BCrypt allows you to configure the strength of the hashing algorithm by specifying the number of hashing rounds. 
		 * 		The higher the number of rounds, the more computationally intensive the hashing process becomes, making it more resistant to brute-force attacks. 
		 * 
		 * 		The default strength is 10, but you can adjust it as needed.
		 * 
		 * Usage: 
		 * 		
		 * 		In Spring Security, you typically use the BCryptPasswordEncoder to encode passwords before storing them in a database. 
		 * 		When a user attempts to log in, you use the matches() method to verify if the entered password matches the stored (encoded) password.
		 * 
		 * Here's a breakdown of structure for BCrypt hash: 
		 * 		
		 * 		E.g., $2a$10$b3hQKZ55KuX17Qqb0pGVo.qPI6BNDsZA9DFtTqASVbQWMqCanBzM2
		 * 		
		 * 		1. $2a$: 
		 * 			  This portion indicates the version of the BCrypt algorithm being used. 
		 *            In this case, it's version 2a. The "2a" signifies a specific version of the algorithm and helps ensure compatibility.
		 *      2. 10$: 
		 *      	  This part represents the cost factor or the number of hashing rounds used by the algorithm. 
		 *      	  The higher the cost factor, the more computationally intensive the hashing process becomes. 
		 *            In this case, "10" means 2^10 rounds (1024 rounds).
		 *            
		 *      3. b3hQKZ55KuX17Qqb0pGVo.: 
		 *      	  This is the salt portion of the hash. 
		 *            The salt is randomly generated for each password and is used to add complexity to the hashing process. 
		 *            It helps defend against attacks such as rainbow table attacks.
		 *            
		 *      4. qPI6BNDsZA9DFtTqASVbQWMqCanBzM2: 
		 *      	  This is the hashed password itself. 
		 *      	  It's the result of applying the BCrypt algorithm to the combination of the original password and the salt. 
		 *      	  This portion is what's stored in the database.
		 *      
		 *      5. In summary:
		 *      	  The output "$2a$10$b3hQKZ55KuX17Qqb0pGVo.qPI6BNDsZA9DFtTqASVbQWMqCanBzM2" represents a BCrypt hash with version 2a, 
		 *      	  a cost factor of 10 (meaning 1024 rounds of hashing), a randomly generated salt, and the hashed password.
		 *      
		 *	References:
		 *		1.	  https://stackoverflow.com/questions/6832445/how-can-bcrypt-have-built-in-salts
		 */
		int strength = 10; // Default strength 
		PasswordEncoder pe = new BCryptPasswordEncoder(strength);
		String encode = pe.encode("1234");				
		System.out.println(encode); // 
		boolean matches = pe.matches("1234", encode);
		System.out.println(matches); 
		
		System.out.println();
		
		String encode2 = pe.encode("1234");
		System.out.println(encode2);
		boolean matches2 = pe.matches("1234", encode2);
		System.out.println(matches2);	
	}	
}