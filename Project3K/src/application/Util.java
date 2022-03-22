package application;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

/**
 * This is the Util class has a bunch of utility functions.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Util {

	/**
	 * This is BEGINNING_INDEX
	 */
	private static final int BEGINNING_INDEX = 0;

	/**
	 * This is MAX_TOKEN_COUNT
	 */
	private static final int MAX_TOKEN_COUNT = 100;

	/**
	 * This is the Util constructor.
	 */
	public Util() {
	}

	/**
	 * This is the readLine method
	 *
	 * @param scanner the scanner
	 * @return the line
	 */
	public static String readLine(Scanner scanner) {
		String line = null;
		try {
			line = null;
			line = scanner.nextLine();
		} catch (Exception ex) {
			// ignored
		}
		return line;
	}

	/**
	 * This is the tokenize method.
	 *
	 * @param line      the line
	 * @param separator the separator
	 * @return the tokenization result
	 */
	public static String[] tokenize(String line, char separator) {
		line = line.replace(separator, ' ');
		StringTokenizer st = new StringTokenizer(line);
		String[] tokens = new String[MAX_TOKEN_COUNT];
		int i = BEGINNING_INDEX;
		while (st.hasMoreTokens()) {
			tokens[i++] = st.nextToken();
		}
		String[] results = new String[i];
		for (int j = BEGINNING_INDEX; j < i; j++) {
			results[j] = tokens[j];
		}
		return results;
	}

	/**
	 * This is the tokenizeInteger method
	 *
	 * @param line      the line
	 * @param separator the separator
	 * @return the tokenization result
	 */
	public static int[] tokenizeIntegers(String line, char separator) {
		String[] tokens = tokenize(line, separator);
		int n = tokens.length;
		int[] result = new int[tokens.length];
		for (int i = BEGINNING_INDEX; i < n; i++) {
			try {
				result[i] = Integer.parseInt(tokens[i]);
			} catch (NumberFormatException nex) {
				return null;
			}
		}
		return result;
	}

	/**
	 * This is the isDouble method.
	 *
	 * @param s the s
	 * @return true if is double
	 */
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 * This is the isInteger method.
	 *
	 * @param s the s
	 * @return true if is integer
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 * This is the moneyToString method.
	 *
	 * @param amount the amount
	 * @return the string
	 */
	public static String moneyToString(double amount) {
		return new DecimalFormat("#,###,##0.00").format(amount);
	}
}
