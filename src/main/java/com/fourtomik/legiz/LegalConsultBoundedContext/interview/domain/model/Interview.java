package com.fourtomik.legiz.LegalConsultBoundedContext.interview.domain.model;

import com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.domain.model.ConsultLegal;
import com.fourtomik.legiz.user.domain.model.AuditModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "interview")
public class Interview extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_consul_legal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ConsultLegal consultLegal;

    @DateTimeFormat
    private LocalDate date_Interview;

    private String hour;

    private String url;

    public Interview() {
    }

    public Interview(Long id, LocalDate date_Interview, String hour, String url) {
        this.id = id;
        this.date_Interview = date_Interview;
        this.hour = hour;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public Interview setId(Long id) {
        this.id = id;
        return this;
    }

    public ConsultLegal getConsultLegal() {
        return consultLegal;
    }

    public Interview setConsultLegal(ConsultLegal consultLegal) {
        this.consultLegal = consultLegal;
        return this;
    }

    public LocalDate getDate_Interview() {
        return date_Interview;
    }

    public Interview setDate_Interview(LocalDate date_Interview) {
        this.date_Interview = date_Interview;
        return this;
    }

    public String getHour() {
        return hour;
    }

    public Interview setHour(String hour) {
        this.hour = hour;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Interview setUrl(String url) {
        this.url = url;
        return this;
    }
}
