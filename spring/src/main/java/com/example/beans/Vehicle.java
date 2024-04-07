package com.example.beans;

import org.springframework.stereotype.Component;

import com.example.models.Song;

import jakarta.annotation.PreDestroy;

// streoType annotation is Component
@Component
public class Vehicle{
     private String name;

     public void setName (String name){
          this.name = name;
     }

     public String getName(){
          return this.name;
     }

     public String hello(){
          return "Hello this is from vehicle class";
     }

     // Uncomment if needed I am demonestrating Aspect 

     // public void playSong(Song song, boolean started){
     //      // Remaining logic is not core like logging and if else condition checks
     //      // What code or logic we want the Spring to execute when u call a particular method
     //      // is called Aspect
     //      // When teh spring meed to execute the given Aspect for example is it before or after 
     //      // the method call. This called Advice
     //      // Which method inside App that framework needs to intercept and execute the given Aspect
     //      // This is called pointcut
     //      long startTime = System.nanoTime();
     //      if(started){
     //           song.playSong(); // This is core logic of the playSong method
     //      } else{
     //           System.out.println("Couldn't play song as vehicle is not started yet!");
     //      }

     //      // End measuring execution time
     //      long endTime = System.nanoTime();

     //      // Calculate the execution time in milliseconds
     //      long executionTime = (endTime - startTime) / 1000000;
     //      System.out.println("Total execution time: " + executionTime + "ms");
     // }

     
     public void playSong(Song song, boolean started){
          // Remaining logic is not core like logging and if else condition checks
          // What code or logic we want the Spring to execute when u call a particular method
          // is called Aspect
          // When teh spring meed to execute the given Aspect for example is it before or after 
          // the method call. This called Advice
          // Which method inside App that framework needs to intercept and execute the given Aspect
          // This is called pointcut
          // long startTime = System.nanoTime();
          // if(started){
          //       // This is core logic of the playSong method
          // } else{
          //      System.out.println("Couldn't play song as vehicle is not started yet!");
          // }

          // // End measuring execution time
          // long endTime = System.nanoTime();

          // // Calculate the execution time in milliseconds
          // long executionTime = (endTime - startTime) / 1000000;
          // System.out.println("Total execution time: " + executionTime + "ms");

          song.playSong();;
     }


     /*
      * Spring ioc creates bean for component class and we don't have access for the members and its' svalues during creation. But if
      we want to create the bean and give some inscrtuctions post the @PostConstruct is used
     */
    @jakarta.annotation.PostConstruct
    public void initialize(){
     this.name = "springAudi";
    }

    /*
     * PreDestroy annotation is used to make sure spring will make the call to this method
     * just before clearing and destroying the context
     * scenarios IO resources, databases
     */
    @PreDestroy
    public void destroy(){
     System.out.println("Destoy is called!");
    }
}