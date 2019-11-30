package com.exchangerate.api.populator;

import com.exchangerate.api.dto.CalculateRequestDTO;
import com.exchangerate.api.dto.CalculateResponseDTO;
import com.exchangerate.api.model.ExchangeRateResponse;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yusufaltun
 */

public class CalculateResponsePopulatorTest
{
    @Test
    public void should_return_populated_response()
    {
        CalculateRequestDTO dto = CalculateRequestDTO.of("EUR", "USD", "", 1d);
        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();
        exchangeRateResponse.setBase("EUR");
        exchangeRateResponse.setDto(dto);

        HashMap<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.10);
        exchangeRateResponse.setRates(rates);

        CalculateResponsePopulator populator = new CalculateResponsePopulator();
        CalculateResponseDTO response = populator.populate(exchangeRateResponse);

        assertEquals("EUR",response.getFrom());
        assertEquals("USD",response.getTo());
        assertEquals(1.1, response.getCalculatedAmount());
    }
}
