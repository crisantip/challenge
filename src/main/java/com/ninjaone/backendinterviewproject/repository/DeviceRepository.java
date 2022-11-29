package com.ninjaone.backendinterviewproject.repository;

import com.ninjaone.backendinterviewproject.model.DeviceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<DeviceEntity, Long> {

    DeviceEntity findByTypeEqualsIgnoreCaseAndSystemNameEqualsIgnoreCase(String type, String systemName);
}
