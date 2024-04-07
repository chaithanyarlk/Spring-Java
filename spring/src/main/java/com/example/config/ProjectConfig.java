package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.ComponentScan;

import com.example.beans.Person;
import com.example.beans.Vehicle;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Configuration annotation will indicates that the class has the @Bean definition methods

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages ={"com.example.beans","com.example.aspect"})
public class ProjectConfig {

     @Bean
     Vehicle vehicle(){
          var vehicle =  new Vehicle();
          vehicle.setName("Audi");
          return vehicle;
     }

     @Primary
     @Bean
     Vehicle vehicle1(){
          var vehicle =  new Vehicle();
          vehicle.setName("Tata");
          return vehicle;
     }

     @Bean(value = "ferrari")
     Vehicle vehicl21(){
          var vehicle =  new Vehicle();
          vehicle.setName("ferrari");
          return vehicle;
     }

     @Bean
     String hello(){
          return "hello";
     }

     /* This is one of the way and not preferred way for wiring the object as any change is done
     in vehicle class need to change at all places
     */ 
    @Bean(value = "person1")
     Person person1(){
          Person person = new Person();

          person.setPname("person1");
          person.setVehicle(new Vehicle());
          return person;
     }

     /*
      * Method parameters wiring beans in which if the function is taking a paramter 
      of some class and a bean exists it will automatically inject it
      */

      @Bean(value = "person2")
     Person person2(Vehicle vehicle){
          Person person = new Person();

          person.setPname("person2");
          person.setVehicle(vehicle);
          return person;
     }

}