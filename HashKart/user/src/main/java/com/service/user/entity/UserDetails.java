package com.service.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "users_details")
public class UserDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Column (name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Column (name = "email", nullable = false, unique = true, length = 30)
    private String email;
    @Column (name = "phone_number", length = 15)
    private String phoneNumber;
    @Column (name = "street", length = 30)
    private String street;
    @Column (name = "street_number", length = 10)
    private String streetNumber;
    @Column (name = "zip_code", length = 6)
    private String zipCode;
    @Column (name = "locality", length = 30)
    private String locality;
    @Column (name = "country", length = 30)
    private String country;

    @OneToOne(mappedBy = "userDetails")
	@JsonIgnore 
    private User user;
}
