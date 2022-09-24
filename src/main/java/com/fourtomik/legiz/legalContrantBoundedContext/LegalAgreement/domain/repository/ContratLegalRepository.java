package com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.repository;

import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.model.ContratLegal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratLegalRepository extends JpaRepository<ContratLegal, Long> {
    public Page<ContratLegal> findById(Long Id, Pageable pageable);
    Page<ContratLegal> findByClientId(Long ClientId, Pageable pageable);
    Page<ContratLegal> findByLawyerId(Long LawyerId, Pageable pageable);
    public Page<ContratLegal> findByClientIdAndLawyerId(Long ClientId, Long LawyerId, Pageable pageable);
}
