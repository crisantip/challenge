package com.ninjaone.backendinterviewproject.model;

import com.ninjaone.backendinterviewproject.dto.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "device_service")
public class DeviceServiceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_service_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="device_id")
    private DeviceEntity device;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="service_id")
    private ServiceEntity service;

    private Double cost;

    private Status status = Status.ACTIVE;
}
