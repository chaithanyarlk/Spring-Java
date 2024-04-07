package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.ProjectConfig;
import com.example.models.Song;
import com.example.beans.Person;
import com.example.beans.Vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hello world5!");

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*
         * Sometmes we want to create a new instance of an object and add them into Spring context based on programming condition
         */
        var vehicleAudi = new Vehicle();
        vehicleAudi.setName("Audi1");

        context.registerBean("AduiBean",Vehicle.class,()-> vehicleAudi);

        

        var vehicleBeanAudi = context.getBean("AduiBean",Vehicle.class);
        System.out.println(vehicleBeanAudi.getName());

        var vehicle = context.getBean("vehicle",Vehicle.class);
        System.out.println(vehicle.getName());

        var vehicle2 = context.getBean("vehicle",Vehicle.class);
        System.out.println(vehicle.getName());

        if(vehicle == vehicle2){
            /*
             * In general spring treats scope of bean as singleton so the object will be the same
             * Problem with Singleton is race condition
             * example threads accessing same object updation
             * 
             * Eager Instantiation --> create all singleton beans at start of application
             * Lazy Instantiation --> when application refer to bean then create --> @Lazy
             * 
             * @Scope(BeanDefinition.SCOPE_PROTOTYPE) --> this will create new object for each call
             */
            System.out.println("SAME!");
        }

        vehicle = context.getBean("vehicle1",Vehicle.class);
        System.out.println(vehicle.getName());

        vehicle = context.getBean("ferrari",Vehicle.class);
        System.out.println(vehicle.getName());

        vehicle = context.getBean(Vehicle.class);
        System.out.println("Primary "+vehicle.getName());
        System.out.println(vehicle.hello());

        var hello = context.getBean(String.class);
        System.out.println(hello);


        var person = context.getBean("person1",Person.class);
        System.out.println(person.getPname());
        System.out.println(person.getVehicle().getName());

        person = context.getBean("person2",Person.class);
        System.out.println(person.getPname());
        System.out.println(person.getVehicle().getName());


        Song song = new Song();
        song.setArtist("Abc");
        song.setSongName("abc");
        vehicle.playSong(song, true);

        context.close();
    }
}