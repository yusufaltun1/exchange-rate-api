package com.exchangerate.api.builder;

import com.exchangerate.api.dto.LatestRequestDTO;
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
public class LatestDTOBuilderTest
{
    @Value("${exchangerate.access.key}")
    private String accessToken;

    @Autowired
    private LatestRequestBuilder latestRequestBuilder;

    @Test
    public void should_generate_request_url()
    {
        LatestRequestDTO dto = LatestRequestDTO.of("EUR", "USD");
        String url = "http://data.fixer.io/api/latest?access_key="+ accessToken +"&baseEUR&symbols=USD";
        assertEquals(url, latestRequestBuilder.build(dto).getURL());
    }
}
