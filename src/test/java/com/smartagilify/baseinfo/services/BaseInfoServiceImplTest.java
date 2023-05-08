package com.smartagilify.baseinfo.services;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.entities.BaseInfo;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BaseInfoServiceImplTest {
    BaseInfoServiceImpl underTest;
    @Mock
    BaseInfoRepository baseInfoRepository;

    @BeforeEach
    void setUp() {
        underTest = new BaseInfoServiceImpl(baseInfoRepository, baseInfoRepository);
    }

    @AfterEach
    void tearDown() {
//        if (baseInfo != null) underTest.delete(baseInfo);
    }

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