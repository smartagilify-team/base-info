package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.mappers.BaseInfoMapper;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.core.exceptions.BusinessException;
import com.smartagilify.core.mappers.BaseMapper;
import com.smartagilify.core.services.BaseService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseInfoServiceImpl extends BaseService<BaseInfo, BaseInfoMapper, BaseInfoDTO> implements BaseInfoService {
    private BaseInfoRepository baseInfoRepository;

    @Override
    protected Class getMapper() {
        return BaseInfoMapper.class;
    }

    protected BaseInfoServiceImpl(JpaRepository<BaseInfo, Long> jpaRepository, BaseInfoRepository baseInfoRepository) {
        super(jpaRepository);
        this.baseInfoRepository = baseInfoRepository;
    }

    @Override
    public BaseInfoDTO findByCode(String code) {
        Optional<BaseInfo> baseInfo = baseInfoRepository.findByCode(code);
        if (!baseInfo.isPresent()) throw new BusinessException("cannot find base info with this code.");
        return (BaseInfoDTO) mapper.entity2Dto(baseInfo.get());
    }

}
