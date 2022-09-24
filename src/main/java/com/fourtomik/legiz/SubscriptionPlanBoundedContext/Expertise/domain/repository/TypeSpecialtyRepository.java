package com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.repository;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.model.TypeSpecialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSpecialtyRepository extends JpaRepository<TypeSpecialty, Long> {
    public Page<TypeSpecialty> findById (Long Id, Pageable pageable);
}
