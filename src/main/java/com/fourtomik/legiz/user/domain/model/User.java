package com.fourtomik.legiz.user.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 30)
    private String surname;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(max = 30)
    private String password;

    @NotNull
    private Long DNI;

    @DateTimeFormat
    private LocalDate date_Birthday;

    public User() {
        super();
    }

    public User(Long id, @NotNull String name, @NotNull String surname, @NotNull String email, @NotNull String password, @NotNull Long DNI, LocalDate date_Birthday) {
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

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getDNI() {
        return DNI;
    }

    public User setDNI(Long DNI) {
        this.DNI = DNI;
        return this;
    }

    public LocalDate getDate_Birthday() {
        return date_Birthday;
    }

    public User setDate_Birthday(LocalDate date_Birthday) {
        this.date_Birthday = date_Birthday;
        return this;
    }
}
