import java.util.Scanner;

public abstract class BankAccount  {
    private final int accNumber;
    private double balance;
    private String customerId;

    // Constructors

    public BankAccount( double balance, Customer customer) {
        int lastAccountNumber = 9999999;
        this.accNumber = lastAccountNumber+1;
        lastAccountNumber++;
        this.balance = balance;
        this.customerId = customer.getCustomerId();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customer) {
        this.customerId = customer.getCustomerId();
    }

    public int getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    //Methods
    Scanner sc = new Scanner(System.in);

    //method to search an account number


    public void deposit(){
        double amount;
        System.out.println("Enter amount to deposit (format: 0.00): ");
        amount = sc.nextDouble();
        if(amount != 0){
            setBalance(getBalance() + amount);
        }
    }
    public void withdraw(){
        double amount;
        System.out.println("Enter amount to withdraw: ");
        amount = sc.nextDouble();
        if(amount !=0){
            if(amount<=balance){
                setBalance(this.balance - amount);
            }else System.out.println("Insufficient funds");
        } else System.out.println("Field required ");
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



}


