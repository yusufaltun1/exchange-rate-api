package com.exchangerate.api.builder;

import com.exchangerate.api.dto.CalculateRequestDTO;
import com.exchangerate.api.dto.HistoricalRequestDTO;
import com.exchangerate.api.dto.LatestRequestDTO;
import com.exchangerate.api.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author yusufaltun
 */
@Component
public class CalculateRequestBuilder extends Builder<Request, CalculateRequestDTO>
{
    @Autowired
    private HistoricalRequestBuilder historicalRequestBuilder;

    @Autowired
    private LatestRequestBuilder latestRequestBuilder;

    @Override
    public Request build(CalculateRequestDTO dto) {

        if(StringUtils.isEmpty(dto.getDate()))
        {
            return latestRequestBuilder.build(LatestRequestDTO.of(dto.getFrom(), dto.getTo()));
        }
        else
        {
            return historicalRequestBuilder.build(HistoricalRequestDTO.of(dto.getFrom(), dto.getTo(), dto.getDate()));
        }
    }
}
