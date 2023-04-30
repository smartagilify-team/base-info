package com.smartagilify.baseinfo.mappers;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailRequestDTO;
import com.smartagilify.baseinfo.dtos.BaseInfoRequestDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.core.mappers.BaseMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;

@Mapper(componentModel = "spring")
public interface BaseInfoDetailMapper extends BaseMapper<BaseInfoDetailRequestDTO, BaseInfoDetail> {
    @Override
    @Mapping(source = "baseInfoId", target = "baseInfo.id")
    @Mapping(source = "parentId", target = "parent.id")
    BaseInfoDetail dto2Entity(BaseInfoDetailRequestDTO arg);



    @Override
    @InheritInverseConfiguration
    BaseInfoDetailRequestDTO entity2Dto(BaseInfoDetail entity);

}
