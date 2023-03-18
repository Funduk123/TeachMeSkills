package com.tms.lecture_43.web;

import com.tms.lecture_43.model.BookEntity;
import com.tms.lecture_43.model.BookProjection;
import com.tms.lecture_43.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookResource {

    private final BookService service;

    @GetMapping("/page/{page}/{size}")
    public Page<BookEntity> getAll(@PathVariable(name = "page", required = false) Integer page, @PathVariable(name = "size", required = false) Integer size) {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public BookEntity getById(@PathVariable(name = "id") Integer id) {
        return service.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<BookEntity> getByName(
            @PathVariable(name = "name") String name) {
        return service.getByName(name);
    }

    @PostMapping
    public BookEntity save(@RequestBody BookEntity book) {
        return service.save(book);
    }

    @GetMapping("/search")
    public List<BookEntity> getByNameAndDescription(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "pages", required = false) Integer pages) {
        return service.getByNameAndDescription(name, description, pages);
    }

    @GetMapping("/pages/{from}/{to}")
    public List<BookEntity> getByPages(
            @PathVariable(name = "from") Integer from,
            @PathVariable(name = "to") Integer to) {
        return service.getByPages(from, to);
    }

    @DeleteMapping("/{id}")
    public BookEntity deleteById(
            @PathVariable(name = "id") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public BookEntity update(
            @PathVariable(name = "id") String id,
            @RequestBody BookEntity book) {
        book.setId(Integer.parseInt(id));
        return service.update(book);
    }

    @PutMapping("/update/{id}")
    public void simpleUpdate(
            @PathVariable(name = "id") Integer id,
            @RequestParam(name = "des") String description) {
        service.simpleUpdate(id, description);
    }

    @GetMapping("/all-pages")
    public List<BookProjection> getAllForPages() {
        return service.getAllByPages();
    }

}
