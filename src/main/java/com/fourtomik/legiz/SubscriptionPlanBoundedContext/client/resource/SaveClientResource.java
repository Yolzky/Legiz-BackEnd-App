package com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.resource;

import com.fourtomik.legiz.user.resource.SaveUserResource;

import java.time.LocalDate;

public class SaveClientResource extends SaveUserResource {
    private String civil_Status;

    public SaveClientResource() {
        super();
    }

    public SaveClientResource(String name, String surname, String email, String password, Long DNI, LocalDate date_Birthday, String civil_Status) {
        super(name, surname, email, password, DNI, date_Birthday);
        this.civil_Status = civil_Status;
    }

    public String getCivil_Status() {
        return civil_Status;
    }

    public SaveClientResource setCivil_Status(String civil_Status) {
        this.civil_Status = civil_Status;
        return this;
    }
}
