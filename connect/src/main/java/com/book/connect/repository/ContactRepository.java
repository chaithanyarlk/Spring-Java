package com.book.connect.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

import com.book.connect.model.Contact;
import com.book.connect.rommappers.ContactRowMapper;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */

// @Repository
// public class ContactRepository {
     
//      private final JdbcTemplate jdbcTemplate;
//      // spring jdbc template

//      @Autowired
//      public ContactRepository(JdbcTemplate jdbcTemplate){
//           this.jdbcTemplate = jdbcTemplate;
//      }


//      public int insertContact(Contact contact){
//           String sqlString = "INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,\" +\r\n" + //
//                               "                \"CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
//           return jdbcTemplate.update(sqlString,contact.getName(),contact.getMobileNum(),
//           contact.getEmail(),contact.getSubject(),contact.getMessage(),
//           contact.getCreatedAt(),contact.getCreatedBy());
          
//      }

//      @SuppressWarnings("deprecation")
//      public List<Contact> findMsgsWithStatus(String status) {
//         String sql = "SELECT * FROM CONTACT_MSG WHERE STATUS = ?";
//         return jdbcTemplate.queryForList(sql, new Object[]{status},Contact.class);
//     }

//     public int updateMsgStatus(int contactId, String status,String updatedBy) {
//      String sql = "UPDATE CONTACT_MSG SET STATUS = ?, UPDATED_BY = ?,UPDATED_AT =? WHERE CONTACT_ID = ?";
//      return jdbcTemplate.update(sql, status, updatedBy, Timestamp.valueOf(LocalDateTime.now()),contactId);
//  }

// }

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    // Derieved Query Methods
    List<Contact> findByStatus(String status);

}
