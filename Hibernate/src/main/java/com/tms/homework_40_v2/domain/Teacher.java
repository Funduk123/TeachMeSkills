package com.tms.homework_40_v2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String secondName;

    @Embedded
    private Address address;

    @Temporal(TemporalType.TIME)
    private Date beginLesson;

    private boolean practice;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    @Enumerated(EnumType.STRING)
    private Role role;

}
