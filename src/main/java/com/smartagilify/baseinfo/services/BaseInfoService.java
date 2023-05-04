package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;

public interface BaseInfoService {
    public BaseInfoDTO findByCode(String code);
}
