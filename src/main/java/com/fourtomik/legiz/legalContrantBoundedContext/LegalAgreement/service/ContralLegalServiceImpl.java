package com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.repository.ClientRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.repository.LawyerRepository;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.model.ContratLegal;
import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.repository.ContratLegalRepository;
import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.service.ContratLegalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContralLegalServiceImpl implements ContratLegalService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private ContratLegalRepository contratLegalRepository;

    @Override
    public ContratLegal createContratLegal(Long clientId, Long laywerId, ContratLegal contratLegal) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id",clientId);

        else if (!lawyerRepository.existsById(laywerId))
            throw new ResourceNotFoundException("Lawyer","Id", laywerId);

        return clientRepository.findById(clientId).map(client -> {
            contratLegal.setClient(client);
            lawyerRepository.findById(laywerId).map(lawyer -> {
                contratLegal.setLawyer(lawyer);
                return contratLegalRepository.save(contratLegal);
            }).orElseThrow(() -> new ResourceNotFoundException("Laywer Id" + laywerId));
            return contratLegalRepository.save(contratLegal);
        }).orElseThrow(() -> new ResourceNotFoundException("Client Id" + clientId));
    }

    @Override
    public ContratLegal updateContratLegal(Long clientId, Long laywerId, Long contratLegalId, ContratLegal contratLegalRequest) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id",clientId);

        else if (!lawyerRepository.existsById(laywerId))
            throw new ResourceNotFoundException("Lawyer","Id", laywerId);

        return contratLegalRepository.findById(contratLegalId).map(contratLegal -> {
            contratLegal.setDescription(contratLegalRequest.getDescription())
                    .setCost(contratLegalRequest.getCost())
                    .setStart_Date(contratLegalRequest.getStart_Date())
                    .setEnd_Date(contratLegalRequest.getEnd_Date());
            return  contratLegalRepository.save(contratLegal);
        }).orElseThrow(() -> new ResourceNotFoundException("Client Id" + clientId + "Lawyer Id" + laywerId));
    }

    @Override
    public ResponseEntity<?> deleteContratLegal(Long clientId, Long laywerId, Long contratLegalId) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id",clientId);

        else if (!lawyerRepository.existsById(laywerId))
            throw new ResourceNotFoundException("Lawyer","Id", laywerId);

        return contratLegalRepository.findById(contratLegalId).map(contratLegal -> {
            contratLegalRepository.delete(contratLegal);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Consult Legal","Id",contratLegalId));
    }

    @Override
    public Page<ContratLegal> getAllContratLegalByClientId(Long clientId, Pageable pageable) {
        return contratLegalRepository.findByClientId(clientId,pageable);
    }

    @Override
    public Page<ContratLegal> getAllContratLegalByLawyerId(Long laywerId, Pageable pageable) {
        return contratLegalRepository.findByLawyerId(laywerId,pageable);
    }

    @Override
    public Page<ContratLegal> getAllContratLegalByClientIdAndLawyerId(Long clientId, Long laywerId, Pageable pageable) {
        return contratLegalRepository.findByClientIdAndLawyerId(clientId,laywerId,pageable);
    }

    @Override
    public Page<ContratLegal> getAllContratLegal(Pageable pageable) {
        return contratLegalRepository.findAll(pageable);
    }
}
