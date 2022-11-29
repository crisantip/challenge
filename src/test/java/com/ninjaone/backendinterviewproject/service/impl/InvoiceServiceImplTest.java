package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.component.CacheManager;
import com.ninjaone.backendinterviewproject.dto.InvoiceCost;
import com.ninjaone.backendinterviewproject.model.*;
import com.ninjaone.backendinterviewproject.repository.InvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceImplTest {

    public static final String CUSTOMER_ID = "123";

    @InjectMocks
    private InvoiceServiceImpl invoiceService;
    @Mock
    private InvoiceRepository invoiceRepository;
    @Mock
    private CacheManager cacheManager;

    private InvoiceEntity invoiceEntity;

    @BeforeEach
    void setup(){
        buildEntities();
    }

    @Test
    void generateInvoiceReport() {
        when(invoiceRepository.findByCustomerId(CUSTOMER_ID)).thenReturn(invoiceEntity);

        InvoiceCost invoiceCost = invoiceService.generateInvoiceReport(CUSTOMER_ID);
        assertEquals(4, invoiceCost.getServices().size());
        assertEquals(64, invoiceCost.getTotalInvoiceCost());
    }

    private void buildEntities() {

        DeviceEntity windows = buildDeviceEntity(1L, "Windows", "PC01");
        DeviceEntity mac = buildDeviceEntity(2L, "Mac", "PC02");

        ServiceEntity device = buidlServiceEntity(1L, "Device");
        ServiceEntity antivirus = buidlServiceEntity(2L, "Antivirus");
        ServiceEntity backup = buidlServiceEntity(3L, "Backup");
        ServiceEntity screenShare = buidlServiceEntity(4L, "Screen Share");

        invoiceEntity = new InvoiceEntity();
        invoiceEntity.setId(1L);
        invoiceEntity.setCustomerId(CUSTOMER_ID);
        invoiceEntity.setInvoiceDetails(new ArrayList<>());

        InvoiceDetailEntity invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(1L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(1L, windows, device, 4.0));
        invoiceDetailEntity.setQuantity(2);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);

        invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(2L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(2L, mac, device, 4.0));
        invoiceDetailEntity.setQuantity(3);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);

        invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(3L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(3L, windows, antivirus, 5.0));
        invoiceDetailEntity.setQuantity(2);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);

        invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(4L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(4L, mac, antivirus, 7.0));
        invoiceDetailEntity.setQuantity(3);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);

        invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(5L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(5L, windows, backup, 3.0));
        invoiceDetailEntity.setQuantity(1);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);

        invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(6L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(6L, mac, backup, 3.0));
        invoiceDetailEntity.setQuantity(2);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);

        invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(7L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(7L, windows, screenShare, 1.0));
        invoiceDetailEntity.setQuantity(2);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);

        invoiceDetailEntity = new InvoiceDetailEntity();
        invoiceDetailEntity.setId(8L);
        invoiceDetailEntity.setInvoice(invoiceEntity);
        invoiceDetailEntity.setDeviceService(buildDeviceServiceEntity(8L, mac, screenShare, 1.0));
        invoiceDetailEntity.setQuantity(2);
        invoiceEntity.getInvoiceDetails().add(invoiceDetailEntity);
    }

    private static DeviceServiceEntity buildDeviceServiceEntity(Long id, DeviceEntity device, ServiceEntity service, Double cost){
        DeviceServiceEntity deviceServiceEntity = new DeviceServiceEntity();
        deviceServiceEntity.setId(id);
        deviceServiceEntity.setDevice(device);
        deviceServiceEntity.setService(service);
        deviceServiceEntity.setCost(cost);
        return deviceServiceEntity;
    }

    private ServiceEntity buidlServiceEntity(Long id, String deviceName) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setId(id);
        serviceEntity.setName(deviceName);
        return serviceEntity;
    }

    private static DeviceEntity buildDeviceEntity(Long id, String type, String systemName) {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setId(id);
        deviceEntity.setType(type);
        deviceEntity.setSystemName(systemName);
        return deviceEntity;
    }
}