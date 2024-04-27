//Victor Udeh
//CS320
//Apr 12 2024


package services;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.AppointmentService;

class ApptServiceTests {

    @AfterEach
    void tearDown() {
        AppointmentService.appointments.clear();
    }

    @DisplayName("Add an Appointment")
    @Test
    void testAddUniqueAppt() {
        String id = "0"; // Assuming AppointmentService internally manages IDs starting at 0.
        String description = "This is a good description";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);
        Date goodDate = c.getTime();

        AppointmentService tempAppt = new AppointmentService();

        assertTrue(AppointmentService.appointments.isEmpty());

        tempAppt.addUniqueAppointment(goodDate, description);

        assertTrue(AppointmentService.appointments.containsKey(id));
        assertEquals(goodDate, AppointmentService.appointments.get(id).getDate());
        assertEquals(description, AppointmentService.appointments.get(id).getDescription());
    }

    @DisplayName("Add a bad Appointment with empty description")
    @Test
    void testAddEmptyDesc() {
        String description = ""; // Empty description is bad.
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);
        Date goodDate = c.getTime();

        AppointmentService tempAppt = new AppointmentService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tempAppt.addUniqueAppointment(goodDate, description);
        });

        assertEquals("Invalid description", exception.getMessage());
    }

    @DisplayName("Add a bad Appointment with null description")
    @Test
    void testAddNullDesc() {
        String description = null; // Null description is bad.
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);
        Date goodDate = c.getTime();

        AppointmentService tempAppt = new AppointmentService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tempAppt.addUniqueAppointment(goodDate, description);
        });

        assertEquals("Invalid description", exception.getMessage());
    }

    @DisplayName("Test delete Appointment")
    @Test
    void testDeleteAppt() {
        String description = "This is a good description";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 5);
        Date goodDate = c.getTime();

        AppointmentService tempAppt = new AppointmentService();

        assertTrue(AppointmentService.appointments.isEmpty());

        tempAppt.addUniqueAppointment(goodDate, description); // id "0"
        tempAppt.addUniqueAppointment(goodDate, description); // id "1"
        tempAppt.addUniqueAppointment(goodDate, description); // id "2"

        assertEquals(3, AppointmentService.appointments.size());

        tempAppt.deleteAppointment("1");

        assertEquals(2, AppointmentService.appointments.size());
        assertFalse(AppointmentService.appointments.containsKey("1"));

        // Trying to delete again shouldn't change the count
        tempAppt.deleteAppointment("1");
        assertEquals(2, AppointmentService.appointments.size());
    }
}
