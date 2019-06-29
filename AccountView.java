import java.util.Scanner;

public class AccountView {


    public AccountView() { }

    public void accountView() {

        Scanner input = new Scanner(System.in);
        Account _account = new Account();
        _account.createAccount();
        int optionNumber;

        boolean exit = false;

        while(!exit) {

            System.out.print(
                    "\nAccount Options\nPlease choose the option you would like to do.\n" +
                            "1. Add an account (incomplete)\n" +
                            "2. Switch accounts\n" +
                            "3. Check balance\n" +
                            "4. Pay a bill\n" +
                            "5. Make a withdrawal\n" +
                            "6. Make a deposit\n" +
                            "7. View transaction history (incomplete)\n" +
                            "8. View current account\n" +
                            "9. View all accounts\n" +
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
                    _account.payBill();
                    break;
                case 5:
                    _account.makeWithdrawal();
                    break;
                case 6:
                    _account.makeDeposit();
                    break;
                case 7:
                    _account.viewTransactionHistory();
                    break;
                case 8:
                    _account.viewCurrentAccount();
                    break;
                case 9:
                    _account.viewAllAccounts();
                    break;
                case 0:
                    exit = true;
            }
        }
    }
}
