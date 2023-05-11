package com.smartagilify.baseinfo.controllers;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.mappers.BaseInfoDetailMapper;
import com.smartagilify.baseinfo.services.BaseInfoDetailService;
import com.smartagilify.core.controllers.BaseController;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.model.ResultDTO;
import com.smartagilify.core.services.BaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(RestAddress.BASE_INFO_DETAIL)
public class BaseInfoDetailController extends BaseController<BaseInfoDetail, BaseInfoDetailMapper, BaseInfoDetailDTO> {

    private final BaseInfoDetailService baseInfoDetailService;

    public BaseInfoDetailController(BaseService<BaseInfoDetail, BaseInfoDetailMapper, BaseInfoDetailDTO> service, BaseInfoDetailService baseInfoDetailService) {
        super(service);
        this.baseInfoDetailService = baseInfoDetailService;
    }

    @ApiOperation(value = "Save a base info detail"
            , notes = "This api will save base info detail")
    @ApiResponses(
            {
                    @ApiResponse(code = 201, message = "successful"),
                    @ApiResponse(code = 500, message = "internal error")
            }
    )
    @Override
    public ResponseEntity<ResultDTO<BaseInfoDetailDTO>> save(@RequestBody
                                                             @ApiParam(value = "Input dto included a base info detail data "
                                                                     , required = true)
                                                             InputDTO<BaseInfoDetailDTO> dto) {
        BaseInfoDetailDTO res = baseInfoDetailService.save(dto);
        return new ResponseEntity(ResultDTO.<BaseInfoDetailDTO>builder().resultList(Collections.singletonList(res)).message("CREATED").build(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Find all base Info detail by their base info id"
            , notes = "This api will return you all of base info detail that are belong to a base info just by base info id")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "successful"),
                    @ApiResponse(code = 500, message = "internal error")
            }
    )
    @GetMapping({RestAddress.FIND_ALL_BY_BASE_INFO_ID})
    public ResponseEntity<ResultDTO<BaseInfoDetailDTO>> findAllByBaseInfoId(@PathVariable
                                                                            @ApiParam(value = "Base info Id", required = true)
                                                                            Long baseInfoId) {
        List<BaseInfoDetailDTO> all = baseInfoDetailService.findAllByBaseInfoId(baseInfoId);
        return new ResponseEntity(ResultDTO.<BaseInfoDetailDTO>builder().resultList(all).message("FIND ALL SUCCESSFULLY").build(), HttpStatus.OK);
    }

    @ApiOperation(value = "Find all child of a base info detail"
            , notes = "This api will return all of child of a base info detail, base info details are related to each other recurceivly")
    @ApiResponses(
            {
                    @ApiResponse(code = 201, message = "successful"),
                    @ApiResponse(code = 500, message = "internal error")
            }
    )
    @GetMapping(RestAddress.FIND_ALL_CHILD)
    public ResponseEntity<ResultDTO<BaseInfoDetailDTO>> findAllChild(@PathVariable
                                                                     @ApiParam(value = "Id of base info detail", required = true)
                                                                     Long baseInfoEntityId) {
        List<BaseInfoDetailDTO> allChild = baseInfoDetailService.findAllChild(baseInfoEntityId);
        return new ResponseEntity(ResultDTO.<BaseInfoDetailDTO>builder().resultList(allChild).message("FIND ALL SUCCESSFULLY").build(), HttpStatus.OK);
    }

    @ApiOperation(value = "Find base info detail by its code"
            , notes = "This api will return a base info by its code")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "successful"),
                    @ApiResponse(code = 500, message = "internal error")
            }
    )
    @GetMapping(RestAddress.FIND_BY_CODE)
    public ResponseEntity<ResultDTO<BaseInfoDetailDTO>> findByCode(@PathVariable
                                                                   @ApiParam(value = "Code of base info detail", required = true)
                                                                   String code) {
        BaseInfoDetailDTO res = baseInfoDetailService.findByCode(code);
        return new ResponseEntity(ResultDTO.<BaseInfoDetailDTO>builder().resultList(Collections.singletonList(res)).message("FIND ALL SUCCESSFULLY").build(), HttpStatus.OK);
    }
}
