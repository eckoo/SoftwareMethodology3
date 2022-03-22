package application;

/**
 * This is the MoneyMarket class represents a money market account.
 * It holds the logic for getting and setting variables in the MoneyMarket class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class MoneyMarket extends Savings {

	/**
	 * This is minimal loyal balance.
	 */
	public static final int MINIMAL_LOYAL_BALANCE = 2500;

	/**
	 * This is NORMAL_ANNUAL_INTEREST_RATE
	 */
	private static final double NORMAL_ANNUAL_INTEREST_RATE = 0.008;

	/**
	 * This is LOYAL_ANNUAL_INTEREST_RATE
	 */
	private static final double LOYAL_ANNUAL_INTEREST_RATE = 0.0095;

	/**
	 * This is NUM_MONTHS_IN_YEAR
	 */
	private static final int NUM_MONTHS_IN_YEAR = 12;

	/**
	 * This is WAIVED
	 */
	private static final double WAIVED = 0;

	/**
	 * This is FEE
	 */
	private static final double FEE = 10;

	/**
	 * This is withdrawl.
	 */
	protected int withdrawl;

	/**
	 * This is MoneyMarket constructor.
	 *
	 * @param holder the holder
	 */
	public MoneyMarket(Profile holder) {
		super(holder, true);
	}

	@Override
	public double monthlyInterest() {
		double annualInterestRate = this.loyal ? LOYAL_ANNUAL_INTEREST_RATE : NORMAL_ANNUAL_INTEREST_RATE;
		return this.balance * annualInterestRate / NUM_MONTHS_IN_YEAR;
	}

	@Override
	public double fee() {
		if (this.loyal && this.withdrawl < 4) {
			return WAIVED;
		} else {
			return FEE;
		}
	}

	@Override
	public String getType() {
		return MONEY_MARKET;
	}

	@Override
	public String toString() {
		return super.toString() + "::withdrawl: " + withdrawl;
	}

	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		withdrawl++;
		if (this.balance < MINIMAL_LOYAL_BALANCE) {
			this.loyal = false;
		}
	}
}
