package com.smartagilify.baseinfo.mappers;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.core.mappers.BaseMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BaseInfoDetailMapper extends BaseMapper<BaseInfoDetailDTO, BaseInfoDetail> {
    @Override
    @Mapping(source = "baseInfoId", target = "baseInfo.id")
    @Mapping(source = "parentId", target = "parent.id")
    BaseInfoDetail dto2Entity(BaseInfoDetailDTO arg);

    @Override
    @InheritInverseConfiguration
    BaseInfoDetailDTO entity2Dto(BaseInfoDetail entity);

}
