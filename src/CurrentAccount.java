import java.util.Scanner;

public class CurrentAccount extends BankAccount {
    private int currentSortCode;

    public CurrentAccount() {
        super();
        this.currentSortCode = 102345;
    }

    public int getCurrentSortCode() {
        return currentSortCode = 102345;
    }

    public static CurrentAccount newCurrentAccount() {
        CurrentAccount currentAcc = new CurrentAccount();
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nNew current account sort code: "+ currentAcc.getCurrentSortCode() +
            "\nAccount number is: "
                    + currentAcc.getAccNumber() +
                    "\nInitial balance is: " + currentAcc.getBalance());

            System.out.print("\nIf required enter amount to deposit (format: 0.00): ");
            double amount = sc.nextDouble();
            currentAcc.deposit(amount);
            System.out.println("\nNew current account: " + currentAcc.getAccNumber() + " updated balance is: " + currentAcc.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
      return currentAcc;

    }

}