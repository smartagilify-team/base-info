package com.smartagilify.baseinfo.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "BI$T_BASE_INFO")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

public class BaseInfo extends BaseEntity {
    private String title;
    private Long code;
    private String icon;

}
