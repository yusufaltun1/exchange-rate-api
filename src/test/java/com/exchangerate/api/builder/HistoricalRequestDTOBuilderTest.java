package com.exchangerate.api.builder;

import com.exchangerate.api.dto.HistoricalRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yusufaltun
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application-test.properties")
public class HistoricalRequestDTOBuilderTest
{
    @Value("${exchangerate.access.key}")
    private String accessToken;

    @Autowired
    private HistoricalRequestBuilder historicalRequestBuilder;

    @Test
    public void should_generate_request_url()
    {
        HistoricalRequestDTO dto = HistoricalRequestDTO.of("EUR", "USD", "2019-01-01");
        String url = "http://data.fixer.io/api/2019-01-01?access_key="+ accessToken +"&base=EUR&symbols=USD";
        assertEquals(url, historicalRequestBuilder.build(dto).getURL());
    }
}
