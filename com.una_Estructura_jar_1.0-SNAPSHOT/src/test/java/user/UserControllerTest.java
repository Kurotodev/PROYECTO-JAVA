/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import com.una.estructura.controller.user.UserController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Eddier Lopez
 */
public class UserControllerTest {
    UserController instance;
    public UserControllerTest(){
        instance=new UserController();
    }
    
    @Test
    public void testAddNewUser(){
        String data[]={
                        "1",
                        "Jose",
                        "Perez",
                        "jperez@una.cr",
                        "jperez",
                        "1234"
                    };
        String expected="Usuario registrado exitosamente";
        String result=instance.add(data);
        assertEquals(expected,result);
    }
    
    @Test
    public void testAddExistUser(){
        String data[]={
                        "1",
                        "Jose",
                        "Perez",
                        "jperez@una.cr",
                        "jperez",
                        "1234"
                    };
        String expected="Error: Usuario ya resgistrado previamente";
        String result=instance.add(data);
        assertEquals(expected,result);
    }
    @Test
    public void testFindUser(){
        String result[]=instance.find("1");
        assertNotNull(result);
    }
    @Test
    public void testFindNull(){
        String result[]=instance.find("99");
        assertNull(result);
    }
    @Test
    public void testLogin(){
        assertTrue(instance.login("user", "123"));
    }
    
    
    
}
