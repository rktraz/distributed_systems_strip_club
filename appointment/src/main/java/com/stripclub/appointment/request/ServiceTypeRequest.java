package com.stripclub.appointment.request;

import com.stripclub.appointment.api.dto.ServiceType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ServiceTypeRequest {

    private ServiceTypeRequest() {

    }

    private static final String servicetypeService = "http://servicetype:8086";

    public  static ServiceType getServiceTypeById(long idService) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<Long> userRequest = new HttpEntity<>(idService);
        final ResponseEntity<ServiceType> ServiceInfo = restTemplate.exchange(
                servicetypeService + "/servicetypes/" + idService, HttpMethod.GET, userRequest, ServiceType.class);
        return ServiceInfo.getBody();
    }
}
