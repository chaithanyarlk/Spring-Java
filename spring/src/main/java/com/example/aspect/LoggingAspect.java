package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.models.Song;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

     // Order annotation will be useful when more than one aspects are present which to execute first

    @Before("execution(* com.example.beans.Vehicle.hello())")
    public void beforeStartMethodExecution() {
        System.out.println("Before starting the vehicle");
    }

    @AfterReturning("execution(* com.example.beans.Vehicle.hello())")
    public void aftertMethodExecution() {
        System.out.println("After starting the vehicle");
    }

    @Around("execution(* com.example.beans.Vehicle.playSong(*,*)) && args(*,sta1rted,..)")
    public void log(ProceedingJoinPoint joinPoint, boolean started) throws Throwable{
     // && args(*,started) --> arguments can also be mentioned and doesn't matter the order or name it will do matching operation
     // The named ones must be written in the function with respective places and data types
     long startTime = System.nanoTime();
     System.out.println(started);
     System.out.println("BEFORE POINTCUT EXECUTION!");
     
     System.out.println(joinPoint.getArgs().toString());

     Object[] args = joinPoint.getArgs();

     for (Object arg : args) {
          System.out.println("Argument: " + arg);
     }

     Song s = (Song) args[0];


     boolean shouldIplay = (boolean) args[1];

     s.playSong();

     System.out.println("This from advice");

     System.out.println("Above are arguments");

     if(shouldIplay){
          joinPoint.proceed();
     }else{
          System.out.println("Sorry not proceeding!");
     }

     // End measuring execution time
     long endTime = System.nanoTime();

     // Calculate the execution time in milliseconds
     long executionTime = (endTime - startTime) / 1000000;
     System.out.println("Total execution time: " + executionTime + "ms");
    }
}
