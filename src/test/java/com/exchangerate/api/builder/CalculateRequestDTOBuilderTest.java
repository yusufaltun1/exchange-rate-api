package com.exchangerate.api.builder;

import com.exchangerate.api.dto.CalculateRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yusufaltun
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application-test.properties")
public class CalculateRequestDTOBuilderTest
{
    @Value("${exchangerate.access.key}")
    private String accessToken;

    @Autowired
    private CalculateRequestBuilder calculateRequestBuilder;

    @Test
    public void should_generate_request_url_with_date()
    {
        CalculateRequestDTO dto = CalculateRequestDTO.of("EUR", "USD", "2019-01-01", 10.5);
        String url = "http://data.fixer.io/api/2019-01-01?access_key="+ accessToken +"&base=EUR&symbols=USD";
        assertEquals(url, calculateRequestBuilder.build(dto).getURL());
    }

    @Test
    public void should_generate_request_url()
    {
        CalculateRequestDTO dto = CalculateRequestDTO.of("EUR", "USD", "", 10.5);
        String url = "http://data.fixer.io/api/latest?access_key="+ accessToken +"&baseEUR&symbols=USD";
        assertEquals(url, calculateRequestBuilder.build(dto).getURL());
    }
}
