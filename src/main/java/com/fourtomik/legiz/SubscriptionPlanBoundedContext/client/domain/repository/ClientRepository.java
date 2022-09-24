package com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.repository;

import com.fourtomik.legiz.SubscriptionPlanBoundedContext.client.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    public Page<Client> findById(Long Id, Pageable pageable);
}
