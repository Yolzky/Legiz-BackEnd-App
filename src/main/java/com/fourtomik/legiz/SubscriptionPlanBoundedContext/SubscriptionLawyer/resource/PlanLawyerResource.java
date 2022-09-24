package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.resource;

import java.time.LocalDate;

public class PlanLawyerResource {
    private Long id;

    private String description;

    private String duration;

    private Long cost;

    private Long idLawyer;

    private String nameLawyer;

    private String surnameLawyer;

    private String emailLawyer;

    private String passwordLawyer;

    private Long DNILawyer;

    private LocalDate date_BirthdayLawyer;

    public PlanLawyerResource() {
    }

    public PlanLawyerResource(Long id, String description, String duration, Long cost) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public PlanLawyerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlanLawyerResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public PlanLawyerResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public PlanLawyerResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public Long getIdLawyer() {
        return idLawyer;
    }

    public PlanLawyerResource setIdLawyer(Long idLawyer) {
        this.idLawyer = idLawyer;
        return this;
    }

    public String getNameLawyer() {
        return nameLawyer;
    }

    public PlanLawyerResource setNameLawyer(String nameLawyer) {
        this.nameLawyer = nameLawyer;
        return this;
    }

    public String getSurnameLawyer() {
        return surnameLawyer;
    }

    public PlanLawyerResource setSurnameLawyer(String surnameLawyer) {
        this.surnameLawyer = surnameLawyer;
        return this;
    }

    public String getEmailLawyer() {
        return emailLawyer;
    }

    public PlanLawyerResource setEmailLawyer(String emailLawyer) {
        this.emailLawyer = emailLawyer;
        return this;
    }

    public String getPasswordLawyer() {
        return passwordLawyer;
    }

    public PlanLawyerResource setPasswordLawyer(String passwordLawyer) {
        this.passwordLawyer = passwordLawyer;
        return this;
    }

    public Long getDNILawyer() {
        return DNILawyer;
    }

    public PlanLawyerResource setDNILawyer(Long DNILawyer) {
        this.DNILawyer = DNILawyer;
        return this;
    }

    public LocalDate getDate_BirthdayLawyer() {
        return date_BirthdayLawyer;
    }

    public PlanLawyerResource setDate_BirthdayLawyer(LocalDate date_BirthdayLawyer) {
        this.date_BirthdayLawyer = date_BirthdayLawyer;
        return this;
    }
}
