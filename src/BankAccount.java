import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class BankAccount  {

//    private int customerId;
    private String fullName;
   private int accNumber;
   private int sortCode;
    private String type;
    private int balance;
   // list class another
    private int transactionAmount;


    // Constructors
    private BankAccount() {
        this( null, 0, 0, null, 0, 0);
    }

    private BankAccount( String fullName, int accNumber, int sortCode, String type, int balance, int transactionAmount) {

        this.fullName = fullName;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.type = type;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
    }
    private BankAccount( String fullName, int accNumber, int sortCode, String type, int balance) {

        this.fullName = fullName;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.type = type;
        this.balance = balance;

    }


    // getters
    public String getFullName() {
        return fullName;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    public String getType() {
        return type;
    }

    public int getBalance() {
        return balance;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }


// setters
    private void setFullName(String firstName, String lastName){
    this.fullName = firstName+" "+lastName;
}

    private void setAccNumber(){
        this.accNumber = new Random().nextInt(90000000)+10000000;
    }

    private void setSortCode(){
        switch (this.getType()){
            case "basic": this.sortCode = 102345;
            case "savings": this.sortCode = 102346;
            case "business": this.sortCode = 102347;
//            default: this.sortCode = 102345;
        }
    }
    private void setType(String selection){
        switch (selection){
            case "basic":this.type = "basic";
            case "savings":this.type = "savings";
            case "business":this.type = "business";
//            default: this.type = "basic";
        }
    }
    public void setBalance(int balance) {this.balance = balance;}

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    //Methods
    public static void newBankAccount() throws Exception {
        BankAccount acc = new BankAccount();
        try {

            System.out.println("In order to perform this function, please follow the instructions below:");
            if (LoginScript.LScript()) { // Additional login credentials check
                var inputs = new Hashtable<String, String>();
                System.out.println(inputs);
                Scanner input = new Scanner(System.in);
                String[] dataLabels = {"First Name", "Last Name", "Type of account", "Balance", "Transaction Amount"};
                String scan;

                //Populating the inputs table with user inputs
                for (String data : dataLabels) {
                    System.out.printf("Input the following information:\n%s", data + ": ");
                    scan = input.nextLine();
                    inputs.put(data, scan);

                }
                // Time to set some states
                acc.setFullName(inputs.get("First Name"), inputs.get("Last Name"));
                acc.setType(inputs.get("Type"));
                acc.setSortCode();
                acc.setAccNumber();
                acc.setBalance(Integer.parseInt(inputs.get("Balance")));
                acc.setTransactionAmount(Integer.parseInt(inputs.get("Transaction Amount")));
            } else throw new Exception("Access Denied.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //??WIP//
//    public void deposit(int amount){
//        if(amount != 0){
//            setBalance(getBalance() + amount);
//            setTransactionAmount(amount);
//        }
//    }
//
//    public void withdraw(int amount){
//        if(amount !=0){
//            setBalance(this.balance - amount);
//            setTransactionAmount(-amount);
//        }
//    }

//    public void getTransactionAmount(){
//
//    }



}


