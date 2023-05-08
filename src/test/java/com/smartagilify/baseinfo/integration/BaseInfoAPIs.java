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
public class BaseInfoAPIs {


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
    public void testSaveBaseInfo() {

        BaseInfoDTO baseInfoDTO = new BaseInfoDTO("vehicle-type", "VT", "sdfd21212");
        inputDTO = new InputDTO<>();
        inputDTO.setUserId(17L);
        inputDTO.setData(baseInfoDTO);
        inputDTO.setActionType(EN_ACTION_TYPE.SAVE);

        HttpEntity<InputDTO> request = new HttpEntity<>(inputDTO, headers);
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/api/base-info/save").toUriString();
        ResponseEntity<ResultDTO<BaseInfoDTO>> response = restTemplate.exchange(url, HttpMethod.POST, request, RESPONSE_TYPE);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @Sql(statements = "INSERT INTO bi$t_base_info VALUES (50, '127.0.0.1', 1, 2, '2023-05-08 17:00:00', 1, 1, 'CREATED', 2, '2023-05-08 17:00:00', 'code_001', 'icon_001', 'Title 001')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE bi$t_base_info f where f.id = 50", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindAllBaseInfo() {

        inputDTO = new InputDTO<>();
        inputDTO.setActionType(EN_ACTION_TYPE.GET_LIST);
        inputDTO.setUserId(17L);
        String[] orderBy = {"id"};
        inputDTO.setInputFilter(new InputFilter(0, 1, Sort.Direction.DESC, null, orderBy, null, null, null));

        HttpEntity<InputDTO> request = new HttpEntity<>(inputDTO, headers);
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/api/base-info/find-all").toUriString();

        ResponseEntity<ResultDTO<BaseInfoDTO>> response = restTemplate.exchange(url, HttpMethod.POST, request, RESPONSE_TYPE);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response.getBody().getResultList());
        Assertions.assertEquals(response.getBody().getResultList().size(), 1);
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private static final ParameterizedTypeReference<ResultDTO<BaseInfoDTO>> RESPONSE_TYPE = new ParameterizedTypeReference<>() {
    };

}
