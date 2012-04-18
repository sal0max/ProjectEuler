package de.msal.euler;

/**
 * Add all the natural numbers below one thousand that are multiples of 3 or 5.
 * 
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class Prob001 {

	final static long MAX = 1000L;// Long.MAX_VALUE;
	private static long startTime;

	public static void main(String[] args) {

		startTime = System.nanoTime();
		bruteForceMethod();
		System.out.println("\ttime = " + (System.nanoTime() - startTime)
				/ 1000000f + "ms");

		startTime = System.nanoTime();
		gaussMethod();
		System.out.println("\ttime = " + (System.nanoTime() - startTime)
				/ 1000000f + "ms");
	}

	private static void bruteForceMethod() {
		long sum = 0;
		System.out.println("Brute Force Method");
		for (int i = 1; i < MAX; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println("\n\tsum  = " + sum);
	}

	private static void gaussMethod() {
		System.out.println("Gauss Method");

		long N = MAX - 1;
		long cthree = (N - (N % 3) + 3) * (N - N % 3) / 3 / 2;
		long cfive = (N - (N % 5) + 5) * (N - N % 5) / 5 / 2;
		long cfifteen = (N - (N % 15) + 15) * (N - N % 15) / 15 / 2;

		System.out.println("\n\tsum  = " + (long) (cthree + cfive - cfifteen));
	}

}
