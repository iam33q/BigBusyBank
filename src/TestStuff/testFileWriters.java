import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFileWriters {
    @Test
    void testWriteCSVRecord(){
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("table.csv"));
            String[] niners = {"9","9","9","9","9","9","9","9"};
            writer.writeNext(niners);
            writer.close();
            CSVReader reader = new CSVReader(new FileReader("table.csv"));
            String[] maybeNiners = reader.readAll().toArray(String[][]::new)[0];
            reader.close();
            assertArrayEquals(niners,maybeNiners);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
