package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.model;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model.Lawyer;
import com.fourtomik.legiz.user.domain.model.AuditModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "planlawyer")
public class PlanLawyer extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_lawyer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Lawyer lawyer;

    private String description;

    private String duration;

    private Long cost;


    public PlanLawyer() {
    }

    public PlanLawyer(Long id, String description, String duration, Long cost) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public PlanLawyer setId(Long id) {
        this.id = id;
        return this;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public PlanLawyer setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlanLawyer setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public PlanLawyer setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public PlanLawyer setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}
