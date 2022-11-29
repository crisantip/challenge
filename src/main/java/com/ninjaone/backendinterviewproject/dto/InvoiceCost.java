package com.ninjaone.backendinterviewproject.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class InvoiceCost {

    private String customerId;
    private Map<Long, ServiceCost> services = new HashMap<>();
    private Double totalInvoiceCost = 0.0;

}
