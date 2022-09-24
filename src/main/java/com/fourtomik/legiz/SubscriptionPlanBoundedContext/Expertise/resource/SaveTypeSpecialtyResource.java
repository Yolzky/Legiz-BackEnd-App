package com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.resource;

import javax.validation.constraints.Size;

public class SaveTypeSpecialtyResource {
    @Size(max = 30)
    private String name;

    public SaveTypeSpecialtyResource() {
    }

    public SaveTypeSpecialtyResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SaveTypeSpecialtyResource setName(String name) {
        this.name = name;
        return this;
    }
}
