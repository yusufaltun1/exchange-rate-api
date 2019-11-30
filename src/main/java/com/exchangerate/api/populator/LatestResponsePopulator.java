package com.exchangerate.api.populator;

import com.exchangerate.api.dto.LatestResponseDTO;
import com.exchangerate.api.model.ExchangeRateResponse;

/**
 * @author yusufaltun
 */
public class LatestResponsePopulator implements Populator<LatestResponseDTO>
{
    @Override
    public LatestResponseDTO populate(ExchangeRateResponse res)
    {
        String key = (String) res.getRates().keySet().toArray()[0];
        LatestResponseDTO dto = new LatestResponseDTO(res.getBase(), key);

        dto.setAmount(res.getRates().get(key));

        return dto;
    }
}
