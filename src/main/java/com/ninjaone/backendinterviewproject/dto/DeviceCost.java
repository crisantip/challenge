package com.ninjaone.backendinterviewproject.dto;

import lombok.Data;

@Data
public class DeviceCost extends Device {

    private Integer quantity;
    private Double cost;
    private Double totalDeviceCost = 0.0;
}
