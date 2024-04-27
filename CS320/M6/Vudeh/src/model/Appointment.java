package model;

import java.util.Date;

/**
 * Represents an appointment with unique ID, date, and description.
 * Validates appointment details and handles exceptions for invalid data.
 * Author: Victor Udeh
 * CS320
 * Date: Apr 12, 2024
 */
public class Appointment {

    private String uniqueID;
    private Date date;
    private String description;

    /**
     * Constructor to initialize an Appointment object with the given ID, date, and description.
     * @param uniqueID Unique identifier for the appointment (must be 10 characters or fewer and not null).
     * @param date The scheduled date of the appointment (cannot be in the past, must not be null).
     * @param description A brief description of the appointment (must be 50 characters or fewer and not null).
     */
    public Appointment(String uniqueID, Date date, String description) {
        if (!validateID(uniqueID)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (!validateDate(date)) {
            throw new IllegalArgumentException("Invalid date");
        }
        if (!validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.uniqueID = uniqueID;
        this.date = date;
        this.description = description;
    }

    /**
     * Validates the unique ID.
     * @param uniqueID The ID to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateID(String uniqueID) {
        return uniqueID != null && uniqueID.length() <= 10;
    }

    /**
     * Validates the date.
     * @param date The date to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateDate(Date date) {
        return date != null && !date.before(new Date());
    }

    /**
     * Validates the description.
     * @param description The description to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateDescription(String description) {
        return description != null && description.length() <= 50 && !description.isEmpty();
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the appointment.
     * @param date The new date to be set.
     */
    public void setDate(Date date) {
        if (!validateDate(date)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the appointment.
     * @param description The new description to be set.
     */
    public void setDescription(String description) {
        if (!validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
