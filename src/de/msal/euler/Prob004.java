package de.msal.euler;

/**
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Prob004 {

	public static void main(String[] args) {
		int x1 = 999;
		int x2 = 999;

		int pal = 0;
		int tmpPal;
		int tmpI1 = 0;
		int tmpI2 = 0;

		for (int i1 = x1; i1 >= 100; i1--) {
			for (int i2 = x2; i2 >= 100; i2--) {
				tmpPal = i1 * i2;
				if (isPalindrom(tmpPal) && tmpPal > pal) {
					pal = tmpPal;
					tmpI1 = i1;
					tmpI2 = i2;
				}
			}
		}
		System.out.println("largest palindrome: " + pal);
		System.out.println("   (" + tmpI2 + " × " + tmpI1 + ")");
	}

	private static boolean isPalindrom(int i) {
		if (i == invertNumber(i))
			return true;
		else
			return false;
	}

	private static int invertNumber(int i) {
		String originalNum = String.valueOf(i);
		String invertedNum = new String();

		for (int z = originalNum.length() - 1; z >= 0; z--) {
			invertedNum += originalNum.charAt(z);
		}

		return Integer.valueOf(invertedNum);
	}

}