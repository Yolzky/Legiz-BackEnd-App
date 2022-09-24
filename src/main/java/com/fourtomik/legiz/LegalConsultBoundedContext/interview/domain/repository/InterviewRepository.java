package com.fourtomik.legiz.LegalConsultBoundedContext.interview.domain.repository;

import com.fourtomik.legiz.LegalConsultBoundedContext.interview.domain.model.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    public Page<Interview> findById (Long Id, Pageable pageable);
    Page<Interview> findByConsultLegalId (Long ConsultLegalId, Pageable pageable);
    Boolean existsByConsultLegalId (Long ConsultLegalId);
}
