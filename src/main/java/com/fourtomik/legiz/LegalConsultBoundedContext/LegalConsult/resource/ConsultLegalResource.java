package com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.resource;

import java.time.LocalDate;

public class ConsultLegalResource {
    private Long id;

    private String document;

    private String comentary;

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

    public ConsultLegalResource() {
    }

    public ConsultLegalResource(Long id, String document, String comentary) {
        this.id = id;
        this.document = document;
        this.comentary = comentary;
    }

    public Long getId() {
        return id;
    }

    public ConsultLegalResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public ConsultLegalResource setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getComentary() {
        return comentary;
    }

    public ConsultLegalResource setComentary(String comentary) {
        this.comentary = comentary;
        return this;
    }

    public Long getIdClient() {
        return idClient;
    }

    public ConsultLegalResource setIdClient(Long idClient) {
        this.idClient = idClient;
        return this;
    }

    public String getNameClient() {
        return nameClient;
    }

    public ConsultLegalResource setNameClient(String nameClient) {
        this.nameClient = nameClient;
        return this;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public ConsultLegalResource setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
        return this;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public ConsultLegalResource setEmailClient(String emailClient) {
        this.emailClient = emailClient;
        return this;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public ConsultLegalResource setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
        return this;
    }

    public Long getDNIClient() {
        return DNIClient;
    }

    public ConsultLegalResource setDNIClient(Long DNIClient) {
        this.DNIClient = DNIClient;
        return this;
    }

    public LocalDate getDate_BirthdayClient() {
        return date_BirthdayClient;
    }

    public ConsultLegalResource setDate_BirthdayClient(LocalDate date_BirthdayClient) {
        this.date_BirthdayClient = date_BirthdayClient;
        return this;
    }

    public String getCivil_StatusClient() {
        return civil_StatusClient;
    }

    public ConsultLegalResource setCivil_StatusClient(String civil_StatusClient) {
        this.civil_StatusClient = civil_StatusClient;
        return this;
    }

    public Long getIdLawyer() {
        return idLawyer;
    }

    public ConsultLegalResource setIdLawyer(Long idLawyer) {
        this.idLawyer = idLawyer;
        return this;
    }

    public String getNameLawyer() {
        return nameLawyer;
    }

    public ConsultLegalResource setNameLawyer(String nameLawyer) {
        this.nameLawyer = nameLawyer;
        return this;
    }

    public String getSurnameLawyer() {
        return surnameLawyer;
    }

    public ConsultLegalResource setSurnameLawyer(String surnameLawyer) {
        this.surnameLawyer = surnameLawyer;
        return this;
    }

    public String getEmailLawyer() {
        return emailLawyer;
    }

    public ConsultLegalResource setEmailLawyer(String emailLawyer) {
        this.emailLawyer = emailLawyer;
        return this;
    }

    public String getPasswordLawyer() {
        return passwordLawyer;
    }

    public ConsultLegalResource setPasswordLawyer(String passwordLawyer) {
        this.passwordLawyer = passwordLawyer;
        return this;
    }

    public Long getDNILawyer() {
        return DNILawyer;
    }

    public ConsultLegalResource setDNILawyer(Long DNILawyer) {
        this.DNILawyer = DNILawyer;
        return this;
    }

    public LocalDate getDate_BirthdayLawyer() {
        return date_BirthdayLawyer;
    }

    public ConsultLegalResource setDate_BirthdayLawyer(LocalDate date_BirthdayLawyer) {
        this.date_BirthdayLawyer = date_BirthdayLawyer;
        return this;
    }
}
