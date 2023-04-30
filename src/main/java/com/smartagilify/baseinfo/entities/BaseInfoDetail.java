package com.smartagilify.baseinfo.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BI$T_BASE_INFO_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class BaseInfoDetail extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "base_info_id")
    private BaseInfo baseInfo;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private BaseInfoDetail parent;
    private String title;
    private Long code;
    private String color;
    private String icon;
}
