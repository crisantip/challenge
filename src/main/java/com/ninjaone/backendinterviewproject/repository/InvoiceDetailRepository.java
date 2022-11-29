package com.ninjaone.backendinterviewproject.repository;

import com.ninjaone.backendinterviewproject.model.InvoiceDetailEntity;
import com.ninjaone.backendinterviewproject.model.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetailEntity, Long> {

    List<InvoiceDetailEntity> findByDeviceServiceId(Long deviceServiceId);
}
