package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Person {
     private String pname;

     /*
      * auto wires the beans that is injecting objects at runtime
      @Autowired(required=false) n case not mandatory

      Autowired can be applied over setter method also

      Autowired can be used over constructor also

      How iwll spring know which bean to autowire?

      1. First it will go with the type
      2. If multiple Beans of same type then by parameter name
      public Person(Vehicle vehicle)
      3. If parameter name matches then searches for Primary Bean for that type
      public Person(Vehicle xyz ) & vehicle is primary then go by primary
      4. Then goes for Qualifier annotation which checks for maytching bean name
      public Person(@Qualifier("vehicle2") Vehicle vehicle)
      */
     @Autowired // Using this approach we can do it for final objects even
     private Vehicle vehicle;

     public void setPname(String pname){
          this.pname = pname;
     } 

     public String getPname(){
          return this.pname ;
     } 
     
     public void setVehicle(Vehicle vehicle){
          this.vehicle = vehicle;
     }

     public Vehicle getVehicle(){
          return this.vehicle ;
     }
}
