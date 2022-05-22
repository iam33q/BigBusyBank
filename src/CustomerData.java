import com.opencsv.CSVWriter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
//import java.time.

public class CustomerData {

    String type;
    int accNumber;
    int sortCode;
    String fullName;
    String[] address = new String[4];
    String[] address2= new String[4];
    String[] address3= new String[4];
    LocalDate dob;

    private CustomerData(String type, int accNumber, int sortCode, String fullName, String[] address, LocalDate dob){
        this.type = type;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.fullName = fullName;
        this.address = address;
        this.dob=dob;
    }
    private CustomerData(String type, int accNumber, int sortCode, String fullName, String[] address, String[] address2, LocalDate dob){
        this.type = type;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.fullName = fullName;
        this.address = address;
        this.address2 = address2;
    }
    private CustomerData(String type, int accNumber, int sortCode, String fullName, String[] address, String[] address2, String[] address3, LocalDate dob){
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
    private void setAccNumber(int number){
        if (number <= 99999999 && number >= 10000000) this.accNumber = number;
    }
    private void setSortCode(){
        switch (this.getType()){
            case "basic": this.sortCode = 102345;
            case "savings": this.sortCode = 102346;
            case "business": this.sortCode = 102347;
            default: this.sortCode = 102345;
        }
    }
    private void setName(String firstName, String lastName, String otherNames){
        this.fullName = firstName+" "+otherNames+" "+lastName;
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

    // Methods
    public static void enterCustomerData(){
        try{
            System.out.println("In order to perform this function, please follow the instructions below:");
            if (LoginScript.LScript()){

            } else throw new Exception("Access Denied.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}