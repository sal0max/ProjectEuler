package de.msal.euler;

import java.math.BigInteger;

/**
 * Find the sum of digits in 100!
 * 
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */

public class Prob020 {

	public static void main(String[] args) {
		BigInteger arg = new BigInteger("100");
		BigInteger fak = new BigInteger(fak(arg).toByteArray());

		System.out.println(arg + "! = " + fak);
		System.out.println("sum of digits = " + makeSum(fak));
	}

	private static BigInteger fak(BigInteger input) {
		if (input.equals(new BigInteger("0"))
				|| input.equals(new BigInteger("1")))
			return new BigInteger("1");
		else
			// input * (fak(input-1));
			return input.multiply(fak(input.subtract(new BigInteger("1"))));
	}

	private static int makeSum(BigInteger input) {
		String s = input.toString();
		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			sum += Integer.valueOf(String.valueOf((s.charAt(i))));
		}

		return sum;
	}

}
