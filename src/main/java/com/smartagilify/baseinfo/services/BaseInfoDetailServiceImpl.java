package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.mappers.BaseInfoDetailMapper;
import com.smartagilify.baseinfo.repositories.BaseInfoDetailRepository;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.core.enumerations.EN_STATE;
import com.smartagilify.core.exceptions.BusinessException;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.services.BaseService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BaseInfoDetailServiceImpl extends BaseService<BaseInfoDetail, BaseInfoDetailMapper, BaseInfoDetailDTO> implements BaseInfoDetailService {

    private final BaseInfoDetailRepository baseInfoDetailRepository;
    private final BaseInfoRepository baseInfoRepository;

    public BaseInfoDetailServiceImpl(JpaRepository<BaseInfoDetail, Long> jpaRepository, BaseInfoDetailRepository baseInfoDetailRepository, BaseInfoRepository baseInfoRepository) {
        super(jpaRepository);
        this.baseInfoDetailRepository = baseInfoDetailRepository;
        this.baseInfoRepository = baseInfoRepository;
    }

    @Override
    protected Class<BaseInfoDetailMapper> getMapper() {
        return BaseInfoDetailMapper.class;
    }

    @Override
    public BaseInfoDetailDTO save(InputDTO<BaseInfoDetailDTO> dto) {

        BaseInfoDetail entity = mapper.dto2Entity(dto.getData());
        Optional<BaseInfo> baseInfoEntity = baseInfoRepository.findById(entity.getBaseInfo().getId());
        if (!baseInfoEntity.isPresent()) {
            throw new BusinessException("Can not find base info.");
        }
        entity.setBaseInfo(baseInfoEntity.get());

        if (entity.getParent().getId() == null)
            entity.setParent(null);
        else {
            Optional<BaseInfoDetail> parentBaseInfoDetailEntity = baseInfoDetailRepository.findById(entity.getParent().getId());
            if (!parentBaseInfoDetailEntity.isPresent()) {
                throw new BusinessException("Can not parent base info detail.");
            }
            entity.setParent(parentBaseInfoDetailEntity.get());
        }
        entity.setState(EN_STATE.CREATED);
        entity.setCreateById(dto.getUserId());
        entity.setCreateDate(LocalDateTime.now());
        BaseInfoDetail save = baseInfoDetailRepository.save(entity);
        return mapper.entity2Dto(save);
    }

    @Override
    public List<BaseInfoDetailDTO> findAllByBaseInfoId(Long baseInfoId) {
        List<BaseInfoDetail> rea = baseInfoDetailRepository.findBaseInfoDetailByBaseInfo_IdOrderByCreateDateDesc(baseInfoId);
        List<BaseInfoDetailDTO> baseInfoDetailDTOS = Mappers.getMapper(BaseInfoDetailMapper.class).entity2Dto(rea);
        return baseInfoDetailDTOS;
    }

    @Override
    public List<BaseInfoDetailDTO> findAllChild(Long baseEntityInfoId) {

        Optional<BaseInfoDetail> infoDetail = baseInfoDetailRepository.findById(baseEntityInfoId);
        if (infoDetail.isPresent())
            return mapper.entity2Dto(infoDetail.get().getChildren());
        return null;
    }

    @Override
    public BaseInfoDetailDTO findByCode(String code) {
        Optional<BaseInfoDetail> baseInfoDetail = baseInfoDetailRepository.findByCode(code);
        if (!baseInfoDetail.isPresent()) throw new BusinessException("cannot find base info with this code.");
        return mapper.entity2Dto(baseInfoDetail.get());
    }

}
