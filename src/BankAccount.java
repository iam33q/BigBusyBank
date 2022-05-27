import java.util.Random;
import java.util.Scanner;

public  abstract class BankAccount  {
    private static String accNumber;
    private static String customerId;
    private static double balance;

//    private static LocalDate openDate;

// Constructors---------------------------------------------------------------------------


    public BankAccount(String accNumber, String customerId, double balance) {
        BankAccount.customerId=customerId;
        BankAccount.accNumber = String.valueOf(new Random().nextInt(90000000)+10000000);;
        BankAccount.balance = balance;
//        BankAccount.openDate= LocalDate.now();
    }

    public BankAccount() {

    }

    // getters------------------------------------------------------------------------
    public static String getCustomerId() {return customerId;}
    public static String getAccNumber() {return accNumber;}

    public static double getBalance() {return balance;}

//    public static LocalDate getOpenDate() {
//        return openDate;
//    }

    //setters-----------------------------------------------------------------

    public void setBalance(double balance) {
        BankAccount.balance = balance;
    }

    public void setCustomerId(Customer customer) {
        BankAccount.customerId = Customer.getCustomerId();
    }



    //Methods------------------------------------------------------------------------------
    Scanner sc = new Scanner(System.in);

    public void checkBalance(){
    System.out.printf("Your balance is: %.2f ", getBalance());
    }


    public void runDeposit(double amount){
        if(amount >0){
            setBalance(getBalance() + amount);
        }
    }

    public  void runWithdraw(double amount){
        if(amount >0){
            if(amount<=balance){
                setBalance(balance - amount);
            }else System.out.println("Insufficient funds");
        } else System.out.println("Amount is required ");
    }
    protected void deposit(){
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
                setBalance(balance - amount);
            }else System.out.println("Insufficient funds");
        } else System.out.println("Amount is required ");
        return getBalance();
    }

//WIP -------------------------------------------------
    public void transfer(BankAccount to, double amount){
        this.runWithdraw(amount);
        to.runDeposit(amount);;

//        int sender;
//        int receiver;
//        double amount;
//
//        System.out.println("Enter sender account number : ");
//        sender = sc.nextInt();
//        System.out.println("Enter receiver account number:  ");
//        receiver = sc.nextInt();
//        System.out.println("How much would you like to transfer? ");
//        amount = sc.nextDouble();


    }


//    public static void saveCurrentAccountToDisk( BankAccount acc){
//        ArrayList<String> CSVInput = new ArrayList<>();
//
//        CSVInput.add(getCustomerId());
//        CSVInput.add(String.valueOf(getAccNumber()));
//        CSVInput.add(String.valueOf(getBalance()));
//
//        try {
//            CSVWriter writer = new CSVWriter(new FileWriter("customerData.csv"));
//            writer.writeNext(CSVInput.toArray(String[]::new));
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}


