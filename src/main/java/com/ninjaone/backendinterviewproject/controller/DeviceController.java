package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.dto.Device;
import com.ninjaone.backendinterviewproject.service.DeviceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceManager deviceManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device create(@RequestBody Device device) {
        return deviceManager.create(device);
    }

    @DeleteMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long deviceId) {
        deviceManager.delete(deviceId);
    }
}
