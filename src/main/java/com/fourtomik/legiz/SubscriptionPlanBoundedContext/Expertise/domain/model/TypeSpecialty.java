package com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.model;

import com.fourtomik.legiz.user.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "typespecialty")
public class TypeSpecialty extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    public TypeSpecialty() {
    }

    public TypeSpecialty(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public TypeSpecialty setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TypeSpecialty setName(String name) {
        this.name = name;
        return this;
    }
}
