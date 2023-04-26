package com.smartagilify.baseinfo.service;

import com.smartagilify.baseinfo.entity.BaseInfo;
import com.smartagilify.baseinfo.model.BaseInfoRequestModel;
import com.smartagilify.baseinfo.model.BaseInfoResponseModel;
import com.smartagilify.baseinfo.repository.BaseInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BaseInfoServiceImpl implements BaseInfoService {
    private final BaseInfoRepository baseInfoRepository;

    @Override
    public BaseInfoResponseModel save(BaseInfoRequestModel baseInfoRequestModel) {
        BaseInfo baseInfo = baseInfoRepository.save(BaseInfo.builder()
                .title(baseInfoRequestModel.getTitle())
                .code(baseInfoRequestModel.getCode())
                .icon(baseInfoRequestModel.getIcon())
                .build());

        return BaseInfoResponseModel.builder()
                .id(baseInfo.getId())
                .title(baseInfo.getTitle())
                .code(baseInfo.getCode())
                .icon(baseInfo.getIcon())
                .build();
    }

    @Override
    public List<BaseInfoResponseModel> getBaseInfos() {
        List<BaseInfo> all = baseInfoRepository.findAll();
        List<BaseInfoResponseModel> responseModels = new ArrayList<>();
        all.stream()
                .map(baseInfo -> responseModels
                        .add(new BaseInfoResponseModel(
                                baseInfo.getId(),
                                baseInfo.getTitle(),
                                baseInfo.getCode(),
                                baseInfo.getIcon())));
        return responseModels;
    }
}
