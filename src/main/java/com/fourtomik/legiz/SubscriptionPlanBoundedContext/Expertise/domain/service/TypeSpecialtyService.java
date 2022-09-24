package com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.Expertise.domain.model.TypeSpecialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TypeSpecialtyService {
    Page<TypeSpecialty> getAllTypeSpecialty(Pageable pageable);
    TypeSpecialty getTypeSpecialtyById(Long typeSpecialtyId);
    TypeSpecialty createTypeSpecialty(TypeSpecialty typeSpecialty);
    TypeSpecialty updateTypeSpecialty(Long typeSpecialtyId, TypeSpecialty typeSpecialtyRequest);
    ResponseEntity<?> deleteTypeSpecialty(Long typeSpecialtyId);
}
