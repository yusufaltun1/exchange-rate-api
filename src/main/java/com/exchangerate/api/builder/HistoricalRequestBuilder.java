package com.exchangerate.api.builder;

import com.exchangerate.api.dto.HistoricalRequestDTO;
import com.exchangerate.api.request.HistoricalRequest;
import org.springframework.stereotype.Component;

/**
 * @author yusufaltun
 */
@Component
public class HistoricalRequestBuilder extends Builder<HistoricalRequest, HistoricalRequestDTO>
{
    @Override
    public HistoricalRequest build(HistoricalRequestDTO dto)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(getUrl())
            .append("/").append(dto.getDate())
            .append("?access_key=")
            .append(getAccessToken())
            .append("&base=")
            .append(dto.getFrom())
            .append("&symbols=")
            .append(dto.getTo());

        return new HistoricalRequest(builder.toString());
    }


}
