package com.smartagilify.baseinfo.controllers;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.mappers.BaseInfoMapper;
import com.smartagilify.baseinfo.services.BaseInfoService;
import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.model.BaseDTO;
import com.smartagilify.core.model.ResultDTO;
import com.smartagilify.core.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/base-info")
public class BaseInfoController extends BaseController<BaseInfoDTO, BaseInfo, BaseInfoMapper> {
    private BaseInfoService baseInfoService;

    public BaseInfoController(BaseService<BaseInfo> service, BaseInfoService baseInfoService) {
        super(service);
        this.baseInfoService = baseInfoService;
    }

    @Override
    protected Class<BaseInfoMapper> getMapper() {
        return BaseInfoMapper.class;
    }

    @RequestMapping("/find-by-code/{code}")
    public ResponseEntity<BaseInfoDTO> findByCode(@PathVariable String code) {
        BaseInfoDTO res = baseInfoService.findByCode(code);
        return new ResponseEntity(ResultDTO.<BaseInfoDTO>builder().resultList(Collections.singletonList(res)).message("FIND ALL SUCCESSFULLY").build(), HttpStatus.OK);
    }

}
