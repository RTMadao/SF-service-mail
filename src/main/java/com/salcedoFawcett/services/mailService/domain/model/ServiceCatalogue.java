package com.salcedoFawcett.services.mailService.domain.model;

public class ServiceCatalogue {
    private String id;
    private String serviceName;

    public ServiceCatalogue() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
