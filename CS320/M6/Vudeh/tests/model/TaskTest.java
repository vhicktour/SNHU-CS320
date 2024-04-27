//Victor Udeh
//CS320
//Apr 12 2024


package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

    /**
     * Good constructor
     */
    @DisplayName("Good constructor")
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
    
    /**
     * Invalid constructor with description too long
     */
    @DisplayName("Invalid constructor - Description too long")
    @Test
    void invalidConstructorDescriptionTooLong() {
        String id = "1";
        String fullName = "Victor Udeh";
        String description = "This is an invalid description because the text is way too long to be a real string and should not allow this to work";
       
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });     
    }
    
    /**
     * Invalid constructor with long IDs
     */
    @DisplayName("Invalid constructor with long ID")
    @Test
    void invalidIDConstructor() {
        String id = "12345678910111213";
        String fullName = "Victor Udeh";
        String description = "description";
       
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });       
    }

    /**
     * Invalid constructor with null IDs
     */
    @DisplayName("Invalid constructor with null ID")
    @Test
    void invalidNullConstructor() {
        String id = null;
        String fullName = "Victor Udeh";
        String description = "description";
       
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });       
    }
    
    /**
     * Test the setName with good input 
     */
    @DisplayName("Test a valid setName")
    @Test
    public void testGoodName() {
        String id = "1";
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        
        Task tempTask = new Task(id, fullName, description);  
        tempTask.setName("Test Name");        
        assertEquals("Test Name", tempTask.getName());
    }
    
    /**
     * Test the setName with null input 
     */
    @DisplayName("Test an invalid null setName")
    @Test
    public void testNullName() {
        String id = "1";
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        
        Task tempTask = new Task(id, fullName, description);         
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tempTask.setName(null); 
        }); 
    }
    
    /**
     * Test the setName with overly long input 
     */
    @DisplayName("Test an invalid long setName")
    @Test
    public void testLongName() {
        String id = "1";
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        
        Task tempTask = new Task(id, fullName, description);         
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tempTask.setName("This name is incredibly long and why is this a name, anyway"); 
        }); 
    }
    
    /**
     * Test the setName with empty string 
     */
    @DisplayName("Test an invalid empty setName")
    @Test
    public void testEmptyName() {
        String id = "1";
        String fullName = "Victor Udeh";
        String description = "This is a good description";
        
        Task tempTask = new Task(id, fullName, description);         
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tempTask.setName(""); 
        }); 
    }
    
    /**
     * Test the setDescription with empty string 
     */
    @DisplayName("Test an invalid empty setDescription")
    @Test
    public void testEmptyDescription() {
        String id = "1";
        String fullName = "Victor Udeh";
        String description = "";                 
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        }); 
    }
    
    /**
     * Test the setDescription with null string 
     */
    @DisplayName("Test an invalid null setDescription")
    @Test
    public void testNullDescription() {
        String id = "1";
        String fullName = "Victor Udeh";
        String description = null;                 
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        }); 
    }
}
