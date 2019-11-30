package com.exchangerate.api.populator;

import com.exchangerate.api.dto.HistoricalResponseDTO;
import com.exchangerate.api.model.ExchangeRateResponse;

/**
 * @author yusufaltun
 */

public class HistoricalResponsePopulator implements Populator<HistoricalResponseDTO>
{
    @Override
    public HistoricalResponseDTO populate(ExchangeRateResponse res) {
        String key = (String) res.getRates().keySet().toArray()[0];
        HistoricalResponseDTO dto = new HistoricalResponseDTO(res.getBase(), key);

        dto.setAmount(res.getRates().get(key));
        dto.setDate(res.getDate());
        return dto;
    }
}
