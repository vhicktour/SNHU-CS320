//Victor Udeh
//CS320
//Apr 12 2024

package services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.TaskService;

class TaskServiceTest {

    @AfterEach
    void tearDown() {
        TaskService.tasks.clear();
    }

    @DisplayName("Add a Task")
    @Test
    void testAddUniqueTask() {
        String id = "0";
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        
        TaskService tempTask = new TaskService();
        
        assertTrue(TaskService.tasks.isEmpty());
        
        tempTask.addUniqueTask(fullName, description);
       
        assertTrue(TaskService.tasks.containsKey(id));
        assertEquals(fullName, TaskService.tasks.get(id).getName());
        assertEquals(description, TaskService.tasks.get(id).getDescription());              
    }

    @DisplayName("Test deleteTask")
    @Test
    void testDeleteTask() {
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        TaskService tempTask = new TaskService();
        
        assertTrue(TaskService.tasks.isEmpty());

        tempTask.addUniqueTask(fullName, description); // ID 0
        tempTask.addUniqueTask(fullName, description); // ID 1
        tempTask.addUniqueTask(fullName, description); // ID 2
          
        assertEquals(3, TaskService.tasks.size());
          
        tempTask.deleteTasks("1");
          
        assertEquals(2, TaskService.tasks.size());
        assertFalse(TaskService.tasks.containsKey("1"));
        
        // Deleting non-existing ID should not affect the size
        tempTask.deleteTasks("1");
        assertEquals(2, TaskService.tasks.size());
    }

    @DisplayName("Test updateTask with a good ID")
    @Test
    void testUpdateTasks() {
        String id = "0";
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        TaskService tempTask = new TaskService();
        
        tempTask.addUniqueTask(fullName, description); // ID 0

        tempTask.updateTasks("0", fullName, "New description");
        assertEquals("New description", TaskService.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService.tasks.get(id).getName());
    }

    @DisplayName("Test updateTask with a bad ID")
    @Test
    void testBadUpdateTasks() {
        String id = "0";
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        TaskService tempTask = new TaskService();
        
        tempTask.addUniqueTask(fullName, description); // ID 0

        // Attempt to update non-existing ID 1
        tempTask.updateTasks("1", fullName, "New description");
        assertEquals(description, TaskService.tasks.get(id).getDescription()); // Description should remain unchanged
        assertEquals(fullName, TaskService.tasks.get(id).getName());
    }
}
