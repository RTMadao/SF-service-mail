package com.salcedoFawcett.services.mailService.domain.model;

public class Customer {
    private int id;
    private String registrationName;
    private PartyIdentification partyIdentification;

    public Customer() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public PartyIdentification getPartyIdentification() {
        return partyIdentification;
    }

    public void setPartyIdentification(PartyIdentification partyIdentification) {
        this.partyIdentification = partyIdentification;
    }
}
