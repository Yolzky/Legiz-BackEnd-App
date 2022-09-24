package com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.domain.model;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.model.Client;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model.Lawyer;
import com.fourtomik.legiz.user.domain.model.AuditModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "consultlegal")
public class ConsultLegal extends AuditModel {
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

    private String document;

    private String comentary;

    public ConsultLegal() {
    }

    public ConsultLegal(Long id, String document, String comentary) {
        this.id = id;
        this.document = document;
        this.comentary = comentary;
    }

    public Long getId() {
        return id;
    }

    public ConsultLegal setId(Long id) {
        this.id = id;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public ConsultLegal setClient(Client client) {
        this.client = client;
        return this;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public ConsultLegal setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public ConsultLegal setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getComentary() {
        return comentary;
    }

    public ConsultLegal setComentary(String comentary) {
        this.comentary = comentary;
        return this;
    }
}
