package model;

/**
 * Represents a task with a unique identifier, full name, and description.
 * Validates task details and handles exceptions for invalid data.
 * Author: Victor Udeh
 * CS320
 * Date: Apr 12, 2024
 */
public class Task {
    
    private String uniqueID;
    private String fullName;
    private String description;

    /**
     * Constructor to initialize a Task object with the given ID, full name, and description.
     * @param uniqueID Unique identifier for the task (must be 10 characters or fewer and not null).
     * @param fullName Name of the task (must be 20 characters or fewer and not null).
     * @param description Description of the task (must be 50 characters or fewer and not null).
     */
    public Task(String uniqueID, String fullName, String description) {
        if (!validateID(uniqueID)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (!validateName(fullName)) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (!validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        
        this.uniqueID = uniqueID;
        this.fullName = fullName;
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
     * Validates the name.
     * @param fullName The name to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validateName(String fullName) {
        return fullName != null && fullName.length() <= 20 && !fullName.isEmpty();
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

    private void setID(String uniqueID){ 
        this.uniqueID = uniqueID; 
    }

    public String getName() {
        return fullName;
    }

    public void setName(String fullName) {
        if (!validateName(fullName)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (!validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
