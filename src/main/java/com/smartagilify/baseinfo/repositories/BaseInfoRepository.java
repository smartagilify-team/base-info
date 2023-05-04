package com.smartagilify.baseinfo.repositories;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseInfoRepository extends JpaRepository<BaseInfo, Long> {
    Optional<BaseInfoDTO> findByCode(String code);
}
