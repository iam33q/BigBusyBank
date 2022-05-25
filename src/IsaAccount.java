import java.util.Scanner;

public class IsaAccount extends BankAccount {
    private final int currentSortCode =103446;
    private final float annualInterestRate = 0.2F;
    private final double maxBalance = 20000;

    private final String interestDate = "01-03"; // it should be more sofisticated way to specify the date of interest

    public IsaAccount(double balance, Customer customer) {
        super(balance, customer);

    }
    public IsaAccount(double balance) {
        super(balance);

    }

    public IsaAccount() {
        super();
    }


    private int getCurrentSortCode() {
        return currentSortCode;
    }

    private float getAnnualInterestRate() {
        return annualInterestRate;
    }

    private double getMaxBalance() {
        return maxBalance;
    }

    public String getInterestDate() {
        return interestDate;
    }

    public static IsaAccount newIsaAccount() {
        IsaAccount isaAcc = new IsaAccount();
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nNew ISA account sort code: "+ isaAcc.getCurrentSortCode() +
                    "\nAccount number is: "
                    + isaAcc.getAccNumber() +
                    "\nInitial balance is: " + isaAcc.getBalance());
            isaAcc.deposit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isaAcc;

    }

    public double annualInterestAmount(){
        double balance;
        balance = getBalance();
        return balance * annualInterestRate;
    }

    public void showInterestAmount(){

        System.out.println("Annual interest amount is: " + annualInterestAmount());
    }

    public void addInterestToBalance(){
        String currentDate;
        double interest;
        System.out.println("Enter today's day and month [01-03]: ");
        currentDate = sc.nextLine();

        if(interestDate.equals(currentDate)){
            interest = annualInterestAmount();
            showInterestAmount();
            if(interest>0){
                System.out.println("interest is 0");
            } else System.out.println("There is no interest to add");

        }else System.out.println("You can not apply interest today");
    }





    public static void main(String args[])
    {
IsaAccount isaAcc = new IsaAccount(2000.00);

isaAcc.addInterestToBalance();

    }

}