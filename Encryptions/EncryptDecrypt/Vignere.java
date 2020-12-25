package EncryptDecrypt;

import java.util.Arrays;

public class Vignere {
		private static String[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		private static String[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".split("");
		public String Encrypt (String input, String key) {
			
			String inputArry[] = input.split("");
			String keyArry[] = key.split("");
			int keyNumArry[];
			int inputNumArry[];
			keyNumArry = new int [key.length()];
			inputNumArry =  new int [input.length()];
			
			for(int l = 0; l < key.length();l++) {
				for(int j = 0; j < alphabetUpper.length; j++) {
						if(alphabetUpper[j].equals(keyArry[l].toUpperCase())) {
							keyNumArry[l] = j;
							break;
						}
					}
			}
			
			for(int a = 0; a < input.length();a++) {
				for(int b = 0; b < alphabetUpper.length; b++) {
						if(alphabetUpper[b].equals(inputArry[a].toUpperCase())) {
							inputNumArry[a] = b;
							break;
						}
					}
			}
			
			for(int i = 0; i < input.length(); i++) {
					if(inputArry[i].equals(inputArry[i].toUpperCase())) {
						inputArry[i] = alphabetUpper[((inputNumArry[i]+(keyNumArry[i%key.length()]))%26)];
					}
					if(inputArry[i].equals(inputArry[i].toLowerCase())) {
						inputArry[i] = alphabetLower[((inputNumArry[i]+(keyNumArry[i%key.length()]))%26)];
					}
			}
			
			String encrypted = Arrays.toString(inputArry);
			encrypted = encrypted.replace(",", "");
			encrypted = encrypted.replace("[", "");
			encrypted = encrypted.replace("]", "");
			encrypted = encrypted.replaceAll("\\s+", "");
			return encrypted;
			
		}
		public String Decrypt(String input, String key) {
			String inputArry[] = input.split("");
			String keyArry[] = key.split("");
			int keyNumArry[];
			int inputNumArry[];
			keyNumArry = new int [key.length()];
			inputNumArry =  new int [input.length()];
			
			for(int l = 0; l < key.length();l++) {
				for(int j = 0; j < alphabetUpper.length; j++) {
						if(alphabetUpper[j].equals(keyArry[l].toUpperCase())) {
							keyNumArry[l] = j;
							break;
						}
					}
			}
			
			for(int a = 0; a < input.length();a++) {
				for(int b = 0; b < alphabetUpper.length; b++) {
						if(alphabetUpper[b].equals(inputArry[a].toUpperCase())) {
							inputNumArry[a] = b;
							break;
						}
					}
			}
			
			for(int i = 0; i < input.length(); i++) {
					if(inputArry[i].equals(inputArry[i].toUpperCase())) {
						inputArry[i] = alphabetUpper[(Math.abs(inputNumArry[i]-(keyNumArry[i%key.length()])+26)%26)];
					}
					if(inputArry[i].equals(inputArry[i].toLowerCase())) {
						inputArry[i] = alphabetLower[(Math.abs(inputNumArry[i]-(keyNumArry[i%key.length()])+26)%26)];
					}
			}
			
			String decrypted = Arrays.toString(inputArry);
			decrypted = decrypted.replace(",", "");
			decrypted = decrypted.replace("[", "");
			decrypted = decrypted.replace("]", "");
			decrypted = decrypted.replaceAll("\\s+", "");
			return decrypted;
		}
}
