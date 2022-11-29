package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.dto.DeviceService;
import com.ninjaone.backendinterviewproject.service.DeviceServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/device-services")
public class DeviceServiceController {

    private final DeviceServiceManager deviceServiceManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceService create(@RequestBody DeviceService deviceService) {
        return deviceServiceManager.create(deviceService);
    }

    @DeleteMapping("/{deviceServiceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long deviceServiceId) {
        deviceServiceManager.delete(deviceServiceId);
    }
}
