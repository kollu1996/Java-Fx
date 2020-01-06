/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myfx_project;

/**
 *
 * @author sreenikhilkollu
 */
public class Rental_Property extends Property {
     private  long monthlyRent = -1;
    private long leasePeriod = -1;
    private String type;
    public Rental_Property(String add, String city, String sta, int post, int bed, int bath, long  rent, long  lease, String type){
        super(add,city,sta,post, bed, bath, type);
        this.monthlyRent = rent;
        this.leasePeriod = lease;
        this.type = type;
    }
    public Rental_Property() {System.out.println("Rental property class no arg constructor is called");} // To avoid no arg ctor error
    public void print(){
        super.print();
        System.out.println("Monthly Rent: "+ monthlyRent);
        System.out.println("Lease Period: " + leasePeriod);
        System.out.println("Property type is: "+ type);
    }
    
    public long getRent(){
        return monthlyRent;
    }
    
    public long getLease(){
        return leasePeriod;
    }
    
    public void setrent(String rent){
        this.monthlyRent = Long.parseLong(rent);
    }
    
    public void setlease(String lease){
        this.leasePeriod  = Long.parseLong(lease);
    }
    
}
