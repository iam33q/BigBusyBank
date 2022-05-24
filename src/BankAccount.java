public abstract class BankAccount  {
    private final int accNumber;
    private double balance;


    // Constructors

    public BankAccount() {
        int lastAccountNumber = 99999999;
        this.accNumber = lastAccountNumber+1;
    }
    private BankAccount( double balance) {
        int lastAccountNumber = 99999999;
        this.accNumber = lastAccountNumber+1;
        this.balance = balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Methods
    public void deposit(double amount){
        if(amount != 0){
            setBalance(getBalance() + amount);
        }
    }
    public void withdraw(double amount){
        if(amount !=0){
            setBalance(this.balance - amount);
        }
    }

    public void transfer(int fromAccNum, int toAccNum, double amount){


    }



}


