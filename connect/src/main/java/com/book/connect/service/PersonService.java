package com.book.connect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.book.connect.model.Person;
import com.book.connect.model.Roles;
import com.book.connect.repository.PersonRepository;
import com.book.connect.repository.RolesRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName("student");
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
