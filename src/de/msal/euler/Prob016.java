package de.msal.euler;

import java.math.BigInteger;

/**
 * What is the sum of the digits of the number 2^1000?
 * 
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */

public class Prob016 {

	public static void main(String[] args) {

		BigInteger number = new BigInteger("2").pow(1000);
		String s = number.toString();
		long sum = 0;

		for (int i = 0; i < s.length(); i++) {
			sum += Integer.valueOf(s.charAt(i) - '0');
			System.out.println("+" + s.charAt(i) + "  " + sum);

		}

		System.out.println("Summe von 2^1000 (" + number.toString() + "):");
		System.out.println("  " + sum);
	}

}
