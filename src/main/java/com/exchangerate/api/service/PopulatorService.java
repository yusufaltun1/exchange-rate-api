package com.exchangerate.api.service;

import com.exchangerate.api.dto.BaseDTO;
import com.exchangerate.api.dto.CalculateRequestDTO;
import com.exchangerate.api.dto.HistoricalRequestDTO;
import com.exchangerate.api.dto.LatestRequestDTO;
import com.exchangerate.api.model.ExchangeRateResponse;
import com.exchangerate.api.populator.CalculateResponsePopulator;
import com.exchangerate.api.populator.HistoricalResponsePopulator;
import com.exchangerate.api.populator.LatestResponsePopulator;
import com.exchangerate.api.populator.Populator;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author yusufaltun
 */
@Service
public class PopulatorService
{
    private HashMap<Class<? extends BaseDTO>, Populator> populators = new HashMap<>();

    {
        populators.put( LatestRequestDTO.class, new LatestResponsePopulator());
        populators.put( HistoricalRequestDTO.class, new HistoricalResponsePopulator());
        populators.put( CalculateRequestDTO.class, new CalculateResponsePopulator());
    }

    public BaseDTO populate(BaseDTO requestDTO, ExchangeRateResponse response)
    {
        response.setDto(requestDTO);
        return populators.get(requestDTO.getClass()).populate(response);
    }
}
