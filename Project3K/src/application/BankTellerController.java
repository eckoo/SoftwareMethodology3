/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class BankTellerController implements Initializable {

	/**
	 * Creates formatter Object of type DateTimeFormatter.
	 */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * Creates txtFirstName Object of type TextField.
     */
    @FXML
    private TextField txtFirstName;
    
    /**
     * Creates txtLastName Object of type TextField.
     */
    @FXML
    private TextField txtLastName;
    
    /**
     * Creates rdbtnChecking Object of type RadioButton.
     */
    @FXML
    private RadioButton rdbtnChecking;
    
    /**
     * Creates group Object of type ToggleGroup.
     */
    @FXML
    private ToggleGroup group;
    
    /**
     * Creates rdbtnCollegeChecking Object of type RadioButton.
     */
    @FXML
    private RadioButton rdbtnCollegeChecking;
    
    /**
     * Creates rdbtnSaving Object of type RadioButton.
     */
    @FXML
    private RadioButton rdbtnSaving;
    
    /**
     * Creates rdbtnMoneyMarket Object of type RadioButton.
     */    
    @FXML
    private RadioButton rdbtnMoneyMarket;
    
    /**
     * Creates txtDateOfBirth Object of type DatePicker.
     */
    @FXML
    private DatePicker txtDateOfBirth;
    
    /**
     * Creates chkboxLoyalCustomer Object of type CheckBox.
     */
    @FXML
    private CheckBox chkboxLoyalCustomer;
    
    /**
     * Creates rbtnNB Object of type RadioButton.
     */
    @FXML
    private RadioButton rbtnNB;
    
    /**
     * Creates group1 Object of type ToggleGroup.
     */
    @FXML
    private ToggleGroup group1;
   
    /**
     * Creates rbtnNewark Object of type RadioButton.
     */
    @FXML
    private RadioButton rbtnNewark;
    
    /**
     * Creates rbtnCamden Object of type RadioButton.
     */
    @FXML
    private RadioButton rbtnCamden;
    
    /**
     * Creates txtFirstName1 Object of type TextField.
     */
    @FXML
    private TextField txtFirstName1;
    
    /**
     * Creates txtLastName1 Object of type TextField.
     */
    @FXML
    private TextField txtLastName1;
    
    /**
     * Creates rdbtnChecking1 Object of type RadioButton.
     */
    @FXML
    private RadioButton rdbtnChecking1;
    
    /**
     * Creates rdbtnCollegeChecking1 Object of type RadioButton.
     */
    @FXML
    private RadioButton rdbtnCollegeChecking1;
    
    /**
     * Creates group11 Object of type ToggleGroup.
     */
    @FXML
    private ToggleGroup group11;
    
    /**
     * Creates rdbtnSaving1 Object of type RadioButton.
     */
    @FXML
    private RadioButton rdbtnSaving1;
    
    /**
     * Creates rdbtnMoneyMarket1 Object of type RadioButton.
     */
    @FXML
    private RadioButton rdbtnMoneyMarket1;
    
    /**
     * Creates txtDateOfBirth1 Object of type DatePicker.
     */
    @FXML
    private DatePicker txtDateOfBirth1;
    
    /**
     * Creates txtAmount Object of type TextField.
     */
    @FXML
    private TextField txtAmount;
    
    /**
     * Creates txtAreaMsg Object of type TextArea.
     */
    @FXML
    private TextArea txtAreaMsg;
    
    /**
     * Creates txtDeposit Object of type Text Area.
     */
    @FXML
    private TextField txtDeposit;
    
    /**
     * Creates an object for loyalty value.
     */
    private static final String LOYAL = "1";
    
    /**
     * Creates an object for not loyal value.
     */
    private static final String NOT_LOYAL = "0";
    
    /**
     * Creates an object for New Brunswick campus code.
     */
    private static final String NEW_BRUNSWICK = "0";
    
    /**
     * Creates an object for Newark campus code.
     */
    private static final String NEWARK = "1";
    
    /**
     * Creates an object for Camden campus code.
     */
    private static final String CAMDEN = "2";
    
    /**
     * Creates an object for initial value of code.
     */
    private static final String CODE_BASE = "-1";
    
    
    /**
     * Initializes the controller class.
     * @param url Object of type URL.
     * @param rb Object of type ResourceBundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.accountDatabase = new AccountDatabase();
    }

    /**
     * createAccount handles the logic for creating an account via our GUI.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void createAccount(ActionEvent event) {
        String accType = "N";
        if (rdbtnChecking.isSelected()) {
            accType = "C";
        } else if (rdbtnSaving.isSelected()) {
            accType = "S";
        } else if (rdbtnCollegeChecking.isSelected()) {
            accType = "CC";
        } else if (rdbtnMoneyMarket.isSelected()) {
            accType = "MM";
        }

        String fname = txtFirstName.getText().trim();
        String lname = txtLastName.getText().trim();
        LocalDate date = txtDateOfBirth.getValue();
        String dob = "Nill";
        if (date != null) {
            dob = formatter.format(date);
        }
        String amount = txtDeposit.getText().trim();

        String code = CODE_BASE;

        if (rdbtnCollegeChecking.isSelected()) {

            if (rbtnNB.isSelected()) {
                code = NEW_BRUNSWICK;
            } else if (rbtnNewark.isSelected()) {
                code = NEWARK;
            } else if (rbtnCamden.isSelected()) {
                code = CAMDEN;
            }
        }
        if (rdbtnSaving.isSelected()) {
            if (chkboxLoyalCustomer.isSelected()) {
                code = LOYAL;
            } else {
                code = NOT_LOYAL;
            }
        }
        //MoneyMarket is loyal by default, but this will check the box after creation to let user know without printing accounts.
        if(rdbtnMoneyMarket.isSelected()) {
        	chkboxLoyalCustomer.setSelected(true);
        }

        String line = "O " + accType + " " + fname + " " + lname + " " + dob + " " + amount;
        if (!code.equals(CODE_BASE)) {
            line += " " + code;
        }

        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {

        }
    }

    /**
     * closeAccount handles the logic for closing an account via our GUI.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void closeAccount(ActionEvent event) {
        String accType = "N";
        if (rdbtnChecking.isSelected()) {
            accType = "C";
        } else if (rdbtnSaving.isSelected()) {
            accType = "S";
        } else if (rdbtnCollegeChecking.isSelected()) {
            accType = "CC";
        } else if (rdbtnMoneyMarket.isSelected()) {
            accType = "MM";
        }

        String fname = txtFirstName.getText().trim();
        String lname = txtLastName.getText().trim();
        LocalDate date = txtDateOfBirth.getValue();
        String dob = "Nill";
        if (date != null) {
            dob = formatter.format(date);
        }

        String line = "C " + accType + " " + fname + " " + lname + " " + dob;
        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {

        }
    }

    /**
     * deposit() handles the logic for depositing money into an account.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void deposit(ActionEvent event) {
        String accType = "N";
        if (rdbtnChecking1.isSelected()) {
            accType = "C";
        } else if (rdbtnSaving1.isSelected()) {
            accType = "S";
        } else if (rdbtnCollegeChecking1.isSelected()) {
            accType = "CC";
        } else if (rdbtnMoneyMarket1.isSelected()) {
            accType = "MM";
        }

        String fname = txtFirstName1.getText().trim();
        String lname = txtLastName1.getText().trim();
        LocalDate date = txtDateOfBirth1.getValue();
        String dob = "Nill";
        if (date != null) {
            dob = formatter.format(date);
        }
        String amount = txtAmount.getText().trim();
        String line = "D " + accType + " " + fname + " " + lname + " " + dob + " " + amount;
        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {

        }
    }

    /**
     * withdraw() handles the logic for withdrawing an amount from an account.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void withdraw(ActionEvent event) {
        String accType = "N";
        if (rdbtnChecking1.isSelected()) {
            accType = "C";
        } else if (rdbtnSaving1.isSelected()) {
            accType = "S";
        } else if (rdbtnCollegeChecking1.isSelected()) {
            accType = "CC";
        } else if (rdbtnMoneyMarket1.isSelected()) {
            accType = "MM";
        }

        String fname = txtFirstName1.getText().trim();
        String lname = txtLastName1.getText().trim();
        LocalDate date = txtDateOfBirth1.getValue();
        String dob = "Nill";
        if (date != null) {
        dob = formatter.format(date);
        }
        String amount = txtAmount.getText().trim();

        String line = "W " + accType + " " + fname + " " + lname + " " + dob.toString() + " " + amount;
        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {

        }
    }

    /**
     * printAll prints out a list of accounts in the database.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void printAll(ActionEvent event) {
        String line = "P";
        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {

        }
    }

    /**
     * applyIandF prints out list of accounts with calculated fees and monthly interests.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void applyIandF(ActionEvent event) {
        String line = "PI";
        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {

        }
    }

    /**
     * printByType prints out list of accounts ordered by account type.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void printByType(ActionEvent event) {
        String line = "PT";
        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {

        }
    }

    /**
     * updateBalance updates all accounts with fees and interest, and displays all accounts with updated balance.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void updateBalance(ActionEvent event) {
        String line = "UB";
        String[] tokens = Util.tokenize(line, ' ');
        if (handleTokens(tokens)) {
        }
    }

    /**
     * This is accountDatabase
     */
    private AccountDatabase accountDatabase;

    /**
     * This is COMMAND_TOKEN_INDEX
     */
    private static final int COMMAND_TOKEN_INDEX = 0;

    /**
     * This is Q_COMMAND_TOKEN_COUNT
     */
    private static final int Q_COMMAND_TOKEN_COUNT = 1;

    /**
     * This is O_COMMAND_MINIMAL_TOKEN_COUNT
     */
    private static final int O_COMMAND_MINIMAL_TOKEN_COUNT = 6;
    /**
     * This is O_COMMAND_MAXIMAL_TOKEN_COUNT
     */
    private static final int O_COMMAND_MAXIMAL_TOKEN_COUNT = 7;
    /**
     * This is C_COMMAND_TOKEN_COUNT
     */
    private static final int C_COMMAND_TOKEN_COUNT = 5;
    /**
     * This is D_COMMAND_TOKEN_COUNT
     */
    private static final int D_COMMAND_TOKEN_COUNT = 6;
    /**
     * This is W_COMMAND_TOKEN_COUNT
     */
    private static final int W_COMMAND_TOKEN_COUNT = 6;
    /**
     * This is P_COMMAND_TOKEN_COUNT
     */
    private static final int P_COMMAND_TOKEN_COUNT = 1;
    /**
     * This is PT_COMMAND_TOKEN_COUNT
     */
    private static final int PT_COMMAND_TOKEN_COUNT = 1;
    /**
     * This is PI_COMMAND_TOKEN_COUNT
     */
    private static final int PI_COMMAND_TOKEN_COUNT = 1;
    /**
     * This is UB_COMMAND_TOKEN_COUNT
     */
    private static final int UB_COMMAND_TOKEN_COUNT = 1;
    /**
     * This is O_COMMAND_ACCOUNT_TYPE_INDEX
     */
    private static final int O_COMMAND_ACCOUNT_TYPE_INDEX = 1;
    /**
     * This is O_COMMAND_FNAME_TOKEN_INDEX
     */
    private static final int O_COMMAND_FNAME_TOKEN_INDEX = 2;
    /**
     * This is O_COMMAND_LNAME_TOKEN_INDEX
     */
    private static final int O_COMMAND_LNAME_TOKEN_INDEX = 3;
    /**
     * This is O_COMMAND_DOB_TOKEN_INDEX
     */
    private static final int O_COMMAND_DOB_TOKEN_INDEX = 4;
    /**
     * This is O_COMMAND_DEPOSIT_TOKEN_INDEX
     */
    private static final int O_COMMAND_DEPOSIT_TOKEN_INDEX = 5;
    /**
     * This is O_COMMAND_CAMPUS_CODE_TOKEN_INDEX
     */
    private static final int O_COMMAND_CAMPUS_CODE_TOKEN_INDEX = 6;
    /**
     * This is O_COMMAND_SAVING_CODE_TOKEN_INDEX
     */
    private static final int O_COMMAND_SAVING_CODE_TOKEN_INDEX = 6;
    /**
     * This is LESSER
     */
    private static final int LESSER = -1;
    /**
     * This is INVALID_CAMPUS_CODE
     */
    private static final int INVALID_CAMPUS_CODE = -1;
    /**
     * This is INVALID_SAVING_CODE
     */
    private static final int INVALID_SAVING_CODE = -1;
    /**
     * This is SAVING_CODE_NON_LOYAL
     */
    private static final int SAVING_CODE_NON_LOYAL = 0;
    /**
     * This is SAVING_CODE_LOYAL
     */
    private static final int SAVING_CODE_LOYAL = 1;
    /**
     * This is C_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX
     */
    private static final int C_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX = 1;
    /**
     * This is C_COMMAND_FNAME_TOKEN_INDEX
     */
    private static final int C_COMMAND_FNAME_TOKEN_INDEX = 2;
    /**
     * This is C_COMMAND_LNAME_TOKEN_INDEX
     */
    private static final int C_COMMAND_LNAME_TOKEN_INDEX = 3;
    /**
     * This is C_COMMAND_DOB_TOKEN_INDEX
     */
    private static final int C_COMMAND_DOB_TOKEN_INDEX = 4;
    /**
     * This is D_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX
     */
    private static final int D_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX = 1;
    /**
     * This is D_COMMAND_FNAME_TOKEN_INDEX
     */
    private static final int D_COMMAND_FNAME_TOKEN_INDEX = 2;
    /**
     * This is D_COMMAND_LNAME_TOKEN_INDEX
     */
    private static final int D_COMMAND_LNAME_TOKEN_INDEX = 3;
    /**
     * This is D_COMMAND_DOB_TOKEN_INDEX
     */
    private static final int D_COMMAND_DOB_TOKEN_INDEX = 4;
    /**
     * This is D_COMMAND_AMOUNT_TOKEN_INDEX
     */
    private static final int D_COMMAND_AMOUNT_TOKEN_INDEX = 5;
    /**
     * This is W_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX
     */
    private static final int W_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX = 1;
    /**
     * This is W_COMMAND_FNAME_TOKEN_INDEX
     */
    private static final int W_COMMAND_FNAME_TOKEN_INDEX = 2;
    /**
     * This is W_COMMAND_LNAME_TOKEN_INDEX
     */
    private static final int W_COMMAND_LNAME_TOKEN_INDEX = 3;
    /**
     * This is W_COMMAND_DOB_TOKEN_INDEX
     */
    private static final int W_COMMAND_DOB_TOKEN_INDEX = 4;
    /**
     * This is W_COMMAND_AMOUNT_TOKEN_INDEX
     */
    private static final int W_COMMAND_AMOUNT_TOKEN_INDEX = 5;
    /**
     * This is NO_TOKENS
     */
    private static final int NO_TOKENS = 0;
    /**
     * This is ZERO_AMOUNT
     */
    private static final double ZERO_AMOUNT = 0;

    /**
     * handleTokens handles all of the different actions via tokens.
     *
     * @param tokens Object of type String[].
     * @return true if ended, false if NO_TOKENS.
     */
    private boolean handleTokens(String[] tokens) {
        int n = tokens.length;
        if (n == NO_TOKENS) {
            return false;
        }
        if (tokens[COMMAND_TOKEN_INDEX].equals("O")) {
            OA(tokens);
        } else if (tokens[COMMAND_TOKEN_INDEX].equals("C")) {
            if (n < C_COMMAND_TOKEN_COUNT) {
                txtAreaMsg.setText("Missing data for closing an account.");
            } else {
                C(tokens);
            }
        } else if ((n == D_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("D"))) {
            D(tokens);
        } else if ((n == W_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("W"))) {
            W(tokens);
        } else if ((n == P_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("P"))) {
            P(tokens);
        } else if ((n == PT_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("PT"))) {
            PT(tokens);
        } else if ((n == PI_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("PI"))) {
            PI(tokens);
        } else if ((n == UB_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("UB"))) {
            UB(tokens);
        } else if ((n == Q_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("Q"))) {
            txtAreaMsg.setText("Bank Teller is terminated. ");
            return true;
        } else {
            txtAreaMsg.setText("Invalid command!");
        }
        return false;
    }

    /**
     * The OA method tests to see if a user can open an account.
     *
     * @param tokens Object of type String[].
     */
    private void OA(String[] tokens) {
        if (tokens.length < O_COMMAND_MINIMAL_TOKEN_COUNT) {
            txtAreaMsg.setText("Missing data for opening an account.");
            return;
        }
        String accountType = tokens[O_COMMAND_ACCOUNT_TYPE_INDEX];
        if (accountType.equals("CC") || accountType.equals("S")) {
            if (tokens.length != O_COMMAND_MAXIMAL_TOKEN_COUNT) {
                txtAreaMsg.setText("Missing data for opening an account.");
                return;
            }
        } else {
            if (tokens.length != O_COMMAND_MINIMAL_TOKEN_COUNT) {
                txtAreaMsg.setText("Invalid command!");
                return;
            }
        }
        Date dob = new Date(tokens[O_COMMAND_DOB_TOKEN_INDEX]);
        Date today = new Date();
        if (!dob.isValid()) {
            txtAreaMsg.setText("Date of birth invalid.");
            return;
        }
        OB(tokens, accountType, dob, today);
    }

    /**
     * The OB method tests to see if a user can open an account.
     *
     * @param tokens Object of type String[].
     * @param accountType Object of type String.
     * @param dob Object of type Date.
     * @param today Object of type Date.
     */
    private void OB(String[] tokens, String accountType, Date dob, Date today) {
        if (dob.compareTo(today) != LESSER) {
            txtAreaMsg.setText("Date of birth invalid.");
            return;
        }
        String depositString = tokens[O_COMMAND_DEPOSIT_TOKEN_INDEX];
        if (!Util.isDouble(depositString)) {
            txtAreaMsg.setText("Not a valid amount.");
            return;
        }
        double deposit = Double.parseDouble(depositString);
        if (deposit <= ZERO_AMOUNT) {
            txtAreaMsg.setText("Initial deposit cannot be 0 or negative.");
            return;
        }
        int campusCode = INVALID_CAMPUS_CODE;
        int savingCode = INVALID_SAVING_CODE;
        if (accountType.equals("CC")) {
            String campusCodeString = tokens[O_COMMAND_CAMPUS_CODE_TOKEN_INDEX];
            if (!Util.isInteger(campusCodeString)) {
                txtAreaMsg.setText("Invalid campus code.");
                return;
            }
            campusCode = Integer.parseInt(campusCodeString);
            if ((campusCode != CollegeChecking.NEW_BRUNSWICK) && (campusCode != CollegeChecking.NEWARK)
                    && (campusCode != CollegeChecking.CAMDEN)) {
                txtAreaMsg.setText("Invalid campus code.");
                return;
            }
        }
        OC(tokens, accountType, dob, deposit, campusCode, savingCode);
    }

    /**
     * The OC method tests to see if a user can open an account.
     *
     * @param tokens Object of type String[].
     * @param accountType Object of type String.
     * @param dob Object of type Date.
     * @param deposit Object of type double.
     * @param campusCode Object of type int.
     * @param savingCode Object of type int.
     */
    private void OC(String[] tokens, String accountType, Date dob, double deposit, int campusCode, int savingCode) {
        if (accountType.equals("S")) {
            String savingCodeString = tokens[O_COMMAND_SAVING_CODE_TOKEN_INDEX];
            if (!Util.isInteger(savingCodeString)) {
                txtAreaMsg.setText("Invalid saving code.");
                return;
            }
            savingCode = Integer.parseInt(savingCodeString);
            if ((savingCode != SAVING_CODE_NON_LOYAL) && (savingCode != SAVING_CODE_LOYAL)) {
                txtAreaMsg.setText("Invalid saving code.");
                return;
            }
        }
        if (accountType.equals("MM") && (deposit < MoneyMarket.MINIMAL_LOYAL_BALANCE)) {
            txtAreaMsg.setText("Minimum of $2500 to open a MoneyMarket account.");
            return;
        }
        Profile profile = new Profile(tokens[O_COMMAND_FNAME_TOKEN_INDEX], tokens[O_COMMAND_LNAME_TOKEN_INDEX], dob);
        Account account = createAccount(accountType, profile, campusCode, savingCode);
        int check = accountDatabase.checkOpen(account);
        if (check == AccountDatabase.OPEN_OK) {
            accountDatabase.open(account);
            account.deposit(deposit);
            txtAreaMsg.setText("Account opened.");
        } else if (check == AccountDatabase.OPEN_REOPEN_OK) {
            account = accountDatabase.getAccount(account);
            account.closed = false;
            if (accountType.equals("CC")) {
                ((CollegeChecking) account).campusCode = campusCode;
            }
            if (accountType.equals("MM") && deposit > MoneyMarket.MINIMAL_LOYAL_BALANCE) {
                ((MoneyMarket) account).loyal = true;
            }
            account.deposit(deposit);
            txtAreaMsg.setText("Account reopened.");
        } else {
            txtAreaMsg.setText(profile.toString() + " same account(type) is in the database.");
        }
    }

    /**
     * The C method checks to see if we can close an account.
     *
     * @param tokens Object of type String[].
     */
    private void C(String[] tokens) {
        String accountType = tokens[C_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX];
        Date dob = new Date(tokens[C_COMMAND_DOB_TOKEN_INDEX]);
        Profile profile = new Profile(tokens[C_COMMAND_FNAME_TOKEN_INDEX], tokens[C_COMMAND_LNAME_TOKEN_INDEX], dob);
        Account account = createAccount(accountType, profile, INVALID_CAMPUS_CODE, INVALID_SAVING_CODE);
        if (this.accountDatabase.close(account)) {
            txtAreaMsg.setText("Account closed.");
        } else {
            txtAreaMsg.setText("Account is closed already.");
        }
    }

    /**
     * The D method checks to see if deposit amount is valid.
     *
     * @param tokens Object of type String[].
     */
    private void D(String[] tokens) {
        String accountType = tokens[D_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX];
        Date dob = new Date(tokens[D_COMMAND_DOB_TOKEN_INDEX]);
        String fname = tokens[D_COMMAND_FNAME_TOKEN_INDEX];
        String lname = tokens[D_COMMAND_LNAME_TOKEN_INDEX];
        String amountString = tokens[D_COMMAND_AMOUNT_TOKEN_INDEX];
        if (!Util.isDouble(amountString)) {
            txtAreaMsg.setText("Not a valid amount.");
            return;
        }
        double amount = Double.parseDouble(amountString);
        if (amount <= ZERO_AMOUNT) {
            txtAreaMsg.setText("Deposit - amount cannot be 0 or negative.");
            return;
        }
        Profile profile = new Profile(fname, lname, dob);
        Account account = createAccount(accountType, profile, INVALID_CAMPUS_CODE, INVALID_SAVING_CODE);
        account.deposit(amount);
        if (this.accountDatabase.getAccount(account) == null) {
            txtAreaMsg.setText(fname + " " + lname + " " + dob + " "
                    + account.getType().replace("Money Market Savings", "Money Market") + " is not in the database.");
        } else {
            this.accountDatabase.deposit(account);
            txtAreaMsg.setText("Deposit - balance updated.");
        }

    }

    /**
     * The W method checks to see if withdraw amount is valid.
     *
     * @param tokens Object of type String[].
     */
    private void W(String[] tokens) {
        String accountType = tokens[W_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX];
        Date dob = new Date(tokens[W_COMMAND_DOB_TOKEN_INDEX]);
        String fname = tokens[W_COMMAND_FNAME_TOKEN_INDEX];
        String lname = tokens[W_COMMAND_LNAME_TOKEN_INDEX];
        String amountString = tokens[W_COMMAND_AMOUNT_TOKEN_INDEX];
        if (!Util.isDouble(amountString)) {
            txtAreaMsg.setText("Not a valid amount.");
            return;
        }
        double amount = Double.parseDouble(amountString);
        if (amount <= ZERO_AMOUNT) {
            txtAreaMsg.setText("Withdraw - amount cannot be 0 or negative.");
            return;
        }
        Profile profile = new Profile(fname, lname, dob);
        Account account = createAccount(accountType, profile, INVALID_CAMPUS_CODE, INVALID_SAVING_CODE);
        account.deposit(amount);
        if (this.accountDatabase.getAccount(account) == null) {
            txtAreaMsg.setText(fname + " " + lname + " " + dob + " "
                    + account.getType().replace("Money Market Savings", "Money Market") + " is not in the database.");
        } else {
            if (this.accountDatabase.withdraw(account)) {
                txtAreaMsg.setText("Withdraw - balance updated.");
            } else {
                txtAreaMsg.setText("Withdraw - insufficient fund.");
            }
        }
    }

    /**
     * The P method calls method to display all accounts in the database.
     *
     * @param tokens Object of type String[].
     */
    private void P(String[] tokens) {
        txtAreaMsg.setText(this.accountDatabase.print());
    }

    /**
     * The PT method calls method to display all accounts in database, ordered by account type.
     *
     * @param tokens Object of type String[].
     */
    private void PT(String[] tokens) {
        txtAreaMsg.setText(this.accountDatabase.printByAccountType());
    }

    /**
     * The PI method calls method to display all accounts in database, ordered by calculated fees and monthly interests.
     *
     * @param tokens Object of type String[].
     */
    private void PI(String[] tokens) {
        txtAreaMsg.setText(this.accountDatabase.printFeeAndInterest());
    }

    /**
     * The UB method calls method to update and display the accounts with updated balances.
     *
     * @param tokens Object of type String[].
     */
    private void UB(String[] tokens) {
        txtAreaMsg.setText(this.accountDatabase.updateBalance());
    }

    /**
     * The createAccount method creates a new account instance.
     *
     * @param accountType Object of type String.
     * @param profile Object of type Profile.
     * @param campusCode Object of type int.
     * @param savingCode Object of type int.
     * @return account - created account.
     */
    private Account createAccount(String accountType, Profile profile, int campusCode, int savingCode) {
        Account account = null;
        if (accountType.equals("C")) {
            account = new Checking(profile);
        } else if (accountType.equals("CC")) {
            account = new CollegeChecking(profile, campusCode);
        } else if (accountType.equals("S")) {
            account = new Savings(profile, savingCode == SAVING_CODE_LOYAL);
        } else if (accountType.equals("MM")) {
            account = new MoneyMarket(profile);
        }
        return account;
    }

    /**
     * typeSelected holds the logic for the current type of account selected via RadioButton.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void typeSelected(ActionEvent event) {
        if (rdbtnSaving.isSelected()) {
            setLocationDisable(true);
            setLoyalDisable(false);
        } else if (rdbtnCollegeChecking.isSelected()) {
            setLocationDisable(false);
            setLoyalDisable(true);
        } else {
            setLocationDisable(true);
            setLoyalDisable(true);
        }
    }

    /**
     * setLocationDisable disables location selection until certain account type is chosen.
     * @param b Object of type boolean.
     */
    private void setLocationDisable(boolean b) {
        rbtnCamden.setDisable(b);
        rbtnNB.setDisable(b);
        rbtnNewark.setDisable(b);
    }

    /**
     * setLoyalDisable disables loyalty selection until certain account type is chosen.
     * @param b Object of type boolean.
     */
    private void setLoyalDisable(boolean b) {
        chkboxLoyalCustomer.setDisable(b);
    }

}
