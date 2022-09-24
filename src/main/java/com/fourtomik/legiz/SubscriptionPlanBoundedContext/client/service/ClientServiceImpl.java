package com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.model.Client;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.repository.ClientRepository;
import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.service.ClientService;
import com.fourtomik.legiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long clientId, Client clientRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client","Id",clientId));

        return clientRepository.save(
                client.setCivil_Status(clientRequest.getCivil_Status())
        );
    }

    @Override
    public ResponseEntity<?> deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client","Id",clientId));

        clientRepository.delete(client);
        return ResponseEntity.ok().build();
    }
}
