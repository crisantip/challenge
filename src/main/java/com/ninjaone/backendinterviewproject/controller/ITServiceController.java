package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.dto.ITService;
import com.ninjaone.backendinterviewproject.service.ITServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/services")
public class ITServiceController {

    private final ITServiceManager itServiceManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ITService create(@RequestBody ITService itService) {
        return itServiceManager.create(itService);
    }

    @DeleteMapping("/{serviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long serviceId) {
        itServiceManager.delete(serviceId);
    }
}
