package com.tms.lecture_43.service.impl;

import com.tms.lecture_43.model.*;
import com.tms.lecture_43.repository.BookRepository;
import com.tms.lecture_43.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public Page<BookEntity> getAll(Integer page, Integer size) {

        if (page == null || page < 0 || size == null || size < 1) {
            return repository.findAll(PageRequest.of(0, 1000));
        }

        Sort.by(Sort.Direction.ASC, "pages");
        PageRequest pageRequest = PageRequest.of(page, size);

        return repository.findAll(pageRequest);
    }

    @Override
    public BookEntity getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<BookEntity> getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public List<BookEntity> getByNameAndDescription(String name, String description, Integer pages) {
        Specification<BookEntity> specification = createSpecification(name, description, pages);
        return repository.findAll(specification);
    }

    private static Specification<BookEntity> createSpecification(String name, String description, Integer pages) {
        return (root, query, builder) -> {

            List<Predicate> listCond = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                Predicate equalName = builder.equal(root.get(BookEntity_.NAME), name);
                listCond.add(equalName);
            }

            if (description != null && !description.isBlank()) {
                Predicate equalDescription = builder.equal(root.get(BookEntity_.DESCRIPTION), description);
                listCond.add(equalDescription);
            }

            if (pages != null) {
                Predicate equalPages = builder.equal(root.get(BookEntity_.PAGES), pages);
                listCond.add(equalPages);
            }

//            ListJoin<BookEntity, AuthorEntity> joinAuthor = root.join(BookEntity_.authors);
//            List<AuthorEntity> authors = book.getAuthors();
//            joinAuthor.get(AuthorEntity_.LAST_NAME);

            return builder.and(listCond.toArray(new Predicate[]{}));
        };
    }

    @Override
    public List<BookEntity> getByPages(Integer from, Integer to) {
        return repository.getByPagesBetween(from, to);
    }

    @Override
    public BookEntity save(BookEntity book) {
        return repository.save(book);
    }

    @Override
    public BookEntity delete(Integer id) {
        var bookFromDb = repository.findById(id).orElse(null);
        if (bookFromDb != null) {
            repository.delete(bookFromDb);
        }
        return bookFromDb;
    }

    @Override
    public List<BookProjection> getAllByPages() {
        return repository.getBy();
    }

    @Override
    @Transactional
    public BookEntity update(BookEntity book) {
        var bookFromDb = repository.findById(book.getId()).orElseThrow(RuntimeException::new);

        bookFromDb.setName(book.getName());
        bookFromDb.setDescription(book.getDescription());
        bookFromDb.setPages(book.getPages());

        return bookFromDb;
    }

    @Override
    @Transactional
    public void simpleUpdate(Integer id, String newDescription) {
        repository.updateBook(id, newDescription);
    }

}
