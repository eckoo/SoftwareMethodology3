package application;

/**
 * This is the AccountDatabase class represents the database for accounts.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class AccountDatabase {

	/**
	 * Creates a variable for the array of accounts that will be stored.
	 */
	private Account[] accounts;
	
	/**
	 * Creates a variable for the number of Accounts stored.
	 */
	private int numAcct;

	/**
	 * Creates a value that is returned to let us know we can successfully open an account.
	 */
	public static final int OPEN_OK = 0;
	
	/**
	 * Creates a value that is returned to let us know we can successfully reopen an account.
	 */
	public static final int OPEN_REOPEN_OK = 1;
	
	/**
	 * Creates a value that is returned to let us know we cannot open an account.
	 */
	public static final int OPEN_FAILED = 2;

	/**
	 * Creates a variable for the default capacity of an array.
	 */
	private static final int DEFAULT_CAPACITY = 10086;
	
	/**
	 * Creates a variable for the balance of a closed account.
	 */
	private static final int CLOSED_BALANCE = 0;
	
	/**
	 * Creates a variable for equals.
	 */
	private static final int EQUALS = 0;
	
	/**
	 * Creates a variable for index not found. 
	 */
	private static final int NOT_FOUND = -1;
	
	/**
	 * Creates a variable for beginning index. 
	 */
	private static final int BEGINNING_INDEX = 0;
	
	/**
	 * Creates a variable for empty. 
	 */
	private static final int EMPTY = 0;
	
	/**
	 * Creates a variable for next. 
	 */
	private static final int NEXT = 1;
	
	/**
	 * Creates a variable for resetting the number of withdraws. 
	 */
	private static final int WITHDRAWL_RESET = 0;
	
	/**
	 * Creates a variable for growing the array. 
	 */
	private static final int GROW = 0;

    /**
     * This is the AccountDatabase constructor.
     */
    public AccountDatabase() {
        this.accounts = new Account[DEFAULT_CAPACITY];
    }

    /**
     * This is the find method.
     *
     * @param account the account
     * @return the index
     */
    private int find(Account account) {
        for (int i = BEGINNING_INDEX; i < numAcct; i++) {
            Account anotherAccount = this.accounts[i];
            if (account.equals(anotherAccount)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * This is the grow method.
     */
    private void grow() {
        Account[] newAccounts = new Account[this.accounts.length + GROW];
        for (int i = BEGINNING_INDEX; i < numAcct; i++) {
            newAccounts[i] = this.accounts[i];
        }
        this.accounts = newAccounts;
    }

    /**
     * This is the open method
     *
     * @param account the account
     * @return true if opened
     */
    public boolean open(Account account) {
        if (this.accounts.length == this.numAcct) {
            grow();
        }
        this.accounts[this.numAcct++] = account;
        return true;
    }

    /**
     * This is the close method.
     *
     * @param account the account
     * @return true if closed
     */
    public boolean close(Account account) {
        int index = find(account);
        if (index != NOT_FOUND) {
            Account found = this.accounts[index];
            if (found.closed) {
                return false;
            } else {
                found.closed = true;
                found.balance = CLOSED_BALANCE;
                if (found.getType().equals(Account.SAVINGS) || found.getType().equals(Account.MONEY_MARKET)) {
                    ((Savings) found).loyal = false;
                }
                if (found.getType().equals(Account.MONEY_MARKET)) {
                    ((MoneyMarket) found).withdrawl = WITHDRAWL_RESET;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * This is the deposit method.
     *
     * @param account the account
     */
    public void deposit(Account account) {
        this.getAccount(account).deposit(account.balance);
    }

    /**
     * This is the withdraw method
     *
     * @param account the account
     * @return true if withdrawn
     */
    public boolean withdraw(Account account) {
        Account anotherAccount = this.getAccount(account);
        double amount = account.getBalance();
        if (anotherAccount.getBalance() > amount) {
            anotherAccount.withdraw(amount);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is the print method.
     *
     * @return the data
     */
    public String print() {
        String data = "";
        if (numAcct == EMPTY) {
            data = ("Account Database is empty!");
        } else {
            data += ("*list of accounts in the database*\n");
            for (int i = BEGINNING_INDEX; i < numAcct; i++) {
                data += (this.accounts[i].toString() + "\n");
            }
            data += ("*end of list*");
        }
        return data;
    }

    /**
     * This is the printByAccountType method.
     *
     * @return data
     */
    public String printByAccountType() {
        String data = "";
        if (numAcct == EMPTY) {
            data += ("Account Database is empty!\n");
        } else {
            for (int i = BEGINNING_INDEX; i < this.numAcct; i++) {
                for (int j = i + NEXT; j < this.numAcct; j++) {
                    if (this.accounts[i].getType().compareTo(this.accounts[j].getType()) > EQUALS) {
                        Account temp = this.accounts[i];
                        this.accounts[i] = this.accounts[j];
                        this.accounts[j] = temp;
                    }
                }
            }
            data += ("*list of accounts by account type.\n");
            for (int i = BEGINNING_INDEX; i < numAcct; i++) {
                data += (this.accounts[i].toString() + "\n");
            }
            data += ("*end of list.");
        }
        return data;
    }

    /**
     * This is the printFeeAndInterest method.
     *
     * @return data
     */
    public String printFeeAndInterest() {
        String data = "";
        if (numAcct == EMPTY) {
            data += ("Account Database is empty!");
        } else {

            data += ("*list of accounts with fee and monthly interest\n");
            for (int i = BEGINNING_INDEX; i < numAcct; i++) {
                Account account = this.accounts[i];
                System.out.print(account.toString());
                data += ("::fee $" + Util.moneyToString(account.fee()) + "::monthly interest $"
                        + Util.moneyToString(account.monthlyInterest()) + "\n");
            }
            data += ("*end of list.");
        }
        return data;
    }

    /**
     * This is the updateBalance method.
     *
     * @return data
     */
    public String updateBalance() {
        String data = "";
        if (numAcct == EMPTY) {
            data += ("Account Database is empty!");
        } else {

            data += ("*list of accounts with updated balance\n");
            for (int i = BEGINNING_INDEX; i < numAcct; i++) {
                Account account = this.accounts[i];
                account.balance += account.monthlyInterest();
                account.balance -= account.fee();
                data += (account.toString() + "\n");
            }
            data += ("*end of list.");
        }
        return data;
    }

    /**
     * This is the checkOpen method.
     *
     * @param account the account
     * @return the check open result
     */
    public int checkOpen(Account account) {
        String simpleAccountType = account.getType().replace(Account.COLLEGE_CHECKING, "C").replace(Account.CHECKING,
                "C");
        for (int i = BEGINNING_INDEX; i < numAcct; i++) {
            Account anotherAccount = this.accounts[i];
            String anotherSimpleAccountType = anotherAccount.getType().replace(Account.COLLEGE_CHECKING, "C")
                    .replace(Account.CHECKING, "C");
            if (simpleAccountType.equals(anotherSimpleAccountType)
                    && account.getHolder().equals(anotherAccount.getHolder())) {
                if (anotherAccount.closed && anotherAccount.getType().equals(account.getType())) {
                    return OPEN_REOPEN_OK;
                } else {
                    return OPEN_FAILED;
                }
            }
        }
        return OPEN_OK;
    }

    /**
     * This is the getAccount method.
     *
     * @param account the account
     * @return the getAccount result
     */
    public Account getAccount(Account account) {
        int index = find(account);
        if (index != NOT_FOUND) {
            return this.accounts[index];
        } else {
            return null;
        }
    }

}
