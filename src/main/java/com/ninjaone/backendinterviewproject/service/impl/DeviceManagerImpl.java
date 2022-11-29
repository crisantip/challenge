package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.dto.Device;
import com.ninjaone.backendinterviewproject.mapper.DeviceMapper;
import com.ninjaone.backendinterviewproject.model.DeviceEntity;
import com.ninjaone.backendinterviewproject.repository.DeviceRepository;
import com.ninjaone.backendinterviewproject.service.DeviceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeviceManagerImpl implements DeviceManager {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    @Override
    public Device create(Device device) {

        DeviceEntity deviceEntity = deviceRepository
                .findByTypeEqualsIgnoreCaseAndSystemNameEqualsIgnoreCase(device.getType(), device.getSystemName());
        if(deviceEntity != null) {
            throw new RuntimeException("The device already exists");
        }
        deviceEntity = deviceMapper.toEntity(device);
        DeviceEntity savedDeviceEntity = deviceRepository.save(deviceEntity);
        return deviceMapper.toDto(savedDeviceEntity);
    }

    @Override
    public void delete(Long deviceId) {
        deviceRepository.deleteById(deviceId);
    }
}
