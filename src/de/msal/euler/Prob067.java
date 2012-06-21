package de.msal.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Using an efficient algorithm find the maximal sum in the triangle?
 * 
 * 
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 * 
 * [...]
 * 
 * Find the maximum total from top to bottom in triangle.txt (right click and
 * 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 * 
 * NOTE: This is a much more difficult version of Problem 18. It is not possible
 * to try every route to solve this problem, as there are 299 altogether! If you
 * could check one trillion (1012) routes every second it would take over twenty
 * billion years to check them all. There is an efficient algorithm to solve it.
 * ;o)
 */

public class Prob067 {

	@SuppressWarnings("unchecked")
	static ArrayList<ArrayList<Double>> readFile(String filename)
			throws IOException {
		ArrayList<Double> array = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();

		LineNumberReader lnr = new LineNumberReader(new FileReader(filename));
		lnr.setLineNumber(1);
		StreamTokenizer tokenizer = new StreamTokenizer(lnr);
		tokenizer.parseNumbers();
		tokenizer.eolIsSignificant(true);
		tokenizer.nextToken();

		while (tokenizer.ttype != StreamTokenizer.TT_EOF) {
			while (tokenizer.ttype != StreamTokenizer.TT_EOL) {
				if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
					array.add(tokenizer.nval);
					tokenizer.nextToken();
				}
			}
			list.add((ArrayList<Double>) array.clone());
			array.clear();
			tokenizer.nextToken();
		}

		Collections.reverse(list);
		return list;
	}

	public static void main(String[] args) throws IOException {

		ArrayList<ArrayList<Double>> list = readFile("res/euler/triangle.txt");

		for (int j = 0; j < list.size() - 1; j++) {
			for (int i = 0; i < list.get(j + 1).size(); i++) {
				list.get(j + 1).set(
						i,
						list.get(j).get(i) + list.get(j + 1).get(i) > list.get(
								j).get(i + 1)
								+ list.get(j + 1).get(i) ? list.get(j).get(i)
								+ list.get(j + 1).get(i) : list.get(j).get(
								i + 1)
								+ list.get(j + 1).get(i));
			}
		}

		System.out.println(list.get(list.size() - 1).get(0));
	}

}
