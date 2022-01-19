package com.stripclub.servicetype.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "servicetype", schema = "servicetype")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_service;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "service_price")
    private int servicePrice;

    public Long getId_service() {
        return id_service;
    }

    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }
    public ServiceType(){

    }
    public ServiceType(Boolean gender, String serviceType, int servicePrice) {
        this.gender = gender;
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
    }
}