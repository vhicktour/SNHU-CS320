package model;

/**
 * Represents a contact with an ID, first name, last name, phone number, and address.
 * Ensures that all contact details meet specified validation requirements.
 * Author: Victor Udeh
 * CS320
 * Date: Apr 12, 2024
 */
public class Contact {
    
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    /**
     * Constructor to initialize a Contact object with the given ID, first name, last name, phone number, and address.
     * @param contactID Unique identifier for the contact (must be 10 characters or fewer and not null).
     * @param firstName First name of the contact (must be 10 characters or fewer and not null).
     * @param lastName Last name of the contact (must be 10 characters or fewer and not null).
     * @param phoneNumber Phone number of the contact (must be exactly 10 digits and not null).
     * @param address Address of the contact (must be 30 characters or fewer and not null).
     */
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (!validateID(contactID)) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (!validateFirstName(firstName)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (!validateLastName(lastName)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (!validatePhone(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (!validateAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Validates the contact ID.
     * @param contactID The ID to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateID(String contactID) {
        return contactID != null && contactID.length() <= 10;
    }

    /**
     * Validates the first name.
     * @param firstName The first name to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateFirstName(String firstName) {
        return firstName != null && firstName.length() <= 10;
    }

    /**
     * Validates the last name.
     * @param lastName The last name to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateLastName(String lastName) {
        return lastName != null && lastName.length() <= 10;
    }

    /**
     * Validates the phone number.
     * @param phoneNumber The phone number to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validatePhone(String phoneNumber) {
        return phoneNumber != null && phoneNumber.length() == 10;
    }

    /**
     * Validates the address.
     * @param address The address to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateAddress(String address) {
        return address != null && address.length() <= 30;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!validateFirstName(firstName)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!validateLastName(lastName)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!validatePhone(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!validateAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
