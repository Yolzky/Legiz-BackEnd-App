package com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.model;

import com.fourtomik.legiz.user.domain.model.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "clients")
public class Client extends User {
    @NotNull
    private String civil_Status;

    public Client() {
        super();
    }

    public Client(Long id, @NotNull String name, @NotNull String surname, @NotNull String email, @NotNull String password, @NotNull Long DNI, LocalDate date_Birthday, @NotNull String civil_Status) {
        super(id, name, surname, email, password, DNI, date_Birthday);
        this.civil_Status = civil_Status;
    }

    public String getCivil_Status() {
        return civil_Status;
    }

    public Client setCivil_Status(String civil_Status) {
        this.civil_Status = civil_Status;
        return this;
    }
}
