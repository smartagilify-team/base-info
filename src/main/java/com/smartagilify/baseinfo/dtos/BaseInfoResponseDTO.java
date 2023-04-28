package com.smartagilify.baseinfo.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInfoResponseDTO {
    private Long id;
    private String title;
    private Long code;
    private String icon;
}
