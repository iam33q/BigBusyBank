import java.util.Scanner;

public class CurrentAccount extends BankAccount {
    private int currentSortCode;

    public CurrentAccount() {

    }

    public int getCurrentSortCode() {
        return currentSortCode = 102345;
    }
    public CurrentAccount(double balance) {
        super(balance);
        this.currentSortCode = 102345;
    }

    public CurrentAccount newCurrentAccount() {
        CurrentAccount currentAcc = new CurrentAccount();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("In order to create current account, please follow the instructions below:");
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            CurrentAccount currentAccount = new CurrentAccount(amount);
            System.out.println("Customer X current account sort code is: "+ currentAccount.getCurrentSortCode() + " account number is: "
                    + currentAccount.getAccNumber() + " initial balance is: " + currentAccount.getBalance());

        } catch (Exception e) {
            e.printStackTrace();
        }
      return currentAcc;

    }

}