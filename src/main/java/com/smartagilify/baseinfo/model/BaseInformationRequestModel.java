package com.smartagilify.baseinfo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInformationRequestModel {
    private String title;
    private Long code;
    private String icon;
}
