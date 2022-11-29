package com.ninjaone.backendinterviewproject.mapper;

import com.ninjaone.backendinterviewproject.dto.Device;
import com.ninjaone.backendinterviewproject.model.DeviceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceEntity toEntity(Device dto);
    Device toDto(DeviceEntity entity);
}
