package com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.resource;

import java.time.LocalDate;

public class ContratLegalResource {
    private Long id;

    private String description;

    private Long cost;

    private LocalDate start_Date;

    private LocalDate end_Date;

    private Long idClient;

    private String nameClient;

    private String surnameClient;

    private String emailClient;

    private String passwordClient;

    private Long DNIClient;

    private LocalDate date_BirthdayClient;

    private String civil_StatusClient;

    private Long idLawyer;

    private String nameLawyer;

    private String surnameLawyer;

    private String emailLawyer;

    private String passwordLawyer;

    private Long DNILawyer;

    private LocalDate date_BirthdayLawyer;

    public ContratLegalResource() {
    }

    public ContratLegalResource(Long id, String description, Long cost, LocalDate start_Date, LocalDate end_Date) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
    }

    public Long getId() {
        return id;
    }

    public ContratLegalResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ContratLegalResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public ContratLegalResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public LocalDate getStart_Date() {
        return start_Date;
    }

    public ContratLegalResource setStart_Date(LocalDate start_Date) {
        this.start_Date = start_Date;
        return this;
    }

    public LocalDate getEnd_Date() {
        return end_Date;
    }

    public ContratLegalResource setEnd_Date(LocalDate end_Date) {
        this.end_Date = end_Date;
        return this;
    }

    public Long getIdClient() {
        return idClient;
    }

    public ContratLegalResource setIdClient(Long idClient) {
        this.idClient = idClient;
        return this;
    }

    public String getNameClient() {
        return nameClient;
    }

    public ContratLegalResource setNameClient(String nameClient) {
        this.nameClient = nameClient;
        return this;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public ContratLegalResource setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
        return this;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public ContratLegalResource setEmailClient(String emailClient) {
        this.emailClient = emailClient;
        return this;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public ContratLegalResource setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
        return this;
    }

    public Long getDNIClient() {
        return DNIClient;
    }

    public ContratLegalResource setDNIClient(Long DNIClient) {
        this.DNIClient = DNIClient;
        return this;
    }

    public LocalDate getDate_BirthdayClient() {
        return date_BirthdayClient;
    }

    public ContratLegalResource setDate_BirthdayClient(LocalDate date_BirthdayClient) {
        this.date_BirthdayClient = date_BirthdayClient;
        return this;
    }

    public String getCivil_StatusClient() {
        return civil_StatusClient;
    }

    public ContratLegalResource setCivil_StatusClient(String civil_StatusClient) {
        this.civil_StatusClient = civil_StatusClient;
        return this;
    }

    public Long getIdLawyer() {
        return idLawyer;
    }

    public ContratLegalResource setIdLawyer(Long idLawyer) {
        this.idLawyer = idLawyer;
        return this;
    }

    public String getNameLawyer() {
        return nameLawyer;
    }

    public ContratLegalResource setNameLawyer(String nameLawyer) {
        this.nameLawyer = nameLawyer;
        return this;
    }

    public String getSurnameLawyer() {
        return surnameLawyer;
    }

    public ContratLegalResource setSurnameLawyer(String surnameLawyer) {
        this.surnameLawyer = surnameLawyer;
        return this;
    }

    public String getEmailLawyer() {
        return emailLawyer;
    }

    public ContratLegalResource setEmailLawyer(String emailLawyer) {
        this.emailLawyer = emailLawyer;
        return this;
    }

    public String getPasswordLawyer() {
        return passwordLawyer;
    }

    public ContratLegalResource setPasswordLawyer(String passwordLawyer) {
        this.passwordLawyer = passwordLawyer;
        return this;
    }

    public Long getDNILawyer() {
        return DNILawyer;
    }

    public ContratLegalResource setDNILawyer(Long DNILawyer) {
        this.DNILawyer = DNILawyer;
        return this;
    }

    public LocalDate getDate_BirthdayLawyer() {
        return date_BirthdayLawyer;
    }

    public ContratLegalResource setDate_BirthdayLawyer(LocalDate date_BirthdayLawyer) {
        this.date_BirthdayLawyer = date_BirthdayLawyer;
        return this;
    }
}
