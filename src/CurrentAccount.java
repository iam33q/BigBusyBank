import com.opencsv.CSVWriter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    //Setters



    //Methods-------------------------------------------------------------------------------
    public static CurrentAccount newCurrentAccount(Customer customer) {

        CurrentAccount acc = new CurrentAccount(null, 0);
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("New current account sort code is: " + acc.getSortCode());
            System.out.println("Account number is: " + getAccNumber());
//            System.out.println("Account open date is: " + getOpenDate());
            System.out.printf("Initial balance is: %.2f ", getBalance());

            acc.deposit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;

    }

//    public static void saveCurrentAccountToDisk(Object acc) {
//
////        ArrayList<String> CSVInput = new ArrayList<>();
//
//        ArrayList<Object> accounts = new ArrayList<>();
//        accounts.add(acc);
//
//
////            CSVInput.add(getCustomerId());
////            CSVInput.add(getAccNumber());
////            CSVInput.add(String.valueOf(acc.getSortCode()));
//////            CSVInput.add(String.valueOf(getOpenDate()));
////            CSVInput.add(String.valueOf(getBalance()));
//
//
//        try {
////            CSVWriter writer = new CSVWriter(new FileWriter("customerAccountsData.csv"));
//////            writer.writeNext(CSVInput.toArray(String[]::new));
////            writer.close();
//            final String CSV_SEPARATOR = ",";
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("products.csv"), "UTF-8"));
//            for (Object account : accounts) {
//                StringBuffer oneLine = new StringBuffer();
//                oneLine.append(getAccNumber());
//                oneLine.append(CSV_SEPARATOR);
//                oneLine.append(account.getCustomerId());
//                oneLine.append(CSV_SEPARATOR);
//                oneLine.append(account.getBalance());
//                oneLine.append(CSV_SEPARATOR);
//                oneLine.append(account.getSortCode());
//                bw.write(oneLine.toString());
//                bw.newLine();
//            }
//            bw.flush();
//            bw.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}