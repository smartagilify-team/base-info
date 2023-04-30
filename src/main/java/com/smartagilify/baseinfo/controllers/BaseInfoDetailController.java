package com.smartagilify.baseinfo.controllers;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailRequestDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.mappers.BaseInfoDetailMapper;
import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.services.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/base-info-detail")
public class BaseInfoDetailController extends BaseController<BaseInfoDetailRequestDTO, BaseInfoDetail, BaseInfoDetailMapper> {

    public BaseInfoDetailController(BaseService<BaseInfoDetail> service) {
        super(service);
    }

    @Override
    protected Class<BaseInfoDetailMapper> getMapper() {
        return BaseInfoDetailMapper.class;
    }

}
