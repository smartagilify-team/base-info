package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.core.exceptions.BusinessException;
import com.smartagilify.core.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseInfoServiceImpl extends BaseService<BaseInfo> implements BaseInfoService {
    private BaseInfoRepository baseInfoRepository;

    protected BaseInfoServiceImpl(JpaRepository<BaseInfo, Long> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public BaseInfoDTO findByCode(String code) {
        Optional<BaseInfoDTO> baseInfoDTO = baseInfoRepository.findByCode(code);
        if (!baseInfoDTO.isPresent()) throw new BusinessException("cannot find base info with this code.");
        return baseInfoDTO.get();
    }
}
