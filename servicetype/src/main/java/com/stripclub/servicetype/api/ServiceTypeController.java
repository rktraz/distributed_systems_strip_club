package com.stripclub.servicetype.api;

import com.stripclub.servicetype.service.ServiceTypeService;
import com.stripclub.servicetype.repo.model.ServiceType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/servicetypes")
public class ServiceTypeController {

    private final ServiceTypeService serviceTypeService;

    @GetMapping
    public ResponseEntity<List<ServiceType>> index() {
        final List<ServiceType> servicetypes = serviceTypeService.fetchAll();
        return ResponseEntity.ok(servicetypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceType> show(@PathVariable long id) {
        try {
            final ServiceType serviceType = serviceTypeService.fetchById(id);
            return ResponseEntity.ok(serviceType);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.stripclub.servicetype.api.dto.ServiceType serviceType) {
        final Boolean gender = serviceType.getGender();
        final String serviceTypeproc = serviceType.getServiceType();
        final int servicePrice = serviceType.getServicePrice();
        final long serviceTypeId = serviceTypeService.create(gender, serviceTypeproc,servicePrice);
        final String serviceTypeUri = String.format("/servicetypes/%d", serviceTypeId);

        return ResponseEntity.created(URI.create(serviceTypeUri)).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> change(@PathVariable long id, @RequestBody com.stripclub.servicetype.api.dto.ServiceType serviceType) {
        final String serviceTypeproc = serviceType.getServiceType();
        try {
            serviceTypeService.updateServiceType(id ,serviceTypeproc );
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        serviceTypeService.deleteServiceType(id);
        return ResponseEntity.noContent().build();
    }
}
