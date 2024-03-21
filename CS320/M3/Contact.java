// Code by Victor Udeh
// March 21, 2024
// Snhu CS320 M3-2

public class Contact {
  // Fields as specified by the requirements
  private final String contactId; // Unique identifier for the contact, immutable
  private String firstName;
  private String lastName;
  private String phone;
  private String address;

  // Constructor to initialize the contact object
  public Contact(String contactId, String firstName, String lastName, String phone, String address) {
      if (contactId == null || contactId.length() > 10) {
          throw new IllegalArgumentException("Invalid contact ID");
      }
      if (firstName == null || firstName.length() > 10) {
          throw new IllegalArgumentException("Invalid first name");
      }
      if (lastName == null || lastName.length() > 10) {
          throw new IllegalArgumentException("Invalid last name");
      }
      if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
          throw new IllegalArgumentException("Invalid phone number");
      }
      if (address == null || address.length() > 30) {
          throw new IllegalArgumentException("Invalid address");
      }

      this.contactId = contactId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.address = address;
  }

  // Getters and Setters for firstName, lastName, phone, and address
  // No setter for contactId as it should not be changed after creation

  public String getContactId() {
      return contactId;
  }

  public String getFirstName() {
      return firstName;
  }

  public void setFirstName(String firstName) {
      if (firstName == null || firstName.length() > 10) {
          throw new IllegalArgumentException("Invalid first name");
      }
      this.firstName = firstName;
  }

  public String getLastName() {
      return lastName;
  }

  public void setLastName(String lastName) {
      if (lastName == null || lastName.length() > 10) {
          throw new IllegalArgumentException("Invalid last name");
      }
      this.lastName = lastName;
  }

  public String getPhone() {
      return phone;
  }

  public void setPhone(String phone) {
      if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
          throw new IllegalArgumentException("Invalid phone number");
      }
      this.phone = phone;
  }

  public String getAddress() {
      return address;
  }

  public void setAddress(String address) {
      if (address == null || address.length() > 30) {
          throw new IllegalArgumentException("Invalid address");
      }
      this.address = address;
  }
}
