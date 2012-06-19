package de.msal.euler;

/**
 * What is the sum of both diagonals in a 1001 by 1001 spiral?
 * 
 * 
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows: [...]
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 */

public class Prob028 {

	public static void main(String[] args) {

		// size of the spiral
		int[] spiral = new int[1001 * 1001];

		/* fill array */
		for (int i = 0; i < spiral.length; i++) {
			spiral[i] = i + 1;
		}

		int sum = 0;
		int curPos = 0;

		try {
			// 4 times steps of 2, then 4 times steps of 4, then 4 times steps
			// of 6, ...
			for (int k = 2; true; k = k + 2) {
				for (int i = 1; i < 5; i++) { // 4x
					sum += spiral[curPos];
					System.out.println(spiral[curPos] + " (current sum = "
							+ sum + ")");
					curPos += k;// remember current position in the array
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\ntotal sum = " + sum);
		}
	}

}
