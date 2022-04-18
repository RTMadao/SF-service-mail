package com.salcedoFawcett.services.mailService.domain.model;

public class EmailStructure {

    protected String to;
    protected String from;
    protected String subject;
    protected String msg;

    public EmailStructure() {
    }

    public void setEmailData(Message msg){
        this.to = msg.getAddressee();
        this.from = "ticket@iconexion.com.co";
        this.subject = msg.getTitle();
        this.msg = msg.getHtmlTemplate();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
