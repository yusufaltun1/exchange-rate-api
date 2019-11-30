package com.exchangerate.api.builder;

import com.exchangerate.api.dto.LatestRequestDTO;
import com.exchangerate.api.request.LatestRequest;
import org.springframework.stereotype.Component;

/**
 * @author yusufaltun
 */
@Component
public class LatestRequestBuilder extends Builder<LatestRequest, LatestRequestDTO>
{
    @Override
    public LatestRequest build(LatestRequestDTO dto) {
        StringBuilder builder = new StringBuilder();
        builder.append(getUrl())
            .append("/latest")
            .append("?access_key=")
            .append(getAccessToken())
            .append("&base")
            .append(dto.getFrom())
            .append("&symbols=")
            .append(dto.getTo());

        return new LatestRequest(builder.toString());
    }
}
