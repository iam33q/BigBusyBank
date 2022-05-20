import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class testingfilereaders {
            CSVReader reader;

    {
        try {
            reader = new CSVReader( new FileReader("Logindata.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    String[] data1;
    int l = data1.length;


    {
        try {
            data1 = reader.readNext();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    }

