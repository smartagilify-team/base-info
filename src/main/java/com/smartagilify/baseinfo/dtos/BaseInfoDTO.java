package com.smartagilify.baseinfo.dtos;

import com.smartagilify.core.model.BaseDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInfoDTO extends BaseDTO {
    private String title;
    private Long code;
    private String icon;
}
