package com.salcedoFawcett.services.mailService.domain.model;

public abstract class Message {

    protected String title;
    protected String addressee;
    protected String htmlTemplate;

    public Message(){}

    public Message(String title, String addressee) {
        this.title = title;
        this.addressee = addressee;
    }

    public String getTitle() {
        return title;
    }

    public abstract void setTitle(String title);

    public String getHtmlTemplate() {
        return htmlTemplate;
    }

    public abstract void setHtmlTemplate();

    public String getAddressee() {
        return addressee;
    }

    public abstract void setAddressee(String addressee);
}
