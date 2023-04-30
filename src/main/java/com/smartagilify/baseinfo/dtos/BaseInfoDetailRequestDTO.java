package com.smartagilify.baseinfo.dtos;

import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.core.model.BaseDTO;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInfoDetailRequestDTO extends BaseDTO {

    private Long baseInfoId;
    private Long parentId;
    private String title;
    private Long code;
    private String color;
    private String icon;
}