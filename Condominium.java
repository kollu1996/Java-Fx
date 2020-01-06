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
public class Condominium extends Purchase_Property {
     public Condominium(String add, String city, String sta, int post, int bed, int bath, long  price, long  tax, long monthlyManag, String type){
        super( add,  city,  sta,  post,  bed,  bath,  price,  tax, monthlyManag, type);
    }
    @Override
    public void print() {
        System.out.println("I am a Condominium");
        super.print();
        System.out.println("--------------------------------");
    }
    public long getPurchase(){
            return super.getPurchase();
        }
}
