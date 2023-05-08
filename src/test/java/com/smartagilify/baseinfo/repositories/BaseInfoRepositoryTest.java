package com.smartagilify.baseinfo.repositories;

import com.smartagilify.baseinfo.entities.BaseInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BaseInfoRepositoryTest {
    @Autowired
    BaseInfoRepository underTest;
    BaseInfo baseInfo;

    @AfterEach
    void tearDown() {
        if (baseInfo != null) underTest.delete(baseInfo);
    }

    @Test
    void ShouldFindByCode() {
        baseInfo = BaseInfo.builder().title("vehicle-type").code("VT").icon("ashkjf131a5s4f").createById(17L).createDate(LocalDateTime.now()).build();
        underTest.save(baseInfo);
        Optional<BaseInfo> byCode = underTest.findByCode(baseInfo.getCode());
        assertEquals(byCode.get().getCode(), "VT");
    }

    @Test
    void ShouldGetExceptionWhenCallFindByCode() {
        Optional<BaseInfo> byCode = underTest.findByCode("VT");
        assertFalse(byCode.isPresent());
    }
}