package com.exchangerate.api.controller;
import com.exchangerate.api.dto.BaseDTO;
import com.exchangerate.api.dto.HistoricalResponseDTO;
import com.exchangerate.api.dto.LatestResponseDTO;
import com.exchangerate.api.service.ExchangeRateService;
import com.exchangerate.api.service.ValidationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
/**
 * @author yusufaltun
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureRestDocs(outputDir = "build/generated-snipped")
public class ExchangeRateControllerTest
{
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    private ExchangeRateService exchangeRateService;

    @MockBean
    private ValidationService validationService;

    @BeforeEach
    public void init() {
        doNothing().when(validationService).validate(any());
    }

    @Test
    public void shouldReturnLatestExchangeRateIfAllParamValid() throws Exception {
        String uri = "/api/latest/EUR/USD";

        LatestResponseDTO dto = new LatestResponseDTO("USD", "EUR");
        dto.setAmount(1.3d);

        when(exchangeRateService.makeRequest(anyObject())).thenReturn(dto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        dto.setAmount(1.3d);

        assertEquals(objectToString(dto), content);
    }

    @Test
    public void shouldReturnHistoricalExchangeRateIfAllParamValid() throws Exception {
        String uri = "/api/historical/EUR/USD/2019-01-01";
        HistoricalResponseDTO dto = new HistoricalResponseDTO("USD", "EUR");
        dto.setAmount(1.3d);
        dto.setDate("2019-01-01");

        when(exchangeRateService.makeRequest(anyObject())).thenReturn(dto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        assertEquals(objectToString(dto), content);
    }

    public String objectToString(BaseDTO dto) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dto);
    }
}
