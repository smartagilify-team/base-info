package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailRequestDTO;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.core.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BaseInfoDetailServiceImpl extends BaseService<BaseInfoDetail> implements BaseInfoDetailService {

    public BaseInfoDetailServiceImpl(JpaRepository<BaseInfoDetail, Long> jpaRepository) {
        super(jpaRepository);
    }

}
