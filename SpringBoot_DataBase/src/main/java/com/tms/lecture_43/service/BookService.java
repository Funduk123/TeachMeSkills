package com.tms.lecture_43.service;

import com.tms.lecture_43.model.BookEntity;
import com.tms.lecture_43.model.BookProjection;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    Page<BookEntity> getAll(Integer page, Integer size);

    BookEntity getById(Integer id);

    List<BookEntity> getByName(String name);

    BookEntity save(BookEntity book);

    List<BookEntity> getByNameAndDescription(String name, String description, Integer pages);

    List<BookEntity> getByPages(Integer from, Integer to);

    BookEntity update(BookEntity book);

    void simpleUpdate(Integer id, String description);

    BookEntity delete(Integer id);

    List<BookProjection> getAllByPages();
}