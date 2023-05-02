package com.smartagilify.baseinfo.dtos;

import com.smartagilify.core.model.BaseDTO;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInfoDetailDTO extends BaseDTO {
    private Long baseInfoId;
    private Long parentId;
    private String title;
    private Long code;
    private String color;
    private String icon;
}