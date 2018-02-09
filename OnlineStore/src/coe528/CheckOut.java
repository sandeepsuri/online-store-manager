
package coe528;

import java.util.ArrayList;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A.S.A (Amsanaa Chandrakumar, Sandeep Suri, Archit Gupta)
 */
public class CheckOut {

    private ArrayList<MainStore> items;

    //Constructor    
    public CheckOut() {
        items = new ArrayList<MainStore>();

    }
   
    /**
     * REQUIRES: items
     * MODIFIES: items
     * EFFECTS: Adds the items from grocery, electronics, and home supplies into 
     * the items array
     * @param item 
     */
    public void addItem(MainStore item){
            items.add(item);
            System.out.println("Item added");
        
    }
    /**
     * REQUIRES: items
     * MODIFIES: items
     * EFFECTS: Removes the items from items array
     * @param delete 
     */
        public void removeItem(String delete) {
            for( Iterator<MainStore> iterator = items.iterator(); iterator.hasNext(); ){
                MainStore value = iterator.next();
                if (delete.equalsIgnoreCase(value.getName())) {
                    iterator.remove();
                    System.err.println("Item Deleted!");
             }
        }
    }
        
        
        

    /**
     * EFFECTS: Gets the size of the items array 
     * @return 
     */
    public int getNumItems() {
        return items.size();
    }
    /**
     * EFFECTS: Returns the representation of the Manager class
     * @return StringRepresentation
     */
    @Override
    public String toString() {
        for (int i = 0; i < items.size(); i++) {
            MainStore EI = items.get(i);
            System.out.println("#" + (i + 1) + ": " + EI);
        }
        
        return ("Total Number of Items Stored: " + getNumItems());
        
    } 
    /**
     * EFFECTS: Checks the value of the variable on the CheckOut to make sure<br>
     * they meet the rep invariant requirements
     * @return 
     */
    public Boolean repOk(){
        if (items.size() < 0) return false;
        
        return true;
    }
    
    
}
