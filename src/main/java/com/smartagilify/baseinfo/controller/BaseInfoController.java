package com.smartagilify.baseinfo.controller;

import com.smartagilify.baseinfo.model.BaseInformationRequestModel;
import com.smartagilify.baseinfo.model.BaseInformationResponseModel;
import com.smartagilify.baseinfo.service.BaseInformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/base-info")
public class BaseInfoController {
    private final BaseInformationService baseInformationService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseInformationResponseModel saveBaseInfo(@RequestBody BaseInformationRequestModel  baseInformationRequestModel){
        return baseInformationService.save(baseInformationRequestModel);
    }
}
