package com.example.baitapnhom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="books") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id 
    @GeneratedValue
    private Long id;

    private String title;
    private String category;
    private String author;    
    private boolean available;
}
