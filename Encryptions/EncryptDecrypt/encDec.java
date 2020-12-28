package EncryptDecrypt;

import java.util.Scanner;

public class encDec {

	public static void main(String[] args) {
		// Classes defined
		Scanner input = new Scanner(System.in);
		Scanner choice = new Scanner(System.in);
		Caesar c = new Caesar();
		Vignere v = new Vignere();
		RSA rsa = new RSA();
		// Getting User Input
		System.out.println("Choose between Encryption/Decryption");
		System.out.println("-------------------------------------");
		System.out.println("Caesar Encryption = 0");
		System.out.println("Caesar Decryption = 1");
		System.out.println("Vignere Encryption = 2");
		System.out.println("Vignere Decryption = 3");
		System.out.println("RSA Encryption = 4");
		System.out.println("RSA Decryption = 5");
		System.out.println("-------------------------------------");
		int switchChoice = choice.nextInt();
		
		switch(switchChoice)
		{
			case 0:
				System.out.print("Input phrase user wants to encrypt: ");
				String userInputCE = input.nextLine();
				System.out.print("Input key for algorithm: ");
				String userKeyCE = input.nextLine();
				int keyCE = Integer.parseInt(userKeyCE);
				c.Encrypt(userInputCE, keyCE);
				break;
			case 1:
				System.out.print("Input phrase user wants to encrypt: ");
				String userInputCD = input.nextLine();
				System.out.print("Input key for algorithm: ");
				String userKeyCD = input.nextLine();
				int keyCD = Integer.parseInt(userKeyCD);
				c.Decrypt(userInputCD, keyCD);
				break;
			case 2:
				System.out.print("Input phrase user wants to encrypt: ");
				String userInputVE = input.nextLine();
				System.out.print("Input key for algorithm: ");
				String userKeyVE = input.nextLine();
				v.Encrypt(userInputVE,userKeyVE);
				break;
			case 3:
				System.out.print("Input phrase user wants to encrypt: ");
				String userInputVD = input.nextLine();
				System.out.print("Input key for algorithm: ");
				String userKeyVD = input.nextLine();
				v.Decrypt(userInputVD, userKeyVD);
				break;
			case 4:
				System.out.print("Print message to encrypt: ");
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
				break;
			case 5:
				System.out.print("Prime 1: ");
				int pD = input.nextInt();
				System.out.print("Prime 2: ");
				int qD = input.nextInt();
				int nD = pD*qD;
				System.out.println("Your modulo number is: "+nD);
				System.out.print("Enter Private Key: " );
				int d = input.nextInt();
				input.nextLine();
				System.out.print("Enter your Cipher: " );
				String cipher = input.nextLine();
				rsa.rsaDecrypt(cipher, nD, d);
				break;
			default:
				System.out.print("Please input a number between 0-5. Pick again: ");
				switchChoice = choice.nextInt();
		}
		input.close();
		choice.close();
	}

}
