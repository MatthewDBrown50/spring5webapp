package com.codnamebear.spring5webapp.controllers;

import com.codnamebear.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    // Pull in the current list of books
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){ // Pull in the model

        // Assign the current list of books to the model's "books" attribute
        model.addAttribute("books", bookRepository.findAll());

        // Return the name of the associated attribute
        return "books";
    }
}
