import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsaAccount extends BankAccount {
    private static String sortCode ="103446";
    private static final float annualInterestRate = 0.02F;
    private static final double maxAllowance = 19607;

    private static String interestYear;

    //Constructors-----------------------------------------------------------

    public IsaAccount( Customer customer, double balance) {
        super(customer, balance);
        IsaAccount.sortCode= "103446";
        IsaAccount.interestYear = String.valueOf(LocalDate.now().getYear());
    }

    public IsaAccount(double balance) {
        super(balance);
        interestYear = String.valueOf(LocalDate.now().getYear());
    }

    public IsaAccount() {
        super();
        interestYear = String.valueOf(LocalDate.now().getYear());
    }

    //Getters ---------------------------------------------------------------------------------------
    public static String getSortCode() {
        return sortCode;
    }

    private static float getAnnualInterestRate() {
        return annualInterestRate;
    }

    private static double getMaxAllowance() {
        return maxAllowance;
    }

    public static String getInterestYear() {
        return interestYear;
    }

    //Setters-------------------------------------------------------------------------
    private void setInterestYear(String interestYear) {
        IsaAccount.interestYear = interestYear;
    }

    //Methods
    public static IsaAccount newIsaAccount( Customer customer) {
        IsaAccount isaAcc = new IsaAccount(null,0);
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nNew ISA account sort code: "+ isaAcc.getSortCode() +
                    "\nAccount number is: "
                    + isaAcc.getAccNumber() +
                    "\nInitial balance is: " + isaAcc.getBalance()+
            "\nInterest year is: " + isaAcc.getInterestYear());

            isaAcc.deposit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        writeToDisk(isaAcc);
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

        if(amount>0 && !((getBalance()+amount) > getMaxAllowance())){
            setBalance(getBalance() + amount);
        }
        System.out.printf("New balance is: %.2f" ,getBalance());
        System.out.println();

    }


    public void addInterestToBalance(){
        double interest;
        String currentYear = String.valueOf(LocalDate.now().getYear());
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


    public static void writeToDisk(IsaAccount acc) {
        try {
            File middleFile = new File("middle.csv");
            File endFile = new File("customerAccountsData.csv");
            CSVReader reader = new CSVReader(new FileReader("customerAccountsData.csv"));
            List<String[]> allRecords = reader.readAll();
            reader.close();
            boolean deleted = endFile.delete();

            ArrayList<String> CSVInput = new ArrayList<>();
            CSVInput.add(getCustomerId());
            CSVInput.add(getAccNumber());
            CSVInput.add(String.valueOf(getBalance()));
            CSVInput.add(acc.getSortCode());

            allRecords.add(CSVInput.toArray(String[]::new));
            CSVWriter writer = new CSVWriter(new FileWriter("middle.csv"));
            writer.writeAll(allRecords);
            writer.close();
            if(deleted) middleFile.renameTo(new File("customerAccountsData.csv"));
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }




    }

