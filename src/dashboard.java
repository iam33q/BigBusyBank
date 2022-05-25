import java.util.Random;
import java.util.Scanner;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Hashtable;

public class dashboard {
    public static void main(String[] args) throws Exception {
//        create a new instance of User

        User u = User.login();

        CurrentAccount acc = CurrentAccount.newCurrentAccount();



//        ask for which task the user would like to perform
        System.out.println("hey there " + u.uname + " please press 'e' to access an existing account," +
                " 'c' to close an existing account, or 'n' to open a new account");

//        read the input that the user enters
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toUpperCase();

//        switch statement to execute the requested functionality
        switch(input) {

            case "E":
                System.out.println("Please enter a bank account number");
                input = in.nextLine();
//                bringing in code from User.java
                var loginDetails = new Hashtable<String,String>(); // This is where the login details will sit
                CSVReader reader = new CSVReader(new FileReader("loginData.csv"));  // Importing CSV data inside this weird object
                String[][] data= reader.readAll().toArray(String[][]::new);                 // Converting weird object into workable string array
                for (String[] pair:data) loginDetails.put(pair[0], pair[1]);                // Placing array data into key value pairs
                System.out.println("The balance for account number " + input + " is equal to " + loginDetails.get(input));
                break;

            case "C":
                System.out.println("You are going to close an account");
                break;

            case "N":
                System.out.println("You are going to open a new account");
                Customer cus = Customer.newCustomer();
                break;
        }
    }
}