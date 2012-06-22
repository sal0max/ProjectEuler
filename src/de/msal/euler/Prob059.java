package de.msal.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 * Using a brute force attack, can you decrypt the cipher using XOR encryption?
 * 
 * 
 * Each character on a computer is assigned a unique code and the preferred
 * standard is ASCII (American Standard Code for Information Interchange). For
 * example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 * 
 * A modern encryption method is to take a text file, convert the bytes to
 * ASCII, then XOR each byte with a given value, taken from a secret key. The
 * advantage with the XOR function is that using the same encryption key on the
 * cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107
 * XOR 42 = 65.
 * 
 * For unbreakable encryption, the key is the same length as the plain text
 * message, and the key is made up of random bytes. The user would keep the
 * encrypted message and the encryption key in different locations, and without
 * both "halves", it is impossible to decrypt the message.
 * 
 * Unfortunately, this method is impractical for most users, so the modified
 * method is to use a password as a key. If the password is shorter than the
 * message, which is likely, the key is repeated cyclically throughout the
 * message. The balance for this method is using a sufficiently long password
 * key for security, but short enough to be memorable.
 * 
 * Your task has been made easy, as the encryption key consists of three lower
 * case characters. Using cipher1.txt (right click and 'Save Link/Target
 * As...'), a file containing the encrypted ASCII codes, and the knowledge that
 * the plain text must contain common English words, decrypt the message and
 * find the sum of the ASCII values in the original text.
 */

public class Prob059 {

	/* ascii: a-z == decimal: 97-122 */

	private static double[] passHolder = new double[3];
	private static int counter = 0;
	private static String line = "";

	private static String[] wordlist = { "hello", "world" };

	// static FileWriter fstream;
	// static BufferedWriter out;

	public static void main(String[] args) throws IOException {
		// fstream = new FileWriter("res/euler/cipher1_out.txt");
		// out = new BufferedWriter(fstream);

		long startTime = System.currentTimeMillis();

		for (int i = 97; i <= 122; i++) {
			for (int j = 97; j <= 122; j++) {
				for (int k = 97; k <= 122; k++) {
					passHolder[0] = i;
					passHolder[1] = j;
					passHolder[2] = k;
					bruteCrack("res/euler/cipher1.txt", passHolder);
					// out.write("\n");
					if (checkForEnglishWords(line)) {
						System.out.println("passphrase: "
								+ Character.toString((char) passHolder[0])
								+ Character.toString((char) passHolder[1])
								+ Character.toString((char) passHolder[2]));
						System.out.println("decrypted : " + line);
						System.out.println("sum       : "
								+ stringToAsciiSum(line));
					}
					line = "";
				}
			}
		}
		System.out.println("runtime   : ~"
				+ ((System.currentTimeMillis() - startTime) / 1000) + "s");
		// out.close();
	}

	private static void bruteCrack(String filename, double[] passHolder)
			throws IOException {
		Reader r = new BufferedReader(new FileReader(filename));
		StreamTokenizer tokenizer = new StreamTokenizer(r);
		tokenizer.parseNumbers();
		tokenizer.nextToken();
		while (tokenizer.ttype != StreamTokenizer.TT_EOF) {
			if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
				counter = counter > 2 ? 0 : counter;
				xorShift(tokenizer.nval, passHolder[counter]);
				counter++;
			}
			tokenizer.nextToken();
		}
		counter = 0;
	}

	private static void xorShift(Double input, Double passphrase)
			throws IOException {
		// out.write(Character.toString((char) (input.intValue() ^
		// passphrase.intValue())));
		line += Character.toString((char) (input.intValue() ^ passphrase
				.intValue()));
	}

	private static boolean checkForEnglishWords(String s) {
		for (int i = 0; i < wordlist.length; i++)
			if (s.contains(wordlist[i])) {
				return true;
			}
		return false;
	}

	private static int stringToAsciiSum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i);
		}
		return sum;
	}

}
