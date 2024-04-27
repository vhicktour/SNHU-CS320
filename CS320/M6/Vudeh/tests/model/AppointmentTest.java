//Victor Udeh
//CS320
//Apr 12 2024

package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

class AppointmentTest {

    @DisplayName("Test good constructor")
    @Test
    void testAppointment() {
        String id = "1";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);  
        Date goodDate = c.getTime();
        String description = "This is a good description";
        
        Appointment tempAppt = new Appointment(id, goodDate, description);
        
        assertEquals(id, tempAppt.getUniqueID());  
        assertEquals(goodDate, tempAppt.getDate());
        assertEquals(description, tempAppt.getDescription());       
    }

    @DisplayName("Test bad constructor id too long")
    @Test
    void testBadAppointment() {
        String id = "123456789101112";
        Date date = new Date();
        String description = "This is a good description";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, date, description);
        });
        
        assertEquals("Invalid ID", exception.getMessage());
    }

    @DisplayName("Test bad constructor id null")
    @Test
    void testBadIDNull() {
        String id = null;
        Date date = new Date();
        String description = "This is a good description";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, date, description);
        });
        
        assertEquals("Invalid ID", exception.getMessage());
    }

    @DisplayName("Test bad constructor past date")
    @Test
    void testBadDate() {
        String id = "1";
        Calendar c = Calendar.getInstance();
        c.set(1996, Calendar.DECEMBER, 5); // Note the year is in the past
        Date badDate = c.getTime();
        String description = "This is a good description";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, badDate, description);
        });
        
        assertEquals("Invalid date", exception.getMessage());
    }

    @DisplayName("Test bad constructor null date")
    @Test
    void testNullDate() {
        String id = "1";
        String description = "This is a good description";    	
        Date nullDate = null;
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, nullDate, description);
        });
        
        assertEquals("Invalid date", exception.getMessage());
    }

    @DisplayName("Test bad description too long")
    @Test
    void testLongDesc() {
        String id = "1";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);
        Date goodDate = c.getTime();
        String description = "This description is way too long for it to be valid and should cause an error";
        
        Appointment tempAppt = new Appointment(id, goodDate, "test");
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, goodDate, description);
        });
        
        assertEquals("Invalid description", exception.getMessage());
    }

    @DisplayName("Test bad description null")
    @Test
    void testNullDesc() {
        String id = "1";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);
        Date goodDate = c.getTime();
        String description = null;
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, goodDate, description);
        });
        
        assertEquals("Invalid description", exception.getMessage());
    }

    @DisplayName("Test bad description empty")
    @Test
    void testEmptyDesc() {
        String id = "1";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);
        Date goodDate = c.getTime();
        String description = "";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, goodDate, description);
        });
        
        assertEquals("Invalid description", exception.getMessage());
    }
}
