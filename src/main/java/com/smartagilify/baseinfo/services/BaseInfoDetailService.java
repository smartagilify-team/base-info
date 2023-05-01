package com.smartagilify.baseinfo.services;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.smartagilify.baseinfo.dtos.BaseInfoDetailRequestDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.core.model.InputDTO;

public interface BaseInfoDetailService {
    BaseInfoDetail save(InputDTO<BaseInfoDetailRequestDTO> dto);
}
