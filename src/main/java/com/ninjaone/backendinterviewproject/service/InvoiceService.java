package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.dto.InvoiceCost;

public interface InvoiceService {

    InvoiceCost generateInvoiceReport(String customerId);
}
