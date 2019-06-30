import java.util.Scanner;

public class AccountView {

    public AccountView() { }

    public void accountView() {

        Scanner input = new Scanner(System.in);
        Account _account = new Account();
        _account = _account.createAccount();
        int optionNumber;

        boolean exit = false;

        while(!exit) {

            System.out.print(
                    "\n(" + _account.getAccountName() + ")" +
                    " Account Options\nPlease choose the option you would like to do.\n" +
                            "1. Add an account\n" +
                            "2. Switch accounts\n" +
                            "3. Check balance\n" +
                            "4. Make a withdrawal\n" +
                            "5. Make a deposit\n" +
                            "6. View current account\n" +
                            "7. View all accounts\n" +
                            "0. Sign out\n" + ">>> ");

            optionNumber = input.nextInt();

            switch (optionNumber) {
                case 1:
                    _account = _account.createAccount();
                    break;
                case 2:
                    _account = _account.switchAccount(_account);
                    break;
                case 3:
                    _account.printBalance();
                    break;
                case 4:
                    _account.makeWithdrawal();
                    break;
                case 5:
                    _account.makeDeposit();
                    break;
                case 6:
                    _account.viewCurrentAccount();
                    break;
                case 7:
                    _account.viewAllAccounts();
                    break;
                case 0:
                    exit = true;
            }
        }
    }
}
