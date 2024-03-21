// Code by Victor Udeh
// March 21, 2024
// Snhu CS320 M3-2


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        // Test successful creation of a contact
        Contact contact = new Contact("ID123456", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
    }

    @Test
    public void testContactCreationFailure() {
        // Test creation of a contact with invalid data
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testSetFirstNameFailure() {
        // Test setting an invalid first name
        Contact contact = new Contact("ID123456", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // Add more tests to cover other failure and success scenarios for all fields
}
