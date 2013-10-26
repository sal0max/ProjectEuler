package de.msal.euler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Using names.txt, a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order. Then working out the
 * alphabetical value for each name, multiply this value by its alphabetical
 * position in the list to obtain a name score.
 * <p/>
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * <p/>
 * What is the total of all the name scores in the file?
 */

public class Prob022 {

	public static void main(String[] args) {

		try {
			int sum = 0;

			/* read file (given as command line parameter) */
			String s = readFile(args[0]);

			/* sort the names */
			s = s.replace("\"", "");
			String[] names = s.split(",");
			names = getAlphabeticallySortedArray(names);

			/* compute the total of name scores */
			for (int i = 0; i < names.length; i++) {
				sum += (i + 1) * getAlphabeticValue(names[i]);
			}

			System.out.println("Total of all the name scores in the file: " + sum);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

	/**
	 * Transfers the array into an {@link ArrayList}, uses {@link
	 * Collections#sort(java.util.List)} and returns the sorted names again as an
	 * array of strings.
	 *
	 * @param array
	 * 		The array with the names to sort.
	 * @return a sorted array.
	 */
	private static String[] getAlphabeticallySortedArray(String[] array) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));
		Collections.sort(list);
		return list.toArray(array);
	}

	/**
	 * Calculates the alphabetic value of a String. E.g.:
	 * <p/>
	 * {@code COLIN = 3 + 15 + 12 + 9 + 14 = 53.}
	 *
	 * @param name
	 * 		The String of which the value should be calculated.
	 * @return The alphabetic value of given String.
	 */
	private static int getAlphabeticValue(String name) {
		int sum = 0;
		for (int i = 0; i < name.length(); i++) {
			sum += (int) name.charAt(i) - 64;
		}
		return sum;
	}

	/**
	 * Reads a given text file and returns its text as string.
	 *
	 * @param filename
	 * 		the path to the filename.
	 * @return the text of the file as string.
	 * @throws FileNotFoundException
	 */
	private static String readFile(String filename) throws FileNotFoundException {
		StringBuilder text = new StringBuilder();
		Scanner scanner = new Scanner(new FileInputStream(filename));

		try {
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine());
			}
		} finally {
			scanner.close();
		}

		return text.toString();
	}

}
