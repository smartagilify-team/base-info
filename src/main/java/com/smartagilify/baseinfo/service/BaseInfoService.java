package com.smartagilify.baseinfo.service;

import com.smartagilify.baseinfo.model.BaseInfoRequestModel;
import com.smartagilify.baseinfo.model.BaseInfoResponseModel;

import java.util.List;

public interface BaseInfoService {
    BaseInfoResponseModel save(BaseInfoRequestModel baseInfoRequestModel);

    List<BaseInfoResponseModel> getBaseInfos();
}
