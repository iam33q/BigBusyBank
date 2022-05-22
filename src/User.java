import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

<<<<<<< HEAD:src/User.java
<<<<<<< HEAD:src/User.java
public class User {
    public String uname;
    public static String pass;

    public static User login() throws Exception {

=======
public class LoginScript {
    public static void main(String[] args) {
>>>>>>> eaf1b84f33b23f72840e36e5ca9aedef7585a31a:src/LoginScript.java
=======
public class LoginScript{
    public static boolean LScript() {
>>>>>>> 3f1a44d0aba368b7b660e6508d414c76b43226db:src/LoginScript.java
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
<<<<<<< HEAD:src/User.java
        // System.out.println(loginDetails); I think some of these don't work, unless you copy them in.
=======
        // System.out.println(loginDetails); I think some of the login details don't work, unless you copy them in.
>>>>>>> 3f1a44d0aba368b7b660e6508d414c76b43226db:src/LoginScript.java
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
<<<<<<< HEAD:src/User.java

                    User user = new User(uname, pass);
                    return user;
                    /*
                    Here shall lie the code that gives access to the rest of the app somehow
                    You know, like a proper login prompt would do it
                    Probably some encryption protocol
                     */

=======
                    tryNum = 0;
                    return true;
>>>>>>> 3f1a44d0aba368b7b660e6508d414c76b43226db:src/LoginScript.java
                } else throw new Exception("Invalid Credentials.");

            } catch (Exception e) {
                tryNum--;
                System.out.println(e.toString());
                if (tryNum == 0) {
                    System.out.println("Login Unsuccessful. Please contact your administrator!");
                }
            }
        } while (tryNum > 0);
<<<<<<< HEAD:src/User.java
        throw new Exception ("Maximum login attempts made.");
    }
    public User(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
=======
        return false;
>>>>>>> 3f1a44d0aba368b7b660e6508d414c76b43226db:src/LoginScript.java
    }
}