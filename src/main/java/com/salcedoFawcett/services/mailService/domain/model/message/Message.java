package com.salcedoFawcett.services.mailService.domain.model.message;

public abstract class Message {

    protected String title;
    protected String addressee;
    protected String htmlTemplate;
    protected boolean attachment;
    protected String attachmentPath;

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
    public abstract boolean isAttachment();
    public abstract String getAttachmentPath();
    public abstract String getFileName();
}
