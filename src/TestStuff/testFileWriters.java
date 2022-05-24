import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFileWriters {
    @Test
    void testWriteCSVRecord(){
        try {
            File testFile = new File("test.csv");
            CSVWriter writer = new CSVWriter(new FileWriter("test.csv"));
            String[] myInput = {"9","9","9","9","9","9","9","9"};
            writer.writeNext(myInput);
            writer.close();
            CSVReader reader = new CSVReader(new FileReader("test.csv"));
            String[][] maybeNiners = reader.readAll().toArray(String[][]::new);
            System.out.println(Arrays.deepToString(maybeNiners));
            reader.close();
            testFile.delete();
            assertArrayEquals(myInput,maybeNiners[0]);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    void testWriteCSVRecord2(){
        try {
            File testFile = new File("test.csv");
            CSVWriter writer = new CSVWriter(new FileWriter("test.csv"));
            String[] myInput = {"9","9","9","9","9","9","9","9"};
            writer.writeNext(myInput);
            writer.writeNext(new String[] {"You Mad Bro?"});
            writer.close();
            CSVReader reader = new CSVReader(new FileReader("test.csv"));
            String[][] maybeNiners = reader.readAll().toArray(String[][]::new);
            System.out.println(Arrays.deepToString(maybeNiners));
            reader.close();
            testFile.delete();
            assertEquals("You Mad Bro?",maybeNiners[1][0]);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
