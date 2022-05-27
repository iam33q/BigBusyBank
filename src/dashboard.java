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
        System.out.println("hey there " + u.uname + " please enter 'existing customer' to access an existing customer," +
                " 'edit customer' to edit a customer, 'edit account' to edit an account, 'close' to close an existing account," +
                " 'new customer' to create a new profile, or 'new account' to create a new account");

//        read the input that the user enters
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toUpperCase();

//        switch statement to execute the requested functionality
        switch(input) {

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

//            edit account functionality
            case "EDIT ACCOUNT":
                System.out.println("You are going to edit an account");
                break;

//            close account functionality
            case "CLOSE":
                System.out.println("You are going to close an account");
                break;

//            new customer functionality
            case "NEW CUSTOMER":
                System.out.println("You are going to create a new customer");
                Customer cus = Customer.newCustomer();
                break;

//            new account functionality
            case "NEW ACCOUNT":
                System.out.println("You are going to open a new account");
                break;
        }
    }
}