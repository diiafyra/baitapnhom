package com.example.baitapnhom.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.baitapnhom.service.BorrowService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BorrowApiController {
    private final BorrowService borrowService;

    @PostMapping("/books/borrow/{id}")
    public String borrow(@PathVariable Long id, Principal principal) {
        borrowService.borrowBook(principal.getName(), id);
        return "redirect:/books";
    }

    @PostMapping("/books/return/{id}")
    public String returnBook(@PathVariable Long id) {
        borrowService.returnBook(id);
        return "redirect:/books";
    }

}
