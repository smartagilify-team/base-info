package com.smartagilify.baseinfo.controller;

import com.smartagilify.baseinfo.model.BaseInfoRequestModel;
import com.smartagilify.baseinfo.model.BaseInfoResponseModel;
import com.smartagilify.baseinfo.service.BaseInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/base-info")
public class BaseInfoController {
    private final BaseInfoService baseInfoService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseInfoResponseModel saveBaseInfo(@RequestBody BaseInfoRequestModel baseInfoRequestModel){
        return baseInfoService.save(baseInfoRequestModel);
    }

    @GetMapping("get-base-infos")
    @ResponseStatus(HttpStatus.OK)
    public List<BaseInfoResponseModel > getBaseInfos (){
        return baseInfoService.getBaseInfos();
    }
}
