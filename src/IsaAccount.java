import java.time.LocalDate;
import java.util.Scanner;

public class IsaAccount extends BankAccount {
    private final int currentSortCode =103446;
    private final float annualInterestRate = 0.02F;
    private final double maxAllowence = 19607;

    private int interestYear;

    public IsaAccount(double balance, Customer customer) {
        super(balance, customer);
        this.interestYear = LocalDate.now().getYear();
    }
    public IsaAccount(double balance) {
        super(balance);
        this.interestYear = LocalDate.now().getYear();
    }

    public IsaAccount() {
        super();
        this.interestYear = LocalDate.now().getYear();
    }

    private int getCurrentSortCode() {
        return currentSortCode;
    }

    private float getAnnualInterestRate() {
        return annualInterestRate;
    }

    private double getMaxAllowence() {
        return maxAllowence;
    }

    public int getInterestYear() {
        return interestYear;
    }

    private void setInterestYear(int interestYear) {
        this.interestYear = interestYear;
    }

    //Methods
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
        System.out.printf("Annual interest amount is: %.2f ", annualInterestAmount());
    }

    @Override
    public void deposit(){
        double amount;
        System.out.println("Enter amount to deposit: ");
        amount = sc.nextDouble();

        if(amount>0 && !((getBalance()+amount) > getMaxAllowence())){
            setBalance(getBalance() + amount);
        }
        System.out.printf("New balance is: %.2f" ,getBalance());
        System.out.println();

    }
    public void addInterestToBalance(){
        double interest;
        int currentYear = LocalDate.now().getYear();
        if(currentYear==interestYear){
            if(LocalDate.now().isAfter(LocalDate.of(LocalDate.now().getYear(),3,1))){
                interest = annualInterestAmount();
                showInterestAmount();
                if(interest>0){
                    deposit();
                   setInterestYear(currentYear+1);
                } else System.out.println("There is no interest to add");

            }else System.out.println("You can not apply interest today");
        }
    }


    public static void main(String args[])
    {
IsaAccount isaAcc = new IsaAccount(2000.00);

isaAcc.addInterestToBalance();

    }

}