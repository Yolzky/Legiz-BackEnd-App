package com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.controller;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.model.Lawyer;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.service.LawyerService;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.resource.LawyerResource;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.resource.SaveLawyerResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LawyerController {
    @Autowired
    private LawyerService lawyerService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Create Lawyers", description="Create Lawyers", tags={"lawyers"})
    @PostMapping("/typespecialty/{typespecialtyId}/lawyers")
    public LawyerResource createLawyer(
            @PathVariable Long typespecialtyId,
            @Valid @RequestBody SaveLawyerResource resource) {
        return convertToResource(lawyerService.createLawyer(typespecialtyId,convertToEntity(resource)));
    }

    @Operation(summary="Delete Lawyers by Type Specialty Id", description="Delete Lawyers by Type Specialty Id", tags={"lawyers"})
    @DeleteMapping("/typespecialty/{typespecialtyId}/lawyers/{lawyerId}")
    public ResponseEntity<?> deleteLawyer(
            @PathVariable Long typespecialtyId,
            @PathVariable Long lawyerId) {
        return lawyerService.deleteLawyer(typespecialtyId, lawyerId);
    }

    @Operation(summary="Get Lawyers", description="Get all Lawyers by Type Specialty Id", tags={"lawyers"})
    @GetMapping("/typespecialty/{typespecialtyId}/lawyers")
    public Page<LawyerResource> getAllLawyersByTypeSpecialtyId(
            @PathVariable Long typespecialtyId,
            Pageable pageable) {
        Page<Lawyer> lawyerPage = lawyerService.getAllLawyersByTypeSpecialtyId(typespecialtyId, pageable);
        List<LawyerResource> resources = lawyerPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Lawyers", description = "Get All Lawyers", tags = {"lawyers"})
    @GetMapping("/lawyers")
    public Page<LawyerResource> getAllLawyer(Pageable pageable){
        Page<Lawyer> lawyerPage = lawyerService.getAllLawyer(pageable);
        List<LawyerResource> resources = lawyerPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }
    private Lawyer convertToEntity(SaveLawyerResource resource){
        return mapper.map(resource, Lawyer.class);
    }

    private LawyerResource convertToResource(Lawyer entity){
        return mapper.map(entity,LawyerResource.class);
    }

}
