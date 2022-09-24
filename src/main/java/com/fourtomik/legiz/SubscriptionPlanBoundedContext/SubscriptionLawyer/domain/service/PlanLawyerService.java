package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.model.PlanLawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PlanLawyerService {
    PlanLawyer createPlanLawyer(Long lawyerId, PlanLawyer planLawyer);
    Page<PlanLawyer> getAllPlanLawyerByLawyerId(Long lawyerId, Pageable pageable);
    Page<PlanLawyer> getAllPlanLawyer(Pageable pageable);
    PlanLawyer updatePlanLawyer(Long planLawyerId, Long lawyerId, PlanLawyer planLawyerRequest);
    ResponseEntity<?> deletePlanLawyer(Long lawyerId, Long planLawyerId);
}
