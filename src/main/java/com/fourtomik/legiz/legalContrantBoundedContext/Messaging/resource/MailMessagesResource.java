package com.fourtomik.legiz.legalContrantBoundedContext.Messaging.resource;

public class MailMessagesResource {
    private Long id;

    private String message;

    public MailMessagesResource() {
    }

    public MailMessagesResource(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public MailMessagesResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MailMessagesResource setMessage(String message) {
        this.message = message;
        return this;
    }
}
