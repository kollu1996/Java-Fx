/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myfx_project;


import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import javafx.application.Platform;
import javafx.stage.FileChooser;
/**
 *
 * @author sreenikhilkollu
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Fxcontroller extends App{
   static ArrayList<Property> stack = new ArrayList<Property>();
    
   private static Scene scene;
    @FXML
    private Button apbt;

    @FXML
    private Button hobt;

    @FXML
    private Button cobt;
    
    //====================== HOUSE BUTTON =============================

     @FXML
    private TextField citytext;

    @FXML
    private TextField addtext;

    @FXML
    private TextField sttext;

    @FXML
    private TextField ziptext;

    @FXML
    private TextField purchtext;

    @FXML
    private TextField taxtext;

    @FXML
    private Button houbtn;
    
    @FXML
    private TextField bathtext;

    @FXML
    private TextField bedtext;
    
     @FXML
    private TextField renttext;
     
     @FXML
    private TextField leasetext;
     
     
  
    //============================   Appartment   ===============================
     @FXML
    private Pane apptext;

    @FXML
    private TextField appaddress;

    @FXML
    private TextField appcity;

    @FXML
    private TextField appzip;

    @FXML
    private TextField apprent;

    @FXML
    private TextField appstate;

    @FXML
    private TextField applease;

    @FXML
    private Button appbtn;

    @FXML
    private TextField appbath;

    @FXML
    private TextField appbed;
   //=========================== Condominium ==================================
    
    @FXML
    private Pane condtext;

    @FXML
    private TextField conaddress;

    @FXML
    private TextField concity;

    @FXML
    private TextField constate;

    @FXML
    private TextField conzip;

    @FXML
    private TextField conprice;

    @FXML
    private TextField contax;

    @FXML
    private TextField conmanage;

    @FXML
    private Button condbtn;

    @FXML
    private TextField conbed;

    @FXML
    private TextField conbath;
    
    //============================ Display all ==============================
    
    @FXML
    private Button houseallbtn;

    @FXML
    private Button condoallbtn;

    @FXML
    private Button appallbtn;
    
    @FXML
    private Button initialize;
    
    @FXML
    private Button img;
    
    @FXML
    private Button addappimg;
    
    @FXML
    private Button condoaddimg;

    @FXML
    private Button exitid;

//This is evoked when user hits initialize button in the UI. Three property objects are created and added to array list
    // The array list has weired name ( stack ) because initially I have developed this application using stack and after some 
    //point I realized that it is difficult to delete specific property using stack data structure, so I chaged the design little bit.
    @FXML
    void initialize(ActionEvent event) throws IOException{
         House h2 = new House("129 Park Street", "West Haven", "Connecticut", 76516, 7, 3, 500000, 1000, "House");
         Appartment a2 = new Appartment("24 Ashiville","West Haven","Connecticut", 76516, 5, 2, 2500, 24, "Appartment");
         Condominium c2 = new Condominium("Soundview at Savinrock", "West Haven", "Connecticut", 76516, 4, 2, 80000, 2000, 1800, "Condominium");
         stack.add(h2);
         stack.add(a2);
         stack.add(c2);
         System.out.println("Successfully inialized arraylist contents");
    }
    //The following 3 functions are evoked when user opts for creating a property.
    @FXML
    void aclick(ActionEvent event) throws IOException {
        System.out.println("Appartment Button is clicked");
        App a = new App();
        a.communicate(2);
    }
    
    @FXML
    void cclick(ActionEvent event) throws IOException {
       System.out.println("Condominium Button is clicked");
       App a = new App();
       a.communicate(3);
    }
    
    @FXML
    void hclick(ActionEvent event) throws IOException {
       System.out.println("House Button is clicked");
       App a = new App();
       a.communicate(1);
    }
    
    //The following 3 functions are evoked as soon as the user enters the details and hit submit
    //I am pushing the object in to arraylist at this point
    //These functions are essentially getting data of the form and creating the object.
    
    @FXML
    void houseclick(ActionEvent event)  throws IOException {
     String Address = addtext.getText();
     int num_bathrooms = Integer.parseInt(bathtext.getText());
     Long tax = Long.parseLong(taxtext.getText());
     int num_bedrooms = Integer.parseInt(bedtext.getText());
     Long price = Long.parseLong(purchtext.getText());
     String City = citytext.getText();
     int postalCode = Integer.parseInt(ziptext.getText());
     String State = sttext.getText();
      House h1 = new House(Address, City, State, postalCode, num_bedrooms, num_bathrooms, price, tax, "House");
      stack.add(h1);
      System.out.println("Successfully pushed house to stack object");
    
    }
    
    @FXML
    void appclick(ActionEvent event) {
         String Address = appaddress.getText();
         int num_bathrooms = Integer.parseInt(appbath.getText());
         int num_bedrooms = Integer.parseInt(appbed.getText());
          String City = appcity.getText();
         int postalCode = Integer.parseInt(appzip.getText());
         String State = appstate.getText();
         long rent = Long.parseLong(apprent.getText());
         long lease = Long.parseLong(applease.getText());
         Appartment a1 = new Appartment(Address,City,State, postalCode, num_bedrooms, num_bathrooms, rent, lease, "Appartment");
         stack.add(a1);
         System.out.println("Successfully pushed Appartment to stack object");
        }
    
    @FXML
    void condclick(ActionEvent event) {
          String Address = conaddress.getText();
         int num_bathrooms = Integer.parseInt(conbath.getText());
         int num_bedrooms = Integer.parseInt(conbed.getText());
          String City = concity.getText();
         int postalCode = Integer.parseInt(conzip.getText());
         String State = constate.getText();
         long monthly_mgt = Long.parseLong(conmanage.getText());
         long purchase_price = Long.parseLong(conprice.getText());
         long tax = Long.parseLong(contax.getText());
         Condominium c1 = new Condominium(Address, City, State, postalCode, num_bedrooms, num_bathrooms, purchase_price, tax, monthly_mgt, "Condominium");
         stack.add(c1);
         System.out.println("Successfully pushed Condominium to stack object");
    }
    
    //The following 4 functions belong to see the preview of properties.
    //They include, see all, only house, only condominium, only appartment.
    
    @FXML
    void allclick(ActionEvent event) throws IOException {
         property_details(stack);
    }
    
    @FXML
    void appallclick(ActionEvent event) throws IOException {
        appartmentall(stack);
    }
    
     @FXML
    void condoallclick(ActionEvent event) throws IOException {
         condoall(stack);
    }
    
    @FXML
    void houseallclick(ActionEvent event) throws IOException {
       houseall(stack);
    }
    
    
    
    //The following 3 functions are evoked when user selects the image in the forum
    
    @FXML
    void addimage(ActionEvent event) throws IOException  {
           addimagehouse();
           System.out.println("Image added successfully");
    }
    
    @FXML
    void appimg(ActionEvent event) throws IOException {
        addimageapp();
    }
    
    @FXML
    void condoimg(ActionEvent event) throws IOException {
        addimagecondo();
    }
    
    
    //When user selects exit app.
      @FXML
    void exitclick(ActionEvent event) {
     exitid.setOnAction((e) -> {
          System.exit(0);
         Platform.exit();
     });
    }

}
