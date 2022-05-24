import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Customer {
    private static String customerId;
    private static String fullName;
    private static LocalDate dob;
    private static String telephone;
    private static String Email;
    private static String IdNumber;
    private static String[] address = new String[4];
    private static String[] address2= new String[4];
    private static String[] address3= new String[4];
    private static final String[] dataLabels = {"Customer Id","First Name","Last Name","Date of Birth","Telephone","Email","Id Number","Street Number 1","Street Name 1","Town 1","Post Code 1"}; // One of these three arrays will be used to define the size of a data set further down
    private static final String[] dataLabels2 = {"Customer Id","First Name","Last Name","Date of Birth","Telephone","Email","Id Number","Street Number 1","Street Name 1","Town 1","Post Code 1","Street Number 2","Street Name 2","Town 2","Post Code 2"};
    private static final String[] dataLabels3 = {"Customer Id","First Name","Last Name","Date of Birth","Telephone","Email","Id Number","Street Number 1","Street Name 1","Town 1","Post Code 1","Street Number 2","Street Name 2","Town 2","Post Code 2","Street Number 3","Street Name 3","Town 3","Post Code 3"};
    //Constructors
    private Customer(String customerId, String fullName, LocalDate dob, String telephone, String Email, String IdNumber, String[] address){
        this.customerId = customerId;
        this.fullName = fullName;
        this.telephone = telephone;
        this.Email = Email;
        this.dob=dob;
        this.IdNumber = IdNumber;
        this.address = address;
    }
    private Customer(String customerId, String fullName, LocalDate dob, String telephone, String Email, String IdNumber, String[] address, String[] address2){
        this.customerId = customerId;
        this.fullName = fullName;
        this.telephone = telephone;
        this.Email = Email;
        this.dob=dob;
        this.IdNumber = IdNumber;
        this.address = address;
        this.address2 = address2;
    }
    private Customer(String customerId, String fullName, LocalDate dob, String telephone, String Email, String IdNumber, String[] address, String[] address2, String[] address3){
        this.customerId = customerId;
        this.fullName = fullName;
        this.telephone = telephone;
        this.Email = Email;
        this.dob=dob;
        this.IdNumber = IdNumber;
        this.address = address;
        this.address2 = address2;
        this.address3 = address3;
    }

    //Getters
    public static String getCustomerId() {return customerId;}
    private String getFullName(){return this.fullName;}
    private LocalDate getDob(){return this.dob;}
    private String getTelephone(){return this.telephone;}
    public String getEmail() {return Email;}
    public String getIdNumber() {return IdNumber;}
    private String[] getAddress(){return this.address;}
    private String[] getAddress2(){return this.address2;}
    private String[] getAddress3(){return this.address3;}

    //Setters
    private void setCustomerId() {this.customerId = new UUID(new Random().nextLong(2^32), new Random().nextLong(2^32)).toString();}
    private void setName(String firstName, String lastName){this.fullName = firstName+" "+lastName;}
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
            if(phone.length() == 11) this.telephone = telephone;
            else throw new Exception("Invalid phone number.");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void setEmail(String email) {
        boolean check1 = email.contains("@");
        boolean check2 = email.contains(".");
        if(check1&&check2) Email = email; // Very advanced email format checker
    }
    public void setIdNumber(String idNumber) {IdNumber = idNumber;}
    private void setAddress(String streetNumber, String streetName,String town, String postCode){this.address = new String[] {streetNumber,streetName,town,postCode};}
    private void setAddress2(String streetNumber, String streetName,String town, String postCode){this.address2 = new String[] {streetNumber,streetName,town,postCode};}
    private void setAddress3(String streetNumber, String streetName,String town, String postCode){this.address3 = new String[] {streetNumber,streetName,town,postCode};}

    // More setters because life is hard
    private void setName(String fullName){this.fullName = fullName;}
    private void setAddress1StreetNumber(String s){this.address[0]=s;}
    private void setAddress1StreetName(String s){this.address[1]=s;}
    private void setAddress1Town(String s){this.address[2]=s;}
    private void setAddress1PostCode(String s){this.address[3]=s;}
    private void setAddress2StreetNumber(String s){this.address2[0]=s;}
    private void setAddress2StreetName(String s){this.address2[1]=s;}
    private void setAddress2Town(String s){this.address2[2]=s;}
    private void setAddress2PostCode(String s){this.address2[3]=s;}
    private void setAddress3StreetNumber(String s){this.address3[0]=s;}
    private void setAddress3StreetName(String s){this.address3[1]=s;}
    private void setAddress3Town(String s){this.address3[2]=s;}
    private void setAddress3PostCode(String s){this.address3[3]=s;}

    // Methods
    public static Customer newCustomer(){
        Customer acc = null;
        try{
            System.out.println("In order to perform this function, please follow the instructions below:");
            if (LoginScript.LScript()){ // Additional login credentials check
                String[] activeLabels;
                var inputs = new Hashtable<String,String>();
                Scanner input = new Scanner(System.in);
                String scan;
                int numberOfAddresses = 1;
                int i=0;

                // Checking residence history, adjusting number of data labels accordingly
                System.out.println("Input the move-in date for your current address, using the following format: [dd-MM-yyyy]");
                String date = input.next();
                LocalDate dateInput = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if(dateInput.isAfter(LocalDate.now().minusYears(3))) // VERY COMPLICATED LOGIC FOLLOW CAREFULLY
                {
                    numberOfAddresses++;
                    System.out.println("Input the move-in date for your previous address, using the following format: [dd-MM-yyyy]");
                    String date2 = input.next();
                    LocalDate dateinput2 = LocalDate.parse(date2,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    if(dateinput2.isAfter(LocalDate.now().minusYears(3))){
                        numberOfAddresses++;
                        activeLabels = dataLabels3;
                        acc = new Customer(null,null,null,null,null,null,new String[] {"one","two","three","four"},new String[] {"one","two","three","four"},new String[] {"one","two","three","four"});
                    } else {
                        activeLabels = dataLabels2;
                        acc = new Customer(null,null,null,null,null,null,new String[] {"one","two","three","four"},new String[] {"one","two","three","four"});
                    }
                } else {
                    activeLabels = dataLabels;
                    acc = new Customer(null,null,null,null,null,null,new String[] {"one","two","three","four"});
                }

                // Populating the inputs table with user inputs, in what I'm hoping is a foolproof way
                for (String data:activeLabels){
                    System.out.printf("Input the following information:\n%s",data);
                    scan = input.nextLine();
                    inputs.put(data,scan);
                }

                // Time to set some states
                acc.setName(inputs.get("First Name"),inputs.get("Last Name"));
                acc.setDob(inputs.get("Date of Birth"));
                acc.setTelephone(inputs.get("Telephone"));
                acc.setEmail(inputs.get("Email"));
                acc.setIdNumber(inputs.get("Id Number"));
                acc.setCustomerId();
                acc.setAddress(inputs.get("Street Number 1"),inputs.get("Street Name 1"),inputs.get("Town 1"),inputs.get("Post Code 1"));
                if (numberOfAddresses == 2) acc.setAddress2(inputs.get("Street Number 2"),inputs.get("Street Name 2"),inputs.get("Town 2"),inputs.get("Post Code 2"));
                if (numberOfAddresses == 3) acc.setAddress3(inputs.get("Street Number 3"),inputs.get("Street Name 3"),inputs.get("Town 3"),inputs.get("Post Code 3"));
            } else throw new Exception("Access Denied.");
        } catch (Exception e){
            e.printStackTrace();
        }
        writeCustomerToDisk(acc);
        System.out.println("Account Creation Successful! Stored to disk.");
        return acc;
    }
    public static void editCustomer(Customer acc){
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String scan;
        String scan2;
        String[] activeLabels; // This will be defined below, according to the number of addresses in the Customer object.
        if(acc.getAddress2() != null){
            if(acc.getAddress3() != null) activeLabels = dataLabels3;
            else activeLabels = dataLabels2;
        } else activeLabels = dataLabels;
        boolean keepGoing = true;
        System.out.println("Type in the data labels and press enter to select them for alteration. \nThen type in the new entry for that data label. \n Type in STOP to exit data entry.");
        System.out.println("Note: Date of Birth must be formatted as follows: [dd-MM-yyyy].\nCustomerId cannot be overwritten. \nFirst Name and Last Name choices will overwrite both names at once");
        while(keepGoing){ // This loop will stop when you tell it to stop. What more could a user ask for?
            System.out.println("Select which data you would like to alter:\n"+Arrays.toString(activeLabels));
            scan=input.next();
            if(scan.equalsIgnoreCase("stop")) keepGoing=false;
            System.out.println("Enter the desired value for - "+scan);
            scan2=input2.next();
            try {
                switch(scan){
                    case "First Name":
                    case "Last Name":       acc.setName(scan2); break;
                    case "Customer Id":     continue;
                    case "Date of Birth":   acc.setDob(scan2);break;
                    case "Telephone":       acc.setTelephone(scan2);break;
                    case "Email":           acc.setEmail(scan2);
                    case "Id Number":       acc.setIdNumber(scan2);break;
                    case "Street Number 1": acc.setAddress1StreetNumber(scan2);break;
                    case "Street Name 1":   acc.setAddress1StreetName(scan2);break;
                    case "Town 1":          acc.setAddress1Town(scan2);break;
                    case "Post Code 1":     acc.setAddress1PostCode(scan2);break;
                    case "Street Number 2": acc.setAddress2StreetNumber(scan2);break;
                    case "Street Name 2":   acc.setAddress2StreetName(scan2);break;
                    case "Town 2":          acc.setAddress2Town(scan2);break;
                    case "Post Code 2":     acc.setAddress2PostCode(scan2);break;
                    case "Street Number 3": acc.setAddress3StreetNumber(scan2);break;
                    case "Street Name 3":   acc.setAddress3StreetName(scan2);break;
                    case "Town 3":          acc.setAddress3Town(scan2);break;
                    case "Post Code 3":     acc.setAddress3PostCode(scan2);break;
                    default:                throw new Exception("Invalid label. Please try entering a label name again.");
                }
            } catch(Exception e) {
                System.out.println(e);
                System.out.println("Valid Labels: "+activeLabels.toString());
            }
        }
    }
    public static Customer ReadCustomerFromDisk(String searchLabel, String searchString) {
        Customer acc;
        try{
            List<String> labelList = new ArrayList<>(Arrays.asList(dataLabels3));
            if (labelList.contains(searchLabel))    // Validating searchLabel input
            {
                int index1 = labelList.indexOf(searchLabel);
                try {
                    CSVReader reader = new CSVReader(new FileReader("customerData.csv"));
                    List<String[]> allRecords = reader.readAll();
                    //var
                    for (int i = 0; i < allRecords.size(); i++) {
                        if (Objects.equals(allRecords.get(i)[index1], searchString))
                        {   // Construction time!
                            String[] requiredRecord = allRecords.get(i);
                            switch(requiredRecord.length){
                                case 11:
                                    acc=new Customer(customerId, fullName, dob,telephone,Email,IdNumber,address);
                                    break;
                                case 15: acc=new Customer(customerId, fullName, dob,telephone,Email,IdNumber,address,address2);
                                    acc.setAddress2(requiredRecord[11],requiredRecord[12],requiredRecord[13],requiredRecord[14]);
                                    break;
                                case 19: acc=new Customer(customerId, fullName, dob,telephone,Email,IdNumber,address,address2,address3);
                                    acc.setAddress2(requiredRecord[11],requiredRecord[12],requiredRecord[13],requiredRecord[14]);
                                    acc.setAddress3(requiredRecord[15],requiredRecord[16],requiredRecord[17],requiredRecord[18]);
                                    break;
                                default: acc=new Customer(customerId, fullName, dob,telephone,Email,IdNumber,address,address2,address3);
                                    acc.setAddress2(requiredRecord[11],requiredRecord[12],requiredRecord[13],requiredRecord[14]);
                                    acc.setAddress3(requiredRecord[15],requiredRecord[16],requiredRecord[17],requiredRecord[18]);
                                    System.out.println("Something likely went wrong. Please check output.");
                            }
                            acc.setName(requiredRecord[1],requiredRecord[2]);
                            acc.setDob(requiredRecord[3]);
                            acc.setTelephone(requiredRecord[4]);
                            acc.setEmail(requiredRecord[5]);
                            acc.setIdNumber(requiredRecord[6]);
                            acc.setAddress(requiredRecord[7],requiredRecord[8],requiredRecord[9],requiredRecord[10]);
                            System.out.println("Account acquired.");
                            return acc;
                        }
                    }
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            } else throw new Exception("Invalid data label.");
        } catch (Exception e){System.out.println(e);}
        acc=new Customer(customerId, fullName, dob,telephone,Email,IdNumber,address,address2,address3);
        System.out.println("Account not found. Empty account created.");
        return acc;
    }
    public static void writeCustomerToDisk(Customer acc){
        ArrayList<String> CSVInput= new ArrayList<>();
        try{
            CSVInput.add(getCustomerId());
            String[] names = acc.getFullName().split(" ",2); //The consequences of my own actions
            String[] dateComponents = acc.getDob().toString().split("-",3); //The price we pay for non-ISO-complying date input
            CSVInput.add(names[0]);
            CSVInput.add(names[1]);
            CSVInput.add((dateComponents[2]+"-"+dateComponents[1]+"-"+dateComponents[0]));
            CSVInput.add(acc.getTelephone());
            CSVInput.add(acc.getEmail());
            CSVInput.add(acc.getIdNumber());
            CSVInput.add(acc.getAddress()[0]);
            CSVInput.add(acc.getAddress()[1]);
            CSVInput.add(acc.getAddress()[2]);
            CSVInput.add(acc.getAddress()[3]);
            try // Because I have no time/energy to look into reflection and see which classes are available
            {
                CSVInput.add(acc.getAddress2()[0]);
                CSVInput.add(acc.getAddress2()[1]);
                CSVInput.add(acc.getAddress2()[2]);
                CSVInput.add(acc.getAddress2()[3]);
                CSVInput.add(acc.getAddress3()[0]);
                CSVInput.add(acc.getAddress3()[1]);
                CSVInput.add(acc.getAddress3()[2]);
                CSVInput.add(acc.getAddress3()[3]);
            } catch (RuntimeException e) {
                System.out.println("There is no such data available of this customer.");
            }
        } finally {
            try{
                CSVWriter writer = new CSVWriter(new FileWriter("customerData.csv"));
                writer.writeNext(CSVInput.toArray(String[]::new));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void displayCustomerInformation(Customer acc){
        System.out.println("Custioner ID:   "+getCustomerId());
        System.out.println("Full Name:      "+acc.getFullName());
        System.out.println("Date of Birth:  "+acc.getDob());
        System.out.println("Telephone:      "+acc.getTelephone());
        System.out.println("Email:          "+acc.getEmail());
        System.out.println("ID Number:      "+acc.getIdNumber());
        System.out.println("Address 1:      "+acc.getAddress().toString());
        try{
            System.out.println("Address 2:      "+acc.getAddress2().toString());
            System.out.println("Address 3:      "+acc.getAddress3().toString());
        } catch(RuntimeException e){
            System.out.println("This customer has no more addresses.");
        }
    }
}