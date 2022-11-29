package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.dto.ITService;

public interface ITServiceManager {

    ITService create(ITService service);

    void delete(Long serviceId);
}
