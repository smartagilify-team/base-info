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
    @Column(name = "title")
    private String title;
    @Column(name = "code")
    private Long code;
    @Column(name = "icon")
    private String icon;

}
