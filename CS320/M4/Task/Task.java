/**
 * Victor Udeh
 * CS-320
 * 03/28/2024
 * 
 * This class represents a Task object with a unique ID, name, and description.
 * It includes methods to validate and set these properties according to the specified requirements.
 */
package TaskClass;

public class Task {
    
    // Fields for the task object including unique ID, name, and description
    private String uniqueID;
    private String fullName;
    private String description;

    /**
     * Constructor for the Task class.
     * Validates and initializes a new Task object with the provided unique ID, name, and description.
     * 
     * @param uniqueID The unique identifier for the task.
     * @param fullName The name of the task.
     * @param description The description of the task.
     * @throws IllegalArgumentException if any of the parameters fail validation.
     */
    public Task(String uniqueID, String fullName, String description) {
        if (!this.validateID(uniqueID)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        
        if (!this.validateName(fullName)) {
            throw new IllegalArgumentException("Invalid name");
        }
        
        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.uniqueID = uniqueID;
        this.fullName = fullName;
        this.description = description;
    }

    /**
     * Validates the unique ID.
     * 
     * @param uniqueID The unique identifier to be validated.
     * @return true if the ID is valid; false otherwise.
     */
    private boolean validateID(String uniqueID) {
        return uniqueID != null && uniqueID.length() <= 10;
    }

    /**
     * Validates the name of the task.
     * 
     * @param fullName The name to be validated.
     * @return true if the name is valid; false otherwise.
     */
    private boolean validateName(String fullName) {
        return fullName != null && !fullName.equals("") && fullName.length() <= 20;
    }

    /**
     * Validates the description of the task.
     * 
     * @param description The description to be validated.
     * @return true if the description is valid; false otherwise.
     */
    private boolean validateDescription(String description) {
        return description != null && !description.equals("") && description.length() <= 50;
    }

    // Getters and setters for the Task fields
    // Note: The unique ID setter is omitted due to the requirement that the task ID is not updatable.

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String fullName) {
        if (!this.validateName(fullName)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
