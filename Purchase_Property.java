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
public class Purchase_Property extends Property {
    private  long Purchase_price = -1;
    private long taxPerAnnum = -1;
    private long  monthlyAgreement = -1;
    private String type;
    public Purchase_Property(String add, String city, String sta, int post, int bed, int bath, long  price, long  tax, String type){
           super(add,city,sta,post, bed, bath, type);
           this.Purchase_price = price;
           this.taxPerAnnum = tax;
           this.type = type;
    }

    public Purchase_Property(String add, String city, String sta, int post, int bed, int bath, long  price, long  tax, long  monthlyAgreement, String type){
        super(add,city,sta,post, bed, bath, type);
        this.Purchase_price = price;
        this.taxPerAnnum = tax;
        this.type = type;
        this.monthlyAgreement = monthlyAgreement;
    }

    public void print(){
        super.print();
        System.out.println("Purchase_Price: " + Purchase_price);
        System.out.println("Tax per Annum: "+ taxPerAnnum);
        System.out.println("The type of the object is: "+ type);
        if(monthlyAgreement != -1){
             System.out.println("The monyhly agreement is: "+ monthlyAgreement);
        }
    }
    public long getPurchase(){
        return Purchase_price;
    }
    
    public long gettax(){
        return taxPerAnnum;
    }
    
    public void serPurchase(String Purchase){
        this.Purchase_price = Long.parseLong(Purchase);  
    }
    
    public void setTax(String Tax){
        this.taxPerAnnum = Long.parseLong(Tax);
    }
    
    public void setMonthlyagree(String monagree){
        this.monthlyAgreement = Long.parseLong(monagree);
    }
    public long getmonagreement(){
        return monthlyAgreement;
    }
}
