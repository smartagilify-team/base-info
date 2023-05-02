package com.smartagilify.baseinfo.controllers;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.mappers.BaseInfoMapper;
import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/base-info")
public class BaseInfoController extends BaseController<BaseInfoDTO, BaseInfo, BaseInfoMapper> {

    public BaseInfoController(BaseService<BaseInfo> service) {
        super(service);
    }

    @Override
    protected Class<BaseInfoMapper> getMapper() {
        return BaseInfoMapper.class;
    }

}
