//import com.opencsv.CSVWriter;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class IsaAccount extends BankAccount {
//    private static final int sortCode =103446;
//    private static final float annualInterestRate = 0.02F;
//    private static final double maxAllowance = 19607;
//
//    private static int interestYear;
//
//    //Constructors-----------------------------------------------------------
//
//    public IsaAccount(double balance, Customer customer) {
//        super(balance, customer);
//        this.interestYear = LocalDate.now().getYear();
//    }
//    public IsaAccount(double balance) {
//        super(balance);
//        this.interestYear = LocalDate.now().getYear();
//    }
//
//    public IsaAccount() {
//        super();
//        this.interestYear = LocalDate.now().getYear();
//    }
//
//    //Getters ---------------------------------------------------------------------------------------
//    public static int getSortCode() {
//        return sortCode;
//    }
//
//    private static float getAnnualInterestRate() {
//        return annualInterestRate;
//    }
//
//    private static double getMaxAllowance() {
//        return maxAllowance;
//    }
//
//    public static int getInterestYear() {
//        return interestYear;
//    }
//
//    //Setters-------------------------------------------------------------------------
//    private void setInterestYear(int interestYear) {
//        this.interestYear = interestYear;
//    }
//
//    //Methods
//    public static IsaAccount newIsaAccount() {
//        IsaAccount isaAcc = new IsaAccount();
//        try {
//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("\nNew ISA account sort code: "+ isaAcc.getSortCode() +
//                    "\nAccount number is: "
//                    + isaAcc.getAccNumber() +
//                    "\nInitial balance is: " + isaAcc.getBalance());
//            isaAcc.deposit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isaAcc;
//    }
//
//    public double annualInterestAmount(){
//        double balance;
//        balance = getBalance();
//        return balance * annualInterestRate;
//    }
//
//    public void showInterestAmount(){
//        System.out.printf("Annual interest amount is: %.2f ", annualInterestAmount());
//    }
//
//    @Override
//    public void deposit(){
//        double amount;
//        System.out.println("Enter amount to deposit: ");
//        amount = sc.nextDouble();
//
//        if(amount>0 && !((getBalance()+amount) > getMaxAllowance())){
//            setBalance(getBalance() + amount);
//        }
//        System.out.printf("New balance is: %.2f" ,getBalance());
//        System.out.println();
//
//    }
//    public void addInterestToBalance(){
//        double interest;
//        int currentYear = LocalDate.now().getYear();
//        if(currentYear==interestYear){
//            if(LocalDate.now().isAfter(LocalDate.of(LocalDate.now().getYear(),3,1))){
//                interest = annualInterestAmount();
//                showInterestAmount();
//                if(interest>0){
//                    deposit();
//                   setInterestYear(currentYear+1);
//                } else System.out.println("There is no interest to add");
//
//            }else System.out.println("You can not apply interest today");
//        }
//    }
//
//
//    public static void saveIsaAccountToDisk( IsaAccount acc){
//        ArrayList<String> CSVInput = new ArrayList<>();
//
//        CSVInput.add(getCustomerId());
//        CSVInput.add(String.valueOf(getAccNumber()));
//        CSVInput.add(String.valueOf(getBalance()));
//        CSVInput.add(String.valueOf(getSortCode()));
//        CSVInput.add(String.valueOf(getInterestYear()));
//        CSVInput.add(String.valueOf(getAnnualInterestRate()));
//        CSVInput.add(String.valueOf(getMaxAllowance()));
//
//        try {
//            CSVWriter writer = new CSVWriter(new FileWriter("customerData.csv"));
//            writer.writeNext(CSVInput.toArray(String[]::new));
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String args[])
//    {
//IsaAccount isaAcc = new IsaAccount(2000.00);
//
//isaAcc.addInterestToBalance();
//
//    }
//
//}