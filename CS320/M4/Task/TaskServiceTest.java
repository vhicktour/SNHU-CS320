/**
 * Victor Udeh
 * CS-320
 * 03/28/2024
 * 
 * This test class verifies the functionalities of the TaskService class,
 * ensuring tasks can be added, deleted, and updated correctly. It leverages
 * JUnit 5 annotations and assertions to perform the testing operations.
 */

 package Tests;

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.AfterEach;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.DisplayName;
 
 import TaskClass.TaskService;
 
 class TaskServiceTest {
 
		 /**
			* Clears the tasks HashMap after each test to ensure test isolation.
			* @throws Exception
			*/
		 @AfterEach
		 void tearDown() throws Exception {
				 TaskService.tasks.clear();
		 }
 
		 @DisplayName("Add a Task - verifies if a task is added successfully")
		 @Test
		 void testAddUniqueTask() {
				 String id = "0";
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
				 
				 TaskService tempTask = new TaskService();
				 
				 // Initially, the tasks list should be empty.
				 assertEquals(0, TaskService.tasks.size());
				 
				 // Add a unique task and verify it's added correctly.
				 tempTask.addUniqueTask(fullName, description);
				
				 assertTrue(TaskService.tasks.containsKey(id));
				 assertEquals(fullName, TaskService.tasks.get(id).getName());
				 assertEquals(description, TaskService.tasks.get(id).getDescription());              
		 }
 
		 @DisplayName("Delete a Task - verifies if a task is deleted successfully")
		 @Test
		 void testDeleteTask() {
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
			 
				 TaskService tempTask = new TaskService();
				 
				 // Add tasks to the service.
				 tempTask.addUniqueTask(fullName, description); // obj 0
				 tempTask.addUniqueTask(fullName, description); // obj 1
				 tempTask.addUniqueTask(fullName, description); // obj 2
				 
				 assertEquals(3, TaskService.tasks.size());
				 
				 // Delete the task with ID "1" and verify deletion.
				 tempTask.deleteTasks("1");
				 
				 assertEquals(2, TaskService.tasks.size());
				 assertFalse(TaskService.tasks.containsKey("1"));
		 }
 
		 @DisplayName("Update Task with a valid ID - verifies task update functionality")
		 @Test
		 void testUpdateTasks() {
				 String id = "0";
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
			 
				 TaskService tempTask = new TaskService();
				 
				 // Add a task and then update it.
				 tempTask.addUniqueTask(fullName, description);
				 tempTask.updateTasks(id, fullName, "New description");
				 
				 // Verify the update was successful.
				 assertEquals("New description", TaskService.tasks.get(id).getDescription());
				 assertEquals(fullName, TaskService.tasks.get(id).getName());
		 }
 
		 @DisplayName("Attempt to update Task with an invalid ID")
		 @Test
		 void testBadUpdateTasks() {
				 String id = "0";
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
			 
				 TaskService tempTask = new TaskService();
				 
				 // Add a task and attempt to update a non-existing task.
				 tempTask.addUniqueTask(fullName, description);
				 tempTask.updateTasks("1", fullName, "New description");
				 
				 // Verify the original task remains unchanged since "1" is an invalid ID.
				 assertNotEquals("New description", TaskService.tasks.get(id).getDescription());
				 assertEquals(fullName, TaskService.tasks.get(id).getName());
		 }
 }
 