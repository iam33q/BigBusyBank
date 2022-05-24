import java.util.Scanner;

public class IsaAccount extends BankAccount {
    private final int currentSortCode =102345 ;
    private final float interset = 2.0F;
    private double interest;

    private String interestDate = "01-03";

    public IsaAccount(double interest, String interestDate) {
        this.interest = interest;
        this.interestDate = interestDate;
    }

    public IsaAccount(double balance, double interest, String interestDate) {
        super(balance);
        this.interest = interest;
        this.interestDate = interestDate;
    }

    public int getCurrentSortCode() {
        return currentSortCode;
    }

    public float getInterset() {
        return interset;
    }



    public static IsaAccount newIsaAccount() {
        IsaAccount isaAcc = new IsaAccount();
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nNew ISA account sort code: "+ isaAcc.getCurrentSortCode() +
                    "\nAccount number is: "
                    + isaAcc.getAccNumber() +
                    "\nInitial balance is: " + isaAcc.getBalance());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isaAcc;

    }

}