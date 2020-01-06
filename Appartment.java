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
public class Appartment extends Rental_Property {
     public Appartment(String add, String city, String sta, int post, int bed, int bath, long  rent, long  lease, String type){
        super( add,  city,  sta,  post,  bed,  bath,  rent,  lease, type);
    }
    public void print() {
        System.out.println("I am an Appartment");
        super.print();
        System.out.println("--------------------------------");
    }
    public long getRent(){
        return super.getRent();
    }
}
