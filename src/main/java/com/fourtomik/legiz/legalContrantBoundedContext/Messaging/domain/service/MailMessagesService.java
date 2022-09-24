package com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.service;

import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.model.MailMessages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MailMessagesService {
    MailMessages createMailMessages(Long contratLegalId, MailMessages mailMessages);
    Page<MailMessages> getAllMailMessagesByContratLegalId(Long contratLegalId, Pageable pageable);
    Page<MailMessages> getAllMailMessages(Pageable pageable);
    MailMessages updateMailMessages(Long mailMessagesId, Long contratLegalId, MailMessages mailMessagesRequest);
    ResponseEntity<?> deleteMailMessages(Long contratLegalId, Long mailMessagesId);
}
