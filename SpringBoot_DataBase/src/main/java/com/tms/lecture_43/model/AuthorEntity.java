package com.tms.lecture_43.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;


}
