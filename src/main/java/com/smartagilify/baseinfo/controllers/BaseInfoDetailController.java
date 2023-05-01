package com.smartagilify.baseinfo.controllers;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailRequestDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.mappers.BaseInfoDetailMapper;
import com.smartagilify.baseinfo.services.BaseInfoDetailService;
import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.model.BaseDTO;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.model.ResultDTO;
import com.smartagilify.core.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/api/base-info-detail")
public class BaseInfoDetailController extends BaseController<BaseInfoDetailRequestDTO, BaseInfoDetail, BaseInfoDetailMapper> {

    @Autowired
    private final BaseInfoDetailService baseInfoDetailService;

    public BaseInfoDetailController(BaseService<BaseInfoDetail> service, BaseInfoDetailService baseInfoDetailService) {
        super(service);
        this.baseInfoDetailService = baseInfoDetailService;
    }

    @Override
    protected Class<BaseInfoDetailMapper> getMapper() {
        return BaseInfoDetailMapper.class;
    }

    @Override
    public ResponseEntity<ResultDTO<BaseInfoDetailRequestDTO>> save(@RequestBody InputDTO<BaseInfoDetailRequestDTO> dto) {
        BaseInfoDetail save = baseInfoDetailService.save(dto);
        return new ResponseEntity(ResultDTO.builder().resultList(Collections.singletonList((BaseDTO) this.mapper.entity2Dto(save))).message("CREATED").build(), HttpStatus.CREATED);
    }
}
