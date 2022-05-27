import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CurrentAccount extends BankAccount {
    private static String sortCode;

    //Constructors-------------------------------------------------------

    public CurrentAccount(Customer customer, double balance) {
        super(customer, balance);
        CurrentAccount.sortCode = "103445";
    }

    public CurrentAccount() {
        CurrentAccount.sortCode = "103445";
    }

    public CurrentAccount(double balance) {
        super(balance);
        CurrentAccount.sortCode = "103445";
    }


    public CurrentAccount(String accNumber, String customerId, double balance, String sortCode) {
        super();
        CurrentAccount.sortCode = "103445";
    }

    public CurrentAccount(String accNumber, String customerId, String balance, String sortCode) {
        CurrentAccount.sortCode = "103445";
    }

    //Getters--------------------------------------------------------------------------
    public String getSortCode() {
        return sortCode;
    }


    //Methods-------------------------------------------------------------------------------
    public static CurrentAccount newCurrentAccount(Customer customer) {

        CurrentAccount acc = new CurrentAccount(null, 0);
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println(customer.getCustomerId());
            if(Objects.equals(getCustomerId(), "Null")){
                System.out.println("No account can be created");
                return new CurrentAccount(null,0);}

            System.out.println("New current account sort code is: " + acc.getSortCode());
            System.out.println("Account number is: " + getAccNumber());
            System.out.println("Obligatory opening deposit of minimum GBP50" );
            acc.deposit();
            System.out.printf("Initial balance is: %.2f ", getBalance());


        } catch (Exception e) {
            e.printStackTrace();
        }
        writeToDisk(acc);
        return acc;

    }

    public static void writeToDisk(CurrentAccount acc) {
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