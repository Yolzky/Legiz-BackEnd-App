package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.resource;

public class SavePlanLawyerResource {
    private String description;

    private String duration;

    private Long cost;

    public SavePlanLawyerResource() {
    }

    public SavePlanLawyerResource(String description, String duration, Long cost) {
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public SavePlanLawyerResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public SavePlanLawyerResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public SavePlanLawyerResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}
