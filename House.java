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
public class House extends Purchase_Property{
  public House(String add, String city, String sta, int post, int bed, int bath, long  price, long  tax, String type){
            super( add,  city,  sta,  post,  bed,  bath,  price,  tax, type);
        }
        public void print() {
            System.out.println("I am a House");
            super.print();
            System.out.println("--------------------------------");
        }
        public long getPurchase(){
            return super.getPurchase();
        }
        
    }