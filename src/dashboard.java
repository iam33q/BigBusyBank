import java.util.Random;
import java.util.Scanner;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Hashtable;

public class dashboard {
    public static void main(String[] args) throws Exception {
//        create a new instance of User

        User u = User.login();

//        CurrentAccount acc = CurrentAccount.newCurrentAccount();

//        ask which task the user would like to perform
        System.out.println("hey there " + u.uname + " please enter 'withdraw' to withdraw money, 'transfer' to transfer money,");
        System.out.println(" 'existing customer' to access an existing customer, 'edit customer' to edit a customer,");
        System.out.println(" 'new customer' to create a new customer profile, or 'new account' to create a new account, or 'x' to exit");

        boolean closed = false;
        while (!closed) {
//        read the input that the user enters
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().toUpperCase();

//        switch statement to execute the requested functionality
            switch (input) {

//            withdraw money functionality
                case "WITHDRAW":
                    System.out.println("You are going to withdraw money from an account");
                    break;

//            transfer money functionality
                case "TRANSFER":
                    System.out.println("You are going to transfer money between two accounts");
                    break;

//            existing customer functionality
                case "EXISTING CUSTOMER":
                    System.out.println("You are going to access an existing customer");
                    Customer customer = Customer.readFromDisk();
                    break;

//            edit customer functionality
                case "EDIT CUSTOMER":
                    System.out.println("You are going to edit a customer");
                    Customer.edit(Customer.readFromDisk());
                    break;

//            new customer functionality
                case "NEW CUSTOMER":
                    System.out.println("You are going to create a new customer");
                    Customer cus = Customer.newCustomer();
                    break;

//            new account functionality
                case "NEW ACCOUNT":
                    System.out.println("You are going to open a new account. Type 'c' to add a current account,"
                    + " 'i' for an ISA account, or 'b' for a business account.");
                    Scanner in2 = new Scanner(System.in);
                    String input2 = in2.nextLine().toUpperCase();
                    switch (input2) {

                        case "C":
                            CurrentAccount.newCurrentAccount(Customer.readFromDisk());
                            break;

                        case "I":
                            IsaAccount.newIsaAccount(Customer.readFromDisk());
                            break;

                        case "B":
                            System.out.println("Please enter a correct UTR number");
                            Scanner in3 = new Scanner(System.in);
                            String input3 = in3.nextLine();
                            BussinessAccount.newBusinessAccount(Customer.readFromDisk(), input3);
                            break;

                        default:
                            System.out.println("Invalid input, please try again.");

                    }
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
                    break;

                case "X":
                    closed = true;
                    System.out.println("You have exited this banking app");
            }
        }
    }
}