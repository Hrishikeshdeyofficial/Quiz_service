package com.ff.quizservice.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private int id;
    private String quizCategory;
    @ElementCollection
    private List<Long> questions;

}
