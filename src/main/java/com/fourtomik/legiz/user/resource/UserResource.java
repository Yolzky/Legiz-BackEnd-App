package com.fourtomik.legiz.user.resource;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserResource {
    private Long id;

    @Size(max = 30)
    private String name;

    @Size(max = 30)
    private String surname;

    @Column(unique = true)
    @Size(max = 50)
    private String email;

    @Size(max = 30)
    private String password;

    @Column(unique = true)
    private Long DNI;

    @DateTimeFormat
    private LocalDate date_Birthday;

    public UserResource() {
        super();
    }

    public UserResource(Long id, String name, String surname, String email, String password, Long DNI, LocalDate date_Birthday) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.DNI = DNI;
        this.date_Birthday = date_Birthday;
    }

    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserResource setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getDNI() {
        return DNI;
    }

    public UserResource setDNI(Long DNI) {
        this.DNI = DNI;
        return this;
    }

    public LocalDate getDate_Birthday() {
        return date_Birthday;
    }

    public UserResource setDate_Birthday(LocalDate date_Birthday) {
        this.date_Birthday = date_Birthday;
        return this;
    }
}
