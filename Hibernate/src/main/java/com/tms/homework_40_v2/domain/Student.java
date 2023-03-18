package com.tms.homework_40_v2.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String secondName;

    @ManyToMany(mappedBy = "students")
    @ToString.Exclude
    private List<Course> courses;

    @Enumerated(EnumType.STRING)
    private Role role;

}
