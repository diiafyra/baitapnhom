package com.example.baitapnhom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baitapnhom.entity.Book;
import com.example.baitapnhom.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public List<Book> getBooksByCategory(String category) {
        return bookRepo.findByCategory(category);
    }
    
    public Book getById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
    
}
