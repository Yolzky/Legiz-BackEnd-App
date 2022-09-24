package com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.service;

import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.model.ContratLegal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ContratLegalService {
    ContratLegal createContratLegal(Long clientId, Long laywerId, ContratLegal contratLegal);
    ContratLegal updateContratLegal(Long clientId, Long laywerId, Long contratLegalId, ContratLegal contratLegalRequest);
    ResponseEntity<?> deleteContratLegal(Long clientId, Long laywerId, Long contratLegalId);
    Page<ContratLegal> getAllContratLegalByClientId(Long clientId, Pageable pageable);
    Page<ContratLegal> getAllContratLegalByLawyerId(Long laywerId, Pageable pageable);
    Page<ContratLegal> getAllContratLegalByClientIdAndLawyerId(Long clientId, Long laywerId, Pageable pageable);
    Page<ContratLegal> getAllContratLegal(Pageable pageable);
}
