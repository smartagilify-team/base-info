package com.smartagilify.baseinfo;

import com.smartagilify.baseinfo.dtos.BaseInfoDTO;
import com.smartagilify.baseinfo.repositories.BaseInfoRepository;
import com.smartagilify.core.enumerations.EN_ACTION_TYPE;
import com.smartagilify.core.model.InputDTO;
import com.smartagilify.core.model.ResultDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseinfoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    BaseInfoRepository repository;

    private String baseUrl = "http://localhost";
    private static RestTemplate restTemplate;

    @BeforeAll
    private static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    private void setUp() {
        baseUrl = baseUrl.concat(":").concat(String.valueOf(port));
    }

    @AfterEach
    private void destroy() {

    }

    @Test
    public void testBaseInfoSaving() {
        BaseInfoDTO baseInfoDTO = new BaseInfoDTO("vehicle-type", "VT", "sdfd21212");
        InputDTO<BaseInfoDTO> inputDTO = new InputDTO<>();
        inputDTO.setUserId(17L);
        inputDTO.setData(baseInfoDTO);
        inputDTO.setActionType(EN_ACTION_TYPE.SAVE);

        HttpHeaders headers = createHeaders();
        HttpEntity<InputDTO> request = new HttpEntity<>(inputDTO, headers);

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/api/base-info/save").toUriString();

        ResponseEntity<ResultDTO<BaseInfoDTO>> response = restTemplate.exchange(url, HttpMethod.POST, request, RESPONSE_TYPE);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private static final ParameterizedTypeReference<ResultDTO<BaseInfoDTO>> RESPONSE_TYPE = new ParameterizedTypeReference<>() {
    };
}
