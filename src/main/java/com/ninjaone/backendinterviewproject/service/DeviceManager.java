package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.dto.Device;

public interface DeviceManager {

    Device create(Device device);

    void delete(Long deviceId);
}
