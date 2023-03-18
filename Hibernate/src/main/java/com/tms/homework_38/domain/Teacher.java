package com.tms.homework_38.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String firstName;

    private String secondName;

    @Embedded
    private Address address;

    @Temporal(TemporalType.TIME)
    private Date beginLesson;

    private boolean practice;

    @OneToOne(mappedBy = "teacher")
    private Course course;

    @Enumerated(EnumType.STRING)
    private Role role;

}
