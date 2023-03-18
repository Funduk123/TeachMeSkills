package com.tms.JPA_HQL.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "persons")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nickname;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "new_myCity")),
            @AttributeOverride(name = "street", column = @Column(name = "new_myStreet"))
    })
    private Address address;

    @Temporal(TemporalType.TIME)
    private Date birthday;

    @Column(name = "username")
    private String login;

    private String password;

    @Column(length = 500)
    private String aboutMe;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    @JoinTable(joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "tel_id "))
    private List<Phone> phones;

    @Transient // Не сохраняет в БД это поле
    private String test;

    @Version // Оптимистическая блокировка
    private Long version;

    private String description;

}
