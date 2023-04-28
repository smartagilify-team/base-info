package com.smartagilify.baseinfo.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_base_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInfo extends BaseEntity {
    private String title;
    private Long code;
    private String icon;

}
