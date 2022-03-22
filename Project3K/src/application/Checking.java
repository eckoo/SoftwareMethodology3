package application;

/**
 * This is the Checking class represents a checking account.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Checking extends Account {

	/**
	 * This is MINIMAL_BALANCE
	 */
	private static final double MINIMAL_BALANCE = 1000;

	/**
	 * This is FEE
	 */
	private static final double FEE = 25;

	/**
	 * This is WAIVED
	 */
	private static final double WAIVED = 0;

	/**
	 * This is ANNUAL_INTEREST_RATE
	 */
	private static final double ANNUAL_INTEREST_RATE = 0.001;

	/**
	 * This is NUM_MONTHS_IN_YEAR
	 */
	private static final int NUM_MONTHS_IN_YEAR = 12;

	/**
	 * This is the Checking constructor
	 *
	 * @param holder the holder
	 */
	public Checking(Profile holder) {
		super(holder);
	}

	@Override
	public double monthlyInterest() {
		return this.balance * ANNUAL_INTEREST_RATE / NUM_MONTHS_IN_YEAR;
	}

	@Override
	public double fee() {
		if (this.balance < MINIMAL_BALANCE) {
			return FEE;
		} else {
			return WAIVED;
		}
	}

	@Override
	public String getType() {
		return CHECKING;
	}
}
