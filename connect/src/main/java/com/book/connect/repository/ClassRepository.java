package com.book.connect.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.connect.model.Classes;

@Repository
public interface ClassRepository extends JpaRepository<Classes, Integer> {

}
