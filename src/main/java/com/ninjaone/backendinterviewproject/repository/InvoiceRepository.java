package com.ninjaone.backendinterviewproject.repository;

import com.ninjaone.backendinterviewproject.model.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {

    InvoiceEntity findByCustomerId(String customerId);
}
