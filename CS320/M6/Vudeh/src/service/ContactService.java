package service;

import java.util.List;
import java.util.ArrayList;
import model.Contact;

/**
 * Service class for managing contacts in a simple in-memory data structure.
 * Provides methods to add, delete, and update contact details.
 * Uses a pseudo-GUID mechanism to generate unique contact IDs.
 * Author: Victor Udeh
 * CS320
 * Date: Apr 12, 2024
 */
public class ContactService {
    
    private int currentIDNum = 0; // Pseudo GUID for generating unique IDs
    private List<Contact> contactList = new ArrayList<>();

    /**
     * Adds a contact with the specified details.
     * @param firstName The first name of the contact.
     * @param lastName The last name of the contact.
     * @param phoneNumber The phone number of the contact.
     * @param address The address of the contact.
     */
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        String stringID = Integer.toString(currentIDNum);
        Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
        contactList.add(newContact);
        currentIDNum++;
    }

    /**
     * Deletes a contact by ID.
     * @param ID The unique identifier of the contact to delete.
     */
    public void deleteContact(String ID) {
        contactList.removeIf(contact -> contact.getContactID().equals(ID));
    }

    /**
     * Updates the first name of a contact.
     * @param contactID The ID of the contact to update.
     * @param firstName The new first name for the contact.
     */
    public void editFirstName(String contactID, String firstName) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setFirstName(firstName));
    }

    /**
     * Updates the last name of a contact.
     * @param contactID The ID of the contact to update.
     * @param lastName The new last name for the contact.
     */
    public void editLastName(String contactID, String lastName) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setLastName(lastName));
    }

    /**
     * Updates the phone number of a contact.
     * @param contactID The ID of the contact to update.
     * @param phoneNumber The new phone number for the contact.
     */
    public void editNumber(String contactID, String phoneNumber) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setPhoneNumber(phoneNumber));
    }

    /**
     * Updates the address of a contact.
     * @param contactID The ID of the contact to update.
     * @param address The new address for the contact.
     */
    public void editAddress(String contactID, String address) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setAddress(address));
    }
}
