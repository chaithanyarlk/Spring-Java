package com.book.connect.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*
 * 
Lombok is a popular Java library that aims to reduce the amount of boilerplate code that developers need to write by providing annotations to generate common code automatically during compilation. Lombok helps to keep your codebase clean, concise, and easier to maintain.

Here are some key features of Lombok:

Annotation-Based: Lombok provides a set of annotations that you can use to automate the generation of getter/setter methods, constructors, toString(), equals(), hashCode(), and more.

Reduces Boilerplate Code: By using Lombok annotations, you can significantly reduce the amount of repetitive code that you would typically write by hand.

Compile-Time Processing: Lombok operates during the compilation phase of your Java project. It hooks into the compiler to generate bytecode with the requested functionality.

Integration with IDEs: Lombok integrates with popular Java IDEs like IntelliJ IDEA, Eclipse, and NetBeans. IDE plugins are available to provide support for Lombok annotations in your development environment, allowing you to see generated code and navigate to source code effectively.

Customization: Lombok provides various configuration options and annotations to customize the behavior of code generation, allowing you to tailor it to your specific needs.
*/


// @Entity annotation is used to mark a class as a JPA entity
// a JPA entity represents a data model object that is mapped to a database table

@Entity
@Data
@Table(name = "contact_msg")
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "contact_id")
    private int contactId;
     @NotBlank(message = "Name should not be blank")
     @Column(name = "name")
     private String name;
     @Column(name = "mobileNum")
     private String mobileNum;
     @Email(message = "Email is not vlaid!")
     @Column(name = "email")
     private String email;
     @Column(name = "subject")
     private String subject;
     @Column(name = "message")
     private String message;
     @Column(name = "status")
     private String status;
 
//      // Default Constructor
//      public Contact() {
//      }
 
//      // Getter and Setter methods
//      public String getName() {
//          return name;
//      }
 
//      public void setName(String name) {
//          this.name = name;
//      }
 
//      public String getMobileNum() {
//          return mobileNum;
//      }
 
//      public void setMobileNum(String mobileNum) {
//          this.mobileNum = mobileNum;
//      }
 
//      public String getEmail() {
//          return email;
//      }
 
//      public void setEmail(String email) {
//          this.email = email;
//      }
 
//      public String getSubject() {
//          return subject;
//      }
 
//      public void setSubject(String subject) {
//          this.subject = subject;
//      }
 
//      public String getMessage() {
//          return message;
//      }
 
//      public void setMessage(String message) {
//          this.message = message;
//      }

//      @Override
//     public String toString() {
//         return "Contact{" +
//                 "name='" + name + '\'' +
//                 ", mobileNum='" + mobileNum + '\'' +
//                 ", email='" + email + '\'' +
//                 ", subject='" + subject + '\'' +
//                 ", message='" + message + '\'' +
//                 '}';
//     }
 }
 
