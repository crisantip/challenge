package com.ninjaone.backendinterviewproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "invoice_detail")
public class InvoiceDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private InvoiceEntity invoice;

    @OneToOne
    @JoinColumn(name = "device_service_id")
    private DeviceServiceEntity deviceService;

    private Integer quantity;
}
