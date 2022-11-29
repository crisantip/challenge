package com.ninjaone.backendinterviewproject.component;

import com.ninjaone.backendinterviewproject.dto.InvoiceCost;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CacheManager {

    private Map<String, InvoiceCost> cache = new HashMap<>();

    public void addToCache(InvoiceCost invoiceCost) {
        if(cache.get(invoiceCost.getCustomerId()) == null) {
            cache.put(invoiceCost.getCustomerId(), invoiceCost);
        }
    }

    public InvoiceCost getFromCache(String customerId) {
        return cache.get(customerId);
    }

    public void clearCache() {
        cache.clear();
    }
}
