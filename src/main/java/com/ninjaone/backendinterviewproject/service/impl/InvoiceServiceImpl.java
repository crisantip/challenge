package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.component.CacheManager;
import com.ninjaone.backendinterviewproject.dto.DeviceCost;
import com.ninjaone.backendinterviewproject.dto.InvoiceCost;
import com.ninjaone.backendinterviewproject.dto.ServiceCost;
import com.ninjaone.backendinterviewproject.model.*;
import com.ninjaone.backendinterviewproject.repository.InvoiceRepository;
import com.ninjaone.backendinterviewproject.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CacheManager cacheManager;

    @Override
    public InvoiceCost generateInvoiceReport(String customerId) {

        InvoiceCost invoiceCost = cacheManager.getFromCache(customerId);
        if(invoiceCost != null) {
            return invoiceCost;
        }

        invoiceCost = new InvoiceCost();
        InvoiceEntity invoice = invoiceRepository.findByCustomerId(customerId);
        invoiceCost.setCustomerId(invoice.getCustomerId());
        List<InvoiceDetailEntity> invoiceDetails = invoice.getInvoiceDetails();
        for (InvoiceDetailEntity invoiceDetail: invoiceDetails) {

            DeviceServiceEntity deviceService = invoiceDetail.getDeviceService();
            double totalDeviceCost = deviceService.getCost() * invoiceDetail.getQuantity();

            ServiceEntity service = deviceService.getService();
            ServiceCost serviceCost = invoiceCost.getServices().get(service.getId());
            if(serviceCost == null) {
                serviceCost = new ServiceCost();
                serviceCost.setId(service.getId());
                serviceCost.setName(service.getName());
                invoiceCost.getServices().put(service.getId(), serviceCost);
            }

            DeviceEntity device = deviceService.getDevice();
            DeviceCost deviceCost = new DeviceCost();
            deviceCost.setId(device.getId());
            deviceCost.setType(device.getType());
            deviceCost.setSystemName(device.getSystemName());
            deviceCost.setQuantity(invoiceDetail.getQuantity());
            deviceCost.setCost(deviceService.getCost());
            deviceCost.setTotalDeviceCost(totalDeviceCost);
            serviceCost.getDevices().add(deviceCost);

            serviceCost.setTotalServiceCost(serviceCost.getTotalServiceCost() + totalDeviceCost);
            invoiceCost.setTotalInvoiceCost(invoiceCost.getTotalInvoiceCost() + totalDeviceCost);
        }
        cacheManager.addToCache(invoiceCost);
        return invoiceCost;
    }

}
