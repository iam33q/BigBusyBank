import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class BussinessAccount extends BankAccount{

    private String UTRnumber;
    private static double annualFee;

    private static String sortCode = "103447";

    private static boolean checkBook;

    private static String chargeFeeDate;


    //Constructors


    public BussinessAccount(Customer customer, double balance, String UTRnumber) {
        super(customer, balance);
        this.UTRnumber = UTRnumber;
        annualFee = 50;
        BussinessAccount.sortCode= "103447";
        BussinessAccount.checkBook=true;
        BussinessAccount.chargeFeeDate= String.valueOf(LocalDate.now());


    }

    public BussinessAccount(String UTRnumber) {
        this.UTRnumber = UTRnumber;
        annualFee = 50;
        BussinessAccount.sortCode= "103447";
        BussinessAccount.checkBook=true;
        BussinessAccount.chargeFeeDate= String.valueOf(LocalDate.now());
    }

    public BussinessAccount(double balance, String UTRnumber) {
        super(balance);
        this.UTRnumber = UTRnumber;
        annualFee = 50;
        BussinessAccount.sortCode= "103447";
        BussinessAccount.checkBook=true;
        BussinessAccount.chargeFeeDate= String.valueOf(LocalDate.now());
    }


    //Getters and setters


    public String getUTRnumber() {
        return UTRnumber;
    }

    public void setUTRnumber(String utRnumber) {
      try{
          int length = UTRnumber.length();
          if (length !=10) {throw new Exception("Invalid HMRC number");}
          else UTRnumber = utRnumber;
      } catch (Exception e) {
          throw new RuntimeException(e);
      }

    }

    public static double getAnnualFee() {
        return annualFee;
    }

    private void setAnnualFee(double annualFee) {
        annualFee = annualFee;
    }

    public static String getSortCode() {
        return sortCode;
    }

    public static void setChargeFeeDate(String chargeFeeDate) {
        BussinessAccount.chargeFeeDate = chargeFeeDate;
    }

//Methods

    public static BussinessAccount newBusinessAccount( Customer customer, String UTRnumber, int openingBalance) {
        BussinessAccount acc = new BussinessAccount(null, 0, null);
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nNew Bussiness account sort code: "+ acc.getSortCode() +
                    "\nAccount number is: "
                    + acc.getAccNumber() +
                    "\nInitial balance is: " + acc.getBalance());

            acc.deposit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    public static void chargeAnnualFee(){
        double fee = getAnnualFee();
        chargeFeeDate = "2022-05-27";
        String currentDate = String.valueOf(LocalDate.now());
        double balance = getBalance();
        if(Objects.equals(currentDate, chargeFeeDate)){
            setBalance(balance - fee);
            System.out.println("Your new balance is: " + getBalance());
            LocalDate date = LocalDate.parse(currentDate);
            setChargeFeeDate(String.valueOf(date.plusYears(1)));
            } else System.out.println("You can not charge the business fee yet. ");
    }

}
