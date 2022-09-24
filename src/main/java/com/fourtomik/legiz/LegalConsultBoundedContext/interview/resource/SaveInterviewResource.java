package com.fourtomik.legiz.LegalConsultBoundedContext.interview.resource;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SaveInterviewResource {
    @DateTimeFormat
    private LocalDate date_Interview;

    private String hour;

    private String url;

    public SaveInterviewResource() {
    }

    public SaveInterviewResource(LocalDate date_Interview, String hour, String url) {
        this.date_Interview = date_Interview;
        this.hour = hour;
        this.url = url;
    }

    public LocalDate getDate_Interview() {
        return date_Interview;
    }

    public SaveInterviewResource setDate_Interview(LocalDate date_Interview) {
        this.date_Interview = date_Interview;
        return this;
    }

    public String getHour() {
        return hour;
    }

    public SaveInterviewResource setHour(String hour) {
        this.hour = hour;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SaveInterviewResource setUrl(String url) {
        this.url = url;
        return this;
    }
}
