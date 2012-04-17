package de.msal.euler;

/**
 * How many letters would be needed to write all the numbers in words from 1 to
 * 1000?
 * 
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */

public class Prob017 {

	private static String onedigit(int i) {
		switch (i) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		default:
			return "";
		}
	}

	private static String twodigits(int i) {

		if (i <= 13 || i == 15 || i == 18) {
			switch (i) {
			case 10:
				return "ten";
			case 11:
				return "eleven";
			case 12:
				return "twelve";
			case 13:
				return "thirteen";
			case 15:
				return "fifteen";
			case 18:
				return "eighteen";
			default:
				return onedigit(i);
			}
		} else {
			switch (Integer.valueOf(String.valueOf(i).substring(0, 1))) {
			case 1:
				return onedigit(i % 10) + "teen";
			case 2:
				return "twenty" + onedigit(i % 10);
			case 3:
				return "thirty" + onedigit(i % 10);
			case 4:
				return "forty" + onedigit(i % 10);
			case 5:
				return "fifty" + onedigit(i % 10);
			case 6:
				return "sixty" + onedigit(i % 10);
			case 7:
				return "seventy" + onedigit(i % 10);
			case 8:
				return "eighty" + onedigit(i % 10);
			case 9:
				return "ninety" + onedigit(i % 10);
			default:
				return onedigit(i);
			}

		}
	}

	private static String threedigits(int i) {
		if (i % 100 == 0)
			return onedigit(Integer.valueOf(String.valueOf(i).substring(0, 1)))
					+ "hundred";
		else
			return onedigit(Integer.valueOf(String.valueOf(i).substring(0, 1)))
					+ "hundredand"
					+ twodigits(Integer.valueOf(String.valueOf(i).substring(1,
							3)));

	}

	private static String numberToWord(int i) {
		switch (String.valueOf(i).length()) {
		case 1:
			return onedigit(i);
		case 2:
			return twodigits(i);
		case 3:
			return threedigits(i);
		default:
			return "";
		}
	}

	public static void main(String[] args) {

		long length = 0;
		for (int i = 1; i < 1000; i++) {
			System.out.println(numberToWord(i));
			length += numberToWord(i).length();
		}
		length += "onethousand".length();

		System.out.println(length);
	}

}
