package coe528;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * OVERVIEW: Interface to act as a factory for item types
 * @author A.S.A (Amsanaa Chandrakumar, Sandeep Suri, Archit Gupta)
 */
public interface MainStore {
    String type = null;
    String name = null;
    String year = null;
    int daysMin = -1;
    int daysMax = -1;
    float price = -1;
    boolean fastShip = false;
    
    String getType();
    String getName();
    String getYear();
    int getDaysMin();
    int getDaysMax();
    float getPrice();
    boolean getFastShip();
    
    public void setType(String t);
    public void setName(String n);
    public void setYear(String y);
    public void setDaysMin(int dMin);
    public void setDaysMax(int dMax);
    public void setPrice(float p);
    public void setFastShip(boolean fS);
    
    @Override
    public String toString();
    
    @Override
    public boolean equals(Object obj);
    
    @Override
    public int hashCode();
    
    public boolean repOk();
    
    public float fastShip();
    
    
    
    
}
