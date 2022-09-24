package com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.repository;

import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.model.MailMessages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailMessagesRepository extends JpaRepository<MailMessages, Long> {
    public Page<MailMessages> findById (Long Id, Pageable pageable);
    Page<MailMessages> findByContratLegalId (Long contratLegalId, Pageable pageable);
}
