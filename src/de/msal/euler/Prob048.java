package de.msal.euler;

import java.math.BigInteger;

/**
 * Find the last ten digits of 1^1 + 2^2 + ... + 1000^1000.
 * 
 * 
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

public class Prob048 {

	public static void main(String[] args) {
		BigInteger big = BigInteger.ZERO;

		for (int i = 1; i <= 1000; i++) {
			big = big.add(new BigInteger(String.valueOf(i)).pow(i));
		}

		System.out.println(big.toString().substring(
				big.toString().length() - 10));
	}
}