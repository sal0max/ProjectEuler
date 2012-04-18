package de.msal.euler;

/**
 * Find the largest prime factor of a composite number.
 * 
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */

public class Prob003 {

	static long[] tmp = new long[460];
	static int k = 0;
	final static long PRIME = 600851475143L;

	public static void main(String[] args) {
		System.out.println("prime factors of " + PRIME + ":");
		prime(PRIME);
	}

	/**
	 * @param n
	 * @return
	 */
	private static long prime(long n) {
		for (long j = 2; j <= n; j++) {
			if (n % j == 0) {
				tmp[k] = j;
				k++;
				System.out.println("   " + j);

				n = n / j;
				j = 2;
			}
		}
		return n;
	}
}
