package de.msal.euler;

/**
 * What is the difference between the sum of the squares and the square of the
 * sums?
 * 
 * 
 * The sum of the squares of the first ten natural numbers is, 1² + 2² + ... +
 * 10² = 385
 * 
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
 * 10)² = 55² = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */

public class Prob006 {

	public static void main(String[] args) {
		long squOfsum = squareOfSums(100L);
		long sumOfSqu = sumOfSquares(100L);

		long res = (squOfsum > sumOfSqu) ? squOfsum - sumOfSqu : sumOfSqu
				- squOfsum;
		System.out.println(" -> " + res);
	}

	private static long sumOfSquares(long count) {
		long x = 0;
		for (long i = count; i > 0; i--) {
			x += i * i;
		}
		System.out.println("sum of squares: " + x);
		return x;
	}

	private static long squareOfSums(long count) {
		long x = 0;
		for (long i = count; i > 0; i--) {
			x += i;
		}
		long res = x * x;
		System.out.println("square of sums: " + res);
		return res;
	}

}
