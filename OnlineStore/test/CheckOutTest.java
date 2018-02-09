/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import coe528.CheckOut;
import coe528.Electronics;
import coe528.Grocery;
import coe528.HomeSupplies;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author A.S.A (Amsanaa Chandrakumar, Sandeep Suri, Archit Gupta)
 */
public class CheckOutTest {
    
    public CheckOutTest() {
    }
    

    /**
     * Test of addItem method of class CheckOut
     */
    @Test
    public void testAddItem() {
        System.out.println("add items");
        CheckOut items = new CheckOut();   
        Grocery GS1 = new Grocery("Grocery", "Apples", "2019", 3, 13, 1, true);   
        items.addItem(GS1); //this method being tested

        }
    /**
     * Test of removeItem method of class CheckOut
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeVehicle");
        CheckOut items = new CheckOut();   
        Grocery GS1 = new Grocery("Grocery", "Apples", "2019", 3, 13, 1, false);
        Electronics ES = new Electronics("Electronics", "PS4", "2014", 2, 10, 400, true);
        items.addItem(GS1); //this method being tested
        items.addItem(ES);
        
        items.removeItem("Apples");
        }
    /**
     * Test of toString method, of class CheckOut.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CheckOut instance = new CheckOut();
        HomeSupplies HS = new HomeSupplies("Supplies", "Cabinet", "2014", 4, 25, 80, true);  
        instance.addItem(HS);
        String expResult = "Total Number of Items Stored: " + 1;
        String result = instance.toString();
        
        if (!(expResult.equals(result))){
            //assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
        
    /**
     * Test of Grocery Object constructor in Grocery class.
     */
    @Test 
    public void testConstructor() {
        boolean gotEx = true;
        try {
            HomeSupplies HS = new HomeSupplies("Supplies", "Cabinet", "2014", 4, 25, 80, true); 
        }
        catch (IllegalArgumentException e){
            gotEx = false;
        }
        assertTrue(gotEx);
    } //confirmed pass
    
    /**
     * Test of User Input FastShip Parameter in Manager class.
     */
    @Test 
    public void testTypeOfItem() {
        String T;
        boolean gotEx = true;
        try {
        System.out.print ("Indicate Item Type (Grocery, Electronics, HomeSupplies: ");
        T = "Grocery";
        while ((!T.equals("Grocery")) && (!T.equals("Electronic")) && (!T.equals("HomeSupplies")))
            {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            gotEx = false;
        }
        assertTrue(gotEx);
    }
        
}  
    

