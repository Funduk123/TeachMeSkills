package com.springbootmvc.service;

import com.springbootmvc.entity.BookEntity;

import java.util.List;

public interface BookService {

    void save(BookEntity book);

    List<BookEntity> getAll();

    BookEntity getById(Integer id);

    void deleteById(Integer id);

}
