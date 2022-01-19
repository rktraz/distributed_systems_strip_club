package com.stripclub.servicetype.service;


import com.stripclub.servicetype.repo.ServiceTypeRepository;
import com.stripclub.servicetype.repo.model.ServiceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ServiceTypeService {
    private final ServiceTypeRepository serviceTypeRepository;

    public List<ServiceType> fetchAll() {
        return serviceTypeRepository.findAll();
    }

    public Long create(Boolean gender, String serviceTypeproc, int servicePrice) throws IllegalArgumentException{

        final ServiceType serviceType = new ServiceType( gender, serviceTypeproc,servicePrice);
        final ServiceType savedServiceType = serviceTypeRepository.save(serviceType);
        return savedServiceType.getId_service();
    }

    public ServiceType fetchById(long id) throws IllegalArgumentException{
        final Optional<ServiceType> maybeServiceType = serviceTypeRepository.findById(id);
        if (maybeServiceType.isEmpty()) throw new IllegalArgumentException("ServiceType not found");
        else return maybeServiceType.get();
    }
    public void updateServiceType(long id_service ,String serviceTypeproc) throws IllegalArgumentException {
        final Optional<ServiceType> maybeServiceType = serviceTypeRepository.findById(id_service);

        if (maybeServiceType.isEmpty())
            throw new IllegalArgumentException("Invalid ServiceType ID");

        final ServiceType serviceType = maybeServiceType.get();
        if (serviceTypeproc != null && !serviceTypeproc.isBlank()) serviceType.setServiceType(serviceTypeproc);
        serviceTypeRepository.save(serviceType);
    }

    public void deleteServiceType(long id) {
        serviceTypeRepository.deleteById(id);
    }
}
