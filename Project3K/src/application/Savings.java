package application;

/**
 * This is the Savings class represents a saving account.
 * It holds the logic for getting and setting variables in the Savings class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Savings extends Account {

	/**
	 * This is the loyal.
	 */
	protected boolean loyal;

	/**
	 * This is NORMAL_ANNUAL_INTEREST_RATE
	 */
	private static final double NORMAL_ANNUAL_INTEREST_RATE = 0.003;

	/**
	 * This is LOYAL_ANNUAL_INTEREST_RATE
	 */
	private static final double LOYAL_ANNUAL_INTEREST_RATE = 0.0045;

	/**
	 * This is NUM_MONTHS_IN_YEAR
	 */
	private static final int NUM_MONTHS_IN_YEAR = 12;

	/**
	 * This is MINIMAL_BALANCE
	 */
	private static final int MINIMAL_BALANCE = 300;

	/**
	 * This is WAIVED
	 */
	private static final int WAIVED = 0;

	/**
	 * This is FEE
	 */
	private static final int FEE = 6;

	/**
	 * This is constructor.
	 *
	 * @param holder the holder
	 * @param loyal  the loyal
	 */
	public Savings(Profile holder, boolean loyal) {
		super(holder);
		this.loyal = loyal;
	}

	@Override
	public double monthlyInterest() {
		double annualInterestRate = this.loyal ? LOYAL_ANNUAL_INTEREST_RATE : NORMAL_ANNUAL_INTEREST_RATE;
		return this.balance * annualInterestRate / NUM_MONTHS_IN_YEAR;
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
		return SAVINGS;
	}

	@Override
	public String toString() {
		return super.toString() + (this.loyal ? "::Loyal" : "");
	}
}
