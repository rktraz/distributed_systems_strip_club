package com.stripclub.servicetype.repo;

import com.stripclub.servicetype.repo.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
