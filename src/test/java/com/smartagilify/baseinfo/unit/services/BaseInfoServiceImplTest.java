package com.smartagilify.baseinfo.unit.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.baseinfo.services.BaseInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BaseInfoServiceImplTest {
    @InjectMocks
    BaseInfoServiceImpl underTest;
    @Mock
    BaseInfoRepository baseInfoRepository;

    @Test
    void ShouldFindByCode() {
        BaseInfoDTO dto = new BaseInfoDTO("vehicle-type", "VT", "123sd");
        Optional<BaseInfo> baseInfo = Optional.ofNullable(BaseInfo
                .builder()
                .title(dto.getTitle())
                .code(dto.getCode())
                .icon(dto.getIcon())
                .build());
        Mockito.when(baseInfoRepository.findByCode("VT"))
                .thenReturn(baseInfo);

        BaseInfoDTO vt = underTest.findByCode("VT");
        assertEquals(vt, dto);

        Mockito.verify(baseInfoRepository).findByCode("VT");


    }
}