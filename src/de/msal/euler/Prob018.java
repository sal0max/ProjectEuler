package de.msal.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the maximum sum travelling from the top of the triangle to the base.
 * 
 * 
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 * 
 * [...]
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * [...]
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by
 * trying every route. However, Problem 67, is the same challenge with a
 * triangle containing one-hundred rows; it cannot be solved by brute force, and
 * requires a clever method! ;o)
 */

public class Prob018 {

	public static void main(String[] args) {
		int[] ar01 = { 75 };
		int[] ar02 = { 95, 64 };
		int[] ar03 = { 17, 47, 82 };
		int[] ar04 = { 18, 35, 87, 10 };
		int[] ar05 = { 20, 4, 82, 47, 65 };
		int[] ar06 = { 19, 1, 23, 75, 3, 34 };
		int[] ar07 = { 88, 2, 77, 73, 7, 63, 67 };
		int[] ar08 = { 99, 65, 4, 28, 6, 16, 70, 92 };
		int[] ar09 = { 41, 41, 26, 56, 83, 40, 80, 70, 33 };
		int[] ar10 = { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 };
		int[] ar11 = { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 };
		int[] ar12 = { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 };
		int[] ar13 = { 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 };
		int[] ar14 = { 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 };
		int[] ar15 = { 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23 };

		List<int[]> list = new ArrayList<int[]>();
		list.add(ar15);
		list.add(ar14);
		list.add(ar13);
		list.add(ar12);
		list.add(ar11);
		list.add(ar10);
		list.add(ar09);
		list.add(ar08);
		list.add(ar07);
		list.add(ar06);
		list.add(ar05);
		list.add(ar04);
		list.add(ar03);
		list.add(ar02);
		list.add(ar01);

		for (int j = 0; j < list.size() - 1; j++) {
			for (int i = 0; i < list.get(j + 1).length; i++) {
				list.get(j + 1)[i] = list.get(j)[i] + list.get(j + 1)[i] > list
						.get(j)[i + 1] + list.get(j + 1)[i] ? list.get(j)[i]
						+ list.get(j + 1)[i] : list.get(j)[i + 1]
						+ list.get(j + 1)[i];
			}
		}

		System.out.println(list.get(list.size() - 1)[0]);
	}
}
