/**
 * Victor Udeh
 * CS-320
 * 03/28/2024
 * 
 * This test class focuses on validating the functionality of the Task class.
 * It includes tests for successful instantiation with valid parameters,
 * handling of invalid parameters (e.g., too long descriptions, null or invalid IDs),
 * and checks the behavior of setter methods for both valid and invalid inputs.
 */

 package Tests;

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;
 
 import TaskClass.Task;
 
 class TaskTest {
 
		 @DisplayName("Constructing a Task with valid parameters")
		 @Test
		 void goodConstructor() {
				 String id = "1";
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
 
				 Task tempTask = new Task(id, fullName, description);
 
				 assertEquals(id, tempTask.getUniqueID());
				 assertEquals(fullName, tempTask.getName());
				 assertEquals(description, tempTask.getDescription());
		 }
 
		 @DisplayName("Constructing a Task with an excessively long description")
		 @Test
		 void invalidConstructor() {
				 String id = "1";
				 String fullName = "Victor Udeh";
				 String description = "This description is too long and exceeds the maximum allowed length for a task description, thus should throw an IllegalArgumentException.";
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 new Task(id, fullName, description);
				 });
		 }
 
		 @DisplayName("Constructing a Task with an excessively long ID")
		 @Test
		 void invalidIDConstruct() {
				 String id = "12345678910"; // ID longer than 10 characters
				 String fullName = "Victor Udeh";
				 String description = "Valid description";
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 new Task(id, fullName, description);
				 });
		 }
 
		 @DisplayName("Constructing a Task with a null ID")
		 @Test
		 void invalidNullConstruct() {
				 String fullName = "Victor Udeh";
				 String description = "Valid description";
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 new Task(null, fullName, description);
				 });
		 }
 
		 @DisplayName("Setting a valid name using setName")
		 @Test
		 public void testGoodName() {
				 String id = "1";
				 String fullName = "Initial Name";
				 String description = "This is a good description";
				 Task tempTask = new Task(id, fullName, description);
 
				 tempTask.setName("Updated Name");
				 assertEquals("Updated Name", tempTask.getName());
		 }
 
		 @DisplayName("Setting a null name using setName should throw IllegalArgumentException")
		 @Test
		 public void testNullName() {
				 String id = "1";
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
				 Task tempTask = new Task(id, fullName, description);
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 tempTask.setName(null);
				 });
		 }
 
		 @DisplayName("Setting an excessively long name using setName should throw IllegalArgumentException")
		 @Test
		 public void testLongName() {
				 String id = "1";
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
				 Task tempTask = new Task(id, fullName, description);
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 tempTask.setName("This name is far too long to be considered valid for a task name");
				 });
		 }
 
		 @DisplayName("Setting an empty name using setName should throw IllegalArgumentException")
		 @Test
		 public void testEmptyName() {
				 String id = "1";
				 String fullName = "Victor Udeh";
				 String description = "This is a good description";
				 Task tempTask = new Task(id, fullName, description);
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 tempTask.setName("");
				 });
		 }
 
		 @DisplayName("Constructing a Task with an empty description should throw IllegalArgumentException")
		 @Test
		 public void testEmptyDescription() {
				 String id = "1";
				 String fullName = "Victor Udeh";
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 new Task(id, fullName, "");
				 });
		 }
 
		 @DisplayName("Constructing a Task with a null description should throw IllegalArgumentException")
		 @Test
		 public void testNullDescription() {
				 String id = "1";
				 String fullName = "Victor Udeh";
 
				 assertThrows(IllegalArgumentException.class, () -> {
						 new Task(id, fullName, null);
				 });
		 }
 }
 