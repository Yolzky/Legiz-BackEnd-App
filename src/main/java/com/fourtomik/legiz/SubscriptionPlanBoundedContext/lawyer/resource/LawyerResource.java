package com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.resource;

import com.fourtomik.legiz.user.resource.UserResource;

import java.time.LocalDate;

public class LawyerResource extends UserResource {

    public LawyerResource() {
        super();
    }

    public LawyerResource(Long id, String name, String surname, String email, String password, Long DNI, LocalDate date_Birthday) {
        super(id, name, surname, email, password, DNI, date_Birthday);
    }

    private String nameSpecialty;

    private Long TypeSpecialtyId;

    public Long getTypeSpecialtyId() {
        return TypeSpecialtyId;
    }

    public LawyerResource setTypeSpecialtyId(Long typeSpecialtyId) {
        TypeSpecialtyId = typeSpecialtyId;
        return this;
    }

    public String getNameSpecialty() {
        return nameSpecialty;
    }

    public LawyerResource setNameSpecialty(String nameSpecialty) {
        this.nameSpecialty = nameSpecialty;
        return this;
    }
}
