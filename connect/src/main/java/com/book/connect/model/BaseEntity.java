package com.book.connect.model;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}

