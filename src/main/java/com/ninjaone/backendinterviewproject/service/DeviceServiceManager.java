package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.dto.DeviceService;

public interface DeviceServiceManager {

    DeviceService create(DeviceService deviceService);

    void delete(Long deviceServiceId);
}
