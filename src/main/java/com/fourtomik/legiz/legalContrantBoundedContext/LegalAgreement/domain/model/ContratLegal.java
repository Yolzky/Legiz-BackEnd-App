package com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.model;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.model.Client;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model.Lawyer;
import com.fourtomik.legiz.user.domain.model.AuditModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contratlegal")
public class ContratLegal extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_lawyer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Lawyer lawyer;

    private String description;

    private Long cost;

    @DateTimeFormat
    private LocalDate start_Date;

    @DateTimeFormat
    private LocalDate end_Date;

    public ContratLegal() {
    }

    public ContratLegal(Long id, String description, Long cost, LocalDate start_Date, LocalDate end_Date) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
    }

    public Long getId() {
        return id;
    }

    public ContratLegal setId(Long id) {
        this.id = id;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public ContratLegal setClient(Client client) {
        this.client = client;
        return this;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public ContratLegal setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ContratLegal setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public ContratLegal setCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public LocalDate getStart_Date() {
        return start_Date;
    }

    public ContratLegal setStart_Date(LocalDate start_Date) {
        this.start_Date = start_Date;
        return this;
    }

    public LocalDate getEnd_Date() {
        return end_Date;
    }

    public ContratLegal setEnd_Date(LocalDate end_Date) {
        this.end_Date = end_Date;
        return this;
    }
}
