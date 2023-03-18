package com.springbootmvc.web;

import com.springbootmvc.entity.BookEntity;
import com.springbootmvc.repository.BookRepository;
import com.springbootmvc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bookStore")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;
    private final BookRepository repository;

    @GetMapping
    public ModelAndView bookStore(@ModelAttribute(name = "newBook") BookEntity book) {
        var allBooks = service.getAll();
        ModelAndView modelAndView = new ModelAndView("bookStore.html");
        modelAndView.addObject("allBooks", allBooks);
        return modelAndView;
    }

    @PostMapping
    public String save(BookEntity book) {
        service.save(book);
        return "redirect:/bookStore";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        service.deleteById(id);
        return "redirect:/bookStore";
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable(name = "id") Integer id) {
        var bookFromDb = service.getById(id);
        ModelAndView modelAndView = new ModelAndView("update.html");
        modelAndView.addObject("book", bookFromDb);
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") Integer id, BookEntity book) {
        service.save(book);
        return "redirect:/bookStore";
    }

}
