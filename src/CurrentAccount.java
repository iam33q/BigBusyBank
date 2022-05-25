import com.opencsv.CSVWriter;

import java.util.Scanner;

public class CurrentAccount extends BankAccount {
    private int currentSortCode;

    public CurrentAccount(double balance, Customer customer) {
        super(balance, customer);
        this.currentSortCode = 103445;
    }

    public CurrentAccount(double balance) {
        super(balance);
        this.currentSortCode = 103445;
    }
    public CurrentAccount() {
        super();
        this.currentSortCode = 103445;
    }

    public int getCurrentSortCode() {
        return currentSortCode;
    }

    public static CurrentAccount newCurrentAccount() {
        CurrentAccount currentAcc = new CurrentAccount();
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nNew current account sort code: "+ currentAcc.getCurrentSortCode() +
            "\nAccount number is: "
                    + currentAcc.getAccNumber());
            System.out.printf( "\nInitial balance is: %.2f "  , currentAcc.getBalance());

            currentAcc.deposit();

        } catch (Exception e) {
            e.printStackTrace();
        }
      return currentAcc;

    }

    public static void saveCurrentAccountToDisk( CurrentAccount currentAcc){

        

    }

}