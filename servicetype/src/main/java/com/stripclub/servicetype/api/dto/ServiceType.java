package com.stripclub.servicetype.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceType {
    private Boolean gender;
    private String serviceType;
    private int servicePrice;
}
