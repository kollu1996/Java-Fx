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
public class Property {
    private String address;
    private String city;
    private String state;
    private int postalcode;
    private int num_bedroom;
    private int num_bathroom;
    private String type;
    public Property(String add, String city, String sta, int post, int bed, int bath, String type){
        this.address = add;
        this.city = city;
        this.state = sta;
        this.postalcode = post;
        this.num_bedroom = bed;
        this.num_bathroom = bath;
        this.type = type;
    }
    public Property() {System.out.println("Property class no arg constructor is called");} // To avoid no arg ctor error
    public void print(){
        System.out.println("Address:" +address);
        System.out.println("City:" + city);
        System.out.println("State: "+ state);
        System.out.println("Postal Code:" + postalcode);
        System.out.println("Number of bedrooms: " + num_bedroom);
        System.out.println("Number of bathrooms: " + num_bathroom);
    } 
    public String gettype(){return type;}
    public String getaddress(){return address;}
    public String getcity(){return city;}
    public String getstate(){return state;}
    public int getpostalcode() {return postalcode;}
    public int getbedrooms() {return num_bedroom;}
    public int getbathrooms() {return num_bathroom;}
    
    public void setaddress(String address) {this.address = address;}
    public void setcity(String city){this.city = city;}
    public void setstate(String state){this.state = state;}
    public void setpostalcode(String postalcode) {this.postalcode = Integer.parseInt(postalcode);}
    public void setbed(String bedrooms) {this.num_bedroom = Integer.parseInt(bedrooms);}
    public void setbath(String bathrooms) {this.num_bathroom = Integer.parseInt(bathrooms);}
    
    
    public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Property)) return false;
    Property o = (Property) obj;
    return o.address == this.address;
}
}
