package EncryptDecrypt;

import java.util.Scanner;

public class encDec {

	public static void main(String[] args) {
		// Classes defined
		Scanner input = new Scanner(System.in);
		Caesar c = new Caesar();
		Vignere v = new Vignere();
		RSA rsa = new RSA();
		// Getting User Input
//		System.out.print("Input phrase user wants to encrypt: ");
//		String userInput = input.nextLine();
//		System.out.print("Input key for algorithm: ");
//		String userKey = input.nextLine();
		
		// Calling Caesar Class
//		int key = Integer.parseInt(userKey);
//		String k = c.Encrypt(userInput, key);
//		String j = c.Decrypt(k, key);
//		String k = v.Encrypt(userInput,userKey);
//		String j = v.Decrypt(k, userKey);
//		System.out.println(k);
//		System.out.println(j);
//		System.out.println(r.rsaEncypt());\
		String m = input.nextLine();
		System.out.print("Prime 1: ");
		int p = input.nextInt();
		System.out.println(p);
		System.out.print("Prime 2: ");
		int q = input.nextInt();
		System.out.println(q);
		int n = p*q;
		System.out.println("Your modulo number is: "+n);
		int r = (p-1)*(q-1);
		System.out.println("Your r number is: "+n);
		rsa.rsaEncrypt(m, n, r);
		System.out.print("Enter your Private: " );
		int d = input.nextInt();
		input.nextLine();
		System.out.print("Enter your Cipher: " );
		String cipher = input.nextLine();
		rsa.rsaDecrypt(cipher, n, d);
		input.close();
	}

}
