package com.smartagilify.baseinfo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_base_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private Long code;
    private String icon;

}
