package com.ninjaone.backendinterviewproject.mapper;

import com.ninjaone.backendinterviewproject.dto.ITService;
import com.ninjaone.backendinterviewproject.model.ServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITServiceMapper {

    ServiceEntity toEntity(ITService dto);
    ITService toDto(ServiceEntity entity);
}
