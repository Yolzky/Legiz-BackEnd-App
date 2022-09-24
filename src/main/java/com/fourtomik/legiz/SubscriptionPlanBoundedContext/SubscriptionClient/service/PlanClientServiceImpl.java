package com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.repository.ClientRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.model.PlanClient;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.repository.PlanClienteRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.SubscriptionClient.domain.service.PlanClientService;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanClientServiceImpl implements PlanClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PlanClienteRepository planClienteRepository;

    @Override
    public PlanClient createPlanClient(Long clientId, PlanClient planClient) {
        if(planClienteRepository.existsByClientId(clientId))
            throw new ResourceNotFoundException("El cliente ya tiene un plan de suscripcion");

        return clientRepository.findById(clientId).map(client -> {
            planClient.setClient(client);
            return planClienteRepository.save(planClient);
        }).orElseThrow(() -> new ResourceNotFoundException("Client","Id", clientId));
    }

    @Override
    public Page<PlanClient> getAllPlanClientByClientId(Long clientId, Pageable pageable) {
        return planClienteRepository.findByClientId(clientId, pageable);
    }

    @Override
    public Page<PlanClient> getAllPlanClient(Pageable pageable) {
        return planClienteRepository.findAll(pageable);
    }

    @Override
    public PlanClient updatePlanClient(Long planClientId, Long clientId, PlanClient planClientRequest) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id", clientId);

        return planClienteRepository.findById(planClientId).map(planClient -> {
            planClient.setDescription(planClientRequest.getDescription())
                    .setDuration(planClientRequest.getDuration())
                    .setCost(planClientRequest.getCost());
            return planClienteRepository.save(planClient);
        }).orElseThrow(() -> new ResourceNotFoundException("Plan Client","Id",planClientId));
    }

    @Override
    public ResponseEntity<?> deletePlanClient(Long clientId, Long planClientId) {
        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("Client","Id", clientId);

        return planClienteRepository.findById(planClientId).map(planClient -> {
            planClienteRepository.delete(planClient);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Plan Client","Id",planClientId));
    }
}
