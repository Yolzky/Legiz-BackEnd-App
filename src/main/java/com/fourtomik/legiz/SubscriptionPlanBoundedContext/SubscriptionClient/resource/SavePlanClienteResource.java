package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.resource;

public class SavePlanClienteResource {
    private String description;

    private String duration;

    private Long cost;

    public SavePlanClienteResource() {
    }

    public SavePlanClienteResource(String description, String duration, Long cost) {
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public SavePlanClienteResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public SavePlanClienteResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public SavePlanClienteResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}
