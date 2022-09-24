package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.repository.LawyerRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.model.PlanLawyer;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.repository.PlanLawyerRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.service.PlanLawyerService;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanLawyerServiceImpl implements PlanLawyerService {
    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private PlanLawyerRepository planLawyerRepository;

    @Override
    public PlanLawyer createPlanLawyer(Long lawyerId, PlanLawyer planLawyer) {
        if(planLawyerRepository.existsByLawyerId(lawyerId))
            throw new ResourceNotFoundException("El abogado ya tiene un plan de suscripcion");

        return lawyerRepository.findById(lawyerId).map(lawyer -> {
            planLawyer.setLawyer(lawyer);
            return planLawyerRepository.save(planLawyer);
        }).orElseThrow(() -> new ResourceNotFoundException("Lawyer","Id", lawyerId));
    }

    @Override
    public Page<PlanLawyer> getAllPlanLawyerByLawyerId(Long lawyerId, Pageable pageable) {
        return planLawyerRepository.findByLawyerId(lawyerId, pageable);
    }

    @Override
    public Page<PlanLawyer> getAllPlanLawyer(Pageable pageable) {
        return planLawyerRepository.findAll(pageable);
    }

    @Override
    public PlanLawyer updatePlanLawyer(Long planLawyerId, Long lawyerId, PlanLawyer planLawyerRequest) {
        if(!lawyerRepository.existsById(lawyerId))
            throw new ResourceNotFoundException("Lawyer","Id", lawyerId);

        return planLawyerRepository.findById(planLawyerId).map(planLawyer -> {
            planLawyer.setDescription(planLawyerRequest.getDescription())
                    .setDuration(planLawyerRequest.getDuration())
                    .setCost(planLawyerRequest.getCost());
            return planLawyerRepository.save(planLawyer);
        }).orElseThrow(() -> new ResourceNotFoundException("Plan Lawyer","Id",planLawyerId));
    }

    @Override
    public ResponseEntity<?> deletePlanLawyer(Long lawyerId, Long planLawyerId) {
        if(!lawyerRepository.existsById(lawyerId))
            throw new ResourceNotFoundException("Lawyer","Id", lawyerId);

        return planLawyerRepository.findById(planLawyerId).map(planLawyer -> {
            planLawyerRepository.delete(planLawyer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Plan Lawyer","Id",planLawyerId));
    }
}
