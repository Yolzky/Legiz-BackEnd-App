package com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.service;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    Page<Client> getAllClients(Pageable pageable);
    Client createClient(Client client);
    Client updateClient(Long clientId, Client clientRequest);
    ResponseEntity<?> deleteClient(Long clientId);
}
