package com.smartagilify.baseinfo.integration;

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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseInfoDetailAPIs {


    @LocalServerPort
    private int port;
    @Autowired
    BaseInfoRepository repository;
    private String baseUrl = "http://localhost";
    private static RestTemplate restTemplate;
    private InputDTO<BaseInfoDTO> inputDTO;
    private HttpHeaders headers;

    @BeforeAll
    private static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    private void setUp() {
        baseUrl = baseUrl.concat(":").concat(String.valueOf(port));
        headers = createHeaders();
    }

    @AfterEach
    private void destroy() {

    }

    @Test
    @Sql(statements = "INSERT INTO bi$t_base_info VALUES (50, '127.0.0.1', 1, 2, '2023-05-08 17:00:00', 1, 1, 'CREATED', 2, '2023-05-08 17:00:00', 'code_001', 'icon_001', 'Title 001')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "INSERT INTO bi$t_base_info_detail VALUES (1, '192.168.1.1', 1, 1, '2023-05-08 17:00:00', 1, 1, 'CREATED', NULL, NULL, 'CODE_001', 'RED', 'ICON_001', 'TITLE_001', 50, NULL)", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(statements = "DELETE bi$t_base_info_detail f where f.id = 1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(statements = "DELETE bi$t_base_info f where f.id = 50", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindAllByBaseInfoId() {


        HttpEntity<InputDTO> request = new HttpEntity<>(headers);
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/api/base-info-detail/find-all-by-base-info-id/1").toUriString();
        ResponseEntity<ResultDTO<BaseInfoDTO>> response = restTemplate.exchange(url, HttpMethod.GET, request, RESPONSE_TYPE);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private static final ParameterizedTypeReference<ResultDTO<BaseInfoDTO>> RESPONSE_TYPE = new ParameterizedTypeReference<>() {
    };

}
