package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.repository;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.model.PlanClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanClienteRepository extends JpaRepository<PlanClient, Long> {
    public Page<PlanClient> findById (Long Id, Pageable pageable);
    Page<PlanClient> findByClientId (Long clientId, Pageable pageable);
    Boolean existsByClientId (Long clientId);
}
