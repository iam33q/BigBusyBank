import java.util.Random;
import java.util.Scanner;

public  abstract class BankAccount {
    private static String accNumber;
    private static String customerId;
    private static double balance;

    private static String sortCode;


// Constructors---------------------------------------------------------------------------


    public BankAccount(Customer customer, double balance) {
        setCustomerId(customer);
        BankAccount.accNumber = String.valueOf(new Random().nextInt(90000000) + 10000000);
        ;
        BankAccount.balance = balance;

    }

    public BankAccount() {

    }


    public BankAccount(double balance) {
    }

    // getters------------------------------------------------------------------------
    public static String getCustomerId() {
        return customerId;
    }

    public static String getAccNumber() {
        return accNumber;
    }

    public static double getBalance() {
        return balance;
    }

//    public static LocalDate getOpenDate() {
//        return openDate;
//    }

    //setters-----------------------------------------------------------------

    public static void setBalance(double balance) {
        BankAccount.balance = balance;
    }

    public void setCustomerId(Customer customer) {
        BankAccount.customerId = Customer.getCustomerId();
    }

//    public static void setSortCode(String sortCode) {
//        BankAccount.sortCode = sortCode;
//    }

    //Methods------------------------------------------------------------------------------
    Scanner sc = new Scanner(System.in);

    public void checkBalance() {
        System.out.printf("Your balance is: %.2f ", getBalance());
    }


    public void runDeposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
    }

    public static void runWithdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                setBalance(balance - amount);
            } else System.out.println("Insufficient funds");
        } else System.out.println("Amount is required ");
    }

    protected void deposit() {
        double amount;
        System.out.println("Enter amount to deposit: ");
        amount = sc.nextDouble();
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
        System.out.printf("New balance is: %.2f", getBalance());
        System.out.println();
    }

    public double withdraw() {
        double amount;
        System.out.println("Enter amount to withdraw: ");
        amount = sc.nextDouble();
        if (amount > 0) {
            if (amount <= balance) {
                setBalance(balance - amount);
            } else System.out.println("Insufficient funds");
        } else System.out.println("Amount is required ");
        return getBalance();
    }

    //WIP -------------------------------------------------
    public void transfer(BankAccount to, double amount) {
        this.runWithdraw(amount);
        to.runDeposit(amount);
        ;
    }
}


