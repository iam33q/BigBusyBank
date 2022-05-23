import com.opencsv.CSVWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class CustomerAccount {

    String type;
    int accNumber;
    int sortCode;
    String fullName;
    String[] address = new String[4];
    String[] address2= new String[4];
    String[] address3= new String[4];
    LocalDate dob;

    //Constructors
    private CustomerAccount() {
        this(null, 0, 0, null, null, null,null,null);
    }

    //Constructors
    private CustomerAccount(String type, int accNumber, int sortCode, String fullName, LocalDate dob, String[] address){
        this.type = type;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.fullName = fullName;
        this.address = address;
        this.dob=dob;
    }
    private CustomerAccount(String type, int accNumber, int sortCode, String fullName, LocalDate dob, String[] address, String[] address2){
        this.type = type;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.fullName = fullName;
        this.address = address;
        this.address2 = address2;
    }
    private CustomerAccount(String type, int accNumber, int sortCode, String fullName, LocalDate dob, String[] address, String[] address2, String[] address3){
        this.type = type;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.fullName = fullName;
        this.address = address;
        this.address2 = address2;
        this.address3 = address3;

    }

    //Getters
    public String getType(){
        return this.type;
    }
    private int getAccNumber(){
        return this.accNumber;
    }
    private int getSortCode(){
        return this.sortCode;
    }
    private String getFullName(){
        return this.fullName;
    }
    private String[] getAddress(){
        return this.address;
    }
    private String[] getAddress2(){
        return this.address2;
    }
    private String[] getAddress3(){
        return this.address3;
    }
    private LocalDate getDob(){
        return this.dob;
    }

    //Setters
    private void setType(String selection){
        switch (selection){
            case "basic":this.type = "basic";
            case "savings":this.type = "savings";
            case "business":this.type = "business";
            default: this.type = "basic";
        }
    }
    private void setAccNumber(){
        this.accNumber = new Random().nextInt(90000000)+10000000;
    }
    private void setSortCode(){
        switch (this.getType()){
            case "basic": this.sortCode = 102345;
            case "savings": this.sortCode = 102346;
            case "business": this.sortCode = 102347;
            default: this.sortCode = 102345;
        }
    }
    private void setName(String firstName, String lastName){
        this.fullName = firstName+" "+lastName;
    }
    private void setDob(String date) // Date format: dd-MM-yyyy
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(date,dateTimeFormatter);
        LocalDate earliestLegalDate = LocalDate.now().minusYears(16);
        try
        {
            if ( dob.isBefore(earliestLegalDate) )
            {
                this.dob = dob;
            } else throw new Exception("Client is below the age of 16.");
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void setAddress(String streetNumber, String streetName,String town, String postCode){
        this.address[0] = streetNumber;
        this.address[1] = streetName;
        this.address[2] = town;
        this.address[3] = postCode;
    }
    private void setAddress2(String streetNumber, String streetName,String town, String postCode){
        this.address2[0] = streetNumber;
        this.address2[1] = streetName;
        this.address2[2] = town;
        this.address2[3] = postCode;
    }
    private void setAddress3(String streetNumber, String streetName,String town, String postCode){
        this.address3[0] = streetNumber;
        this.address3[1] = streetName;
        this.address3[2] = town;
        this.address3[3] = postCode;
    }

    // Methods
    public static CustomerAccount newCustomerAccount(){
        CustomerAccount acc = new CustomerAccount();
        try{
            System.out.println("In order to perform this function, please follow the instructions below:");
            if (LoginScript.LScript()){
                var inputs = new Hashtable<String,String>();
                Scanner input = new Scanner(System.in);
                String[] dataLabels = {"Account Number","Type","First Name","Last Name","Date of Birth","Street Number 1","Street Name 1","Town 1","Post Code 1","Street Number 2","Street Name 2","Town 2","Post Code 2","Street Number 3","Street Name 3","Town 3","Post Code 3"};
                int numberOfAddresses = 1;
                int i=0;
                String date = input.next();
                LocalDate dateinput = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                System.out.println("Input the duration of residence at current address, using the following format: [dd-MM-yyyy]");
                if(dateinput.isAfter(LocalDate.now().minusYears(3))){
                    numberOfAddresses++;
                    String date2 = input.next();
                    LocalDate dateinput2 = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    if(dateinput2.isAfter(LocalDate.now().minusYears(3))){
                        numberOfAddresses++;
                    }
                }
                for (String data:dataLabels){
                    System.out.printf("Input the following information:\n%s",data);
                    inputs.put(data,input.next());
                    i++;
                    if (i >= 4+4*numberOfAddresses) break; // Feels like there should be a better solution
                }
                acc.setType(inputs.get("Type").toString());
                acc.setSortCode();
                acc.setAccNumber();
                acc.setName(inputs.get("First Name").toString(),inputs.get("Last Name").toString());
                acc.setDob(inputs.get("Date of Birth").toString());
                acc.setAddress(inputs.get("Street Number 1"),inputs.get("Street Name 1"),inputs.get("Town 1"),inputs.get("Post Code 1"));
                if (numberOfAddresses == 2) acc.setAddress2(inputs.get("Street Number 2"),inputs.get("Street Name 2"),inputs.get("Town 2"),inputs.get("Post Code 2"));
                if (numberOfAddresses == 3) acc.setAddress3(inputs.get("Street Number 3"),inputs.get("Street Name 3"),inputs.get("Town 3"),inputs.get("Post Code 3"));
            } else throw new Exception("Access Denied.");
        } catch (Exception e){
            e.printStackTrace();
        }
        return acc;
    }
}