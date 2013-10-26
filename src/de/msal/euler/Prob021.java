package de.msal.euler;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * <p/>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * <p/>
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class Prob021 {

	private final static int MAX = 10000;

	public static void main(String[] args) {
		int sum = 0;
		int[] properDivisors = new int[MAX];

		/* first get us a map of the sum of proper divisors of each number */
		for (int i = 0; i < MAX; i++) {
			properDivisors[i] = getSumOfProperDivisors(i);
		}

		/* now compare */
		for (int i = 0; i < MAX; i++) {
			if (properDivisors[i] < MAX && // d(a) and d(b) must be < 10000
					i == properDivisors[properDivisors[i]] && // a == d(b) && b == d(a)
					i != properDivisors[i]) { // a != b
				sum += i;
			}
		}
		System.out.println("Sum of all the amicable numbers under "
				+ MAX + ": " + sum);
	}

	/**
	 * Calculates the sum of all proper divisors of given number n. A proper
	 * divisor is a number less than n which divides evenly into n.
	 *
	 * @param n
	 * 		The number which sum of proper divisors should be calculated.
	 * @return The sum of all proper divisors.
	 */
	private static int getSumOfProperDivisors(int n) {
		int sum = 0;

		for (int i = 1; i < n; i++) {
			if (n % i == 0)
				sum += i;
		}

		return sum;
	}

}
