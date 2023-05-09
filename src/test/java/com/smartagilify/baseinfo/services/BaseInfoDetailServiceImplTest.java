package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.mappers.BaseInfoDetailMapper;
import com.smartagilify.baseinfo.repositories.BaseInfoDetailRepository;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.core.enumerations.EN_ACTION_TYPE;
import com.smartagilify.core.model.InputDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BaseInfoDetailServiceImplTest {

    @InjectMocks
    private BaseInfoDetailServiceImpl service;
    @Mock
    private BaseInfoDetailRepository baseInfoDetailRepository;
    @Mock
    private BaseInfoRepository baseInfoRepository;

    @Test
    void testSaveBaseInfoTest() {

        BaseInfoDetail baseInfoDetailParent = BaseInfoDetail.builder().id(10L).title("SEDAN").code("SD").build();
        BaseInfo baseInfo = BaseInfo.builder().id(1L).build();
        BaseInfoDetail samand1 = BaseInfoDetail.builder().id(1000L).title("samand").code("IK-SMD").build();
        BaseInfoDetailDTO baseInfoDetailDTO = new BaseInfoDetailDTO();
        baseInfoDetailDTO.setId(100L);
        baseInfoDetailDTO.setTitle("samand");
        baseInfoDetailDTO.setCode("IKH-SMD");
        baseInfoDetailDTO.setBaseInfoId(1L);
        baseInfoDetailDTO.setParentId(10L);

        InputDTO<BaseInfoDetailDTO> inputDTO = new InputDTO<>();
        inputDTO.setActionType(EN_ACTION_TYPE.SAVE);
        inputDTO.setUserId(17L);
        inputDTO.setData(baseInfoDetailDTO);

        when(baseInfoRepository.findById(any())).thenReturn(Optional.of(baseInfo));
        when(baseInfoDetailRepository.findById(any())).thenReturn(Optional.of(baseInfoDetailParent));
        when(baseInfoDetailRepository.save(any())).thenReturn(samand1);

        BaseInfoDetailDTO result = service.save(inputDTO);

        assertEquals(result.getId(), samand1.getId());

        verify(baseInfoRepository).findById(baseInfo.getId());
        verify(baseInfoDetailRepository).findById(baseInfoDetailDTO.getParentId());
    }

}