package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.controller;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.model.PlanLawyer;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.domain.service.PlanLawyerService;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.resource.PlanLawyerResource;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionLawyer.resource.SavePlanLawyerResource;
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
public class PlanLawyerController {

    @Autowired
    private PlanLawyerService planLawyerService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Create Plan Lawyers", description="Create Plan Lawyers", tags={"planlawyers"})
    @PostMapping("/lawyer/{lawyerId}/planlawyer")
    public PlanLawyerResource createPlanLawyer(
            @PathVariable Long lawyerId,
            @Valid @RequestBody SavePlanLawyerResource resource) {
        return convertToResource(planLawyerService.createPlanLawyer(lawyerId,convertToEntity(resource)));
    }

    @Operation(summary="Delete Plan Lawyers by Lawyer Id", description="Delete Plan Lawyers by Lawyer Id", tags={"planlawyers"})
    @DeleteMapping("/lawyer/{lawyerId}/planlawyer/{planlawyerId}")
    public ResponseEntity<?> deletePlanLawyer(
            @PathVariable Long lawyerId,
            @PathVariable Long planlawyerId) {
        return planLawyerService.deletePlanLawyer(lawyerId, planlawyerId);
    }

    @Operation(summary="Update Plan Lawyers by Lawyers Id", description="Update Plan Lawyers by Lawyers Id", tags={"planlawyers"})
    @PutMapping("/lawyer/{lawyerId}/planlawyer/{planlawyerId}")
    public PlanLawyerResource updatePlanLawyer(
            @PathVariable Long planlawyerId,
            @PathVariable Long lawyerId,
            @Valid @RequestBody SavePlanLawyerResource resource) {
        return convertToResource(planLawyerService.updatePlanLawyer(planlawyerId, lawyerId, convertToEntity(resource)));
    }


    @Operation(summary="Get all Plan Lawyers by Lawyer Id", description="Get all Plan Lawyers by Lawyer Id", tags={"planlawyers"})
    @GetMapping("/lawyer/{lawyerId}/planlawyer")
    public Page<PlanLawyerResource> getAllPlanLawyersByLawyerId(
            @PathVariable Long lawyerId,
            Pageable pageable) {
        Page<PlanLawyer> planLawyerPage = planLawyerService.getAllPlanLawyerByLawyerId(lawyerId, pageable);
        List<PlanLawyerResource> resources = planLawyerPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Plan Lawyers", description = "Get All Plan Lawyers", tags = {"planlawyers"})
    @GetMapping("/planlawyers")
    public Page<PlanLawyerResource> getAllPlanLawyer(Pageable pageable){
        Page<PlanLawyer> planLawyerPage = planLawyerService.getAllPlanLawyer(pageable);
        List<PlanLawyerResource> resources = planLawyerPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    private PlanLawyer convertToEntity(SavePlanLawyerResource resource){
        return mapper.map(resource, PlanLawyer.class);
    }

    private PlanLawyerResource convertToResource(PlanLawyer entity){
        return mapper.map(entity,PlanLawyerResource.class);
    }
}
