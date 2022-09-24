package com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.model.TypeSpecialty;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.repository.TypeSpecialtyRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.service.TypeSpecialtyService;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TypeSpecialtyServiceImpl implements TypeSpecialtyService {
    @Autowired
    private TypeSpecialtyRepository typeSpecialtyRepository;

    @Override
    public Page<TypeSpecialty> getAllTypeSpecialty(Pageable pageable) {
        return typeSpecialtyRepository.findAll(pageable);
    }

    @Override
    public TypeSpecialty getTypeSpecialtyById(Long typeSpecialtyId) {
        return typeSpecialtyRepository.findById(typeSpecialtyId)
                .orElseThrow(() -> new ResourceNotFoundException("Type Specialty", "Id", typeSpecialtyId));
    }

    @Override
    public TypeSpecialty createTypeSpecialty(TypeSpecialty typeSpecialty) {
        return typeSpecialtyRepository.save(typeSpecialty);
    }

    @Override
    public TypeSpecialty updateTypeSpecialty(Long typeSpecialtyId, TypeSpecialty typeSpecialtyRequest) {
        TypeSpecialty typeSpecialty = typeSpecialtyRepository.findById(typeSpecialtyId)
                .orElseThrow(() -> new ResourceNotFoundException("Type Specialty", "Id", typeSpecialtyId));
        return typeSpecialtyRepository.save(
                typeSpecialty.setName(typeSpecialtyRequest.getName())
        );
    }

    @Override
    public ResponseEntity<?> deleteTypeSpecialty(Long typeSpecialtyId) {
        TypeSpecialty typeSpecialty = typeSpecialtyRepository.findById(typeSpecialtyId)
                .orElseThrow(() -> new ResourceNotFoundException("Type Specialty", "Id", typeSpecialtyId));
        typeSpecialtyRepository.delete(typeSpecialty);
        return ResponseEntity.ok().build();
    }
}
