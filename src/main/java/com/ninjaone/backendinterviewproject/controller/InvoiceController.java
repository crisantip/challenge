package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.dto.InvoiceCost;
import com.ninjaone.backendinterviewproject.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/{customerId}")
    public InvoiceCost generateInvoiceReport(@PathVariable String customerId) {
        return invoiceService.generateInvoiceReport(customerId);
    }
}
