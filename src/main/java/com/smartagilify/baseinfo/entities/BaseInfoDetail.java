package com.smartagilify.baseinfo.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BI$T_BASE_INFO_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class BaseInfoDetail extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_info_id", referencedColumnName = "id")
    private BaseInfo baseInfo;

    @Column(name = "title")
    private String title;

    @Column(name = "code")
    private Long code;

    @Column(name = "color")
    private String color;

    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BaseInfoDetail> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private BaseInfoDetail parent;

}
