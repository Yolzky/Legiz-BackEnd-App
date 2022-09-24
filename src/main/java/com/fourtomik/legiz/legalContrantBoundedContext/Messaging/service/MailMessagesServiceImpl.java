package com.fourtomik.legiz.legalContrantBoundedContext.Messaging.service;

import com.fourtomik.legiz.exception.ResourceNotFoundException;
import com.fourtomik.legiz.legalContrantBoundedContext.LegalAgreement.domain.repository.ContratLegalRepository;
import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.model.MailMessages;
import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.repository.MailMessagesRepository;
import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.service.MailMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MailMessagesServiceImpl implements MailMessagesService {
    @Autowired
    private ContratLegalRepository contratLegalRepository;

    @Autowired
    private MailMessagesRepository mailMessagesRepository;

    @Override
    public MailMessages createMailMessages(Long contratLegalId, MailMessages mailMessages) {
        return contratLegalRepository.findById(contratLegalId).map(contratLegal -> {
            mailMessages.setContratLegal(contratLegal);
            return mailMessagesRepository.save(mailMessages);
        }).orElseThrow(() -> new ResourceNotFoundException("Contrat Legal","Id", contratLegalId));
    }

    @Override
    public Page<MailMessages> getAllMailMessagesByContratLegalId(Long contratLegalId, Pageable pageable) {
        return mailMessagesRepository.findByContratLegalId(contratLegalId, pageable);
    }
    @Override
    public Page<MailMessages> getAllMailMessages(Pageable pageable) {
        return mailMessagesRepository.findAll(pageable);
    }

    @Override
    public MailMessages updateMailMessages(Long mailMessagesId, Long contratLegalId, MailMessages mailMessagesRequest) {
        if(!contratLegalRepository.existsById(contratLegalId))
            throw new ResourceNotFoundException("Contrat Legal","Id", contratLegalId);

        return mailMessagesRepository.findById(mailMessagesId).map(mailMessages -> {
            mailMessages.setMessage(mailMessagesRequest.getMessage());
            return mailMessagesRepository.save(mailMessages);
        }).orElseThrow(() -> new ResourceNotFoundException("Mail Messages","Id",mailMessagesId));
    }

    @Override
    public ResponseEntity<?> deleteMailMessages(Long contratLegalId, Long mailMessagesId) {
        if(!contratLegalRepository.existsById(contratLegalId))
            throw new ResourceNotFoundException("Contrat Legal","Id", contratLegalId);

        return mailMessagesRepository.findById(mailMessagesId).map(mailMessages -> {
            mailMessagesRepository.delete(mailMessages);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Mail Messages","Id",mailMessagesId));
    }
}
