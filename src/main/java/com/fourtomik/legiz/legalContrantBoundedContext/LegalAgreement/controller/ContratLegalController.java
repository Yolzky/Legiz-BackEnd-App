package com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.controller;

import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.model.ContratLegal;
import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.service.ContratLegalService;
import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.resource.ContratLegalResource;
import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.resource.SaveContratLegalResource;
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
public class ContratLegalController {
    @Autowired
    private ContratLegalService contratLegalService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Create Contrat Legal", description="Create Contrat Legal", tags={"contrat_legals"})
    @PostMapping("/client/{clientId}/lawyer/{lawyerId}/contrat_legals")
    public ContratLegalResource createContratLegal(
            @PathVariable Long clientId,
            @PathVariable Long lawyerId,
            @Valid @RequestBody SaveContratLegalResource resource) {
        return convertToResource(contratLegalService.createContratLegal(clientId,lawyerId,convertToEntity(resource)));
    }

    @Operation(summary="Delete Contrat legal by client ID and lawyer ID", description="Delete Contrat legal by client ID and lawyer ID", tags={"contrat_legals"})
    @DeleteMapping("/client/{clientId}/lawyer/{lawyerId}/contrat_legals/{contratLegalId}")
    public ResponseEntity<?> deleteContratLegal(
            @PathVariable Long clientId,
            @PathVariable Long lawyerId,
            @PathVariable Long contratLegalId) {
        return contratLegalService.deleteContratLegal(clientId, lawyerId, contratLegalId);
    }

    @Operation(summary="Update contrat legal by client ID and lawyer ID", description="Update contrat legal by client ID and lawyer ID", tags={"contrat_legals"})
    @PutMapping("/client/{clientId}/lawyer/{lawyerId}/contrat_legals/{contratLegalId}")
    public ContratLegalResource updateContratLegal(
            @PathVariable Long clientId,
            @PathVariable Long lawyerId,
            @PathVariable Long contratLegalId,
            @Valid @RequestBody SaveContratLegalResource resource) {
        return convertToResource(contratLegalService.updateContratLegal(clientId, lawyerId, contratLegalId, convertToEntity(resource)));
    }

    @Operation(summary="Get Contrat Legal", description="Get all Contrat Legal by client Id", tags={"contrat_legals"})
    @GetMapping("/client/{clientId}/contrat_legals")
    public Page<ContratLegalResource> getAllContratLegalByClientId(
            @PathVariable Long clientId,
            Pageable pageable) {
        Page<ContratLegal> contratLegalPage = contratLegalService.getAllContratLegalByClientId(clientId, pageable);
        List<ContratLegalResource> resources = contratLegalPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Contrat Legal", description="Get all Contrat Legal by lawyer Id", tags={"contrat_legals"})
    @GetMapping("/lawyer/{lawyerId}/contrat_legals")
    public Page<ContratLegalResource> getAllContratLegalByLawyerId(
            @PathVariable Long lawyerId,
            Pageable pageable) {
        Page<ContratLegal> contratLegalPage = contratLegalService.getAllContratLegalByLawyerId(lawyerId, pageable);
        List<ContratLegalResource> resources = contratLegalPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="Get Contrat legal by client Id and lawyer Id", description="Get Contrat legal by client Id and lawyer Id", tags={"contrat_legals"})
    @GetMapping("/client/{clientId}/lawyer/{lawyerId}/contrat_legals")
    public Page<ContratLegalResource> getAllConsultLegalByClientIdAndLawyerId(
            @PathVariable Long clientId,
            @PathVariable Long lawyerId,
            Pageable pageable) {
        Page<ContratLegal> contratLegalPage = contratLegalService.getAllContratLegalByClientIdAndLawyerId(clientId, lawyerId, pageable);
        List<ContratLegalResource> resources = contratLegalPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Contrat Legal", description = "Get All Contrat Legal", tags = {"contrat_legals"})
    @GetMapping("/contrat_legals")
    public Page<ContratLegalResource> getAllContratLegal(Pageable pageable){
        Page<ContratLegal> contratLegalPage = contratLegalService.getAllContratLegal(pageable);
        List<ContratLegalResource> resources = contratLegalPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    private ContratLegal convertToEntity(SaveContratLegalResource resource){
        return mapper.map(resource, ContratLegal.class);
    }

    private ContratLegalResource convertToResource(ContratLegal entity){
        return mapper.map(entity,ContratLegalResource.class);
    }
}
