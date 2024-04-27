/**
 * Victor Udeh
 * CS-320
 * 03/28/2024
 * 
 * This class is responsible for managing tasks within the application.
 * It supports adding unique tasks, deleting tasks by ID, and updating task details.
 * Tasks are stored in a static HashMap, simulating a database-like storage mechanism in memory.
 */

 package TaskClass;

 import java.util.HashMap;
 
 public class TaskService {
		 
		 // A counter to generate pseudo unique task IDs.
		 private int currentIDNum = 0;
		 
		 // HashMap to store tasks with their IDs as keys.
		 public static HashMap<String, Task> tasks = new HashMap<>();
 
		 /**
			* Adds a new task with a unique ID, name, and description.
			* The task ID is auto-generated to ensure uniqueness.
			* 
			* @param _name The name of the task.
			* @param _description The description of the task.
			*/
		 public void addUniqueTask(String _name, String _description) {
				 // Generating a string representation of the current ID number.
				 String stringID = Integer.toString(currentIDNum);
				 
				 // Creating a new Task object and adding it to the tasks HashMap.
				 Task tempTask = new Task(stringID, _name, _description);
				 tasks.put(stringID, tempTask);
 
				 // Incrementing the ID counter for the next task.
				 ++currentIDNum;
		 }
 
		 /**
			* Deletes a task by its ID.
			* If the task exists, it is removed from the tasks HashMap.
			* 
			* @param _ID The unique ID of the task to be deleted.
			*/
		 public void deleteTasks(String _ID) {
				 // Check if the task exists in the HashMap before attempting to remove it.
				 if (tasks.containsKey(_ID)) {
						 tasks.remove(_ID);
				 }
		 }
 
		 /**
			* Updates the name and description of a task identified by its ID.
			* If the task exists, its name and description are updated with the provided values.
			* 
			* @param _ID The unique ID of the task to be updated.
			* @param _newName The new name for the task.
			* @param _newDescription The new description for the task.
			*/
		 public void updateTasks(String _ID, String _newName, String _newDescription) {
				 // Check if the task exists in the HashMap before updating it.
				 if (tasks.containsKey(_ID)) {
						 Task taskToUpdate = tasks.get(_ID);
						 taskToUpdate.setName(_newName);
						 taskToUpdate.setDescription(_newDescription);
				 }
		 }
 }
 