package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.model.PlanClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PlanClientService {
    PlanClient createPlanClient(Long clientId, PlanClient planClient);
    Page<PlanClient> getAllPlanClientByClientId(Long clientId, Pageable pageable);
    Page<PlanClient> getAllPlanClient(Pageable pageable);
    PlanClient updatePlanClient(Long planClientId, Long clientId, PlanClient planClientRequest);
    ResponseEntity<?> deletePlanClient(Long clientId, Long planClientId);
}
