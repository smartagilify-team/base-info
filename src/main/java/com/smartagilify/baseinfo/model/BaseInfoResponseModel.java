package com.smartagilify.baseinfo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInfoResponseModel {
    private Long id;
    private String title;
    private Long code;
    private String icon;
}
