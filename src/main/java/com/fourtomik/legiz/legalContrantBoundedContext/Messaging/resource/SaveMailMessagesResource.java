package com.fourtomik.legiz.legalContrantBoundedContext.Messaging.resource;

public class SaveMailMessagesResource {
    private String message;

    public SaveMailMessagesResource() {
    }

    public SaveMailMessagesResource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public SaveMailMessagesResource setMessage(String message) {
        this.message = message;
        return this;
    }
}
