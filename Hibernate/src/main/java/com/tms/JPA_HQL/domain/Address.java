package com.tms.JPA_HQL.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "myCity")
    private String city;

    @Column(name = "myStreet")
    private String street;

}
