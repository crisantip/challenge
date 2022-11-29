package com.ninjaone.backendinterviewproject.repository;

import com.ninjaone.backendinterviewproject.model.DeviceServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceServiceRepository extends CrudRepository<DeviceServiceEntity, Long> {}
