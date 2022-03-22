package application;

/**
 * This is the Account class represents an account.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */

public abstract class Account {

	/**
	 * This is College Checking
	 */
	public static final String COLLEGE_CHECKING = "College Checking";

	/**
	 * This is Money Market Savings
	 */
	public static final String MONEY_MARKET = "Money Market Savings";

	/**
	 * This is Checking
	 */
	public static final String CHECKING = "Checking";

	/**
	 * This is Savings
	 */
	public static final String SAVINGS = "Savings";

	/**
	 * This is holder.
	 */
	protected Profile holder;

	/**
	 * This is closed.
	 */
	protected boolean closed;

	/**
	 * This is balance.
	 */
	protected double balance;

	/**
	 * This is the Account constructor.
	 *
	 * @param holder the holder
	 */
	protected Account(Profile holder) {
		this.holder = holder;
		this.closed = false;
	}

	/**
	 * This is the getHolder method.
	 *
	 * @return the holder
	 */
	public Profile getHolder() {
		return this.holder;
	}

	/**
	 * This is the getBalance method.
	 *
	 * @return the balance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * This is the equals method.
	 *
	 * @param obj the obj
	 * @return true if equals
	 */
	@Override
	public boolean equals(Object obj) {
		//
		if (!(obj instanceof Account)) {
			return false;
		}
		Account account = (Account) obj;
		if (!this.getType().equals(account.getType())) {
			return false;
		}
		if (!this.getHolder().equals(account.getHolder())) {
			return false;
		}
		return true;
	}

	/**
	 * This is the toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getType() + "::" + this.holder.toString() + "::Balance $" + (Util.moneyToString(this.balance)) + ""
				+ (closed ? "::CLOSED" : "");
	}

	/**
	 * This is the withdraw method.
	 *
	 * @param amount the amount
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	/**
	 * This is the deposit method.
	 *
	 * @param amount the amount
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 * This is the monthlyInterest method.
	 *
	 * @return the monthly interest
	 */
	public abstract double monthlyInterest(); // return the monthly interest

	/**
	 * This is the fee method.
	 *
	 * @return the fee
	 */
	public abstract double fee(); // return the monthly fee

	/**
	 * This is the get type method.
	 *
	 * @return the type
	 */
	public abstract String getType(); // return the account type (class name)
}