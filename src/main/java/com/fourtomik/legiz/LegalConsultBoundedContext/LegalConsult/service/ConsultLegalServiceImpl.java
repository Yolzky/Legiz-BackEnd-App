package com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.service;

import com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.domain.model.ConsultLegal;
import com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.domain.repository.ConsultLegalRepository;
import com.fourtomik.legiz.LegalConsultBoundedContext.LegalConsult.domain.service.ConsultLegalService;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.repository.ClientRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.lawyer.domain.repository.LawyerRepository;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultLegalServiceImpl implements ConsultLegalService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private ConsultLegalRepository consultLegalRepository;

    @Override
    public ConsultLegal createConsultLegal(Long clientId, Long laywerId, ConsultLegal consultLegal) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id",clientId);

        else if (!lawyerRepository.existsById(laywerId))
            throw new ResourceNotFoundException("Lawyer","Id", laywerId);

        return clientRepository.findById(clientId).map(client -> {
            consultLegal.setClient(client);
            lawyerRepository.findById(laywerId).map(lawyer -> {
                consultLegal.setLawyer(lawyer);
                return consultLegalRepository.save(consultLegal);
            }).orElseThrow(() -> new ResourceNotFoundException("Laywer Id" + laywerId));
            return consultLegalRepository.save(consultLegal);
        }).orElseThrow(() -> new ResourceNotFoundException("Client Id" + clientId));
    }

    @Override
    public ConsultLegal updateConsultLegal(Long clientId, Long laywerId, Long consultLegalId, ConsultLegal consultLegalRequest) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id",clientId);

        else if (!lawyerRepository.existsById(laywerId))
            throw new ResourceNotFoundException("Lawyer","Id", laywerId);

        return consultLegalRepository.findById(consultLegalId).map(consultLegal -> {
            consultLegal.setComentary(consultLegalRequest.getComentary())
                    .setDocument(consultLegalRequest.getDocument());
            return  consultLegalRepository.save(consultLegal);
        }).orElseThrow(() -> new ResourceNotFoundException("Client Id" + clientId + "Lawyer Id" + laywerId));
    }

    @Override
    public ResponseEntity<?> deleteConsultLegal(Long clientId, Long laywerId, Long consultLegalId) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id",clientId);

        else if (!lawyerRepository.existsById(laywerId))
            throw new ResourceNotFoundException("Lawyer","Id", laywerId);

        return consultLegalRepository.findById(consultLegalId).map(consultLegal -> {
            consultLegalRepository.delete(consultLegal);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Consult Legal","Id",consultLegalId));
    }

    @Override
    public Page<ConsultLegal> getAllConsultLegalByClientId(Long clientId, Pageable pageable) {
        return consultLegalRepository.findByClientId(clientId,pageable);
    }

    @Override
    public Page<ConsultLegal> getAllConsultLegalByLawyerId(Long laywerId, Pageable pageable) {
        return consultLegalRepository.findByLawyerId(laywerId,pageable);
    }

    @Override
    public Page<ConsultLegal> getAllConsultLegalByClientIdAndLawyerId(Long clientId, Long laywerId, Pageable pageable) {
        return consultLegalRepository.findByClientIdAndLawyerId(clientId,laywerId,pageable);
    }

    @Override
    public Page<ConsultLegal> getAllConsultLegal(Pageable pageable) {
        return consultLegalRepository.findAll(pageable);
    }
}
