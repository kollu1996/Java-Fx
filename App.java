


// Programmer: Sreenikhil Kollu

/*
                                                    ABOUT THE PROJECT  :
A real estate application which allows the client to add properties of 3 kinds namely APPARTMENT, CONDOMINIUM, HOUSE.
client can add property, edit the property and delete the property.
Default property for each type is given
Before viewing the whole details of a property, user will have preview page shown where he can decide which property to actually view.
*/

/*
                                                    Logic Used , Data Strucutres and Framework:
Arraylist,
Java Fx
Setters to save the edited data
Getters to display the data
Stored array list to store properties
Implemented an equals function for array list collection while comparing objects and deleting them.
*/
package com.mycompany.myfx_project;
import static com.mycompany.myfx_project.Fxcontroller.stack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import java.io.IOException;
import java.util.Iterator;
import javafx.scene.control.Label;
import java.util.Stack;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.event.EventHandler; 
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.HostServices;
import java.io.FileInputStream;

 

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    private static boolean flag = false;
     private static Scene scene1;
     private static String houseimgpath;
     private static String appartmentimgpath;
     private static String condominiumimgpath;
     private static String houseimgpath1;
     private static String  condominiumimgpath1;
     private static String appartmentimgpath1;
      public  Stage stage1 = new Stage();
      public  Stage stage2 = new Stage();
      public  Stage stage3 = new Stage();
       
    public int j = 0;
    public void setj(int k) { this.j = k; }
    
    
    //Start of the application.
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("The value of j is: "+ j);
        scene = new Scene(loadFXML("proplist"), 560, 700);
        stage.setScene(scene);
        stage.setTitle("Property Listing");
        stage.show(); 
        
    }
   //This is to display a page for user to enter details of a certain property.
   //I have called these functions in FX controller.
    //When user tries to click add property, one of the aclick or cclick or hclick function is evoked and they internally call
    //one of the below functions
    public void communicate(int k) throws IOException{
        if(k == 1) {
            System.out.println("I have called House");
            Scene scene1 = new Scene(loadFXML("House"), 560, 700);
            stage1.setScene(scene1);
            stage1.setTitle("House Listing");
            stage1.show(); 
        }
        if(k == 2) {
            System.out.println("I have called Appartment");
            Scene scene2 = new Scene(loadFXML("Apartment"), 560, 700);
            stage2.setScene(scene2);
            stage2.setTitle("Appartment Listing");
            stage2.show(); 
        }
        if(k == 3) {
            System.out.println("I have called Condominium");
           
            Scene scene3 = new Scene(loadFXML("condominium"), 560, 700);
            stage3.setScene(scene3);
            stage3.setTitle("Condominium Listing");
            stage3.show(); 
        }
    }
    
    
    
    
    //This is the largest function in the entire code.
    //This is also called from FX controller.
    //When user hits show all property button (Precisely All button), function
    //loops over contents in the array list.
    //Note: This function handles each property (House, appartment, condominium)
    //separately. And for each property, edit, delete and view are included.
    //Note: I have depended on address type of a property while displaying image for default property (Given by me)
    //It is not editable. If image for default property is edited in the edit option the code might run in to errors
    //I mean, I have given a special button called initialize which adds three properties, one of each type with meaningful images.
    //However, the user can delete the default property if he does not likes it in his application.
    //The same logic is applied for button that display's preview for house, condominium and appartment exclusively
    public static void property_details(ArrayList <Property> s) throws IOException{
         Stage stage6 = new Stage();
         Stage stage8 = new Stage();
         Stage stage9 = new Stage();
         Iterator<Property> value = s.iterator();
         VBox vbox3 = new VBox();
         vbox3.setPadding(new Insets(10));
         vbox3.setSpacing(8);
         VBox Mainvbox = new VBox();
         VBox housevbox = new VBox();
         VBox appartmentvbox = new VBox();
         VBox condovbox = new VBox();
         
         while(value.hasNext()){
           Property p =  value.next();                   //Dynamic method dispatch
           if(p.gettype() == "House"){
                System.out.println("I have matched house property");
                //This matches with address for default house property
                if((p.getaddress() == "129 Park Street" )){
                   houseimgpath ="/Users/sreenikhilkollu/Documents/house.jpg";  //Image from a folder in computer
                } 
                if(p.getaddress()!= "129 Park Street") houseimgpath = houseimgpath1;
                FileInputStream  input = new FileInputStream(houseimgpath);
                Pane imagepane = new Pane();
                Image image = new Image(input);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imagepane.getChildren().add(imageView);
                housevbox.setPadding(new Insets(10));
                housevbox.setSpacing(8);
                Label propname = new Label();
                Label proptype   = new Label();
               
                //================ On View Button Click =====================
                
                Button Viewbtn = new Button("View");
                Viewbtn.setOnAction((event) -> {
                Text address = new Text();
                Text bathrooms = new Text();
                Text bedrooms = new Text();
                Text city = new Text();
                Text postalcode = new Text();
                Text state = new Text();
                Text type = new Text();
                Text purchase_price = new Text();
                Text tax = new Text();
                System.out.println("View Button is clicked");
                
                Label typeofproperty = new Label("Property type is: ");
                type.setText(p.gettype());
                type.setX(50); 
                type.setY(50); 
                
                Label addresslabel = new Label("Address: ");
                address.setText(p.getaddress());
                address.setX(50); 
                address.setY(65);
              
                Label numofbathrooms = new Label("Number of bathrooms: ");
                bathrooms.setText(Integer.toString(p.getbathrooms()));
                bathrooms.setX(50); 
                bathrooms.setY(75);
                
                Label numofbedrooms = new Label("Number of bedrooms: ");
                bedrooms.setText(Integer.toString(p.getbedrooms()));
                bedrooms.setX(50); 
                bedrooms.setY(90);
                
                Label citylabel = new Label("City is: ");
                city.setText(p.getcity());
                city.setX(50); 
                city.setY(105);
                
                Label postalcodelabel = new Label("Postal : ");
                postalcode.setText(Integer.toString(p.getpostalcode()));
                postalcode.setX(50); 
                postalcode.setY(120);
                
                Label statelabel = new Label("State : ");
                state.setText(p.getstate());
                state.setX(50); 
                state.setY(135);
                
                Label purchaselabel = new Label("Purchase Price : ");
                purchase_price.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                purchase_price.setX(50);
                purchase_price.setY(150);
                
                Label TaxLabel = new Label("Tax per annum is: ");
                tax.setText(Long.toString(( (Purchase_Property)p ).gettax()));
                tax.setX(50);
                tax.setY(165);
                
                Button Gobackbtn = new Button("Go Back");
                
                //=============== On Back Button Click ======================
                Stage detailedview = new Stage();
                Pane pa = new Pane();
                Gobackbtn.setOnAction((ev) ->{ System.out.println("Gio back button is clicked"); detailedview.close();});
                pa.getChildren().addAll( type, address, bathrooms, bedrooms, city, postalcode, state,tax , purchase_price,  Gobackbtn);
                Scene scene6 = new Scene(pa, 300, 200); 
                detailedview.setScene(scene6);
                detailedview.show();
            });
                
                 
    //==================================== On Edit Button Click =================================================
                
                Button Editbtn = new Button("Edit");
                Editbtn.setOnAction((eve) ->{
                System.out.println("Edit button is clicked");
                Label add = new Label("Address");
                TextField tadd = new TextField(p.getaddress());
                Label bath = new Label("Num of bath: ");
                TextField tbath = new TextField(Integer.toString(p.getbathrooms()));
                Label bed = new Label("Num of bed: ");
                TextField tbed = new TextField(Integer.toString(p.getbedrooms()));
                Label cit = new Label("City: ");
                TextField tcity = new TextField(p.getcity());
                Label pcode = new Label("Postal Code");
                TextField tpcode = new TextField(Integer.toString(p.getpostalcode()));
                Label sta = new Label("State: ");
                TextField tsta = new TextField(p.getstate());
                Label purchprice = new Label("Purchase Price: ");
                TextField tpprice = new TextField(Long.toString(( (Purchase_Property)p ).getPurchase()));
                Label taxlabel = new Label("Tax per annum: ");
                TextField ttax = new TextField(Long.toString(( (Purchase_Property)p ).gettax()));
                Button savebtn = new Button("Save");
                savebtn.setOnAction((even) -> {
                     p.setaddress(tadd.getText());
                     p.setcity(tcity.getText());
                     p.setbath(tbath.getText());
                     p.setbed(tbed.getText());
                     p.setstate(tsta.getText());
                     p.setpostalcode(tpcode.getText());
                     ((Purchase_Property)p).serPurchase(tpprice.getText());
                     ((Purchase_Property)p).setTax(ttax.getText());
                     System.out.println("Updated Object Successfully");
                     System.out.println("Save Button is Clicked"); 
                     stage8.close();
                 });
                 //Vbox 2 for editing the property
                 VBox vbox2 = new VBox();
                 vbox2.setPadding(new Insets(10));
                 vbox2.setSpacing(8);
                 vbox2.getChildren().clear();
                 vbox2.getChildren().addAll(add, tadd, bath, tbath, bed, tbed, cit, tcity,pcode,tpcode,sta,tsta,purchprice,tpprice,taxlabel,ttax,savebtn); 
                 Scene scene8 = new Scene(vbox2, 900, 700);
                 stage8.setScene(scene8);
                 stage8.show();
             });
                
    //======================================= For deleting property ======================================================           
                
                Button Deletebtn = new Button("Delete");
                Deletebtn.setOnAction((evnt) -> { 
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Are you sure? ");
                    alert.setContentText("I am deleting the property!");
                  Optional<ButtonType> result =   alert.showAndWait();
                  if(result.isPresent()){ 
                      Iterator<Property> value1 = s.iterator();
                       System.out.println("The length of arraylist before removing is: "+ s.size());
                      while(value1.hasNext()){
                            Property q =  value1.next(); 
                            if(p.equals(q)){
                                value1.remove();
                                stage6.close();
                                
                            }
                      }
                      System.out.println("Property Successfully Removed");
                      System.out.println("The length of arraylist after removing is: "+ s.size());
                  }
                });
                Label propertytype = new Label("Type of Property: ");
                Label Purchase_Price = new Label("Purchase Price: ");
               
                System.out.println(p.gettype());
                System.out.println(((Purchase_Property)p).getPurchase());
                propname.setText(p.gettype());
                proptype.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                housevbox.getChildren().addAll(imagepane, propertytype, propname, Purchase_Price, proptype, Viewbtn, Editbtn, Deletebtn);
                
           }
           
           if(p.gettype() == "Condominium"){
               System.out.println("I have matched condo property");
                if((p.getaddress() == "Soundview at Savinrock" )){
                   condominiumimgpath ="/Users/sreenikhilkollu/Documents/condo1.jpg";  //Image from a folder in computer
                } 
                if(p.getaddress()!= "Soundview at Savinrock") condominiumimgpath = condominiumimgpath1;
                FileInputStream input = new FileInputStream(condominiumimgpath);
                Pane imagepane = new Pane();
                Image image = new Image(input);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imagepane.getChildren().add(imageView);
               //Vbox for creating condominium preview
                condovbox.setPadding(new Insets(10));
                condovbox.setSpacing(8);
                Label propname = new Label();
                Label proptype   = new Label();
                
                //======================== For Viewing Condominum ================================================================
                Button cViewbtn = new Button("View");
                cViewbtn.setOnAction((eve) ->{
                Text address = new Text();
                Text bathrooms = new Text();
                Text bedrooms = new Text();
                Text city = new Text();
                Text postalcode = new Text();
                Text state = new Text();
                Text type = new Text();
                Text purchase_price = new Text();
                Text tax = new Text();
                Text Monthly_agree = new Text();
                System.out.println("View Button is clicked");
                
                Label typeofproperty = new Label("Property type is: ");
                type.setText(p.gettype());
                type.setX(50); 
                type.setY(50); 
                
                Label addresslabel = new Label("Address: ");
                address.setText(p.getaddress());
                address.setX(50); 
                address.setY(65);
              
                Label numofbathrooms = new Label("Number of bathrooms: ");
                bathrooms.setText(Integer.toString(p.getbathrooms()));
                bathrooms.setX(50); 
                bathrooms.setY(75);
                
                Label numofbedrooms = new Label("Number of bedrooms: ");
                bedrooms.setText(Integer.toString(p.getbedrooms()));
                bedrooms.setX(50); 
                bedrooms.setY(90);
                
                Label citylabel = new Label("City is: ");
                city.setText(p.getcity());
                city.setX(50); 
                city.setY(105);
                
                Label postalcodelabel = new Label("Postal : ");
                postalcode.setText(Integer.toString(p.getpostalcode()));
                postalcode.setX(50); 
                postalcode.setY(120);
                
                Label statelabel = new Label("State : ");
                state.setText(p.getstate());
                state.setX(50); 
                state.setY(135);
                
                Label purchaselabel = new Label("Purchase Price : ");
                purchase_price.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                purchase_price.setX(50);
                purchase_price.setY(150);
                
                Label TaxLabel = new Label("Tax per annum is: ");
                tax.setText(Long.toString(( (Purchase_Property)p ).gettax()));
                tax.setX(50);
                tax.setY(165);
                
                Label Monthlylabel = new Label("Monthly Management is: ");
                Monthly_agree.setText(Long.toString(( (Purchase_Property)p ).getmonagreement()));
                Monthly_agree.setX(50);
                Monthly_agree.setY(180);
                
                Button Gobackbtn = new Button("Go Back");
                
                //=============== On Back Button Click ======================
                Stage detailedview = new Stage();
                Pane pa = new Pane();
                Gobackbtn.setOnAction((ev) ->{ System.out.println("Gio back button is clicked"); detailedview.close();});
                pa.getChildren().addAll( type, address,  bathrooms,  bedrooms,  city,  postalcode,  state, purchase_price,  tax, Monthly_agree, Gobackbtn);
                Scene scene6 = new Scene(pa, 300, 200); 
                detailedview.setScene(scene6);
                detailedview.show();  
                });
                
               //========================  For Editing Condominium ===========================================================
                Button cEditbtn = new Button("Edit");
                 cEditbtn.setOnAction((events) ->{
                 System.out.println("Edit button is clicked");
                 Label add = new Label("Address");
                 TextField tadd = new TextField(p.getaddress());
                 Label bath = new Label("Num of bath: ");
                 TextField tbath = new TextField(Integer.toString(p.getbathrooms()));
                 Label bed = new Label("Num of bed: ");
                 TextField tbed = new TextField(Integer.toString(p.getbedrooms()));
                 Label cit = new Label("City: ");
                 TextField tcity = new TextField(p.getcity());
                 Label pcode = new Label("Postal Code");
                 TextField tpcode = new TextField(Integer.toString(p.getpostalcode()));
                 Label sta = new Label("State: ");
                 TextField tsta = new TextField(p.getstate());
                 Label purchprice = new Label("Purchase Price: ");
                 TextField tpprice = new TextField(Long.toString(( (Purchase_Property)p ).getPurchase()));
                 Label taxlabel = new Label("Tax per annum: ");
                 TextField ttax = new TextField(Long.toString(( (Purchase_Property)p ).gettax()));
                 Label monthlylabel = new Label("Monthly Management: ");
                 TextField tmonthly =  new TextField(Long.toString(( (Purchase_Property)p ).getmonagreement()));
                 Button savebtn = new Button("Save");
                 savebtn.setOnAction((even) -> {
                     p.setaddress(tadd.getText());
                     p.setcity(tcity.getText());
                     p.setbath(tbath.getText());
                     p.setbed(tbed.getText());
                     p.setstate(tsta.getText());
                     p.setpostalcode(tpcode.getText());
                     ((Purchase_Property)p).serPurchase(tpprice.getText());
                     ((Purchase_Property)p).setTax(ttax.getText());
                     ((Purchase_Property)p).setMonthlyagree(tmonthly.getText());
                     System.out.println("Updated Object Successfully");
                     System.out.println("Save Button is Clicked"); 
                     stage8.close();
                });
                 //Vbox 2 for editing the property
                 VBox vbox2 = new VBox();
                 vbox2.setPadding(new Insets(10));
                 vbox2.setSpacing(8);
                 vbox2.getChildren().clear();
                 vbox2.getChildren().addAll(add, tadd, bath, tbath, bed, tbed, cit, tcity,pcode,tpcode,sta,tsta,purchprice,tpprice,taxlabel, ttax,monthlylabel, tmonthly, savebtn); 
                 Scene scene8 = new Scene(vbox2, 900, 700);
                 stage8.setScene(scene8);
                 stage8.show();
                  });
               
                 //======================== For Deleting Condominium ======================================
                Button cDeletebtn = new Button("Delete");
                 cDeletebtn.setOnAction((evnt) -> { 
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Are you sure? ");
                    alert.setContentText("I am deleting the property!");
                  Optional<ButtonType> result =   alert.showAndWait();
                  if(result.isPresent()){ 
                      Iterator<Property> value1 = s.iterator();
                       System.out.println("The length of arraylist before removing is: "+ s.size());
                      while(value1.hasNext()){
                            Property q =  value1.next(); 
                            if(p.equals(q)){
                                value1.remove();
                                stage6.close();
                                
                            }
                      }
                      System.out.println("Property Successfully Removed");
                      System.out.println("The length of arraylist after removing is: "+ s.size());
                  }
                });
                Label propertytype = new Label("Type of Property: ");
                Label Purchase_Price = new Label("Purchase Price: ");
                System.out.println(p.gettype());
                System.out.println(((Purchase_Property)p).getPurchase());
                propname.setText(p.gettype());
                proptype.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                condovbox.getChildren().addAll(imagepane, propertytype, propname, Purchase_Price, proptype, cViewbtn, cEditbtn, cDeletebtn);
           }
           
           if(p.gettype() == "Appartment"){
               if((p.getaddress() == "24 Ashiville" )){
                   appartmentimgpath ="/Users/sreenikhilkollu/Documents/appartment.jpeg";  //Image from a folder in computer
                } 
                if(p.getaddress()!= "24 Ashiville") appartmentimgpath = appartmentimgpath1;
                FileInputStream input = new FileInputStream(appartmentimgpath);
                Pane imagepane = new Pane();
                Image image = new Image(input);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imagepane.getChildren().add(imageView);
               //Vbox1 for creating appartment property preview
                appartmentvbox.setPadding(new Insets(10));
                appartmentvbox.setSpacing(8);
                Label propname = new Label();
                Label proptype = new Label();
                Button aViewbtn = new Button("View");
                
                aViewbtn.setOnAction((eve) ->{
                Text address = new Text();
                Text bathrooms = new Text();
                Text bedrooms = new Text();
                Text city = new Text();
                Text postalcode = new Text();
                Text state = new Text();
                Text type = new Text();
                Text Monthly_rent = new Text();
                Text lease = new Text();
                System.out.println("View Button is clicked");
                
                Label typeofproperty = new Label("Property type is: ");
                type.setText(p.gettype());
                type.setX(50); 
                type.setY(50); 
                
                Label addresslabel = new Label("Address: ");
                address.setText(p.getaddress());
                address.setX(50); 
                address.setY(65);
              
                Label numofbathrooms = new Label("Number of bathrooms: ");
                bathrooms.setText(Integer.toString(p.getbathrooms()));
                bathrooms.setX(50); 
                bathrooms.setY(75);
                
                Label numofbedrooms = new Label("Number of bedrooms: ");
                bedrooms.setText(Integer.toString(p.getbedrooms()));
                bedrooms.setX(50); 
                bedrooms.setY(90);
                
                Label citylabel = new Label("City is: ");
                city.setText(p.getcity());
                city.setX(50); 
                city.setY(105);
                
                Label postalcodelabel = new Label("Postal : ");
                postalcode.setText(Integer.toString(p.getpostalcode()));
                postalcode.setX(50); 
                postalcode.setY(120);
                
                Label statelabel = new Label("State : ");
                state.setText(p.getstate());
                state.setX(50); 
                state.setY(135);
                
                Label rentlabel = new Label("Rent is: ");
                Monthly_rent.setText(Long.toString(( (Rental_Property)p ).getRent()));
                Monthly_rent.setX(50);
                Monthly_rent.setY(150);
                
                Label leaselabel  = new Label("Lease is: ");
                lease.setText(Long.toString(( (Rental_Property)p ).getLease()));
                lease.setX(50);
                lease.setY(165);
                
                
                Button Gobackbtn = new Button("Go Back");
                
                //=============== On Back Button Click ======================
                Stage detailedview = new Stage();
                Pane pa = new Pane();
                Gobackbtn.setOnAction((ev) ->{ System.out.println("Gio back button is clicked"); detailedview.close();});
                pa.getChildren().addAll( type,  address,  bathrooms,  bedrooms, city,  postalcode,state,  Monthly_rent, lease, Gobackbtn);
                Scene scene6 = new Scene(pa, 300, 200); 
                detailedview.setScene(scene6);
                detailedview.show();  
                });
              
                Button aEditbtn = new Button("Edit");
                aEditbtn.setOnAction((events) ->{
                 System.out.println("Edit button is clicked");
                 Label add = new Label("Address");
                 TextField tadd = new TextField(p.getaddress());
                 Label bath = new Label("Num of bath: ");
                 TextField tbath = new TextField(Integer.toString(p.getbathrooms()));
                 Label bed = new Label("Num of bed: ");
                 TextField tbed = new TextField(Integer.toString(p.getbedrooms()));
                 Label cit = new Label("City: ");
                 TextField tcity = new TextField(p.getcity());
                 Label pcode = new Label("Postal Code");
                 TextField tpcode = new TextField(Integer.toString(p.getpostalcode()));
                 Label sta = new Label("State: ");
                 TextField tsta = new TextField(p.getstate());
                 Label rentlabel = new Label("Rent: ");
                 TextField arent = new TextField(Long.toString(( (Rental_Property)p ).getRent()));
                 Label leaselabel = new Label("Lease: ");
                 TextField alease =  new TextField(Long.toString(( (Rental_Property)p ).getLease()));
                 Button savebtn = new Button("Save");
                 savebtn.setOnAction((even) -> {
                     p.setaddress(tadd.getText());
                     p.setcity(tcity.getText());
                     p.setbath(tbath.getText());
                     p.setbed(tbed.getText());
                     p.setstate(tsta.getText());
                     p.setpostalcode(tpcode.getText());
                     ((Rental_Property)p).setrent(arent.getText());
                     ((Rental_Property)p).setlease(alease.getText());
                     System.out.println("Updated Object Successfully");
                     System.out.println("Save Button is Clicked"); 
                     stage8.close();
                });
                 //Vbox 2 for editing the property
                 VBox vbox2 = new VBox();
                 vbox2.setPadding(new Insets(10));
                 vbox2.setSpacing(8);
                 vbox2.getChildren().clear();
                 vbox2.getChildren().addAll(add, tadd, bath, tbath, bed, tbed, cit, tcity,pcode,tpcode,sta,tsta,rentlabel,arent,leaselabel, alease, savebtn); 
                 Scene scene8 = new Scene(vbox2, 900, 700);
                 stage8.setScene(scene8);
                 stage8.show();
                  });
                Button aDeletebtn = new Button("Delete");
                aDeletebtn.setOnAction((evnt) -> { 
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Are you sure? ");
                    alert.setContentText("I am deleting the property!");
                  Optional<ButtonType> result =   alert.showAndWait();
                  if(result.isPresent()){ 
                      Iterator<Property> value1 = s.iterator();
                       System.out.println("The length of arraylist before removing is: "+ s.size());
                      while(value1.hasNext()){
                            Property q =  value1.next(); 
                            if(p.equals(q)){
                                value1.remove();
                                stage6.close();
                                
                            }
                      }
                      System.out.println("Property Successfully Removed");
                      System.out.println("The length of arraylist after removing is: "+ s.size());
                  }
                });
                Label propertytype = new Label("Property Type is: ");
                Label Rent = new Label("Rent per month is: ");
                System.out.println(p.gettype());
                System.out.println(((Rental_Property)p).getRent());
                propname.setText(p.gettype());
                proptype.setText(Long.toString(( (Rental_Property)p ).getRent()));
                appartmentvbox.getChildren().addAll(imagepane, propertytype, propname, Rent, proptype, aViewbtn, aEditbtn, aDeletebtn);
                
                
           }
        }
       
         Mainvbox.getChildren().addAll(housevbox, appartmentvbox, condovbox);
         ScrollPane sc = new ScrollPane();
         sc.setContent(Mainvbox);
         sc.setPannable(true); 
         Scene Mainscene = new Scene(sc, 900, 700);
         Stage Mainstage = new Stage();
         Mainstage.setScene(Mainscene);
         Mainstage.show();
         
    }
    
    
    public static void houseall(ArrayList <Property> s) throws IOException{
      
         System.out.println("The length of arraylist beginning is: "+ s.size());
         Stage stage6 = new Stage();
         Stage stage8 = new Stage();
         Stage stage9 = new Stage();
         Iterator<Property> value = s.iterator();
         VBox vbox3 = new VBox();
         vbox3.setPadding(new Insets(10));
         vbox3.setSpacing(8);
         VBox Mainvbox = new VBox();
         VBox housevbox = new VBox();
         VBox appartmentvbox = new VBox();
         VBox condovbox = new VBox();
         
         while(value.hasNext()){
           Property p =  value.next();                   //Dynamic method dispatch
           if(p.gettype() == "House"){
               if(p.getaddress()!= "129 Park Street") houseimgpath = houseimgpath1;
               if(p.getaddress() == "129 Park Street") {houseimgpath ="/Users/sreenikhilkollu/Documents/house.jpg";}
               FileInputStream input = new FileInputStream(houseimgpath);
               Pane imagepane = new Pane();
               Image image = new Image(input);
               ImageView imageView = new ImageView(image);
               imageView.setFitHeight(100);
               imageView.setFitWidth(100);
               imagepane.getChildren().add(imageView);
                // Vbox1 for creating an house preview
               
                housevbox.setPadding(new Insets(10));
                housevbox.setSpacing(8);
                Label propname = new Label();
                Label proptype   = new Label();
                
                //================ On View Button Click =====================
                
                Button Viewbtn = new Button("View");
                Viewbtn.setOnAction((event) -> {
                Text address = new Text();
                Text bathrooms = new Text();
                Text bedrooms = new Text();
                Text city = new Text();
                Text postalcode = new Text();
                Text state = new Text();
                Text type = new Text();
                Text purchase_price = new Text();
                Text tax = new Text();
                System.out.println("View Button is clicked");
                
                Label typeofproperty = new Label("Property type is: ");
                type.setText(p.gettype());
                type.setX(50); 
                type.setY(50); 
                
                Label addresslabel = new Label("Address: ");
                address.setText(p.getaddress());
                address.setX(50); 
                address.setY(65);
              
                Label numofbathrooms = new Label("Number of bathrooms: ");
                bathrooms.setText(Integer.toString(p.getbathrooms()));
                bathrooms.setX(50); 
                bathrooms.setY(75);
                
                Label numofbedrooms = new Label("Number of bedrooms: ");
                bedrooms.setText(Integer.toString(p.getbedrooms()));
                bedrooms.setX(50); 
                bedrooms.setY(90);
                
                Label citylabel = new Label("City is: ");
                city.setText(p.getcity());
                city.setX(50); 
                city.setY(105);
                
                Label postalcodelabel = new Label("Postal : ");
                postalcode.setText(Integer.toString(p.getpostalcode()));
                postalcode.setX(50); 
                postalcode.setY(120);
                
                Label statelabel = new Label("State : ");
                state.setText(p.getstate());
                state.setX(50); 
                state.setY(135);
                
                Label purchaselabel = new Label("Purchase Price : ");
                purchase_price.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                purchase_price.setX(50);
                purchase_price.setY(150);
                
                Label TaxLabel = new Label("Tax per annum is: ");
                tax.setText(Long.toString(( (Purchase_Property)p ).gettax()));
                tax.setX(50);
                tax.setY(165);
                
                Button Gobackbtn = new Button("Go Back");
                
                //=============== On Back Button Click ======================
                Stage detailedview = new Stage();
                Pane pa = new Pane();
                Gobackbtn.setOnAction((ev) ->{ System.out.println("Gio back button is clicked"); detailedview.close();});
                pa.getChildren().addAll( type,  address, bathrooms,  bedrooms,  city,  postalcode,  state, tax,  purchase_price,  Gobackbtn);
                Scene scene6 = new Scene(pa, 300, 200); 
                detailedview.setScene(scene6);
                detailedview.show();
            });
                
                 
    //==================================== On Edit Button Click =================================================
                
                Button Editbtn = new Button("Edit");
                Editbtn.setOnAction((eve) ->{
                System.out.println("Edit button is clicked");
                Label add = new Label("Address");
                TextField tadd = new TextField(p.getaddress());
                Label bath = new Label("Num of bath: ");
                TextField tbath = new TextField(Integer.toString(p.getbathrooms()));
                Label bed = new Label("Num of bed: ");
                TextField tbed = new TextField(Integer.toString(p.getbedrooms()));
                Label cit = new Label("City: ");
                TextField tcity = new TextField(p.getcity());
                Label pcode = new Label("Postal Code");
                TextField tpcode = new TextField(Integer.toString(p.getpostalcode()));
                Label sta = new Label("State: ");
                TextField tsta = new TextField(p.getstate());
                Label purchprice = new Label("Purchase Price: ");
                TextField tpprice = new TextField(Long.toString(( (Purchase_Property)p ).getPurchase()));
                Label taxlabel = new Label("Tax per annum: ");
                TextField ttax = new TextField(Long.toString(( (Purchase_Property)p ).gettax()));
                Button savebtn = new Button("Save");
                savebtn.setOnAction((even) -> {
                     p.setaddress(tadd.getText());
                     p.setcity(tcity.getText());
                     p.setbath(tbath.getText());
                     p.setbed(tbed.getText());
                     p.setstate(tsta.getText());
                     p.setpostalcode(tpcode.getText());
                     ((Purchase_Property)p).serPurchase(tpprice.getText());
                     ((Purchase_Property)p).setTax(ttax.getText());
                     System.out.println("Updated Object Successfully");
                     System.out.println("Save Button is Clicked"); 
                     stage8.close();
                 });
                 //Vbox 2 for editing the property
                 VBox vbox2 = new VBox();
                 vbox2.setPadding(new Insets(10));
                 vbox2.setSpacing(8);
                 vbox2.getChildren().clear();
                 vbox2.getChildren().addAll(add, tadd, bath, tbath, bed, tbed, cit, tcity,pcode,tpcode,sta,tsta,purchprice,tpprice,taxlabel, ttax, savebtn); 
                 Scene scene8 = new Scene(vbox2, 900, 700);
                 stage8.setScene(scene8);
                 stage8.show();
             });
                
    //======================================= For deleting property ======================================================           
                
                Button Deletebtn = new Button("Delete");
                Deletebtn.setOnAction((evnt) -> { 
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Are you sure? ");
                    alert.setContentText("I am deleting the property!");
                  Optional<ButtonType> result =   alert.showAndWait();
                  if(result.isPresent()){ 
                      Iterator<Property> value1 = s.iterator();
                       System.out.println("The length of arraylist before removing is: "+ s.size());
                      while(value1.hasNext()){
                            Property q =  value1.next(); 
                            if(p.equals(q)){
                                value1.remove();
                                stage6.close();
                                
                            }
                      }
                      System.out.println("Property Successfully Removed");
                      System.out.println("The length of arraylist after removing is: "+ s.size());
                  }
                });
                Label propertytype = new Label("Type of Property: ");
                Label Purchase_Price = new Label("Purchase Price: ");
                System.out.println(p.gettype());
                System.out.println(((Purchase_Property)p).getPurchase());
                propname.setText(p.gettype());
                proptype.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                housevbox.getChildren().addAll(imagepane, propertytype, propname,Purchase_Price, proptype, Viewbtn, Editbtn, Deletebtn);
               
           }
           
    }
         Mainvbox.getChildren().addAll(housevbox, appartmentvbox, condovbox);
         ScrollPane sc = new ScrollPane();
         sc.setContent(Mainvbox);
         sc.setPannable(true); 
         Scene Mainscene = new Scene(sc, 900, 700);
         Stage Mainstage = new Stage();
         Mainstage.setScene(Mainscene);
         Mainstage.show();
    }
    
    public static void condoall (ArrayList <Property> s) throws IOException{
        System.out.println("The length of arraylist beginning is: "+ s.size());
         Stage stage6 = new Stage();
         Stage stage8 = new Stage();
         Stage stage9 = new Stage();
         Iterator<Property> value = s.iterator();
         VBox vbox3 = new VBox();
         vbox3.setPadding(new Insets(10));
         vbox3.setSpacing(8);
         VBox Mainvbox = new VBox();
         VBox housevbox = new VBox();
         VBox appartmentvbox = new VBox();
         VBox condovbox = new VBox();
         while(value.hasNext()){
             Property p =  value.next(); 
            if(p.gettype() == "Condominium"){
                 if((p.getaddress() == "Soundview at Savinrock" )){
                   condominiumimgpath ="/Users/sreenikhilkollu/Documents/condo1.jpg";  //Image from a folder in computer
                } 
                if(p.getaddress()!= "Soundview at Savinrock") condominiumimgpath = condominiumimgpath1;
          
           FileInputStream input = new FileInputStream(condominiumimgpath);
         input = new FileInputStream(condominiumimgpath);
         Pane imagepane = new Pane();
         Image image = new Image(input);
         ImageView imageView = new ImageView(image);
         imageView.setFitHeight(100);
         imageView.setFitWidth(100);
         imagepane.getChildren().add(imageView);
               //Vbox for creating condominium preview
                condovbox.setPadding(new Insets(10));
                condovbox.setSpacing(8);
                Label propname = new Label();
                Label proptype   = new Label();
                
                //======================== For Viewing Condominum ================================================================
                Button cViewbtn = new Button("View");
                cViewbtn.setOnAction((eve) ->{
                Text address = new Text();
                Text bathrooms = new Text();
                Text bedrooms = new Text();
                Text city = new Text();
                Text postalcode = new Text();
                Text state = new Text();
                Text type = new Text();
                Text purchase_price = new Text();
                Text tax = new Text();
                Text Monthly_agree = new Text();
                System.out.println("View Button is clicked");
                
                type.setText(p.gettype());
                type.setX(50); 
                type.setY(50); 
                
                address.setText(p.getaddress());
                address.setX(50); 
                address.setY(65);
              
                bathrooms.setText(Integer.toString(p.getbathrooms()));
                bathrooms.setX(50); 
                bathrooms.setY(75);
                
                bedrooms.setText(Integer.toString(p.getbedrooms()));
                bedrooms.setX(50); 
                bedrooms.setY(90);
                
                city.setText(p.getcity());
                city.setX(50); 
                city.setY(105);
                
                postalcode.setText(Integer.toString(p.getpostalcode()));
                postalcode.setX(50); 
                postalcode.setY(120);
                
                state.setText(p.getstate());
                state.setX(50); 
                state.setY(135);
                
                purchase_price.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                purchase_price.setX(50);
                purchase_price.setY(150);
                
                tax.setText(Long.toString(( (Purchase_Property)p ).gettax()));
                tax.setX(50);
                tax.setY(165);
                
                Monthly_agree.setText(Long.toString(( (Purchase_Property)p ).getmonagreement()));
                Monthly_agree.setX(50);
                Monthly_agree.setY(180);
                
                Button Gobackbtn = new Button("Go Back");
                
                //=============== On Back Button Click ======================
                Stage detailedview = new Stage();
                Pane pa = new Pane();
                Gobackbtn.setOnAction((ev) ->{ System.out.println("Gio back button is clicked"); detailedview.close();});
                pa.getChildren().addAll(type, address, bathrooms, bedrooms, city, postalcode, state, purchase_price, tax, Monthly_agree, Gobackbtn);
                Scene scene6 = new Scene(pa, 300, 200); 
                detailedview.setScene(scene6);
                detailedview.show();  
                });
                
               //========================  For Editing Condominium ===========================================================
                Button cEditbtn = new Button("Edit");
                 cEditbtn.setOnAction((events) ->{
                 System.out.println("Edit button is clicked");
                 Label add = new Label("Address");
                 TextField tadd = new TextField(p.getaddress());
                 Label bath = new Label("Num of bath: ");
                 TextField tbath = new TextField(Integer.toString(p.getbathrooms()));
                 Label bed = new Label("Num of bed: ");
                 TextField tbed = new TextField(Integer.toString(p.getbedrooms()));
                 Label cit = new Label("City: ");
                 TextField tcity = new TextField(p.getcity());
                 Label pcode = new Label("Postal Code");
                 TextField tpcode = new TextField(Integer.toString(p.getpostalcode()));
                 Label sta = new Label("State: ");
                 TextField tsta = new TextField(p.getstate());
                 Label purchprice = new Label("Purchase Price: ");
                 TextField tpprice = new TextField(Long.toString(( (Purchase_Property)p ).getPurchase()));
                 Label taxlabel = new Label("Tax per annum: ");
                 TextField ttax = new TextField(Long.toString(( (Purchase_Property)p ).gettax()));
                 Label monthlylabel = new Label("Monthly Management: ");
                 TextField tmonthly =  new TextField(Long.toString(( (Purchase_Property)p ).getmonagreement()));
                 Button savebtn = new Button("Save");
                 savebtn.setOnAction((even) -> {
                     p.setaddress(tadd.getText());
                     p.setcity(tcity.getText());
                     p.setbath(tbath.getText());
                     p.setbed(tbed.getText());
                     p.setstate(tsta.getText());
                     p.setpostalcode(tpcode.getText());
                     ((Purchase_Property)p).serPurchase(tpprice.getText());
                     ((Purchase_Property)p).setTax(ttax.getText());
                     ((Purchase_Property)p).setMonthlyagree(tmonthly.getText());
                     System.out.println("Updated Object Successfully");
                     System.out.println("Save Button is Clicked"); 
                     stage8.close();
                });
                 //Vbox 2 for editing the property
                 VBox vbox2 = new VBox();
                 vbox2.setPadding(new Insets(10));
                 vbox2.setSpacing(8);
                 vbox2.getChildren().clear();
                 vbox2.getChildren().addAll(add, tadd, bath, tbath, bed, tbed, cit, tcity,pcode,tpcode,sta,tsta,purchprice,tpprice,taxlabel, ttax,monthlylabel, tmonthly, savebtn); 
                 Scene scene8 = new Scene(vbox2, 900, 700);
                 stage8.setScene(scene8);
                 stage8.show();
                  });
               
                 //======================== For Deleting Condominium ======================================
                Button cDeletebtn = new Button("Delete");
                 cDeletebtn.setOnAction((evnt) -> { 
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Are you sure? ");
                    alert.setContentText("I am deleting the property!");
                  Optional<ButtonType> result =   alert.showAndWait();
                  if(result.isPresent()){ 
                      Iterator<Property> value1 = s.iterator();
                       System.out.println("The length of arraylist before removing is: "+ s.size());
                      while(value1.hasNext()){
                            Property q =  value1.next(); 
                            if(p.equals(q)){
                                value1.remove();
                                stage6.close();
                                
                            }
                      }
                      System.out.println("Property Successfully Removed");
                      System.out.println("The length of arraylist after removing is: "+ s.size());
                  }
                });
                Label propertytype = new Label("Type of Property: ");
                Label Purchase_Price = new Label("Purchase Price: ");
                System.out.println(p.gettype());
                System.out.println(((Purchase_Property)p).getPurchase());
                propname.setText(p.gettype());
                proptype.setText(Long.toString(( (Purchase_Property)p ).getPurchase()));
                condovbox.getChildren().addAll(imagepane, propertytype, propname, Purchase_Price, proptype, cViewbtn, cEditbtn, cDeletebtn);
           }
         }
         
         Mainvbox.getChildren().addAll(housevbox, appartmentvbox, condovbox);
         ScrollPane sc = new ScrollPane();
         sc.setContent(Mainvbox);
         sc.setPannable(true); 
         Scene Mainscene = new Scene(sc, 900, 700);
         Stage Mainstage = new Stage();
         Mainstage.setScene(Mainscene);
         Mainstage.show();
   }
    
    
    public static void appartmentall (ArrayList <Property> s) throws IOException{
         
         System.out.println("The length of arraylist beginning is: "+ s.size());
         Stage stage6 = new Stage();
         Stage stage8 = new Stage();
         Stage stage9 = new Stage();
         Iterator<Property> value = s.iterator();
         VBox vbox3 = new VBox();
         vbox3.setPadding(new Insets(10));
         vbox3.setSpacing(8);
         VBox Mainvbox = new VBox();
         VBox housevbox = new VBox();
         VBox appartmentvbox = new VBox();
         VBox condovbox = new VBox();
         
         while(value.hasNext()){
           Property p =  value.next();
             if(p.gettype() == "Appartment"){
                 if((p.getaddress() == "24 Ashiville" )){
                   appartmentimgpath ="/Users/sreenikhilkollu/Documents/appartment.jpeg";  //Image from a folder in computer
                } 
                if(p.getaddress()!= "24 Ashiville") appartmentimgpath = appartmentimgpath1;
                FileInputStream input = new FileInputStream(appartmentimgpath);
         Pane imagepane = new Pane();
         Image image = new Image(input);
         ImageView imageView = new ImageView(image);
         imageView.setFitHeight(100);
         imageView.setFitWidth(100);
         imagepane.getChildren().add(imageView);
           //Vbox1 for creating appartment property preview
                appartmentvbox.setPadding(new Insets(10));
                appartmentvbox.setSpacing(8);
                Label propname = new Label();
                Label proptype = new Label();
                Button aViewbtn = new Button("View");
                
                aViewbtn.setOnAction((eve) ->{
                Text address = new Text();
                Text bathrooms = new Text();
                Text bedrooms = new Text();
                Text city = new Text();
                Text postalcode = new Text();
                Text state = new Text();
                Text type = new Text();
                Text Monthly_rent = new Text();
                Text lease = new Text();
                System.out.println("View Button is clicked");
                
                 Label typeofproperty = new Label("Property type is: ");
                type.setText(p.gettype());
                type.setX(50); 
                type.setY(50); 
                
                Label addresslabel = new Label("Address: ");

                address.setText(p.getaddress());
                address.setX(50); 
                address.setY(65);
              
                 Label numofbathrooms = new Label("Number of bathrooms: ");

                bathrooms.setText(Integer.toString(p.getbathrooms()));
                bathrooms.setX(50); 
                bathrooms.setY(75);
                
                 Label numofbedrooms = new Label("Number of bedrooms: ");

                bedrooms.setText(Integer.toString(p.getbedrooms()));
                bedrooms.setX(50); 
                bedrooms.setY(90);
                
                Label citylabel = new Label("City is: ");

                city.setText(p.getcity());
                city.setX(50); 
                city.setY(105);
                
                Label postalcodelabel = new Label("Postal : ");

                postalcode.setText(Integer.toString(p.getpostalcode()));
                postalcode.setX(50); 
                postalcode.setY(120);
                
                 Label statelabel = new Label("State : ");

                state.setText(p.getstate());
                state.setX(50); 
                state.setY(135);
                
                Label rentlabel = new Label("Rent is: ");
                Monthly_rent.setText(Long.toString(( (Rental_Property)p ).getRent()));
                Monthly_rent.setX(50);
                Monthly_rent.setY(150);
                
                Label leaselabel = new Label("Lease is: ");
                lease.setText(Long.toString(( (Rental_Property)p ).getLease()));
                lease.setX(50);
                lease.setY(165);
                
                
                Button Gobackbtn = new Button("Go Back");
                
                //=============== On Back Button Click ======================
                Stage detailedview = new Stage();
                Pane pa = new Pane();
                Gobackbtn.setOnAction((ev) ->{ System.out.println("Gio back button is clicked"); detailedview.close();});
                pa.getChildren().addAll(type,  address, bathrooms, bedrooms, city,postalcode,state, Monthly_rent, lease, Gobackbtn);
                Scene scene6 = new Scene(pa, 300, 200); 
                detailedview.setScene(scene6);
                detailedview.show();  
                });
              
                Button aEditbtn = new Button("Edit");
                aEditbtn.setOnAction((events) ->{
                 System.out.println("Edit button is clicked");
                 Label add = new Label("Address");
                 TextField tadd = new TextField(p.getaddress());
                 Label bath = new Label("Num of bath: ");
                 TextField tbath = new TextField(Integer.toString(p.getbathrooms()));
                 Label bed = new Label("Num of bed: ");
                 TextField tbed = new TextField(Integer.toString(p.getbedrooms()));
                 Label cit = new Label("City: ");
                 TextField tcity = new TextField(p.getcity());
                 Label pcode = new Label("Postal Code");
                 TextField tpcode = new TextField(Integer.toString(p.getpostalcode()));
                 Label sta = new Label("State: ");
                 TextField tsta = new TextField(p.getstate());
                 Label rentlabel = new Label("Rent: ");
                 TextField arent = new TextField(Long.toString(( (Rental_Property)p ).getRent()));
                 Label leaselabel = new Label("Lease: ");
                 TextField alease =  new TextField(Long.toString(( (Rental_Property)p ).getLease()));
                 Button savebtn = new Button("Save");
                 savebtn.setOnAction((even) -> {
                     p.setaddress(tadd.getText());
                     p.setcity(tcity.getText());
                     p.setbath(tbath.getText());
                     p.setbed(tbed.getText());
                     p.setstate(tsta.getText());
                     p.setpostalcode(tpcode.getText());
                     ((Rental_Property)p).setrent(arent.getText());
                     ((Rental_Property)p).setlease(alease.getText());
                     System.out.println("Updated Object Successfully");
                     System.out.println("Save Button is Clicked"); 
                     stage8.close();
                });
                 //Vbox 2 for editing the property
                 VBox vbox2 = new VBox();
                 vbox2.setPadding(new Insets(10));
                 vbox2.setSpacing(8);
                 vbox2.getChildren().clear();
                 vbox2.getChildren().addAll(add, tadd, bath, tbath, bed, tbed, cit, tcity,pcode,tpcode,sta,tsta,rentlabel,arent,leaselabel, alease, savebtn); 
                 Scene scene8 = new Scene(vbox2, 900, 700);
                 stage8.setScene(scene8);
                 stage8.show();
                  });
                Button aDeletebtn = new Button("Delete");
                aDeletebtn.setOnAction((evnt) -> { 
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Are you sure? ");
                    alert.setContentText("I am deleting the property!");
                  Optional<ButtonType> result =   alert.showAndWait();
                  if(result.isPresent()){ 
                      Iterator<Property> value1 = s.iterator();
                       System.out.println("The length of arraylist before removing is: "+ s.size());
                      while(value1.hasNext()){
                            Property q =  value1.next(); 
                            if(p.equals(q)){
                                value1.remove();
                                stage6.close();
                                
                            }
                      }
                      System.out.println("Property Successfully Removed");
                      System.out.println("The length of arraylist after removing is: "+ s.size());
                  }
                });
                Label propertytype = new Label("Property Type is: ");
                Label Rent = new Label("Rent per month is: ");
                System.out.println(p.gettype());
                System.out.println(((Rental_Property)p).getRent());
                propname.setText(p.gettype());
                proptype.setText(Long.toString(( (Rental_Property)p ).getRent()));
                appartmentvbox.getChildren().addAll(imagepane, propertytype, propname, Rent, proptype, aViewbtn, aEditbtn, aDeletebtn);
                
             }
         }
         Mainvbox.getChildren().addAll(housevbox, appartmentvbox, condovbox);
         ScrollPane sc = new ScrollPane();
         sc.setContent(Mainvbox);
         sc.setPannable(true); 
         Scene Mainscene = new Scene(sc, 900, 700);
         Stage Mainstage = new Stage();
         Mainstage.setScene(Mainscene);
         Mainstage.show();
   }
    
    
    //This is the point where the image choosen by user is set to a static variable.
    //This static variable is referenced in the function
    public static void addimagehouse() throws IOException{
        System.out.println("I will add an image");
        Stage imagestage = new Stage();
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);   
        File selectedFile = fileChooser.showOpenDialog(imagestage);
            if (selectedFile != null) {
               String imagepath = selectedFile.getAbsoluteFile().toString();
                System.out.println("Some file selected");
                System.out.println(imagepath);
                houseimgpath1 = imagepath;
                System.out.println("I have changed house image path");
               }
           else { System.out.println("Some file not selected"); }
       }
    
    public static void addimageapp() throws IOException{
        System.out.println("I will add an image");
        Stage imagestage = new Stage();
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);   
        File selectedFile = fileChooser.showOpenDialog(imagestage);
            if (selectedFile != null) {
               String imagepath = selectedFile.getAbsoluteFile().toString();
                System.out.println("Some file selected");
                System.out.println(imagepath);
                appartmentimgpath1 = imagepath;
               
               }
           else { System.out.println("Some file not selected"); }
       }
    
      public static void addimagecondo() throws IOException{
         System.out.println("I will add an image");
         Stage imagestage = new Stage();
         FileChooser fileChooser = new FileChooser();
         configureFileChooser(fileChooser);   
         File selectedFile = fileChooser.showOpenDialog(imagestage);
            if (selectedFile != null) {
               String imagepath = selectedFile.getAbsoluteFile().toString();
                System.out.println("Some file selected");
                System.out.println(imagepath);
                condominiumimgpath1 = imagepath;
               
               }
           else { System.out.println("Some file not selected"); }
       }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch(args);
    }
     private static void configureFileChooser(final FileChooser fileChooser){
         fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
     }          
}