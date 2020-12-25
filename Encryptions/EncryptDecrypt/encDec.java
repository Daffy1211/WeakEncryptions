package EncryptDecrypt;

import java.util.Scanner;

public class encDec {

	public static void main(String[] args) {
		// Classes defined
		Scanner input = new Scanner(System.in);
		Caesar c = new Caesar();
		Vignere v = new Vignere();
		// Getting User Input
		System.out.print("Input phrase user wants to encrypt: ");
		String userInput = input.nextLine();
		System.out.print("Input key for algorithm: ");
		String userKey = input.nextLine();
		
		// Calling Caesar Class
//		int key = Integer.parseInt(userKey);
//		String k = c.Encrypt(userInput, key);
//		String j = c.Decrypt(k, key);
		String k = v.Encrypt(userInput,userKey);
		
		System.out.println(k);
//		System.out.println(j);
		input.close();
	}

}
