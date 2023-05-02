package com.smartagilify.baseinfo.repositories;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseInfoDetailRepository extends JpaRepository<BaseInfoDetail, Long> {
    List<BaseInfoDetail> findBaseInfoDetailByBaseInfo_IdOrderByCreateDateDesc(Long baseInfoId);

}
