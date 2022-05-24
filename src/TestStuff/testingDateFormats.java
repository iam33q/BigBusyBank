import org.junit.jupiter.api.Test;

import javax.swing.text.DateFormatter;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalDateTime.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.LocalDate.ofYearDay;
import static org.junit.jupiter.api.Assertions.*;

public class testingDateFormats {
    @Test
    void testCurrentDate(){     //Two input date (Year, Day)
        LocalDate now = LocalDate.now();
        LocalDate maybeNow = ofYearDay(2022,(LocalDate.now().getDayOfYear()));
        System.out.println(maybeNow);
        assertEquals(now,maybeNow);
    }
    @Test
    void testCurrentDate2(){    //Three input date (Year, Month, Day)
        LocalDate now2 = LocalDate.now();
        LocalDate maybeNow2 = LocalDate.of(2022,5,22);
        System.out.println(now2+"\n"+maybeNow2);
        assertEquals(now2,maybeNow2);
    }
    @Test
    void testCurrentDate3(){    //String input date (Day, Month, Year)
        LocalDate now3 = LocalDate.now();
        String date = "22-05-2022";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate maybeNow3 = LocalDate.parse(date,dateTimeFormatter);
        assertEquals(now3,maybeNow3);
    }

    @Test
    void testCurrentDate4(){    //String input date (Day, Month, Year)
        LocalDate now3 = LocalDate.now();
        String date = "22-05-2022";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate maybeNow3 = LocalDate.parse(date,dateTimeFormatter);
        assertEquals(now3,maybeNow3);
    }

}

