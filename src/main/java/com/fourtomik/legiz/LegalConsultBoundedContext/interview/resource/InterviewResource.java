package com.fourtomik.legiz.LegalConsultBoundedContext.interview.resource;

import java.time.LocalDate;

public class InterviewResource {
    private Long id;

    private LocalDate date_Interview;

    private String hour;

    private String url;

    public InterviewResource() {
    }

    public InterviewResource(Long id, LocalDate date_Interview, String hour, String url) {
        this.id = id;
        this.date_Interview = date_Interview;
        this.hour = hour;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public InterviewResource setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate_Interview() {
        return date_Interview;
    }

    public InterviewResource setDate_Interview(LocalDate date_Interview) {
        this.date_Interview = date_Interview;
        return this;
    }

    public String getHour() {
        return hour;
    }

    public InterviewResource setHour(String hour) {
        this.hour = hour;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public InterviewResource setUrl(String url) {
        this.url = url;
        return this;
    }
}
