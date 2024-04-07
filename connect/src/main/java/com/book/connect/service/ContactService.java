package com.book.connect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.connect.model.Contact;
import com.book.connect.repository.ContactRepository;

import java.util.*;

import java.time.LocalDateTime;

/*
 * In a Spring application, service files are responsible for containing the business logic of your application. These classes encapsulate the behavior of your application and act as an intermediary between the controller (which handles incoming requests) and the repository (which handles data access).

Here are some key responsibilities of service files in Spring:

1. **Business Logic**: Service files implement the business logic of your application. They contain methods that perform operations such as data validation, data transformation, calculations, and any other business-specific rules.

2. **Transaction Management**: Service files often define transactional boundaries for operations that involve multiple database interactions. By annotating service methods with `@Transactional`, you can ensure that these methods are executed within a single transaction, allowing for consistency and atomicity.

3. **Encapsulation**: Service files help in encapsulating business logic, promoting modularity and maintainability in your application. By separating concerns, you can isolate changes related to business rules from changes related to the presentation layer or data access layer.

4. **Service Orchestration**: Service files coordinate interactions between different components of your application, such as controllers, repositories, and external services. They may invoke repository methods to fetch or manipulate data and orchestrate the flow of data and control within the application.

5. **Abstraction**: Service files provide an abstraction layer over lower-level components such as repositories or external APIs. This allows controllers to interact with services using a higher-level interface without needing to know the details of data access or external communication.

6. **Error Handling**: Service files may handle exceptions thrown during the execution of business logic. They can catch exceptions, perform error handling (e.g., logging, converting exceptions to meaningful error messages), and decide how to propagate or handle errors within the application.

Overall, service files play a crucial role in structuring your Spring application, separating concerns, and ensuring that business logic is centralized, reusable, and testable. They contribute to the maintainability, scalability, and robustness of your application architecture.
 */

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

     /**
      * Save Contact Details into DB
      * @param contact
      * @return boolean
      */
     public boolean saveMessageDetails(Contact contact){
         //TODO - Need to persist the data into the DB table
         System.out.println(contact.toString());
         boolean isSaved = false;
            contact.setStatus("open");
            contact.setCreatedBy("anonymous");
            contact.setCreatedAt(LocalDateTime.now());
            Contact savedContact = contactRepository.save(contact);
            if(null != savedContact && savedContact.getContactId()>0) {
                isSaved = true;
            }
         return isSaved;
     }

     public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus("OPEN");
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus("CLOSE");
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }
 
 }
