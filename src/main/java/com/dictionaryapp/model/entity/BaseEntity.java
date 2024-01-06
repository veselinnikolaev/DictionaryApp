package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
