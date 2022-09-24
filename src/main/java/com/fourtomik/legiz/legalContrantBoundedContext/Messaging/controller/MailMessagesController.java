package com.fourtomik.legiz.legalContrantBoundedContext.Messaging.controller;

import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.model.MailMessages;
import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.domain.service.MailMessagesService;
import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.resource.MailMessagesResource;
import com.fourtomik.legiz.legalContrantBoundedContext.Messaging.resource.SaveMailMessagesResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MailMessagesController {
    @Autowired
    private MailMessagesService mailMessagesService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Create Mail Messages", description="Create Mail Messages", tags={"mail_messages"})
    @PostMapping("/contralLegal/{contratLegalId}/mail_message")
    public MailMessagesResource createMailMessages(
            @PathVariable Long contratLegalId,
            @Valid @RequestBody SaveMailMessagesResource resource) {
        return convertToResource(mailMessagesService.createMailMessages(contratLegalId,convertToEntity(resource)));
    }

    @Operation(summary="Delete Mail Messages by client Id", description="Delete Mail Messages by Contrlegal", tags={"mail_messages"})
    @DeleteMapping("/contralLegal/{contratLegalId}/mail_message/")
    public ResponseEntity<?> deleteMailMessages(
            @PathVariable Long contratLegalId,
            @PathVariable Long mailMessagesId) {
        return mailMessagesService.deleteMailMessages(contratLegalId, mailMessagesId );
    }

    @Operation(summary="Update Mail Messge by Client Id", description="Update Mail Messge by Client Id", tags={"mail_messages"})
    @PutMapping("/contralLegal/{contratLegalId}/mail_message/{mail_messageId}")
    public MailMessagesResource updatePlanClient(
            @PathVariable Long contratLegalId,
            @PathVariable Long mail_messageId,
            @Valid @RequestBody SaveMailMessagesResource resource) {
        return convertToResource(mailMessagesService.updateMailMessages(mail_messageId, contratLegalId, convertToEntity(resource)));
    }

    @Operation(summary = "Get All Plan Mail Messages", description = "Get All Mail Messages", tags = {"mail_messages"})
    @GetMapping("/mail_message")
    public Page<MailMessagesResource> getAllPlanMailMessages(Pageable pageable){
        Page<MailMessages> mailMessagesPage = mailMessagesService.getAllMailMessages(pageable);
        List<MailMessagesResource> resources = mailMessagesPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    private MailMessages convertToEntity(SaveMailMessagesResource resource){
        return mapper.map(resource, MailMessages.class);
    }

    private MailMessagesResource convertToResource(MailMessages entity){
        return mapper.map(entity,MailMessagesResource.class);
    }
}
