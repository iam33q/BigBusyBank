import java.util.Random;
import java.util.Scanner;

public  abstract class BankAccount  {
    private int accNumber;
    private double balance;
    private String customerId;

    // Constructors

    public BankAccount( double balance, Customer customer) {

        this.accNumber = new Random().nextInt(90000000)+10000000;
        this.setBalance(balance);
        this.customerId = customer.getCustomerId();
    }

    public BankAccount(double balance) {
        this.setBalance(balance);
        this.accNumber = new Random().nextInt(90000000)+10000000;
    }

    public BankAccount() {
        this.accNumber = new Random().nextInt(90000000)+10000000;
    }



    // getters
    public String getCustomerId() {
        return customerId;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    //setters

    private void setAccNumber(){
        this.accNumber = new Random().nextInt(90000000)+10000000;
    }
    void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerId(Customer customer) {
        this.customerId = customer.getCustomerId();
    }

    //Methods
    Scanner sc = new Scanner(System.in);

    public void checkBalance(){
    System.out.printf("Your balance is: %.2f ", getBalance());
    }

    public void deposit(){
        double amount;
        System.out.println("Enter amount to deposit: ");
        amount = sc.nextDouble();
        if(amount >0){
            setBalance(getBalance() + amount);
        }
        System.out.printf("New balance is: %.2f" ,getBalance());
        System.out.println();

    }

    public double withdraw(){
        double amount;
        System.out.println("Enter amount to withdraw: ");
        amount = sc.nextDouble();
        if(amount >0){
            if(amount<=balance){
                setBalance(this.balance - amount);
            }else System.out.println("Insufficient funds");
        } else System.out.println("Amount is required ");
        return getBalance();
    }


    public void transfer(){
        int sender;
        int receiver;
        double amount;

        System.out.println("Enter sender account number : ");
        sender = sc.nextInt();
        System.out.println("Enter receiver account number:  ");
        receiver = sc.nextInt();
        System.out.println("How much would you like to transfer? ");
        amount = sc.nextDouble();


    }

    //close account


}


