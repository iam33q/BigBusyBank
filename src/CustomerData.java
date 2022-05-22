import java.time.*;
import java.util.Date;
//import java.time.

public class CustomerData {

    String type;
    int accNumber;
    int sortCode;
    String fullName;
    String address;
    LocalDate dob;

    private CustomerData(String type, int accNumber, int sortCode, String fullName, String address, Instant dob){
        this.type = type;
        this.accNumber = accNumber;
        this.sortCode = sortCode;
        this.fullName = fullName;
        this.address = address;
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
    private String getAddress(){
        return this.address;
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
        this.address = streetName+" "+streetName+", "+town+", "+postCode;
    }
    private void setDob(int d, int m, int y){
        LocalDate dob = LocalDate.of(y,m,d);
        LocalDate earliestLegalDate = LocalDate.now().minusYears(16);
        try{
            if ( dob.isBefore(earliestLegalDate) ){
                this.dob = dob;
            } else throw new Exception("Client is below the age of 16.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void printCustomerData(){

    }
}