
package coe528;

import java.util.Scanner;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *OVERVIEW: Manager are immutable. Consists of a Login method(main), menu
 * method(manMenu), and also a createItem, removeItem, and itemInformation
 * 
 * Abstraction Function: AF(c) = c.CheckOut|0&lt;= CheckOut
 * &lt; = items
 * 
 * Rep Invariant:
 * items
 * c.items.size
 * 
 * @author A.S.A (Amsanaa Chandrakumar, Sandeep Suri, Archit Gupta)
 */
public class Manager {
    private CheckOut newItem = new CheckOut();
    
    /**
     * REQUIRES: The manager goes through the main menu to access the online<br>
     * MODIFIES: newItem<br>
     * EFFECTS: Allows the manager to be able to add new items, removes items, and print
     * out the total items, and what they are and return them to the login screen
     */
    public void manMenu() {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Hello Manager\nPlease enter one of the following commands ");
        System.out.println("To logout enter in: logout");
        System.out.println("To see items available: view");
        System.out.println("Enter in a new item: i or I");
        System.out.println("Delete prvious item: d or D");
        
        s = scanner.next();
        
        while(!s.equals("logout")) {
            if(s.equals("i") || s.equals("I")) {
                String Item, iType, iName, iYear, iFast;
                boolean iFastDel;
                int min, max; 
                float p;
                
                System.out.println("Indicate whether it's Grocery, Electronic, or Home Supplies");
                System.out.println("Type in g for Groceries, e for electronics, or hs for Home Supplies: ");
                
                Item = scanner.next();
                while((!Item.equals("g")) && (!Item.equals("e")) && (!Item.equals("hs"))) 
                {
                    System.out.println("You have entered the wrong type");
                    System.out.println("Please enter either - g, e, or hs: ");
                    Item = scanner.next();
                }
                
                System.out.println("Indicate the type of item(Grocery, Electronic, or Supplies");
                
                iType = scanner.next();
                while((!iType.equals("Grocery")) && (!iType.equals("Electronic")) && (!iType.equals("Supplies"))) 
                {
                    System.out.println("You have entered the wrong type");
                    System.out.println("Please enter either Grocery, Electronic, or Supplies ");
                    iType = scanner.next();
                }
                
                
                System.out.println("Indicate Item Name: ");
                iName = scanner.next();
                
                
                System.out.println("Indicate Item Release Date/Expirary Date: ");
                iYear = scanner.next();
                
                System.out.println("Indicate Item Price: $");
                p = scanner.nextFloat();
                while ((p != (float) p)) {
                    System.out.println("Please enter in a number for the price");
                    p = scanner.nextFloat();
                }
                
                do{
                    System.out.print ("Indicate minimum number of days (between 1 - 7) package will take: ");
                    while (!scanner.hasNextInt()){
                        System.out.print("Please enter valid Integer: ");
                        scanner.next();
                    }
                    min = scanner.nextInt();
                }while (min < 0 && min > 7);
                
                do {
                    System.out.println("Indicate maximum number of days (between 8 - 29) the package will take: ");
                    while(!scanner.hasNextInt()) {
                        System.out.println("Please enter in a number between 8 - 30 ");
                        scanner.next();
                    }
                    max = scanner.nextInt();
                } while (max < 7 && max > 31);
                
               
                
                System.out.println("Is fast shipping included? (true or false) ");
                iFast = scanner.next();
                while ((!iFast.equals("true")) && (!iFast.equals("false")))
                {
                    System.out.println("Wrong Type!");
                    System.out.print ("Fast Shipping (true or false): ");
                    iFast = scanner.next();
                }
                
                if (iFast.equals("true")) {
                    iFastDel = true;
                }
                
                else {
                    iFastDel = false;
                }
                createItem(Item, iType, iName, iYear, min, max, p, iFastDel);
            }
                
            else if (s.equalsIgnoreCase("D")) {
                String O;
                O = scanner.next();
                removeItem(O);
            }   
            
            else if(s.equals("view")){
                itemInformation();
            }
            
            System.out.println("To Logout: logout");
            System.out.println("Enter in a new Item: i or I");
            System.out.println("Delete a item = d or D"); 
            System.out.println("To view items: view\n ");
            
            s = scanner.next();
            
        }
    }
    
    /**
     * REQUIRES: All parameters of the store to be valid<br>
     * MODIFIES: newItem.items<br>
     * EFFECTS: Creates a item following the specifications provided by the user<br>
     * @param Item
     * @param iType
     * @param iName
     * @param iYear
     * @param min
     * @param max
     * @param p
     * @param iFastDel 
     */
    public void createItem(String Item, String iType, String iName, String iYear, int min, int max, float p, boolean iFastDel) {
        if(Item.equals("g")) {
            Grocery MS = new Grocery(iType, iName, iYear, min, max, p, iFastDel);
            newItem.addItem(MS);
            MS.toString();
        }
        
        else if (Item.equals("e")) {
            Electronics MS = new Electronics(iType, iName, iYear, min, max, p, iFastDel);
            newItem.addItem(MS);
        }
        
        else if (Item.equals("hs")) {
            HomeSupplies MS = new HomeSupplies(iType, iName, iYear, min, max, p, iFastDel);
            newItem.addItem(MS);
        }
        
        else System.out.println("Item not found");
    }
    
    /**
     * REQUIRES: newItem is not empty and the items name is registered
     * MODIFIES: newItem.items 
     * EFFECTS: Removes the items from the newItem.items
     * @param O
     */
    public void removeItem(String O) {
        newItem.removeItem(O);
    }
    /**
     * EFFECTS: Prints out the information of the store
     */
    public void itemInformation(){
        System.out.println(newItem);
    }
    
    /**
     * EFFECTS: Returns the string representation of the newItem and the items 
     * details
     * @return StringRepresentation
     */
    @Override 
    public String toString() {
        return "The items listed thus far are: " + newItem.toString()
                + "And the items inside are: ";
    }
    /**
     * EFFECTS: Checks to see if the items to make sure it meets the rep invariant
     * requirements
     * @return 
     */
    public Boolean repOk(){
        return newItem.repOk();
    }

    /**
     * EFFECTS: Confirms the login credentials of the attendant using preset
     * and send confirmed attendants to their menu
     * @param args 
     */
    public static void main(String[] args) {
        Manager start = new Manager();
        String s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the A.S.A Online Store");
        s = "start";
       
        while(!s.equals("end")) {
            System.out.println("Provide Username and Password to continue");
            System.out.println("Username: ");
            s = scanner.nextLine();
            
            if("admin".equals(s)) {
                System.out.println("Password: ");
                s = scanner.nextLine();
            
                if("admin".equals(s)) {
                    start.manMenu();
                }
                else {
                    System.out.println("Incorrect Password");
                }
            }
            
            else {
                System.out.println("Incorrect Username");
            }
        }
    }
}

 