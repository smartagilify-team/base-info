package com.smartagilify.baseinfo.repositories;

import com.smartagilify.baseinfo.entities.BaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseInfoRepository extends JpaRepository<BaseInfo, Long> {
}
