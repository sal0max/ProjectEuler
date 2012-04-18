package de.msal.euler;

/**
 * Find the longest sequence using a starting number under one million.
 * 
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even); n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence: 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class Prob014 {

	private static long count = 0;

	private static long collatzSequenceCount(long input) {
		if (input == 1) {
			count++;
			long tmp = count;
			count = 0;
			return tmp;
		} else if (input % 2 == 0) { // even
			count++;
			return collatzSequenceCount(input / 2);
		} else { // uneven
			count++;
			return collatzSequenceCount(3 * input + 1);
		}
	}

	public static void main(String[] args) {
		long longestSeqNumber = 0L;
		long longestCount = 0L;

		for (long i = 1; i < 1000000L; i++) {
			long tmp = collatzSequenceCount(i);
			if (tmp > longestCount) {
				longestSeqNumber = i;
				longestCount = tmp;
			}
		}
		System.out.println(longestSeqNumber + " (chain length: " + longestCount
				+ ")");

	}

}
