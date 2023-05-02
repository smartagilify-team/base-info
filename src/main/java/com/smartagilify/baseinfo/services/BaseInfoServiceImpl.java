package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.core.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BaseInfoServiceImpl extends BaseService<BaseInfo> implements BaseInfoService {
    protected BaseInfoServiceImpl(JpaRepository<BaseInfo, Long> jpaRepository) {
        super(jpaRepository);
    }
}
