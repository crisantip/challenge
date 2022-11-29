package com.ninjaone.backendinterviewproject.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DeviceServiceId {
    @NonNull
    private Long deviceId;
    @NonNull
    private Long serviceId;
}
