package com.springbootmvc.service.impl;

import com.springbootmvc.entity.BookEntity;
import com.springbootmvc.repository.BookRepository;
import com.springbootmvc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public void save(BookEntity book) {
        repository.save(book);
    }

    @Override
    public List<BookEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public BookEntity getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
