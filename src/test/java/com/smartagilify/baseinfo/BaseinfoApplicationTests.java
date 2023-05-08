package com.smartagilify.baseinfo;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.core.enumerations.EN_ACTION_TYPE;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.model.InputFilter;
import com.smartagilify.core.model.ResultDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@SpringBootTest
class BaseinfoApplicationTests {
    }
