package com.tms.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "persons")
public class UserEntity {

    @Id
    private Integer id;  // Primary key

    @Column(name = "username")
    private String login;

    private String password;

}
