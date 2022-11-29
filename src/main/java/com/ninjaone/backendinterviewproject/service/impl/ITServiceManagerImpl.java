package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.dto.ITService;
import com.ninjaone.backendinterviewproject.mapper.ITServiceMapper;
import com.ninjaone.backendinterviewproject.model.ServiceEntity;
import com.ninjaone.backendinterviewproject.repository.ITServiceRepository;
import com.ninjaone.backendinterviewproject.service.ITServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ITServiceManagerImpl implements ITServiceManager {

    private final ITServiceRepository itServiceRepository;
    private final ITServiceMapper itServiceMapper;

    @Override
    public ITService create(ITService itService) {

        ServiceEntity serviceEntity = itServiceRepository.findByNameEqualsIgnoreCase(itService.getName());
        if(serviceEntity != null) {
            throw new RuntimeException("Service already exists");
        }
        serviceEntity = itServiceMapper.toEntity(itService);
        ServiceEntity savedServiceEntity = itServiceRepository.save(serviceEntity);
        return itServiceMapper.toDto(savedServiceEntity);
    }

    @Override
    public void delete(Long deviceId) {
        itServiceRepository.deleteById(deviceId);
    }
}
