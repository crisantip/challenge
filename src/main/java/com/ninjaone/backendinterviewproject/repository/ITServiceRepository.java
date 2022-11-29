package com.ninjaone.backendinterviewproject.repository;

import com.ninjaone.backendinterviewproject.model.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITServiceRepository extends CrudRepository<ServiceEntity, Long> {

    ServiceEntity findByNameEqualsIgnoreCase(String name);
}
