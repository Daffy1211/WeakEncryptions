package EncryptDecrypt;

import java.util.Arrays;

public class Caesar {
	private static String[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
	private static String[] alphabetLower = "abcdefghjiklmnopqrstuvwxyz".split("");
	
	public String Encrypt(String input, int key) {
		String inputArry[] = input.split("");
		for(int i = 0; i < input.length(); i++) {
			for(int k = 0; k < alphabetUpper.length; k++) {
				if(alphabetUpper[k].equals(inputArry[i])) {
					inputArry[i] = alphabetUpper[((k+key)%26)];
					break;
				}
				if(alphabetLower[k].equals(inputArry[i])) {
					inputArry[i] = alphabetLower[((k+key)%26)];
					break;
				}
			}
		}
		
		String encrypted = Arrays.toString(inputArry);
		encrypted = encrypted.replace(",", "");
		encrypted = encrypted.replace("[", "");
		encrypted = encrypted.replace("]", "");
		encrypted = encrypted.replaceAll("\\s+", "");
		return encrypted;
	}
	
	public String Decrypt(String input, int key) {
		String decrypted = "";
		
		String inputArry[] = input.split("");
		for(int i = 0; i < input.length(); i++) {
			for(int k = 0; k < alphabetUpper.length; k++) {
				if(alphabetUpper[k].equals(inputArry[i])) {
					inputArry[i] = alphabetUpper[(((k-key)+26)%26)];
					break;
				}
				if(alphabetLower[k].equals(inputArry[i])) {
					inputArry[i] = alphabetLower[(((k-key)+26)%26)];
					break;
				}
			}
		}
		decrypted = Arrays.toString(inputArry);
		decrypted = decrypted.replace(",", "");
		decrypted = decrypted.replace("[", "");
		decrypted = decrypted.replace("]", "");
		decrypted = decrypted.replaceAll("\\s+", "");
		return decrypted;
	}
}
