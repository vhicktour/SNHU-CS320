package service;

import java.util.HashMap;
import model.Task;

/**
 * Service class for managing tasks in a simple in-memory data structure.
 * Provides methods to add, delete, and update tasks.
 * Uses a pseudo-GUID mechanism to generate unique task IDs.
 * Author: Victor Udeh
 * CS320
 * Date: Apr 12, 2024
 */
public class TaskService {

    private int currentIDNum = 0; // Pseudo GUID for generating unique IDs
    private HashMap<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new unique task to the service.
     * @param name The name of the task.
     * @param description The description of the task.
     */
    public void addUniqueTask(String name, String description) {
        String stringID = Integer.toString(currentIDNum);
        Task newTask = new Task(stringID, name, description);
        tasks.put(stringID, newTask);
        currentIDNum++;
    }

    /**
     * Deletes a task from the service based on its ID.
     * @param ID The unique identifier of the task to delete.
     */
    public void deleteTask(String ID) {
        tasks.remove(ID);
    }

    /**
     * Updates an existing task's name and description based on its ID.
     * @param ID The unique identifier of the task to update.
     * @param newName The new name for the task.
     * @param newDescription The new description for the task.
     */
    public void updateTask(String ID, String newName, String newDescription) {
        if (tasks.containsKey(ID)) {
            Task taskToUpdate = tasks.get(ID);
            taskToUpdate.setName(newName);
            taskToUpdate.setDescription(newDescription);
        }
    }
}
