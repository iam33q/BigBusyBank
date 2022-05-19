import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class LoginScript {
    public static void main(String[] args) {

        var loginDetails = new Hashtable<String,String>(); // This is where the login details will sit
        try // Maximum Security Data Importer. Hopefully it's readable.
        {
            CSVReader reader = new CSVReader(new FileReader("loginData.csv"));  // Importing CSV data inside this weird object
            String[][] data= reader.readAll().toArray(String[][]::new);                 // Converting weird object into workable string array
            for (String[] pair:data) loginDetails.put(pair[0], pair[1]);                // Placing array data into key value pairs
        }
        catch (IOException | CsvException e)
        {
            throw new RuntimeException(e);
        }

        int tryNum = 3;
        String uname;
        String pass;
        System.out.println(loginDetails);
        do {
            try {
                Scanner input1 = new Scanner(System.in);
                Scanner input2 = new Scanner(System.in);
                System.out.println("Please enter your username: ");
                uname = input1.next().toLowerCase();
                System.out.println("Now enter your password: ");
                pass = input2.next();
                if (uname.equals("")) {
                    tryNum++;
                    throw new Exception("Invalid username.");
                }

                if (pass.equals(loginDetails.get(uname))) {
                    System.out.println("Login successful!");
                    tryNum = 0;
                } else {
                    throw new Exception("Invalid Credentials.");
                }
            } catch (Exception e) {
                tryNum--;
                if (tryNum == 0) {
                    System.out.println("Login Unsuccessful. Please contact your administrator!");
                }
            }
        } while (tryNum > 0);
    }
}