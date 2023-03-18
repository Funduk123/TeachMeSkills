package com.tms.one_to_one.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

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

    @Column(name = "myCity")
    private String city;

    @Column(name = "myStreet")
    private String street;

    private String password;

    @Column(length = 500)
    private String aboutMe;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user")
    private Phone phone;

}
