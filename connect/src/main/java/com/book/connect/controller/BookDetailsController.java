package com.book.connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.connect.model.Book;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class BookDetailsController {
     /*
      * Annotation-Based Mapping: Controllers are annotated with @Controller or @RestController. 
      The @Controller annotation indicates that the class serves as a controller, 
      while @RestController is a specialized version primarily used for RESTful web services. 
      These annotations inform Spring that the class should be scanned for request mappings.
     */

     /*
      * Various Mapping annotations
        - @RequestMapping: This annotation is a generic annotation used to map web requests onto specific handler methods.
         It allows you to specify the HTTP method, 
        the URL pattern, and other parameters to map incoming requests to the appropriate method

        @RequestMapping(value = "/users/{id}", method = RequestMethod.GET) // example

        - @GetMapping: This annotation is a shortcut for @RequestMapping(method = RequestMethod.GET). It specifically maps GET requests to the annotated method

        - @PostMapping: Similar to @GetMapping, this annotation is a shortcut for @RequestMapping(method = RequestMethod.POST). It specifically maps POST requests to the annotated method.

        - @PutMapping: Similar to @GetMapping and @PostMapping, this annotation is a shortcut for @RequestMapping(method = RequestMethod.PUT). It specifically maps PUT requests to the annotated method.

        - @DeleteMapping: Similar to the previous annotations, this annotation is a shortcut for @RequestMapping(method = RequestMethod.DELETE). It specifically maps DELETE requests to the annotated method.
      */

     @GetMapping("/books/{id}")
     public String showBookDetails(Model model,@PathVariable String id) {
          // Logic to fetch book details by ID
          Book book = new Book();
          book.setId(1L);
          book.setTitle("Sample Book");
          book.setAuthor("John Doe");

          log.info(id);
          
          model.addAttribute("book", book);
          return "book-details"; // Return the name of the HTML template
     }


}
