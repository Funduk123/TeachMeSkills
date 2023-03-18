package com.tms.lecture_43.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name = "BookEntity.updateBook", query = "update BookEntity as b set b.description = :des where b.id = :id")
})
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Integer pages;

    @OneToMany
    private List<AuthorEntity> authors;

}
