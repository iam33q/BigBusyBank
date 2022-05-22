import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class LoginScript{
    public static boolean LScript() {
        var loginDetails = new Hashtable<String,String>(); // This is where the login details will sit
        try {
            CSVReader reader = new CSVReader(new FileReader("loginData.csv")); // Importing CSV data inside this weird object
            String[][] data= reader.readAll().toArray(String[][]::new);                 // Converting weird object into workable string array
            for (String[] pair:data) loginDetails.put(pair[0], pair[1]);                // Placing array data into key value pairs
        }
        catch (IOException | CsvException e){
            throw new RuntimeException(e);
        }
        int tryNum = 3;
        String uname;
        String pass;
        // System.out.println(loginDetails); I think some of the login details don't work, unless you copy them in.
        do {
            try {
                Scanner input1 = new Scanner(System.in);
                Scanner input2 = new Scanner(System.in);
                System.out.println("Please enter your username: ");
                uname = input1.next();
                System.out.println("Now enter your password: ");
                pass = input2.next();
                if (pass.equals(loginDetails.get(uname))) {
                    System.out.println("Login successful!");
                    return true;
                } else throw new Exception("Invalid Credentials.");
            } catch (Exception e) {
                tryNum--;
                System.out.println(e.toString());
                if (tryNum == 0) System.out.println("Validation Unsuccessful.");
            }
        } while (tryNum > 0);
        return false;
    }
}