package com.salcedoFawcett.services.mailService.domain.model;

public class PartyIdentification {
    private int id;
    private long partyIdentificationId;
    private int partyIdentificationSchemeId;
    private int partyIdentificationSchemeName;
    private String documentTypeName;

    public PartyIdentification() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPartyIdentificationId() {
        return partyIdentificationId;
    }

    public void setPartyIdentificationId(long partyIdentificationId) {
        this.partyIdentificationId = partyIdentificationId;
    }

    public int getPartyIdentificationSchemeId() {
        return partyIdentificationSchemeId;
    }

    public void setPartyIdentificationSchemeId(int partyIdentificationSchemeId) {
        this.partyIdentificationSchemeId = partyIdentificationSchemeId;
    }

    public int getPartyIdentificationSchemeName() {
        return partyIdentificationSchemeName;
    }

    public void setPartyIdentificationSchemeName(int partyIdentificationSchemeName) {
        this.partyIdentificationSchemeName = partyIdentificationSchemeName;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }
}
