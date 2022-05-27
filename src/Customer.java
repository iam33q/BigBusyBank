import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Customer {
    private static String customerId = "Null";
    private static String fullName = "Null";
    private static LocalDate dob = LocalDate.of(1970,1,1);
    private static String telephone = "Null";
    private static String Email = "Null";
    private static String IdNumber = "Null";
    private static String[] address = new String[] {"Null","Null","Null","Null"};
    private static String[] address2= new String[] {"Null","Null","Null","Null"};
    private static String[] address3= new String[] {"Null","Null","Null","Null"};
    private static final String[] dataLabels =  {"Customer Id","Full Name","Date of Birth","Telephone","Email","Id Number","Street Number 1","Street Name 1","Town 1","Post Code 1"}; // One of these three arrays will be used to define the size of a data set further down
    private static final String[] dataLabels2 = {"Customer Id","Full Name","Date of Birth","Telephone","Email","Id Number","Street Number 1","Street Name 1","Town 1","Post Code 1","Street Number 2","Street Name 2","Town 2","Post Code 2"};
    private static final String[] dataLabels3 = {"Customer Id","Full Name","Date of Birth","Telephone","Email","Id Number","Street Number 1","Street Name 1","Town 1","Post Code 1","Street Number 2","Street Name 2","Town 2","Post Code 2","Street Number 3","Street Name 3","Town 3","Post Code 3"};
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static boolean check;
    //Constructors
    private Customer(String customerId, String fullName, LocalDate dob, String telephone, String Email, String IdNumber, String[] address, String[] address2, String[] address3){
        Customer.customerId = customerId;
        Customer.fullName = fullName;
        Customer.telephone = telephone;
        Customer.Email = Email;
        Customer.dob =dob;
        Customer.IdNumber = IdNumber;
        Customer.address = address;
        Customer.address2 = address2;
        Customer.address3 = address3;
    }
    //Getters
    public static String getCustomerId() {return customerId;}
    private String getFullName(){return fullName;}
    private LocalDate getDob(){return dob;}
    private String getTelephone(){return telephone;}
    public String getEmail() {return Email;}
    public String getIdNumber() {return IdNumber;}
    private String[] getAddress(){return address;}
    private String[] getAddress2(){return address2;}
    private String[] getAddress3(){return address3;}

    //Setters
    private void setCustomerId() {
        customerId = new UUID(new Random().nextLong(2^32), new Random().nextLong(2^32)).toString();
        check=true;
    }
    private void setName(String fullName){Customer.fullName = fullName; check=true;}
    private void setDob(String date) // Date format: dd-MM-yyyy
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(date,dateTimeFormatter);
        LocalDate earliestLegalDate = LocalDate.now().minusYears(16);
        try{
            if (dob.isBefore(earliestLegalDate)) {
                Customer.dob = dob;
                check = true;
            }else throw new Exception("Client is below the age of 16.");
        } catch(Exception e){
            System.out.println(e);        }
    }
    private void setTelephone(String phone){
        try{
            if(phone.length() == 11){
                telephone = telephone;
                check = true;
            }else throw new Exception("Invalid phone number.");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void setEmail(String email) {
        try{
            boolean check1 = email.contains("@");
            boolean check2 = email.contains(".");
            if(check1&&check2) {
                Email = email;
                check=true;
            } // Very advanced email format checker
            else throw new Exception("Invalid email.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
        check=true;
    }
    private void setAddress(String streetNumber, String streetName,String town, String postCode){
        address = new String[] {streetNumber,streetName,town,postCode};
        check=true;
    }
    private void setAddress2(String streetNumber, String streetName,String town, String postCode){
        address2 = new String[] {streetNumber,streetName,town,postCode};
        check=true;
    }
    private void setAddress3(String streetNumber, String streetName,String town, String postCode){
        address3 = new String[] {streetNumber,streetName,town,postCode};
        check=true;
    }

    // More setters because life is hard
    private void setAddress1StreetNumber(String s){address[0]=s;check=true;}
    private void setAddress1StreetName(String s){address[1]=s;check=true;}
    private void setAddress1Town(String s){address[2]=s;check=true;}
    private void setAddress1PostCode(String s){address[3]=s;check=true;}
    private void setAddress2StreetNumber(String s){address2[0]=s;check=true;}
    private void setAddress2StreetName(String s){address2[1]=s;check=true;}
    private void setAddress2Town(String s){address2[2]=s;check=true;}
    private void setAddress2PostCode(String s){address2[3]=s;check=true;}
    private void setAddress3StreetNumber(String s){address3[0]=s;check=true;}
    private void setAddress3StreetName(String s){address3[1]=s;check=true;}
    private void setAddress3Town(String s){address3[2]=s;check=true;}
    private void setAddress3PostCode(String s){address3[3]=s;check=true;}

    // Methods
    public static Customer newCustomer(){
        Customer acc=new Customer(customerId, fullName, dob,telephone,Email,IdNumber,address,address2,address3);
        try{
            System.out.println("\nWelcome to the new customer portal.\nIn order to perform this function, please follow the instructions below:");
            if (LoginScript.LScript()){ // Additional login credentials check
                String[] activeLabels;
                Scanner input = new Scanner(System.in);
                int numberOfAddresses = 1;
                String scan = "";

                // Checking residence history, adjusting number of data labels accordingly
                System.out.println("Input the move-in date for your current address, using the following format: [dd-MM-yyyy]");
                String date = input.next();
                LocalDate dateInput = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if(dateInput.isAfter(LocalDate.now().minusYears(3))){
                    numberOfAddresses++;
                    System.out.println("Input the move-in date for your previous address, using the following format: [dd-MM-yyyy]");
                    String date2 = input.next();
                    LocalDate dateInput2 = LocalDate.parse(date2,dateFormat);
                    if( dateInput2.isAfter( LocalDate.now().minusYears(3) ) ){
                        numberOfAddresses++;
                        activeLabels = dataLabels3;
                    } else activeLabels = dataLabels2;
                } else activeLabels = dataLabels;

                // Setting customer details
                System.out.printf("\nThis customer account will require %d addresses.",numberOfAddresses);
                acc.setCustomerId();
                for (String data:activeLabels) inputCheckerAndSetter(acc,input,data,scan);

                System.out.println("Account Creation Successful!");
                writeToDisk(acc);
                return acc;
            } else throw new Exception("Access Denied. Empty account returned");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return acc;
    }
    public static void edit(){
        Customer acc = readFromDisk();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String scan;
        String scan2 = "";

        String[] activeLabels; // This will be defined below, according to the number of addresses in the Customer object.
        if(!Objects.equals(acc.getAddress2(), new String[]{"Null", "Null", "Null", "Null"})){
            if(!Objects.equals(acc.getAddress3(), new String[]{"Null", "Null", "Null", "Null"})) activeLabels = dataLabels3;
            else activeLabels = dataLabels2;
        } else activeLabels = dataLabels;

        boolean keepGoing = true;
        System.out.println("Type in the data labels and press enter to select them for alteration. \nThen type in the new entry for that data label. \n Type in STOP to exit data entry.");
        System.out.println("Note: Date of Birth must be formatted as follows: [dd-MM-yyyy].\nCustomerId cannot be overwritten. \n");
        System.out.println("Valid Labels: "+ Arrays.toString(activeLabels));
        while(keepGoing){ // This loop will stop when you tell it to stop. What more could a user ask for?
            System.out.println("Select which data you would like to alter:\n"+Arrays.toString(activeLabels));
            scan=input.nextLine();
            if(scan.equalsIgnoreCase("stop")) keepGoing = false; // This is where the
            else inputCheckerAndSetter(acc,input,scan,scan2);
        }
        writeToDisk(acc);
    }
    public static Customer readFromDisk() {
        System.out.println("Welcome to the account search portal.\n");
        Customer acc=new Customer(customerId, fullName, dob,telephone,Email,IdNumber,address,address2,address3);
        System.out.println("Please input one of the following search label:\n"+ Arrays.toString(dataLabels3));
        Scanner in = new Scanner(System.in);
        Scanner in2=new Scanner(System.in);
        String searchLabel = in.nextLine();
        System.out.println("Please input an exact match of the labelled field entry associated with a client:");
        String searchString = in.nextLine();
        try{
            List<String> labelList = new ArrayList<>(Arrays.asList(dataLabels3));
            if (labelList.contains(searchLabel))    // Validating searchLabel input
            {
                int index1 = labelList.indexOf(searchLabel);

                try {
                    CSVReader reader = new CSVReader(new FileReader("customerData.csv"));
                    List<String[]> allRecords = reader.readAll();
                    System.out.println(allRecords.get(0)[index1]);
                    System.out.println(searchString);
                    //var
                    for (int i = 0; i < allRecords.size(); i++) {
                        if (Objects.equals(allRecords.get(i)[index1], searchString)){   // Construction time!
                            String[] requiredRecord = allRecords.get(i);
                            acc.setName(requiredRecord[1]);
                            acc.setDob(requiredRecord[2]);
                            acc.setTelephone(requiredRecord[3]);
                            acc.setEmail(requiredRecord[4]);
                            acc.setIdNumber(requiredRecord[5]);
                            acc.setAddress(requiredRecord[6],requiredRecord[7],requiredRecord[8],requiredRecord[9]);
                            acc.setAddress2(requiredRecord[10],requiredRecord[11],requiredRecord[12],requiredRecord[14]);
                            acc.setAddress3(requiredRecord[14],requiredRecord[15],requiredRecord[16],requiredRecord[17]);
                            return acc;
                        }
                    }
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            } else throw new Exception("Invalid data label.");
        } catch (Exception e){System.out.println(e);}
        System.out.println("Customer not found. Null customer returned.");
        return acc;
    }
    public static void writeToDisk(Customer acc) {
        try {
            File middleFile = new File("middle.csv");
            File endFile = new File("customerData.csv");
            CSVReader reader = new CSVReader(new FileReader("customerData.csv"));
            List<String[]> allRecords = reader.readAll();
            reader.close();
            boolean deleted = endFile.delete();

            ArrayList<String> CSVInput = new ArrayList<>();
            CSVInput.add(getCustomerId());
            String[] dateComponents = acc.getDob().toString().split("-", 3);//The price we pay for non-ISO-compliant date input
            CSVInput.add(acc.getFullName());
            CSVInput.add((dateComponents[2] + "-" + dateComponents[1] + "-" + dateComponents[0]));
            CSVInput.add(acc.getTelephone());
            CSVInput.add(acc.getEmail());
            CSVInput.add(acc.getIdNumber());
            CSVInput.add(acc.getAddress()[0]);
            CSVInput.add(acc.getAddress()[1]);
            CSVInput.add(acc.getAddress()[2]);
            CSVInput.add(acc.getAddress()[3]);
            CSVInput.add(acc.getAddress2()[0]);
            CSVInput.add(acc.getAddress2()[1]);
            CSVInput.add(acc.getAddress2()[2]);
            CSVInput.add(acc.getAddress2()[3]);
            CSVInput.add(acc.getAddress3()[0]);
            CSVInput.add(acc.getAddress3()[1]);
            CSVInput.add(acc.getAddress3()[2]);
            CSVInput.add(acc.getAddress3()[3]);

            allRecords.add(CSVInput.toArray(String[]::new));
            CSVWriter writer = new CSVWriter(new FileWriter("middle.csv"));
            writer.writeAll(allRecords);
            writer.close();
            if(deleted) middleFile.renameTo(new File("customerData.csv"));
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
    public static void displayInformation(Customer acc){
        System.out.println("Customer ID:   "+ getCustomerId());
        System.out.println("Full Name:      "+ acc.getFullName());
        System.out.println("Date of Birth:  "+ acc.getDob());
        System.out.println("Telephone:      "+ acc.getTelephone());
        System.out.println("Email:          "+ acc.getEmail());
        System.out.println("ID Number:      "+ acc.getIdNumber());
        System.out.println("Address 1:      "+ Arrays.toString(acc.getAddress()));
        if(!Objects.equals(acc.address2, new String[]{"Null", "Null", "Null", "Null"})) System.out.println("Address 2:  "+ Arrays.toString(acc.getAddress2()));
        if(!Objects.equals(acc.address3, new String[]{"Null", "Null", "Null", "Null"})) System.out.println("Address 3:  "+ Arrays.toString(acc.getAddress3()));
    }
    private static void inputCheckerAndSetter(Customer acc, Scanner input, String data, String scan){
        check=false;
        while(!check){
            System.out.println("Input the following data to be written/overwritten:\n"+data+":\n");
            scan = input.nextLine();
            try {
                switch(data){
                    case "stop": break;
                    case "Customer Id":
                        acc.setCustomerId();
                        System.out.println("Entry automatically assigned. No particular input required");
                        break;
                    case "Full Name":       acc.setName(scan);                  break;
                    case "Date of Birth":   acc.setDob(scan);                   break;
                    case "Telephone":       acc.setTelephone(scan);             break;
                    case "Email":           acc.setEmail(scan);                 break;
                    case "Id Number":       acc.setIdNumber(scan);              break;
                    case "Street Number 1": acc.setAddress1StreetNumber(scan);  break;
                    case "Street Name 1":   acc.setAddress1StreetName(scan);    break;
                    case "Town 1":          acc.setAddress1Town(scan);          break;
                    case "Post Code 1":     acc.setAddress1PostCode(scan);      break;
                    case "Street Number 2": acc.setAddress2StreetNumber(scan);  break;
                    case "Street Name 2":   acc.setAddress2StreetName(scan);    break;
                    case "Town 2":          acc.setAddress2Town(scan);          break;
                    case "Post Code 2":     acc.setAddress2PostCode(scan);      break;
                    case "Street Number 3": acc.setAddress3StreetNumber(scan);  break;
                    case "Street Name 3":   acc.setAddress3StreetName(scan);    break;
                    case "Town 3":          acc.setAddress3Town(scan);          break;
                    case "Post Code 3":     acc.setAddress3PostCode(scan);      break;
                    default:                throw new Exception("Invalid label. Please try entering a label name again.");
                }
            } catch(Exception e){
                System.out.println(e);
            }
            if (!check) System.out.println("Invalid input. Please try again.");
        }
    }
}