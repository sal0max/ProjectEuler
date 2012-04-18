package de.msal.euler;

/**
 * Calculate the sum of all the primes below two million.
 * 
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */

public class Prob010 {

	private final static long MAX = 2000000;

	public static boolean isPrime(long n) {
		boolean prime = true;
		for (long i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0) {
				prime = false;
				break;
			}
		if ((n % 2 != 0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		long result = 0L;
		for (long i = 2L; i < MAX; i++) {
			if (isPrime(i))
				result += i;
		}
		System.out.println(result);
	}

}
