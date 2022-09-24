package com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.repository;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model.Lawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    public Page<Lawyer> findById (Long Id, Pageable pageable);
    Page<Lawyer> findByTypeSpecialtyId(Long typeSpecialtyId, Pageable pageable);
    Boolean existsByTypeSpecialtyId(Long typeSpecialtyId);
}
