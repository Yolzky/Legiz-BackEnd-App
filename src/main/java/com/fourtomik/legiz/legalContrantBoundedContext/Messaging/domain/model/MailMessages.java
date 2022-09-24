package com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.model;

import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.model.ContratLegal;
import com.fourtomik.legiz.user.domain.model.AuditModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "mailmessages")
public class MailMessages extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_contrat_legal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ContratLegal contratLegal;

    private String message;

    public MailMessages() {
    }

    public MailMessages(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public MailMessages setId(Long id) {
        this.id = id;
        return this;
    }

    public ContratLegal getContratLegal() {
        return contratLegal;
    }

    public MailMessages setContratLegal(ContratLegal contratLegal) {
        this.contratLegal = contratLegal;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MailMessages setMessage(String message) {
        this.message = message;
        return this;
    }
}
