package com.smartagilify.baseinfo.repositories;

import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseInfoDetailRepository extends JpaRepository<BaseInfoDetail, Long> {
}
