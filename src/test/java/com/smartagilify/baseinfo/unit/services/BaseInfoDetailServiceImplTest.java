package com.smartagilify.baseinfo.unit.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDetailDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.entities.BaseInfoDetail;
import com.smartagilify.baseinfo.repositories.BaseInfoDetailRepository;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.baseinfo.services.BaseInfoDetailServiceImpl;
import com.smartagilify.core.enumerations.EN_ACTION_TYPE;
import com.smartagilify.core.exceptions.BusinessException;
import com.smartagilify.core.model.InputDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

    @Test
    void receiveBaseInfoNotFoundException() {
        BaseInfoDetailDTO baseInfoDetailDTO = new BaseInfoDetailDTO();
        baseInfoDetailDTO.setId(100L);
        baseInfoDetailDTO.setTitle("samand");
        baseInfoDetailDTO.setCode("IKH-SMD");
        baseInfoDetailDTO.setBaseInfoId(1L);

        InputDTO<BaseInfoDetailDTO> inputDTO = new InputDTO<>();
        inputDTO.setActionType(EN_ACTION_TYPE.SAVE);
        inputDTO.setUserId(17L);
        inputDTO.setData(baseInfoDetailDTO);

        when(baseInfoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> service.save(inputDTO));
        verify(baseInfoDetailRepository, never()).save(any());
    }

    @Test
    void receiveParentNotFoundException() {
        BaseInfo baseInfo = BaseInfo.builder().id(1L).build();
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
        when(baseInfoDetailRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> service.save(inputDTO));
        verify(baseInfoDetailRepository, never()).save(any());
    }

    @Test
    void testFindAllByBaseInfoId() {
        List<BaseInfoDetail> baseInfoDetaiList = Arrays.asList(BaseInfoDetail.builder().id(1000L).title("samand").code("IK-SMD").build(),
                BaseInfoDetail.builder().id(1000L).title("dena").code("IK-DNA").build());
        when(baseInfoDetailRepository.findBaseInfoDetailByBaseInfo_IdOrderByCreateDateDesc(any())).thenReturn(baseInfoDetaiList);
        List<BaseInfoDetailDTO> result = service.findAllByBaseInfoId(1L);
        assertEquals(result.size(), baseInfoDetaiList.size());
        assertEquals(result.get(0).getId(), baseInfoDetaiList.get(0).getId());
        verify(baseInfoDetailRepository).findBaseInfoDetailByBaseInfo_IdOrderByCreateDateDesc(1L);

    }

    @Test
    void testFindALlChild(){
        BaseInfoDetail baseInfoDetail = BaseInfoDetail.builder().id(1000L).title("samand").code("IK-SMD").build();

        when(baseInfoDetailRepository.findById(anyLong())).thenReturn(Optional.of(baseInfoDetail));

        List<BaseInfoDetailDTO> allChild = service.findAllChild(1L);
        assertNull(allChild);
        verify(baseInfoDetailRepository).findById(1L);
    }

}