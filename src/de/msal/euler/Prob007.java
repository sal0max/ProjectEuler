package de.msal.euler;

/**
 * Find the 10001st prime.
 * 
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10 001st prime number? // 104743
 */

public class Prob007 {

	public static void main(String[] args) {

		int place = 10001;

		int count = 2;
		int count2 = 0;
		int prim = 2;

		long startTime = System.nanoTime();

		for (int i = 1; count <= place; i = i + 2) { // possible prime
			count2 = 0;

			for (int j = i; j > 0; j = j - 2) { // check ifprime
				if (i % j == 0) { // evenly dividable
					count2++; // how many times evenly dividable?
				}
			}
			if (count2 == 2) { // prime!
				prim = i;
				count++; // count how many primes were found
			}

		}
		System.out.println(count - 1 + ". prime number: " + prim);
		System.out.println("\ttime = " + (System.nanoTime() - startTime)
				/ 1000000f + "ms");

	}
}
