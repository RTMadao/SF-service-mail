package com.salcedoFawcett.services.mailService.domain.model;

public class ElectronicDocumentEmailInfo {
    private String documentType;
    private String filePath;
    private String fileName;
    private String customer;
    private String customerEmailContact;
    private String emailContact;

    public ElectronicDocumentEmailInfo() {}

    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getCustomerEmailContact() {
        return customerEmailContact;
    }
    public void setCustomerEmailContact(String customerEmailContact) {
        this.customerEmailContact = customerEmailContact;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public String getEmailContact() {
        return emailContact;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
