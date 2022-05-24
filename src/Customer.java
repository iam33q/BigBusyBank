import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.Scanner;

public class Customer {

    private String fullName;
    private LocalDate dob;
    private String telephone;
    private String[] address = new String[4];
    private String[] address2= new String[4];
    private String[] address3= new String[4];

    //Constructors
    public Customer() {
        this(null, null, null,null,null,null);
    }

    //Constructors
    private Customer(String fullName, LocalDate dob, String telephone, String[] address){
        this.fullName = fullName;
        this.address = address;
        this.dob=dob;
    }
    private Customer(String fullName, LocalDate dob, String telephone, String[] address, String[] address2){
        this.fullName = fullName;
        this.address = address;
        this.address2 = address2;
    }
    private Customer(String fullName, LocalDate dob, String telephone, String[] address, String[] address2, String[] address3){
        this.fullName = fullName;
        this.address = address;
        this.address2 = address2;
        this.address3 = address3;

    }

    //Getters
    private String getFullName(){
        return this.fullName;
    }
    private LocalDate getDob(){
        return this.dob;
    }
    private String getTelephone(){
        return this.telephone;
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

    //Setters
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
    private void setTelephone(String phone){
        try{
            if(phone.length() == 11){
                this.telephone = telephone;
            } else throw new Exception("Invalid phone number.");
        } catch (Exception e){
            System.out.println(e);
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
    public static Customer newCustomer(){
        Customer acc = new Customer();
        try{
            System.out.println("In order to perform this function, please follow the instructions below:");
            if (LoginScript.LScript()){ // Additional login credentials check
                var inputs = new Hashtable<String,String>();
                Scanner input = new Scanner(System.in);
                String[] dataLabels = {"First Name","Last Name","Date of Birth","Type of account","Telephone","Street Number 1","Street Name 1","Town 1","Post Code 1","Street Number 2","Street Name 2","Town 2","Post Code 2","Street Number 3","Street Name 3","Town 3","Post Code 3"};
                String scan;
                int numberOfAddresses = 1;
                int i=0;
                //Checking residence history
                System.out.println("Input the move-in date for your current address, using the following format: [dd-MM-yyyy]");
                String date = input.next();
                LocalDate dateInput = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if(dateInput.isAfter(LocalDate.now().minusYears(3))){
                    numberOfAddresses++;
                    System.out.println("Input the move-in date for your previous address, using the following format: [dd-MM-yyyy]");
                    String date2 = input.next();
                    LocalDate dateinput2 = LocalDate.parse(date2,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    if(dateinput2.isAfter(LocalDate.now().minusYears(3))){
                        numberOfAddresses++;
                    }
                }
                //Populating the inputs table with user inputs
                for (String data:dataLabels){
                    System.out.printf("Input the following information:\n%s",data);
                    scan = input.nextLine();
                    inputs.put(data,scan);
                    i++;
                    if (i >= 5+4*numberOfAddresses) break; // Feels like there should be a better solution
                }
                // Time to set some states
                acc.setName(inputs.get("First Name"),inputs.get("Last Name"));
                acc.setDob(inputs.get("Date of Birth"));
                acc.setTelephone(inputs.get("Telephone"));
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