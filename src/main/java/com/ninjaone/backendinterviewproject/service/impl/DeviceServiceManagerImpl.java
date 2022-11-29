package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.component.CacheManager;
import com.ninjaone.backendinterviewproject.dto.DeviceService;
import com.ninjaone.backendinterviewproject.dto.Status;
import com.ninjaone.backendinterviewproject.mapper.DeviceServiceMapper;
import com.ninjaone.backendinterviewproject.model.DeviceServiceEntity;
import com.ninjaone.backendinterviewproject.model.InvoiceDetailEntity;
import com.ninjaone.backendinterviewproject.repository.DeviceServiceRepository;
import com.ninjaone.backendinterviewproject.repository.InvoiceDetailRepository;
import com.ninjaone.backendinterviewproject.service.DeviceServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeviceServiceManagerImpl implements DeviceServiceManager {

    private final DeviceServiceRepository deviceServiceRepository;
    private final InvoiceDetailRepository invoiceDetailRepository;
    private final DeviceServiceMapper deviceServiceMapper;

    private final CacheManager cacheManager;

    @Override
    public DeviceService create(DeviceService deviceService) {

        DeviceServiceEntity deviceServiceEntity = deviceServiceMapper.toEntity(deviceService);
        deviceServiceEntity.setStatus(Status.ACTIVE);
        DeviceServiceEntity savedDeviceServiceEntity = deviceServiceRepository.save(deviceServiceEntity);
        cacheManager.clearCache();
        return deviceServiceMapper.toDto(savedDeviceServiceEntity);
    }

    @Override
    public void delete(Long deviceServiceId) {
        deleteInvoiceDetailReferences(deviceServiceId);
        deviceServiceRepository.deleteById(deviceServiceId);
    }

    private void deleteInvoiceDetailReferences(Long deviceServiceId) {
        List<InvoiceDetailEntity> invoiceDetails = invoiceDetailRepository.findByDeviceServiceId(deviceServiceId);
        for (InvoiceDetailEntity invoiceDetail :
                invoiceDetails) {
            invoiceDetailRepository.deleteById(invoiceDetail.getId());
        }
    }
}
