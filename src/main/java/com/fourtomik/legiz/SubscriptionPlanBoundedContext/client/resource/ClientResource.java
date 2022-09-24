package com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.resource;

import com.fourtomik.legiz.user.resource.UserResource;

import java.time.LocalDate;

public class ClientResource extends UserResource {
    private String civil_Status;

    public ClientResource() {
        super();
    }

    public ClientResource(Long id, String name, String surname, String email, String password, Long DNI, LocalDate date_Birthday, String civil_Status) {
        super(id, name, surname, email, password, DNI, date_Birthday);
        this.civil_Status = civil_Status;
    }

    public String getCivil_Status() {
        return civil_Status;
    }

    public ClientResource setCivil_Status(String civil_Status) {
        this.civil_Status = civil_Status;
        return this;
    }
}
