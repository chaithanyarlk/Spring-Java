package com.book.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.book.connect.model.Contact;
import com.book.connect.service.ContactService;

import java.util.*;

import jakarta.validation.Valid;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {
     /*
      * In Spring Web applications, scopes define the lifecycle and visibility of beans managed by the Spring IoC (Inversion of Control) container. Each bean in a Spring application can have a different scope, allowing you to control how instances of that bean are created, managed, and destroyed.

Here are some of the common scopes available in Spring Web applications:

1. **Singleton Scope (`@Scope("singleton")`)**:
   - Default scope in Spring.
   - In a web application, a single instance of the bean is created for the entire application context.
   - The same instance is returned for every request for that bean within the application context.
   - Suitable for stateless beans that can be safely shared across multiple requests.

2. **Prototype Scope (`@Scope("prototype")`)**:
   - A new instance of the bean is created every time it is requested from the Spring container.
   - Each request for the bean results in a new object being created.
   - Suitable for stateful beans or beans that require a fresh instance for each request.

3. **Request Scope (`@Scope("request")`)**:
   - A new instance of the bean is created for each HTTP request.
   - The bean is available only within the scope of the current HTTP request.
   - Suitable for beans that hold data specific to a single HTTP request, such as form data or request parameters.

4. **Session Scope (`@Scope("session")`)**:
   - A single instance of the bean is created for each HTTP session.
   - The bean is available throughout the lifetime of the HTTP session.
   - Suitable for beans that need to maintain state across multiple requests within the same session, such as user authentication details or shopping cart items.

5. **Application Scope (`@Scope("application")`)**:
   - A single instance of the bean is created for the entire web application.
   - The bean is shared across all users and sessions of the application.
   - Suitable for beans that hold global application-level data, such as configuration settings or cached data.

6. **WebSocket Scope (`@Scope("websocket")`)**:
   - A single instance of the bean is created for each WebSocket connection.
   - The bean is available only within the scope of the WebSocket session.
   - Suitable for beans that maintain state specific to WebSocket connections, such as chat sessions or real-time data subscriptions.

These are the most commonly used scopes in Spring Web applications. By selecting the appropriate scope for your beans, you can effectively manage their lifecycle and ensure that they behave correctly within the context of your application.
      */

     private final ContactService contactService;

     @Autowired
     public ContactController(ContactService contactService){
          this.contactService = contactService;
     }
     
     @GetMapping("/contact")
     public String showBookDetails(Model model) {
          model.addAttribute("contact", new Contact());
          return "contact"; // Return the name of the HTML template
     }

     /*
      * In Spring MVC, ModelAndView is a class that combines both model data and view information and is used to pass data from a controller to a view. It allows controllers to provide data to the view layer and specify which view template should be rendered to display that data.

     Here's a brief explanation of how ModelAndView works:

     Model Data: The ModelAndView class has a Model object associated with it. The Model represents the data that needs to be passed to the view for rendering. Controllers can add attributes to the model, which will then be available to the view template.

     View Information: The ModelAndView class also contains information about which view template should be rendered to display the model data. This can be specified by providing the view name or a View object.
      */

     // @PostMapping(value = "/saveMsg")
     // public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,@RequestParam String email, @RequestParam String subject, @RequestParam String message){
     //      System.out.println("Name : " + name);
     //    System.out.println("Mobile Number : " + mobileNum);
     //    System.out.println("Email Address : " + email);
     //    System.out.println("Subject : " + subject);
     //    System.out.println("Message : " + message);

     //    return new ModelAndView("redirect:/contact");
     // }

     @PostMapping(value = "/saveMsg")
     public ModelAndView saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors error){
          if(error.hasErrors()){
               log.info("Errros!");
               log.info(error.toString());
          }
        log.info("Name : " + contact.getName());
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
     }

     @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }

   //  @GetMapping(value = "/closeMsg")
   //  public String closeMsg(@RequestParam int id, Authentication authentication) {
   //      contactService.updateMsgStatus(id,authentication.getName());
   //      return "redirect:/displayMessages";
   //  }
}
