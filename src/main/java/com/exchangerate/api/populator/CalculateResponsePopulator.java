package com.exchangerate.api.populator;

import com.exchangerate.api.dto.CalculateRequestDTO;
import com.exchangerate.api.dto.CalculateResponseDTO;
import com.exchangerate.api.model.ExchangeRateResponse;

/**
 * @author yusufaltun
 */

public class CalculateResponsePopulator implements Populator<CalculateResponseDTO>
{
    @Override
    public CalculateResponseDTO populate(ExchangeRateResponse res) {
        CalculateRequestDTO dto = (CalculateRequestDTO) res.getDto();
        double amount = dto.getAmount();

        String key = (String) res.getRates().keySet().toArray()[0];
        CalculateResponseDTO calculateResponseDTO = new CalculateResponseDTO(res.getBase(), key);
        double baseAmount = res.getRates().get(key);

        calculateResponseDTO.setAmount(amount);
        calculateResponseDTO.setCalculatedAmount(amount * baseAmount);
        return calculateResponseDTO;
    }
}
