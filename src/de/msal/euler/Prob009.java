package de.msal.euler;

/**
 * Find the only Pythagorean triplet, {a, b, c}, for which a + b + c = 1000.
 * 
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a² + b² = c²
 * 
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 */

public class Prob009 {

	private static int MAX = 1000;

	public static void main(String[] args) {

		int a = 0, b = 0, c = 0;

		for (c = 0; c <= MAX; c++) {
			for (b = 0; b < c; b++) {
				for (a = 0; a < b; a++) {
					if (a + b + c == 1000 && a * a + b * b == c * c) {
						System.out.println("a = " + a);
						System.out.println("b = " + b);
						System.out.println("c = " + c);
						System.out.print("\n" + a + "² + " + b + "² = " + c
								+ "²");
						System.out.println(" [" + a * a + " + " + b * b + " = "
								+ c * c + "]");
						System.out.println(a + " + " + b + " + " + c + " = "
								+ (a + b + c));
						System.out.println("\na*b*c = " + a * b * c);
					}
				}
			}
		}

	}
}
