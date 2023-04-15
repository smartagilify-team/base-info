package com.smartagilify.baseinfo.service;

import com.smartagilify.baseinfo.entity.BaseInformation;
import com.smartagilify.baseinfo.model.BaseInformationRequestModel;
import com.smartagilify.baseinfo.model.BaseInformationResponseModel;
import com.smartagilify.baseinfo.repository.BaseInformationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BaseInformationServiceImpl implements BaseInformationService {
    private final BaseInformationRepository baseInformationRepository;

    @Override
    public BaseInformationResponseModel save(BaseInformationRequestModel baseInformationRequestModel) {
        BaseInformation baseInformation = baseInformationRepository.save(BaseInformation.builder()
                .title(baseInformationRequestModel.getTitle())
                .code(baseInformationRequestModel.getCode())
                .icon(baseInformationRequestModel.getIcon())
                .build());

        return BaseInformationResponseModel.builder()
                .id(baseInformation.getId())
                .title(baseInformation.getTitle())
                .code(baseInformation.getCode())
                .icon(baseInformation.getIcon())
                .build();
    }
}
