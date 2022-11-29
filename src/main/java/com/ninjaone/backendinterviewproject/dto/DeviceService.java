package com.ninjaone.backendinterviewproject.dto;

import lombok.Data;

@Data
public class DeviceService {

    private Device device;
    private ITService service;
    private Double cost;
    private String status;
}
