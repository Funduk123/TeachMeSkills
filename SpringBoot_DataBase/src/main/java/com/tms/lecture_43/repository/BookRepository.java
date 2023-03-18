package com.tms.lecture_43.repository;

import com.tms.lecture_43.model.BookEntity;
import com.tms.lecture_43.model.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {

    List<BookEntity> getByName(String name);

//    List<BookEntity> getByNameAndDescription(String name, String description,Integer pages);

    List<BookEntity> getByPagesBetween(Integer from, Integer to);

    @Modifying
    void updateBook(Integer id, @Param("des") String newDescription);

    List<BookProjection> getBy();

}
