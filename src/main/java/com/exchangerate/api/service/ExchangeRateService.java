package com.exchangerate.api.service;

import com.exchangerate.api.builder.Builder;
import com.exchangerate.api.builder.CalculateRequestBuilder;
import com.exchangerate.api.builder.HistoricalRequestBuilder;
import com.exchangerate.api.builder.LatestRequestBuilder;
import com.exchangerate.api.client.ExchangeRateClient;
import com.exchangerate.api.dto.BaseDTO;
import com.exchangerate.api.dto.CalculateRequestDTO;
import com.exchangerate.api.dto.HistoricalRequestDTO;
import com.exchangerate.api.dto.LatestRequestDTO;
import com.exchangerate.api.model.ExchangeRateResponse;
import com.exchangerate.api.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @author yusufaltun
 */
@Service
public class ExchangeRateService
{
    @Autowired
    private ExchangeRateClient exchangeRateClient;

    @Autowired
    private LatestRequestBuilder latestRequestBuilder;

    @Autowired
    private CalculateRequestBuilder calculateRequestBuilder;

    @Autowired
    private HistoricalRequestBuilder historicalRequestBuilder;

    @Autowired
    private PopulatorService populatorService;

    @Autowired
    private ValidationService validationService;

    private HashMap<Class<? extends BaseDTO>, Builder> builders = new HashMap<>();

    @PostConstruct
    public void setup()
    {
        builders.put( LatestRequestDTO.class, latestRequestBuilder);
        builders.put( HistoricalRequestDTO.class, historicalRequestBuilder);
        builders.put( CalculateRequestDTO.class, calculateRequestBuilder);
    }

    public BaseDTO makeRequest(BaseDTO dto)
    {
        validationService.validate(dto);

        Class dtoClass = dto.getClass();

        if(builders.containsKey(dtoClass))
        {
            Request req = builders.get(dtoClass).build(dto);
            ExchangeRateResponse res = exchangeRateClient.makeRequest(req);
            return populatorService.populate(dto, res);
        }

        return null;
    }
}

