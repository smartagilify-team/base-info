package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailRequestDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.mappers.BaseInfoDetailMapper;
import com.smartagilify.baseinfo.repositories.BaseInfoDetailRepository;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.services.BaseService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BaseInfoDetailServiceImpl extends BaseService<BaseInfoDetail> implements BaseInfoDetailService {

    private final BaseInfoDetailRepository baseInfoDetailRepository;
    private final BaseInfoRepository baseInfoRepository;

    public BaseInfoDetailServiceImpl(JpaRepository<BaseInfoDetail, Long> jpaRepository, BaseInfoDetailRepository baseInfoDetailRepository, BaseInfoRepository baseInfoRepository) {
        super(jpaRepository);
        this.baseInfoDetailRepository = baseInfoDetailRepository;
        this.baseInfoRepository = baseInfoRepository;
    }

    @Override
    public BaseInfoDetail save(InputDTO<BaseInfoDetailRequestDTO> dto) {

        BaseInfoDetail e = Mappers.getMapper(BaseInfoDetailMapper.class).dto2Entity(dto.getData());
        Optional<BaseInfo> byId = baseInfoRepository.findById(e.getBaseInfo().getId());
        e.setBaseInfo(byId.get());
        if (e.getParent().getId() == null)
            e.setParent(null);
        else {
            Optional<BaseInfoDetail> byId1 = baseInfoDetailRepository.findById(e.getParent().getId());
            e.setParent(byId1.get());
        }
        e.setState(EN_STATE.CREATED);
        e.setCreateById(dto.getUserId());
        e.setCreateDate(LocalDateTime.now());
        BaseInfoDetail save = baseInfoDetailRepository.save(e);
        return save;
    }
}
