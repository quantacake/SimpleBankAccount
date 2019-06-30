import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;
import java.util.HashMap;


public class Account {


    // displays game in colors.
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String RESET = "\033[0m";  // Text Reset

    Scanner input = new Scanner(System.in);
    private boolean newHolder;
    private static AtomicLong accountNumber = new AtomicLong(123456789);
    private Date dateCreated;
    private String accountName;
    private double balance = 0;
    private double amount = 0;
    private static double annualInterestRate = 3.3;
    static HashMap<String, Account> accountDict = new HashMap<String, Account>();  // list of user accounts


    //Transaction transaction;

    public Account() { };

    // new accounts
    public Account(String accountName) {
        this.accountName = accountName;
        dateCreated = new Date();
        accountNumber.incrementAndGet();
    }

    public Account(String accountName, double amount) {
        this.accountName = accountName;
        this.amount = amount;
    }

    // 1
    // create account
    public Account createAccount() {
        System.out.print("What would you like your new account to be called? ");
        String _accountName = input.nextLine();
        Account anAccount = new Account(_accountName);
        accountDict.put(_accountName, anAccount);
        System.out.println("Added the account " + BLUE + _accountName + RESET);
        return anAccount;
    }

    //2
    public Account switchAccount(Account currentAccountName) {

        viewUserAccounts();

        System.out.print("Name of account to access: ");
        String _accountName = input.nextLine();

        if(accountDict.containsKey(_accountName)) {
            System.out.println("Switched to account " + BLUE + _accountName + RESET);
            return accountDict.get(_accountName);
        } else {
            System.out.println("The account " + RED + _accountName + RESET + " does not exist.");
        }

        return currentAccountName;
    }


    // 3
    public void printBalance() {
        System.out.println("Balance: " + BLUE + balance + RESET);
    }

    // 4
    public void makeWithdrawal() {

        System.out.print("Enter the amount you want to withdraw: ");
        double withdrawalAmount = input.nextDouble();

        if(balance >= withdrawalAmount && withdrawalAmount >= 0.0) {
            balance -= withdrawalAmount;

        } else if(withdrawalAmount > balance) {
            System.out.println("The withdraw must be more than your balance of $" + GREEN + balance + RESET);
            makeWithdrawal();

        } else {
            System.out.println(RED + "An error occured." + RESET);
            System.exit(0);
        }
    }

    // 5
    public void makeDeposit() {

        System.out.print("Enter the amount you would like to deposit: ");
        double depositAmount = input.nextDouble();
        if(depositAmount > 0) {
            //transaction = new Transaction("deposit", depositAmount);
            balance += depositAmount;
        }
    }

    // 6
    public void viewCurrentAccount() {

        System.out.println("\nAccount Name: " + BLUE + accountName + RESET +
                "\nAccount Number: " + BLUE + accountNumber + RESET +
                //"\nDate Created: " + BLUE + dateCreated.toString() + RESET +
                "\nBalance: " + BLUE + balance + RESET);
    }

    // 7
    public void viewAllAccounts() {

        Account _account;

         for (Map.Entry<String, Account> entry : accountDict.entrySet()) {

            _account = accountDict.get(entry.getKey());

            System.out.println(BLUE + _account.accountName + RESET +  " | $" +
                    BLUE + _account.balance + RESET + " | Created: " + BLUE +
                    _account.dateCreated + RESET);
        }
    }

    // displays when user is about to switch accounts.
    public void viewUserAccounts() {
        // print keys/accountnames
        for (Map.Entry<String, Account> entry : accountDict.entrySet()) {
            String key = entry.getKey();
            System.out.println(BLUE + key + RESET);
            //Account value = entry.getValue();
        }
    }
}
