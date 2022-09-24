package com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model.Lawyer;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.repository.LawyerRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.service.LawyerService;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.repository.TypeSpecialtyRepository;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LawyerServiceImpl implements LawyerService {
    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private TypeSpecialtyRepository typeSpecialtyRepository;
    @Override

    public Lawyer createLawyer(Long typeSpecialtyId, Lawyer lawyer) {
        if(!typeSpecialtyRepository.existsById(typeSpecialtyId))
            throw new ResourceNotFoundException("Type Specialty","Id",typeSpecialtyId);

        return typeSpecialtyRepository.findById(typeSpecialtyId).map(typeSpecialty -> {
            lawyer.setTypeSpecialty(typeSpecialty);
            return lawyerRepository.save(lawyer);
        }).orElseThrow(() -> new ResourceNotFoundException("Type Specialty","Id",typeSpecialtyId));
    }

    @Override
    public Page<Lawyer> getAllLawyersByTypeSpecialtyId(Long typeSpecialtyId, Pageable pageable) {
        return lawyerRepository.findByTypeSpecialtyId(typeSpecialtyId, pageable);
    }

    @Override
    public ResponseEntity<?> deleteLawyer(Long typeSpecialtyId, Long lawyerId) {
        if(!typeSpecialtyRepository.existsById(typeSpecialtyId))
            throw new ResourceNotFoundException("Type Specialty","Id",typeSpecialtyId);

        return lawyerRepository.findById(lawyerId).map(lawyer -> {
            lawyerRepository.delete(lawyer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Lawyer","Id",lawyerId));
    }

    @Override
    public Page<Lawyer> getAllLawyer(Pageable pageable) {
        return lawyerRepository.findAll(pageable);
    }
}
