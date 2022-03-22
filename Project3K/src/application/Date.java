package application;

import java.util.Calendar;

/**
 * This is the Date class represents a date.
 * It holds the logic for getting and setting variables in the Date class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Date implements Comparable<Date> {

	/**
	 * Creates a variable for the year of the current date.
	 */
	private int year;
	
	/**
	 * Creates a variable for the month of the current date.
	 */
	private int month;
	
	/**
	 * Creates a variable for the day of the current date.
	 */
	private int day;

	/**
	 * Creates a variable for the month of January.
	 */
	private static final int JANUARY = 1;
	
	/**
	 * Creates a variable for the month of February.
	 */
	private static final int FEBRUARY = 2;
	
	/**
	 * Creates a variable for the month of March.
	 */
	private static final int MARCH = 3;
	
	/**
	 * Creates a variable for the month of May.
	 */
	private static final int MAY = 5;
	
	/**
	 * Creates a variable for the month of July.
	 */
	private static final int JULY = 7;
	
	/**
	 * Creates a variable for the month of August.
	 */
	private static final int AUGUST = 8;
	
	/**
	 * Creates a variable for the month of October.
	 */
	private static final int OCTOBER = 10;
	
	/**
	 * Creates a variable for the month of December.
	 */
	private static final int DECEMBER = 12;
	
	/**
	 * Creates a variable for the short month case.
	 */
	private static final int SHORT_MONTH = 30;
	
	/**
	 * Creates a variable for long month case.
	 */
	private static final int LONG_MONTH = 31;
	
	/**
	 * Creates a variable for non-leap year February.
	 */
	private static final int SHORT_FEBRUARY = 28;
	
	/**
	 * Creates a variable for leap year February
	 */
	private static final int LONG_FEBRUARY = 29;

	/**
	 * Creates a variable for checking to see if it is a leap year.
	 */
	private static final int QUADRENNIAL = 4;
	
	/**
	 * Creates a variable for checking to see if it is a leap year.
	 */
	private static final int CENTENNIAL = 100;
	
	/**
	 * Creates a variable for checking to see if it is a leap year.
	 */
	private static final int QUATERCENTENNIAL = 400;

	/**
	 * Creates a variable for checking to see if it is an invalid year.
	 */
	private static final int INVALID_YEAR = 0;
	
	/**
	 * Creates a variable for the minimum day in a month.
	 */
	private static final int MIN_DAY = 0;
	
	/**
	 * Creates a variable for the number of tokens.
	 */
	private static final int NUMBER_OF_TOKENS = 3;
	
	/**
	 * Creates a variable for the month token index.
	 */
	private static final int MONTH_TOKEN_INDEX = 0;
	
	/**
	 * Creates a variable for the day token index.
	 */
	private static final int DAY_TOKEN_INDEX = 1;
	
	/**
	 * Creates a variable for the year token index.
	 */
	private static final int YEAR_TOKEN_INDEX = 2;

	/**
	 * Creates a variable for the calendar correction, since the months start at 0 and go up to 11.
	 */
	private static final int CALENDAR_API_CORRECTION_OFFSET = 1;

	/**
	 * Creates a variable for greater than comparison.
	 */
	private static final int GREATER = 1;
	
	/**
	 * Creates a variable for less than comparison.
	 */
	private static final int LESSER = -1;
	
	/**
	 * Creates a variable for equal to comparison.
	 */
	private static final int EQUALS = 0;

	/**
	 * Creates a variable to check if the number is divisible by zero.
	 */
	private static final int DIVISIBLE_ZERO = 0;

	/**
	 * This is the date constructor.
	 * @param date Object of type String.
	 */
	public Date(String date) {
		int[] tokens = Util.tokenizeIntegers(date, '/');
		if (tokens == null) {
			year = INVALID_YEAR;
		} else if (tokens.length != NUMBER_OF_TOKENS) {
			year = INVALID_YEAR;
		} else {
			month = tokens[MONTH_TOKEN_INDEX];
			day = tokens[DAY_TOKEN_INDEX];
			year = tokens[YEAR_TOKEN_INDEX];
			check();
		}
	}

	/**
	 * This is the date constructor.
	 */
	public Date() {
		Calendar c = Calendar.getInstance();
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH) + CALENDAR_API_CORRECTION_OFFSET;
		this.day = c.get(Calendar.DAY_OF_MONTH);
		check();
	}

	/**
	 * This is the thisYear method
	 * @return true if this year is less than or equal to the current year.
	 */
	public boolean thisYear() {
		return this.year <= new Date().year;
	}

	/**
	 * This is the isValid method
	 * @return true if year is valid.
	 */
	public boolean isValid() {
		return year != INVALID_YEAR;
	}

	/**
	 * This is the toString method.
	 * @return the string representation of the date.
	 */
	@Override
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}

	/**
	 * This is the equals method.
	 * @param obj Object of type Object.
	 * @return true if equals the date equals, false if it does not.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Date) {
			Date date = (Date) obj;
			if (this.year != date.year) {
				return false;
			}
			if (this.month != date.month) {
				return false;
			}
			if (this.day != date.day) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * compareTo compares our date objects to see whether or not they are valid.
	 * @param date Object of type Date.
	 * @return if the inputted year equals, or is lesser or greater than the current year.
	 */
	@Override
	public int compareTo(Date date) {
		if (this.year < date.year) {
			return LESSER;
		}
		if (this.year > date.year) {
			return GREATER;
		}
		if (this.month < date.month) {
			return LESSER;
		}
		if (this.month > date.month) {
			return GREATER;
		}
		if (this.day < date.day) {
			return LESSER;
		}
		if (this.day > date.day) {
			return GREATER;
		}
		return EQUALS;
	}

	/**
	 * This is the check method.
	 */
	private void check() {
		int minDay = MIN_DAY;
		if (month < JANUARY || month > DECEMBER) {
			year = INVALID_YEAR;
			return;
		}
		int maxDay = SHORT_MONTH;
		switch (month) {
		case JANUARY:
		case MARCH:
		case MAY:
		case JULY:
		case AUGUST:
		case OCTOBER:
		case DECEMBER:
			maxDay = LONG_MONTH;
			break;
		}
		if (month == FEBRUARY) {
			maxDay = leap(year) ? LONG_FEBRUARY : SHORT_FEBRUARY;
		}
		year = (day >= minDay && day <= maxDay) ? year : INVALID_YEAR;
	}

	/**
	 * This is the leap method, which checks to see if the current year is a leap year or not.
	 * @param year Object of type int.
	 * @return true if leap year, false if not.
	 */
	private static boolean leap(int year) {
		if (year % QUADRENNIAL != DIVISIBLE_ZERO) {
			return false;
		}
		if (year % CENTENNIAL != DIVISIBLE_ZERO) {
			return true;
		}
		return (year % QUATERCENTENNIAL == DIVISIBLE_ZERO);
	}
}