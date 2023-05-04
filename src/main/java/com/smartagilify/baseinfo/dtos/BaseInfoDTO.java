package com.smartagilify.baseinfo.dtos;

import com.smartagilify.core.model.BaseDTO;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseInfoDTO extends BaseDTO {
    private String title;
    private String code;
    private String icon;

}
