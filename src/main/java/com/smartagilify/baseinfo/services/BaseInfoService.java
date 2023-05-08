package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;

public interface BaseInfoService {
    BaseInfoDTO findByCode(String code);
}
