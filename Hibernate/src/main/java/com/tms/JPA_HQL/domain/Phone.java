package com.tms.JPA_HQL.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

//    @OneToOne
//    @JoinColumn(name = "person_id")
    @ToString.Exclude
    @ManyToMany(mappedBy = "phones")
    private List<UserEntity> user;

}
