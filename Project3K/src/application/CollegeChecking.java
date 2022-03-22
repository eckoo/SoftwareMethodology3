package application;

/**
 * This is CollegeChecking class represents a college checking account.
 * It holds the logic for getting and setting variables in the CollegeChecking class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class CollegeChecking extends Checking {

	/**
	 * This is New Brunswick.
	 */
	public static final int NEW_BRUNSWICK = 0;

	/**
	 * This is Newark.
	 */
	public static final int NEWARK = 1;

	/**
	 * This is Camden.
	 */
	public static final int CAMDEN = 2;

	/**
	 * This is campusCode.
	 */
	protected int campusCode;

	/**
	 * This is ANNUAL_INTEREST_RATE
	 */
	private static final double ANNUAL_INTEREST_RATE = 0.0025;

	/**
	 * This is NUM_MONTHS_IN_YEAR
	 */
	private static final int NUM_MONTHS_IN_YEAR = 12;

	/**
	 * This is WAIVED
	 */
	private static final double WAIVED = 0;

	/**
	 * This is the CollegeChecking constructor.
	 *
	 * @param holder     the holder
	 * @param campusCode the campus code
	 */
	public CollegeChecking(Profile holder, int campusCode) {
		super(holder);
		this.campusCode = campusCode;
	}

	@Override
	public double monthlyInterest() {
		return this.balance * ANNUAL_INTEREST_RATE / NUM_MONTHS_IN_YEAR;
	}

	@Override
	public double fee() {
		return WAIVED;
	}

	@Override
	public String getType() {
		return COLLEGE_CHECKING;
	}

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
