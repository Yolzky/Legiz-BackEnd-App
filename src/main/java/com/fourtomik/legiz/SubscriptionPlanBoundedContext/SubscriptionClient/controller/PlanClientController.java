package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.controller;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.model.PlanClient;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.service.PlanClientService;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.resource.PlanClientResource;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.resource.SavePlanClienteResource;
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
public class PlanClientController {
    @Autowired
    private PlanClientService planClientService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Create Plan Client", description="Create Plan Client", tags={"planclients"})
    @PostMapping("/client/{clientId}/planclient")
    public PlanClientResource createPlanClient(
            @PathVariable Long clientId,
            @Valid @RequestBody SavePlanClienteResource resource) {
        return convertToResource(planClientService.createPlanClient(clientId,convertToEntity(resource)));
    }

    @Operation(summary="Delete Plan client by client Id", description="Delete Plan Client by Client Id", tags={"planclients"})
    @DeleteMapping("/client/{clientId}/planclient/{planclientId}")
    public ResponseEntity<?> deletePlanClient(
            @PathVariable Long clientId,
            @PathVariable Long planclientId) {
        return planClientService.deletePlanClient(clientId, planclientId);
    }

    @Operation(summary="Update Plan Client by Client Id", description="Update Plan Client by Client Id", tags={"planclients"})
    @PutMapping("/client/{clientId}/planclient/{planclientId}")
    public PlanClientResource updatePlanClient(
            @PathVariable Long planclientId,
            @PathVariable Long clientId,
            @Valid @RequestBody SavePlanClienteResource resource) {
        return convertToResource(planClientService.updatePlanClient(planclientId, clientId, convertToEntity(resource)));
    }

    @Operation(summary="Get all Plan Client by Client Id", description="Get all Plan Client by Client Id", tags={"planclients"})
    @GetMapping("/client/{clientId}/planclient")
    public Page<PlanClientResource> getAllPlanClientsByClientId(
            @PathVariable Long clientId,
            Pageable pageable) {
        Page<PlanClient> planClientPage = planClientService.getAllPlanClientByClientId(clientId, pageable);
        List<PlanClientResource> resources = planClientPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Plan Client", description = "Get All Plan Client", tags = {"planclients"})
    @GetMapping("/planclient")
    public Page<PlanClientResource> getAllPlanClient(Pageable pageable){
        Page<PlanClient> planClientPage = planClientService.getAllPlanClient(pageable);
        List<PlanClientResource> resources = planClientPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    private PlanClient convertToEntity(SavePlanClienteResource resource){
        return mapper.map(resource, PlanClient.class);
    }

    private PlanClientResource convertToResource(PlanClient entity){
        return mapper.map(entity,PlanClientResource.class);
    }
}
