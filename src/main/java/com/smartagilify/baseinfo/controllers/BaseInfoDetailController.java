package com.smartagilify.baseinfo.controllers;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.mappers.BaseInfoDetailMapper;
import com.smartagilify.baseinfo.services.BaseInfoDetailService;
import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.model.ResultDTO;
import com.smartagilify.core.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api/base-info-detail")
public class BaseInfoDetailController extends BaseController<BaseInfoDetailDTO, BaseInfoDetail, BaseInfoDetailMapper> {

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
    public ResponseEntity<ResultDTO<BaseInfoDetailDTO>> save(@RequestBody InputDTO<BaseInfoDetailDTO> dto) {
        BaseInfoDetail save = baseInfoDetailService.save(dto);
        return new ResponseEntity(ResultDTO.<BaseInfoDetailDTO>builder().resultList(Collections.singletonList((BaseInfoDetailDTO) this.mapper.entity2Dto(save))).message("CREATED").build(), HttpStatus.CREATED);
    }

    @GetMapping({"/find-all-by-base-info-id/{baseInfoId}"})
    public ResponseEntity<ResultDTO<BaseInfoDetailDTO>> findAllByBaseInfoId(@PathVariable Long baseInfoId) {
        List<BaseInfoDetailDTO> all = baseInfoDetailService.findAllByBaseInfoId(baseInfoId);
        return new ResponseEntity(ResultDTO.<BaseInfoDetailDTO>builder().resultList(all).message("FIND ALL SUCCESSFULLY").build(), HttpStatus.OK);
    }

    @GetMapping({"/find-all-child/{baseInfoEntityId}"})
    public ResponseEntity<ResultDTO<BaseInfoDetailDTO>> findAllChild(@PathVariable Long baseInfoEntityId) {
        List<BaseInfoDetailDTO> allChild = baseInfoDetailService.findAllChild(baseInfoEntityId);
        return new ResponseEntity(ResultDTO.<BaseInfoDetailDTO>builder().resultList(allChild).message("FIND ALL SUCCESSFULLY").build(), HttpStatus.OK);
    }
}
