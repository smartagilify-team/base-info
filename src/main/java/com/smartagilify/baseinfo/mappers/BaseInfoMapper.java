package com.smartagilify.baseinfo.mappers;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.core.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseInfoMapper extends BaseMapper<BaseInfo, BaseInfoDTO> {
}
