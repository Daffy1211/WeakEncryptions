package EncryptDecrypt;

import java.math.*;
import java.util.Arrays;
import java.util.Scanner;

public class RSA {
	private static String[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
	private static String[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".split("");
	
	public static void rsaEncrypt(String m, int n, int r){
		int len = m.length();
		double c[];
		c = new double[len];
		int mConvertedArry[];
		mConvertedArry= new int[len];
		mConvertedArry = changeStringArray(m);
		int a = publicKey(r);
		System.out.println("public key: " + a);
		int d = privateKey(a,r);
		System.out.println("private key: " + d);
		for(int z = 0; z < len; z++) {
			c[z]=((Math.pow(mConvertedArry[z],a))%n);
		}
		String cHex;
		cHex = readableEncrypted(c,len);
		System.out.print("Encrypted message is : ");
		System.out.println(cHex);
	}
	
	public static void rsaDecrypt(String m, int n,int d) {
		String message[] = m.split(" ");
		int len = message.length;

		int c[];
		c = new int[len];
		c = byteSToInt(m);
		
		BigInteger C[];
		C = new BigInteger[len];
		BigInteger mBig[];
		String[] dec;
		mBig = new BigInteger[len];
		dec = new String[len];
		BigInteger nConverted = BigInteger.valueOf(n);
		for(int ii = 0; ii < len; ii++) {
			C[ii] = BigDecimal.valueOf(c[ii]).toBigInteger();
		}
		for(int kk = 0; kk < len; kk++) {
			mBig[kk] = (C[kk].pow(d)).mod(nConverted);
		}
		dec = intArrayToString(mBig);
		String decrypted = Arrays.toString(dec);
		decrypted = decrypted.replace(",", "");
		decrypted = decrypted.replace("[", "");
		decrypted = decrypted.replace("]", "");
		decrypted = decrypted.replaceAll("\\s+", "");
		System.out.println("Decrypted message is : ");
		System.out.println(decrypted);
	}
	
	// Takes cipher decimal array and returns hex string
	public static String readableEncrypted(double c[], int len){
		int cRead[];
		cRead = new int[len];
		String cHex[];
		cHex = new String[len];
		String holder; 
		for(int j = 0; j < len; j++) {
			cRead[j] = (int) c[j];
			holder = Integer.toHexString(cRead[j]);
			if(cRead[j] < 16 ) {cHex[j]= "0" + holder;}
			else {cHex[j] = holder;}
		}
		String encrypted = Arrays.toString(cHex);
		encrypted = encrypted.replace(",", "");
		encrypted = encrypted.replace("[", "");
		encrypted = encrypted.replace("]", "");
		return encrypted;
	} 
	
	// Generates a public key
	public static int publicKey(int r) {
		for(int a=2;a<r;a++){
			if(gcd(a,r)==1){
				r = a;
				break;
			}
		}
		return r;
	}
	
	// Generates a private key
	public static int privateKey(int a, int r) {
		for(int b=0;b<=9;b++){
			int x=1+(b*r);
			if(x%a==0) {      
				int d=x/a;
				r = d;
				break;
			}
		}
		return r;
	}	
	public static int[] byteSToInt(String m) {
		int len = m.length();
		String messageBytes[];
		messageBytes = new String[len];
		messageBytes = m.split(" ");
		int iBit[];
		iBit = new int[messageBytes.length];
		for(int i = 0; i < messageBytes.length; i++) {
			iBit[i] = Integer.valueOf(messageBytes[i], 16);
		}
		return iBit;
	}
	
	static String[] intArrayToString(BigInteger dec[]) {
		String s[];
		s = new String[dec.length];
		int toInt;
		for(int i = 0; i < dec.length; i++){
			toInt = dec[i].intValue();
			s[i] = alphabetUpper[toInt];
		}
		return s;
	}
	
	static int[] changeStringArray(String m){
		int len = m.length();
		String messageArry[] = m.split("");
		int mConvertedArry[];
		mConvertedArry = new int[len];
		for(int i = 0; i < len; i++) {
			for(int k = 0; k < alphabetUpper.length; k++) {
				if(alphabetUpper[k].equals(messageArry[i])) {
					mConvertedArry[i] = k;
					break;
				}
				if(alphabetLower[k].equals(messageArry[i])) {
					mConvertedArry[i] = k;
					break;
				}
			}
		}
		return mConvertedArry;
	}
	
	static int gcd(int p1, int p2)
	{
		if(p1==0)
			return p2; 
		else
			return gcd((p2%p1),p1);
	}
}
