package com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.resource;

public class SaveConsultLegalResource {
    private String document;

    private String comentary;

    public SaveConsultLegalResource() {
    }

    public SaveConsultLegalResource(String document, String comentary) {
        this.document = document;
        this.comentary = comentary;
    }

    public String getDocument() {
        return document;
    }

    public SaveConsultLegalResource setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getComentary() {
        return comentary;
    }

    public SaveConsultLegalResource setComentary(String comentary) {
        this.comentary = comentary;
        return this;
    }
}
