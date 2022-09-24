package com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.resource;

import com.fourtomik.legiz.user.resource.SaveUserResource;

import java.time.LocalDate;

public class SaveLawyerResource extends SaveUserResource {

    public SaveLawyerResource() {
        super();
    }

    public SaveLawyerResource(String name, String surname, String email, String password, Long DNI, LocalDate date_Birthday) {
        super(name, surname, email, password, DNI, date_Birthday);
    }
}
