package com.example.baitapnhom.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.baitapnhom.entity.Book;
import com.example.baitapnhom.entity.Borrow;
import com.example.baitapnhom.entity.User;
import com.example.baitapnhom.repository.BookRepository;
import com.example.baitapnhom.repository.BorrowRepository;
import com.example.baitapnhom.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowService {
    private final BorrowRepository borrowRepo;
    private final BookRepository bookRepo;
    private final UserRepository userRepo;

    public void borrowBook(String username, Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        User user = userRepo.findById(username).orElseThrow();

        Borrow borrow = new Borrow(null, user, book, LocalDateTime.now(), null);
        borrowRepo.save(borrow);
        book.setAvailable(false);
        bookRepo.save(book);
    }

    public List<Borrow> getBorrowsByUsername(String username) {
        return borrowRepo.findByUser_Username(username);
    }

    public void returnBook(Long borrowId) {
        Optional<Borrow> optional = borrowRepo.findById(borrowId);
        if (optional.isPresent()) {
            Borrow borrow = optional.get();
            if (borrow.getReturnTime() == null) {
                borrow.setReturnTime(LocalDateTime.now());
                borrowRepo.save(borrow);
            }
        }
    }

    public List<Borrow> getAllBorrows() {
        return borrowRepo.findAll();
    }

}
