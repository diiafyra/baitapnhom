package com.example.baitapnhom.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.baitapnhom.entity.Book;
import com.example.baitapnhom.service.BookService;
import com.example.baitapnhom.service.BorrowService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookWebController {
    private final BookService bookService;
    private final BorrowService borrowService;

    @GetMapping("/books")
    public String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println("Người dùng hiện tại: " + username);
        System.out.println("Quyền (role): " + auth.getAuthorities());

        model.addAttribute("books", bookService.getAllBooks());

        model.addAttribute("borrows", borrowService.getBorrowsByUsername(username));

        return "books";
    }


    @GetMapping("/books/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/books/save")
    public String save(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "book-form";
    }

    @GetMapping("/books/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}

