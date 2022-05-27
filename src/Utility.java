import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Utility {

    public static ArrayList<CurrentAccount> readFile(String fileName) throws FileNotFoundException {

        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line=br.readLine()) !=null){
                String[] account = line.split(",");
                String customerId = account[0];
                String accNumber = account[1];
                String sortCode = account[3];
//                LocalDate openDate = LocalDate.parse(account[4]);
                double balance = Double.parseDouble(account[2]);

                CurrentAccount acc = new CurrentAccount(accNumber, customerId, balance,sortCode);
                currentAccounts.add(acc);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return currentAccounts;
    }
}
