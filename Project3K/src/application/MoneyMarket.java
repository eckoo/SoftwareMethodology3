package application;

/**
 * This is the MoneyMarket class represents a money market account.
 * It holds the logic for getting and setting variables in the MoneyMarket class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class MoneyMarket extends Savings {

	/* By default, it is a loyal customer account
	If the balance falls below $2500, then it is not a
	loyal customer account anymore
	A loyal customer account gets additional interest
	rate 0.15%; that is, annual interest rate will be
	0.95%.
	Fee cannot be waived if the number of
	withdrawals exceeds 3 times
	*/
	/**
	 * Creates a variable for the Minimum Balance someone can have in their Money Market account to be a loyal member.
	 */
	public static final int MINIMAL_LOYAL_BALANCE = 2500;

	/**
	 * Creates a variable for the normal annual interest rate.
	 */
	private static final double NORMAL_ANNUAL_INTEREST_RATE = 0.008;

	/**
	 * Creates a variable for the loyal annual interest rate.
	 */
	private static final double LOYAL_ANNUAL_INTEREST_RATE = 0.0095;

	/**
	 * Creates a variable for the number of months in one year.
	 */
	private static final int NUM_MONTHS_IN_YEAR = 12;
	
	/**
	 * Creates a variable for the waived monthly fee.
	 */
	private static final double WAIVED = 0;
	
	/**
	 * Creates a variable for the monthly fee.
	 */
	private static final double FEE = 10;

	/**
	 * Creates a variable for withdrawl, which will be an amount that we take from a user's account.
	 */
	protected int withdrawl;

	/**
	 * This is the MoneyMarket constructor method.
	 * @param holder Object of type Profile, balance Object of type double.
	 */
	public MoneyMarket(Profile holder) {
		super(holder, true);
	}

	/**
	 * monthlyInterest returns the monthly interest of the Money Market account.
	 * @return this.balance * annualInterestRate / NUM_MONTHS_IN_YEAR with differing values based on if loyal customer or if non-loyal customer.
	 */
	@Override
	public double monthlyInterest() {
		double annualInterestRate = this.loyal ? LOYAL_ANNUAL_INTEREST_RATE : NORMAL_ANNUAL_INTEREST_RATE;
		return this.balance * annualInterestRate / NUM_MONTHS_IN_YEAR;
	}

	/**
	 * fee returns the monthly fee of the Money Market account.
	 * @return moneyMarketMonthlyFee if account balance is less than $2500, moneyMarketMonthlyFeeWaived if greater than or equal to $2500.
	 */
	@Override
	public double fee() {
		if (this.loyal && this.withdrawl < 4) {
			return WAIVED;
		} else {
			return FEE;
		}
	}

	/**
	 * getType is a constructor method.
	 * @return this.type = "Money Market";
	 */
	@Override
	public String getType() {
		return MONEY_MARKET;
	}

	/**
	 * This is the toString method.
	 * @return the string representation of the Money Market Account.
	 */
	@Override
	public String toString() {
		return super.toString() + "::withdrawl: " + withdrawl;
	}

	/**
	 * The withdraw method keeps count of how many times a withdraw has been made from an account, sets account to not loyal if balance is below a certain amount.
	 * @param amount Object of type double.
	 */
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		withdrawl++;
		if (this.balance < MINIMAL_LOYAL_BALANCE) {
			this.loyal = false;
		}
	}
}
