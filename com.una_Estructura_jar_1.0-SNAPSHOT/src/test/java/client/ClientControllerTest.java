/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import com.una.estructura.controller.client.ClientController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Eddier Lopez
 */
public class ClientControllerTest {
    ClientController instance;
    public ClientControllerTest(){
        instance=new ClientController();
    }
    @Test
    public void testAddNewClient(){
        String data[]={"1","Jose","Perez","jose@una.cr"};
        String expected="Cliente agregado correctamente";
        String result=instance.add(data);
        assertEquals(expected,result);
    }
    @Test
    public void testAddExistClient(){
        String data[]={"1","Jose","Perez","jose@una.cr"};
        String expected="Error: Cliente ya existe";
        String result=instance.add(data);
        assertEquals(expected,result);
    }
    
    @Test
    public void testFindNull(){
        String[] result=instance.find("99");        
        assertNull(result);
    }
    
    @Test
    public void testFindClient(){
        String[] result=instance.find("1");        
        assertNotNull(result,"Se esperaba no nulo");
    }
    
    
}
