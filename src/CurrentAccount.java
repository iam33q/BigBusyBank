import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CurrentAccount extends BankAccount {
    private static String sortCode;

    //Constructors-------------------------------------------------------

    public CurrentAccount(String accNumber, String customerId, double balance, String sortCode) {
        super(accNumber, customerId, balance);
       CurrentAccount.sortCode= "103445";
    }

    public CurrentAccount(String accNumber, String customerId, double balance, LocalDate openDate, String sortCode) {
        super();
    }


    //Getters--------------------------------------------------------------------------
    public String getSortCode() {
        return sortCode;
    }
//Methods-------------------------------------------------------------------------------
    public static CurrentAccount newCurrentAccount() {

        CurrentAccount acc = new CurrentAccount(null,null,0, sortCode);
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("New current account sort code is: "+ acc.getSortCode());
            System.out.println("Account number is: " + getAccNumber());
//            System.out.println("Account open date is: " + getOpenDate());
            System.out.printf( "Initial balance is: %.2f "  , getBalance());

            acc.deposit();

        } catch (Exception e) {
            e.printStackTrace();
        }
      return acc;

    }

    public static void saveCurrentAccountToDisk( CurrentAccount acc){

        ArrayList<String> CSVInput = new ArrayList<>();

            CSVInput.add(getCustomerId());
            CSVInput.add(getAccNumber());
            CSVInput.add(String.valueOf(acc.getSortCode()));
//            CSVInput.add(String.valueOf(getOpenDate()));
            CSVInput.add(String.valueOf(getBalance()));


        try {
            CSVWriter writer = new CSVWriter(new FileWriter("customerAccountsData.csv"));
            writer.writeNext(CSVInput.toArray(String[]::new));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) throws FileNotFoundException {
//        CurrentAccount acc = CurrentAccount.newCurrentAccount();
//        saveCurrentAccountToDisk( acc);

        ArrayList<CurrentAccount> accounts = Utility.readFile("customerAccountsData.csv");
        System.out.println(accounts);

             for (CurrentAccount account : accounts) {
                 System.out.println(account);
             }

              {

        }

    }


}