package com.smartagilify.baseinfo.controllers;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.mappers.BaseInfoMapper;
import com.smartagilify.baseinfo.services.BaseInfoService;
import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.model.ResultDTO;
import com.smartagilify.core.services.BaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping(RestAddress.BASE_INFO)
public class BaseInfoController extends BaseController<BaseInfo, BaseInfoMapper, BaseInfoDTO> {
    private BaseInfoService baseInfoService;

    public BaseInfoController(BaseService<BaseInfo, BaseInfoMapper, BaseInfoDTO> service, BaseInfoService baseInfoService) {
        super(service);
        this.baseInfoService = baseInfoService;
    }

    @ApiOperation(value = "Find base info by its code", notes = "This api will return a base info data by its code")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @RequestMapping(RestAddress.FIND_BY_CODE)
    public ResponseEntity<BaseInfoDTO> findByCode(@PathVariable
                                                  @ApiParam(value = "Code of baseinfo", required = true)
                                                  String code) {
        BaseInfoDTO res = baseInfoService.findByCode(code);
        return new ResponseEntity(ResultDTO.<BaseInfoDTO>builder().resultList(Collections.singletonList(res)).message("FIND ALL SUCCESSFULLY").build(), HttpStatus.OK);
    }

}
