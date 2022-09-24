package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.repository;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.model.PlanLawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanLawyerRepository extends JpaRepository<PlanLawyer,Long> {
    public Page<PlanLawyer> findById (Long Id, Pageable pageable);
    Page<PlanLawyer> findByLawyerId (Long lawyerId, Pageable pageable);
    Boolean existsByLawyerId(Long lawyerId);
}
