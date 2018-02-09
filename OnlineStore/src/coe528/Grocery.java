package coe528;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * OVERVIEW: Grocery is mutable. It is specified by type, name, year, daysMin, daysMax
 * price, and fastShip<br>
 * <br>
 * Abstraction Function: AF(c) = c.getName() | Name specifies what items name (ex apples)<br>
 * <br>
 * Rep Invariant: fastShip = true (comes arrives faster), false (arrives slower)
 * 
 * @author A.S.A (Amsanaa Chandrakumar, Sandeep Suri, Archit Gupta)
 */
public class Grocery implements MainStore{
    private String type;
    private String name;
    private String year;
    private int daysMin;
    private int daysMax;
    private float price;
    private boolean fastShip;
    
    /**
     * 
     * @param t
     * @param n
     * @param y
     * @param dMin
     * @param dMax
     * @param p
     * @param fS 
     */
    public Grocery(String t, String n, String y, int dMin, int dMax, float p, boolean fS){
        this.type = t;
        this.name = n;
        this.year = y;
        this.daysMin = dMin;
        this.daysMax = dMax;
        this.price = p;
        this.fastShip = fS;
    }
    /**
     * EFFECTS: Returns the type string of Grocery
     * @return type
     */
    @Override
    public String getType() {
        return type;
    }
    /**
     * EFFECTS: Returns the name string of Grocery
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * EFFECTS: Returns the year string of Grocery
     * @return year
     */
    @Override
    public String getYear() {
        return year;
    }
    /**
     * EFFECTS: Returns the minimum days int of Grocery
     * @return daysMin
     */
    @Override
    public int getDaysMin() {
        return daysMin;
    }
    /**
     * EFFECTS: Returns the maximum days int of Grocery
     * @return daysMax
     */
    @Override
    public int getDaysMax() {
        return daysMax;
    }
    
    /**
     * EFFECTS: Returns the true if fastShip is true and false if it is not fastShip 
     * @return fastShip
     */
    @Override
    public boolean getFastShip() {
        return fastShip;
    }
    /**
     * MODIFIES: type
     * EFFECTS: sets the type of the Grocery to a new string value<br>
     * @param t 
     */
    @Override
    public void setType(String t) {
        this.type = t;
    }
    /**
     * MODIFIES: name
     * EFFECTS: sets the name of the Grocery to a new string value<br>
     * @param n 
     */
    @Override 
    public void setName(String n) {
        this.name = n;
    }
    /**
     * MODIFIES: year
     * EFFECTS: sets the year of the Grocery to a new string value<br>
     * @param y 
     */
    @Override
    public void setYear(String y) {
        this.year = y;
    }
    /**
     * MODIFIES: daysMin
     * EFFECTS: sets the daysMin of the Grocery to a new integer value<br>
     * @param dMin
     */
    @Override
    public void setDaysMin(int dMin) {
        this.daysMin = dMin;
    }
    /**
     * MODIFIES: daysMax
     * EFFECTS: sets the daysMax of the Grocery to a new integer value<br>
     * @param dMax
     */
    @Override
    public void setDaysMax(int dMax) {
        this.daysMax = dMax;
    }
    /**
     * MODIFIES: price
     * EFFECTS: sets the price of the Grocery to a new float value<br>
     * @param p
     */
    @Override
    public void setPrice(float p) {
        this.price = p;
    }
    /**
     * MODIFIES: fastShip
     * EFFECTS: sets the fastShip of the Grocery to true or false depending<br>
     * whether user wrote yes or no<br>
     * @param fS
     */
    @Override
    public void setFastShip(boolean fS) {
        this.fastShip = fS;
    }
    
    /**
     * EFFECTS: if fastShip is true, getDaysMin will be returned with a random value<br>
     * ranging from 1 to 7, if its false, it will return getDaysMax with a random <br>
     * value ranging from 8 - 29
     * @return float
     */
    @Override
    public float fastShip() {
        if (fastShip == true) {
            int dMin = (int) (Math.random() * 7);
            this.daysMin = dMin;
            return getDaysMin();
        }
        else {
            int dMax = (int) (Math.random() * 30 + 7);
            this.daysMax = dMax;
            return getDaysMax();
        }
        
    }
    /**
     * Effects: Returns the price of the item
     * @return price
     */
    @Override
    public float getPrice() {
        return price;
    }
    
    /**
     * EFFECTS: Returns the string representation of the Grocery
     * @return Grocery
     */
    @Override
    public String toString() {
        return "Item Type: " + getType() + ", " + "Item Name: " + getName() + ", " + "Expires: " + getYear() + ", "
                + "Price: " + getPrice() + ", " + "Fast Shipping: " + getFastShip() + ", " +
                "How many Days until it arrives: " + fastShip();
    }
    /**
     * EFFECTS: Checks values of the variables of the HomeSupplies to make sure
     * they meet the rep invariant requirements.
     * @return boolean
     */
    @Override
    public boolean repOk(){
        if (fastShip == true) return true;
        return false;
    }
    
    

}

