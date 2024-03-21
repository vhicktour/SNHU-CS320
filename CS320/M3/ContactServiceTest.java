// Code by Victor Udeh
// March 21, 2024
// Snhu CS320 M3-2


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("ID123456", "Jane", "Doe", "0987654321", "456 Elm St");
        service.addContact(contact);
        assertNotNull(service);
    }

    @Test
    public void testAddContactFailure() {
        Contact contact1 = new Contact("ID123456", "Jane", "Doe", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact1); // Attempting to add the same contact again
        });
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("IDToDelete", "John", "Smith", "1234567890", "789 Pine St");
        service.addContact(contact);
        service.deleteContact("IDToDelete");
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("IDToDelete"); // Attempting to delete a non-existent contact
        });
    }

    @Test
    public void testUpdateContactSuccess() {
        Contact contact = new Contact("IDToUpdate", "Mike", "Jones", "1234567890", "101 Oak St");
        service.addContact(contact);
        service.updateContact("IDToUpdate", "Michael", null, null, "102 Oak St");
        assertEquals("Michael", contact.getFirstName());
        assertEquals("102 Oak St", contact.getAddress());
    }

    // Implement more tests to cover failure scenarios and updates to other fields
}
