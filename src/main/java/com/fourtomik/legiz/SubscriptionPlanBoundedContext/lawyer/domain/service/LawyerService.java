package com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model.Lawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface LawyerService {
    Lawyer createLawyer(Long typeSpecialtyId, Lawyer lawyer);
    Page<Lawyer> getAllLawyersByTypeSpecialtyId(Long typeSpecialtyId, Pageable pageable);
    ResponseEntity<?> deleteLawyer(Long typeSpecialtyId, Long lawyerId);
    Page<Lawyer> getAllLawyer(Pageable pageable);
}
