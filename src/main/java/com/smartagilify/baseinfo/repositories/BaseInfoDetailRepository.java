package com.smartagilify.baseinfo.repositories;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseInfoDetailRepository extends JpaRepository<BaseInfoDetail, Long> {
   Optional< BaseInfoDetail> findByCode(String code);
    List<BaseInfoDetail> findBaseInfoDetailByBaseInfo_IdOrderByCreateDateDesc(Long baseInfoId);

}
