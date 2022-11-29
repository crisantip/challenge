package com.ninjaone.backendinterviewproject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ServiceCost extends ITService {

    private Double totalServiceCost = 0.0;
    List<DeviceCost> devices = new ArrayList<>();
}
