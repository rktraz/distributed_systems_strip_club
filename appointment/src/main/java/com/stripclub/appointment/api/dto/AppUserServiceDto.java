package com.stripclub.appointment.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppUserServiceDto {
    private long idUser;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private long idService;
    private String serviceType;
    private int servicePrice;
    private long status;


    public AppUserServiceDto(long idUser, String firstname, String lastname, String phoneNumber, long idService,
                             String serviceType, int servicePrice,long status) {
        this.idUser = idUser;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.idService = idService;
        this.serviceType = serviceType;
        this.servicePrice= servicePrice;
        this.status = status;


    }
}
