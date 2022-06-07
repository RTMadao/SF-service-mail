package com.salcedoFawcett.services.mailService.domain.model;

public class Contact {
    private int id;
    private String name;
    private String electronicMail;

    public Contact() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElectronicMail() {
        return electronicMail;
    }

    public void setElectronicMail(String electronicMail) {
        this.electronicMail = electronicMail;
    }
}
