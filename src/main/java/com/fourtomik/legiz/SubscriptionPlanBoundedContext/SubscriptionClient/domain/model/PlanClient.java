package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.model;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.model.Client;
import com.fourtomik.legiz.user.domain.model.AuditModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "planclient")
public class PlanClient extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    private String description;

    private String duration;

    private Long cost;

    public PlanClient() {
    }

    public PlanClient(Long id, String description, String duration, Long cost) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public PlanClient setId(Long id) {
        this.id = id;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public PlanClient setClient(Client client) {
        this.client = client;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlanClient setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public PlanClient setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public PlanClient setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}
