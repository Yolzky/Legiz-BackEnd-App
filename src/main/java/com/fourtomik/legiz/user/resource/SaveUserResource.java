package com.fourtomik.legiz.user.resource;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class SaveUserResource {

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

    public SaveUserResource() {
        super();
    }

    public SaveUserResource(String name, String surname, String email, String password, Long DNI, LocalDate date_Birthday) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.DNI = DNI;
        this.date_Birthday = date_Birthday;
    }

    public String getName() {
        return name;
    }

    public SaveUserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public SaveUserResource setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveUserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getDNI() {
        return DNI;
    }

    public SaveUserResource setDNI(Long DNI) {
        this.DNI = DNI;
        return this;
    }

    public LocalDate getDate_Birthday() {
        return date_Birthday;
    }

    public SaveUserResource setDate_Birthday(LocalDate date_Birthday) {
        this.date_Birthday = date_Birthday;
        return this;
    }
}
