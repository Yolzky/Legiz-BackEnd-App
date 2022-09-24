package com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.resource;

public class TypeSpecialtyResource {
    private Long id;

    private String name;

    public TypeSpecialtyResource() {
    }

    public TypeSpecialtyResource(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public TypeSpecialtyResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TypeSpecialtyResource setName(String name) {
        this.name = name;
        return this;
    }
}
