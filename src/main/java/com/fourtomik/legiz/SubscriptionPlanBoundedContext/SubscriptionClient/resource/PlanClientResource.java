package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.resource;

import java.time.LocalDate;

public class PlanClientResource {

    private Long id;

    private String description;

    private String duration;

    private Long cost;

    private Long idClient;

    private String nameClient;

    private String surnameClient;

    private String emailClient;

    private String passwordClient;

    private Long DNIClient;

    private LocalDate date_BirthdayClient;

    private String civil_StatusClient;

    public PlanClientResource() {
    }

    public PlanClientResource(Long id, String description, String duration, Long cost) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public PlanClientResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlanClientResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public PlanClientResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public PlanClientResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public String getNameClient() {
        return nameClient;
    }

    public PlanClientResource setNameClient(String nameClient) {
        this.nameClient = nameClient;
        return this;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public PlanClientResource setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
        return this;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public PlanClientResource setEmailClient(String emailClient) {
        this.emailClient = emailClient;
        return this;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public PlanClientResource setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
        return this;
    }

    public Long getDNIClient() {
        return DNIClient;
    }

    public PlanClientResource setDNIClient(Long DNIClient) {
        this.DNIClient = DNIClient;
        return this;
    }

    public LocalDate getDate_BirthdayClient() {
        return date_BirthdayClient;
    }

    public PlanClientResource setDate_BirthdayClient(LocalDate date_BirthdayClient) {
        this.date_BirthdayClient = date_BirthdayClient;
        return this;
    }

    public String getCivil_StatusClient() {
        return civil_StatusClient;
    }

    public PlanClientResource setCivil_StatusClient(String civil_StatusClient) {
        this.civil_StatusClient = civil_StatusClient;
        return this;
    }

    public Long getIdClient() {
        return idClient;
    }

    public PlanClientResource setIdClient(Long idClient) {
        this.idClient = idClient;
        return this;
    }
}
