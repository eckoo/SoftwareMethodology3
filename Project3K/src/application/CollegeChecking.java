package application;

/**
 * This is CollegeChecking class represents a college checking account.
 * It holds the logic for getting and setting variables in the CollegeChecking class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class CollegeChecking extends Checking {

	/**
	 * Creates a variable for the campusCode of New Brunswick.
	 */
	public static final int NEW_BRUNSWICK = 0;
	
	/**
	 * Creates a variable for the campusCode of Newark.
	 */
	public static final int NEWARK = 1;
	
	/**
	 * Creates a variable for the campusCode of Camden.
	 */
	public static final int CAMDEN = 2;

	/**
	 * Creates a variable for the campusCode inputted by user.
	 */
	protected int campusCode;

	/**
	 * Creates a variable for the annual interest rate.
	 */
	private static final double ANNUAL_INTEREST_RATE = 0.0025;
	
	/**
	 * Creates a variable for the number of months in one year.
	 */
	private static final int NUM_MONTHS_IN_YEAR = 12;
	
	/**
	 * Creates a variable for the waived monthly fee.
	 */
	private static final double WAIVED = 0;

	//must provide campus code
	//if account holder has checking account, cannot create College Checking account. each account holder can only have ONE checking account.
	/**
	* This is the CollegeChecking Constructor method.
	* @param holder Object of type Profile.
	* @param campusCode Object of type int.
	*/
	public CollegeChecking(Profile holder, int campusCode) {
		super(holder);
		this.campusCode = campusCode;
	}

	/**
	 * monthlyInterest returns the monthly interest of the College Checking account.
	 * @return collegeCheckingMonthlyInterest if called.
	 */
	@Override
	public double monthlyInterest() {
		return this.balance * ANNUAL_INTEREST_RATE / NUM_MONTHS_IN_YEAR;
	}

	/**
	 * fee returns the monthly fee of the College Checking account.
	 * @return collegeCheckingMonthlyFee if account balance is less than $1000, collegeCheckingMonthlyFeeWaived if greater than or equal to $1000.
	 */
	@Override
	public double fee() {
		return WAIVED;
	}

	/**
	 * getType is a constructor method.
	 * @return this.type = "Checking";
	 */
	@Override
	public String getType() {
		return COLLEGE_CHECKING;
	}

	/**
	 * This is the toString method.
	 * @return the string representation of the College Checking Account.
	 */
	@Override
	public String toString() {
		String campus = null;
		switch (campusCode) {
		case NEW_BRUNSWICK:
			campus = "NEW_BRUNSWICK";
			break;
		case NEWARK:
			campus = "NEWARK";
			break;
		case CAMDEN:
			campus = "CAMDEN";
			break;
		}
		return super.toString() + "::" + campus;
	}
}
