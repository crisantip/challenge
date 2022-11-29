package com.ninjaone.backendinterviewproject.mapper;

import com.ninjaone.backendinterviewproject.dto.DeviceService;
import com.ninjaone.backendinterviewproject.model.DeviceServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { DeviceMapper.class, ITServiceMapper.class })
public interface DeviceServiceMapper {

    DeviceServiceEntity toEntity(DeviceService dto);
    DeviceService toDto(DeviceServiceEntity entity);
}
