package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.core.model.InputDTO;

import java.util.List;

public interface BaseInfoDetailService {
    BaseInfoDetail save(InputDTO<BaseInfoDetailDTO> dto);

    List<BaseInfoDetailDTO> findAllByBaseInfoId(Long baseInfoId);

    List<BaseInfoDetailDTO> findAllChild(Long baseEntityInfoId);
}
