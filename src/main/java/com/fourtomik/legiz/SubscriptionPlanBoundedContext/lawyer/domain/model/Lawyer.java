package com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.model.TypeSpecialty;
import com.fourtomik.legiz.user.domain.model.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "lawyers")
public class Lawyer extends User {
    public TypeSpecialty getTypeSpecialty() {
        return typeSpecialty;
    }

    public Lawyer setTypeSpecialty(TypeSpecialty typeSpecialty) {
        this.typeSpecialty = typeSpecialty;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_typeSpecialty_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TypeSpecialty typeSpecialty;

    public Lawyer() {
        super();
    }

    public Lawyer(Long id, String name, String surname, String email, String password, Long DNI, LocalDate date_Birthday) {
        super(id, name, surname, email, password, DNI, date_Birthday);
    }
}
