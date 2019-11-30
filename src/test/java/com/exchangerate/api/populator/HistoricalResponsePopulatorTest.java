package com.exchangerate.api.populator;

import com.exchangerate.api.dto.HistoricalResponseDTO;
import com.exchangerate.api.model.ExchangeRateResponse;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yusufaltun
 */

public class HistoricalResponsePopulatorTest
{
    @Test
    public void should_return_populated_response()
    {
        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();
        exchangeRateResponse.setBase("EUR");

        HashMap<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.10);
        exchangeRateResponse.setRates(rates);

        HistoricalResponsePopulator populator = new HistoricalResponsePopulator();
        HistoricalResponseDTO response = populator.populate(exchangeRateResponse);

        assertEquals("EUR",response.getFrom());
        assertEquals("USD",response.getTo());
        assertEquals(1.1, response.getAmount());
    }
}
