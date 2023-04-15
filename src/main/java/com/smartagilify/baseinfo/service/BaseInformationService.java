package com.smartagilify.baseinfo.service;

import com.smartagilify.baseinfo.model.BaseInformationRequestModel;
import com.smartagilify.baseinfo.model.BaseInformationResponseModel;

public interface BaseInformationService {
    BaseInformationResponseModel save(BaseInformationRequestModel baseInformationRequestModel);
}
